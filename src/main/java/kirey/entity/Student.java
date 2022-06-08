package kirey.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name="city")
    private String city;
    @Column(name="age")
    private Integer age;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "faculty_student", joinColumns = @JoinColumn(name = "student_fk"), inverseJoinColumns = @JoinColumn(name = "faculty_fk"))
    @JsonIgnore
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
        return getClass().hashCode();
    }
}
