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
@Table(name = "faculty")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Faculty extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Integer facultyId;
    @Column(name = "name")
    private String name;
    @Column(name="city")
    private String city;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "faculty_student", joinColumns = @JoinColumn(name = "faculty_fk"), inverseJoinColumns = @JoinColumn(name = "student_fk"))
    private List<Student> students;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Faculty faculty = (Faculty) o;
        return facultyId != null && Objects.equals(facultyId, faculty.facultyId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
