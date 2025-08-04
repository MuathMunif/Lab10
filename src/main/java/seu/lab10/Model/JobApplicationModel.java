package seu.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobApplicationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "The UserId Cannot be null")
    private Integer userId;

    @NotNull(message = "The jobPostId Cannot be null")
    private Integer jobPostId;

    //todo check if they need to insert column


}
