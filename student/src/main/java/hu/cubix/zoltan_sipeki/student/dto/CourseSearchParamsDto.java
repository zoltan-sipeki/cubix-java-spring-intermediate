package hu.cubix.zoltan_sipeki.student.dto;

import java.util.List;

import org.springframework.util.StringUtils;

public record CourseSearchParamsDto(
    String name, 
    Integer id, 
    String teacher, 
    Integer studentId, 
    List<Integer> semester) {

    public boolean isEmpty() {
        return !StringUtils.hasText(name) && id == null && !StringUtils.hasText(teacher) && studentId == null && (semester == null || semester.isEmpty());
    }
}
