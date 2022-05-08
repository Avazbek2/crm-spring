package kg.itschool.crmspring.service;

import kg.itschool.crmspring.models.dto.StudentDto;
import kg.itschool.crmspring.models.request.CreateStudentRequest;

import java.util.List;

public interface StudentService {

    StudentDto save(CreateStudentRequest request);

    StudentDto delete(StudentDto studentDto);

    List<StudentDto> findStudentsByGroupId(Long id);

    StudentDto findById(Long id);
}
