package seu.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The name must be not empty")
    @Size(min = 5 , message = "The name must be more than 4")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain letters only")
    @Column(columnDefinition = "varchar(30)")
    private String name;

    @Email(message = "Must be a valid email format. ")
    @Column(columnDefinition = "VARCHAR(30) UNIQUE")
    private String email;

    @NotEmpty(message = "The password Cannot be null.")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String password;

    @Positive(message = "The age Must be a number. ")
    @Min(value = 21 , message = "The age Must be more than 21")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer age;


    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$", message = "Must be either JOB_SEEKER or EMPLOYER only")
    @NotEmpty(message = "The role Cannot be null.")
    private String role;

}
