package seu.lab10.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import seu.lab10.Api.ApiResponse;
import seu.lab10.Model.JobPostModel;
import seu.lab10.Service.JobPostService;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/job-post")
@RequiredArgsConstructor
public class JobPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllJobPost(){
        return ResponseEntity.status(200).body(jobPostService.getAllJobPost());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addJopPost(@Valid @RequestBody JobPostModel jobPostModel , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(Objects.requireNonNull(errors.getFieldError()).getDefaultMessage()));
        }
        jobPostService.addJobPost(jobPostModel);
        return ResponseEntity.status(200).body(new ApiResponse("Job post added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJopPost(@PathVariable Integer id, @Valid @RequestBody JobPostModel jobPostModel , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(Objects.requireNonNull(errors.getFieldError()).getDefaultMessage()));
        }
        boolean isUpdate = jobPostService.updateJobPost(id, jobPostModel);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("Job post updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job post Not Found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJopPost(@PathVariable Integer id){
        boolean isDelete = jobPostService.deleteJobPost(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("Job post deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job post Not Found"));
    }

}
