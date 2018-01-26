package pl.wspa.postgresql.student;

import lombok.Data;
import pl.wspa.postgresql.student.marks.Mark;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long studentId;
    private String firstName;
    private String lastName;
    private String indexNumber;
    @ElementCollection
    private List<Mark> marks;
}
