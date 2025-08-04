package seu.lab10.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seu.lab10.Model.JobPostModel;

@Repository
public interface JobPostRepository extends JpaRepository<JobPostModel , Integer> {
}
