package seu.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class JobPostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The title Cannot be null. ")
    @Size(min = 5 , message = "The Title Length must be more than 4 characters. ")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String title;

    @NotEmpty(message = "The description Cannot be null")
    @Column(columnDefinition = "VARCHAR(250) NOT NULL")
    private String description;

    @NotEmpty(message = "The Location Cannot be null")
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String location;

    @NotNull(message = "The Salary Cannot be null")
    @Positive(message = "The salary Must be a non-negative number. ")
    @Column(columnDefinition = "Double NOT NULL")
    private double salary;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate postingDate;

}
