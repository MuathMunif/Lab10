package seu.lab10.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seu.lab10.Model.JobPostModel;
import seu.lab10.Repository.JobPostRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public List<JobPostModel> getAllJobPost(){
        return jobPostRepository.findAll();
    }


    public void addJobPost(JobPostModel jobPostModel){
        if (jobPostModel.getPostingDate() == null){
            jobPostModel.setPostingDate(LocalDate.now()) ;
        }
        jobPostRepository.save(jobPostModel);
    }

    public boolean updateJobPost(Integer id ,JobPostModel jobPostModel){
        JobPostModel oldjobPost = jobPostRepository.getById(id);
        if(oldjobPost == null){
            return false;
        }
        oldjobPost.setTitle(jobPostModel.getTitle());
        oldjobPost.setDescription(jobPostModel.getDescription());
        oldjobPost.setLocation(jobPostModel.getLocation());
        oldjobPost.setSalary(jobPostModel.getSalary());
        jobPostRepository.save(oldjobPost);
        return true;
    }


    public boolean deleteJobPost(Integer id){
        JobPostModel jobPostModel = jobPostRepository.getById(id);
        if(jobPostModel == null){
            return false;
        }
        jobPostRepository.delete(jobPostModel);
        return true;
    }
}
