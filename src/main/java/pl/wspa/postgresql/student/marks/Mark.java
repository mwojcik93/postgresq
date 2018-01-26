package pl.wspa.postgresql.student.marks;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Mark {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long markId;
    private Integer value;
    private String subject;
}
