package pl.wspa.postgresql.student;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@EnableScheduling
@AllArgsConstructor
public class GetStudentService {

    private StudentRepository studetRepostiory;

    public List<StudentOut> getAllStudents() {
        return buildStudentOutList(studetRepostiory.findAll());
    }

    public List<StudentOut> getStudentsByFirstName(String firstName){
        return buildStudentOutList(studetRepostiory.findAllByFirstName(firstName));
    }

    private List<StudentOut> buildStudentOutList(List<Student> students){
        List<StudentOut> studentOuts = new ArrayList<>();
        for(int i = 0 ; i < students.size() ; i++){
            studentOuts.add(buildStudentOut(students.get(i)));
        }
        return studentOuts;
    }

    private StudentOut buildStudentOut(Student student) {
        return StudentOut.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .indexNumber(student.getIndexNumber())
                .marks(student.getMarks()).build();
    }

    @Scheduled(fixedDelay = 20000)
    private void saveStudentEveryMinute(){
        Student student = new Student();
        student.setFirstName("Mateusz");
        student.setLastName("W");
        student.setIndexNumber("10");
        student.setMarks(new ArrayList<>());
        Student secondStudent = new Student();
        secondStudent.setFirstName("Paweł");
        secondStudent.setLastName("J");
        secondStudent.setIndexNumber("11");
        secondStudent.setMarks(new ArrayList<>());
        studetRepostiory.save(secondStudent);
        studetRepostiory.save(student);
    }
}
