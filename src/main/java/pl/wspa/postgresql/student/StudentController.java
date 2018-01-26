package pl.wspa.postgresql.student;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class StudentController {

    private GetStudentService getStudentService;

    @GetMapping("/student")
    private List<StudentOut> getAllStudents(){
        log.info("Get all students");
        return getStudentService.getAllStudents();
    }

    @GetMapping("student/{firstName}")
    public List<StudentOut> getStudentsByFirstName(@PathVariable("firstName") String firstName){
        return getStudentService.getStudentsByFirstName(firstName);
    }
}
