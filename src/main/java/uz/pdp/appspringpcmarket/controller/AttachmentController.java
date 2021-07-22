package uz.pdp.appspringpcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.appspringpcmarket.entity.Attachment;
import uz.pdp.appspringpcmarket.payload.ApiResponse;
import uz.pdp.appspringpcmarket.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @GetMapping
    public ResponseEntity<List<Attachment>> getAllAttachment(){
        List<Attachment> attachmentList = attachmentService.getAllAttachment();
        return ResponseEntity.ok(attachmentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attachment> getAttachment(@PathVariable Integer id){
        Attachment attachment = attachmentService.getAttachment(id);
        if (attachment != null)
            return ResponseEntity.status(200).body(attachment);
        else
            return ResponseEntity.status(409).body(attachment);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ApiResponse> getFile(@PathVariable Integer id, HttpServletResponse response){
        ApiResponse apiResponse = attachmentService.getFile(id, response);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse> uploadFile(MultipartHttpServletRequest request){
        ApiResponse apiResponse = attachmentService.uploadFile(request);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editFile(@PathVariable Integer id, MultipartHttpServletRequest request){
        ApiResponse apiResponse = attachmentService.editFile(id, request);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteFile(@PathVariable Integer id){
        ApiResponse apiResponse = attachmentService.deleteFile(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 204 : 409).body(apiResponse);
    }
}
