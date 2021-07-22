package uz.pdp.appspringpcmarket.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appspringpcmarket.entity.Attachment;
import uz.pdp.appspringpcmarket.entity.AttachmentContent;
import uz.pdp.appspringpcmarket.payload.ApiResponse;
import uz.pdp.appspringpcmarket.repository.AttachmentContentRepository;
import uz.pdp.appspringpcmarket.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    public List<Attachment> getAllAttachment(){
        return attachmentRepository.findAll();
    }

    public Attachment getAttachment(Integer id){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        return optionalAttachment.orElse(null);
    }

    @SneakyThrows
    public ApiResponse getFile(Integer id, HttpServletResponse response){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();
            Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findByAttachmentId(id);
            if (optionalAttachmentContent.isPresent()) {
                AttachmentContent attachmentContent = optionalAttachmentContent.get();
                response.setHeader("Content-Disposition", "attachment; filename=\""+attachment.getOrginalName() + "\"");
                response.setContentType(attachment.getContentType());
                FileCopyUtils.copy(attachmentContent.getBytes(), response.getOutputStream());
                return new ApiResponse("Muvvafaqiyatli yuklab bolindi", true);
            }
        }
        return new ApiResponse("Xatolik", false);
    }

    @SneakyThrows
    public ApiResponse uploadFile(MultipartHttpServletRequest request){
        boolean saqlandi = false;
        Iterator<String> fileNames = request.getFileNames();
        while (fileNames.hasNext()) {
            MultipartFile multipartFile = request.getFile(fileNames.next());
            if (multipartFile != null) {
                String originalFilename = multipartFile.getOriginalFilename();
                long size = multipartFile.getSize();
                String contentType = multipartFile.getContentType();
                Attachment attachment = new Attachment();
                attachment.setOrginalName(originalFilename);
                attachment.setSize(size);
                attachment.setContentType(contentType);
                Attachment saveAttachment = attachmentRepository.save(attachment);

                AttachmentContent attachmentContent = new AttachmentContent();
                attachmentContent.setBytes(multipartFile.getBytes());
                attachmentContent.setAttachment(saveAttachment);
                attachmentContentRepository.save(attachmentContent);
                saqlandi = true;
            }
        }
        if (saqlandi)
            return new ApiResponse("saqlandi", true);
        else
            return new ApiResponse("Xatolik", false);
    }

    @SneakyThrows
    public ApiResponse editFile(Integer id, MultipartHttpServletRequest request){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (!optionalAttachment.isPresent()) {
            return new ApiResponse("Bunday file mavjud emas", false);
        }
        Attachment attachment = optionalAttachment.get();

        Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findByAttachmentId(id);
        if (!optionalAttachmentContent.isPresent()) {
            return new ApiResponse("Bunday file byte mavjud emas", false);
        }
        AttachmentContent attachmentContent = optionalAttachmentContent.get();

        boolean saqlandi = false;
        Iterator<String> fileNames = request.getFileNames();
        while (fileNames.hasNext()) {
            MultipartFile file = request.getFile(fileNames.next());
            if (file!=null) {
                String originalFilename = file.getOriginalFilename();
                long size = file.getSize();
                String contentType = file.getContentType();
                attachment.setOrginalName(originalFilename);
                attachment.setSize(size);
                attachment.setContentType(contentType);
                Attachment saveAttachment = attachmentRepository.save(attachment);
                attachmentContent.setBytes(file.getBytes());
                attachmentContent.setAttachment(saveAttachment);
                attachmentContentRepository.save(attachmentContent);
                saqlandi = true;
            }
        }
        if (saqlandi)
            return new ApiResponse("File saqlandi", true);
        else
            return new ApiResponse("Saqlanmadi", false);
    }

    public ApiResponse deleteFile(Integer id){
        try {
            Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findByAttachmentId(id);
            if (!optionalAttachmentContent.isPresent()) {
                return new ApiResponse("Bunday AttachmentContent mavjud emas", false);
            }
            AttachmentContent attachmentContent = optionalAttachmentContent.get();
            attachmentContentRepository.delete(attachmentContent);
            attachmentRepository.deleteById(id);
            return new ApiResponse("O'chirildi", false);
        }catch (Exception e){
            return new ApiResponse("Xatolik", false);
        }
    }
}
