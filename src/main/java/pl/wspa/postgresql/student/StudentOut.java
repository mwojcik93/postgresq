package pl.wspa.postgresql.student;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import pl.wspa.postgresql.student.marks.Mark;

import java.util.List;

@Value
@Builder
public class StudentOut {

    private String firstName;
    private String lastName;
    private String indexNumber;
    private List<Mark> marks;

}
