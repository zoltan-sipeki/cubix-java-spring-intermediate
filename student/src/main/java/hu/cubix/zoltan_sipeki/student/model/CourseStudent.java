package hu.cubix.zoltan_sipeki.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CourseStudent {

    @EqualsAndHashCode.Include
    @GeneratedValue
    @Id
    private int id;

    @ManyToOne
    private Student student;
    
    @ManyToOne
    private Course course;
}
