package seu.lab10.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seu.lab10.Model.JobApplicationModel;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplicationModel , Integer> {
}
