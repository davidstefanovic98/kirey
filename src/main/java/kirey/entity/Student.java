package kirey.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kirey.annotation.AdmissionAgeValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@AdmissionAgeValidation
public class Student extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;
    @NotBlank(message = "First name is required")
    @Size(min = 3)
    @Column(name = "first_name")
    private String firstName;
    @NotBlank(message = "Last name is required")
    @Column(name = "last_name")
    private String lastName;
    @Column(name="city")
    private String city;
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name="date_of_admission")
    private LocalDate dateOfAdmission;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "faculty_student", joinColumns = @JoinColumn(name = "student_fk"), inverseJoinColumns = @JoinColumn(name = "faculty_fk"))
    private List<Faculty> faculties;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return studentId != null && Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}
