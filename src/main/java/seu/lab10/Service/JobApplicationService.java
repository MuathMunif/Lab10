package seu.lab10.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seu.lab10.Model.JobApplicationModel;
import seu.lab10.Model.JobPostModel;
import seu.lab10.Model.UserModel;
import seu.lab10.Repository.JobApplicationRepository;
import seu.lab10.Repository.JobPostRepository;
import seu.lab10.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;

    public List<JobApplicationModel> getAllJobApplication(){
        return jobApplicationRepository.findAll();
    }

    public String aplyingForJob(JobApplicationModel jobApplicationModel){
        UserModel userModel = userRepository.getById(jobApplicationModel.getUserId());
        JobPostModel jobPostModel = jobPostRepository.getById(jobApplicationModel.getJobPostId());
        if(userModel == null){
            return "User not found";
        }
        if(jobPostModel == null){
            return "JobPost not found";
        }
        jobApplicationRepository.save(jobApplicationModel);
        return "Success";
    }

    public boolean deleteJobApplication(Integer id){
        JobApplicationModel olJobApplicationModel = jobApplicationRepository.getById(id);
        if(olJobApplicationModel == null){
            return false;
        }
        jobApplicationRepository.delete(olJobApplicationModel);
        return true;
    }
}
