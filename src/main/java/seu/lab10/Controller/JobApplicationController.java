package seu.lab10.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import seu.lab10.Api.ApiResponse;
import seu.lab10.Model.JobApplicationModel;
import seu.lab10.Service.JobApplicationService;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/Job-application")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllJobApplication(){
        return ResponseEntity.ok(jobApplicationService.getAllJobApplication());
    }

    @PostMapping("/apply-job")
    public ResponseEntity<?> addJobApplication(@Valid@RequestBody JobApplicationModel jobApplicationModel , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(Objects.requireNonNull(errors.getFieldError()).getDefaultMessage()));
        }
        String respnse = jobApplicationService.aplyingForJob(jobApplicationModel);
        if (respnse.equals("success")){
            return ResponseEntity.status(200).body(new ApiResponse("Job Apply successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse(respnse));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJobApplication(@PathVariable Integer id){
        boolean isDeleted = jobApplicationService.deleteJobApplication(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Job Delete successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job Not Found"));
    }



}
