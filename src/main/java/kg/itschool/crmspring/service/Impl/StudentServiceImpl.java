package kg.itschool.crmspring.service.Impl;


import kg.itschool.crmspring.models.dto.StudentDto;
import kg.itschool.crmspring.models.entity.Student;
import kg.itschool.crmspring.models.mapper.GroupMapper;
import kg.itschool.crmspring.models.mapper.StudentMapper;
import kg.itschool.crmspring.models.request.CreateStudentRequest;
import kg.itschool.crmspring.respository.StudentRepository;
import kg.itschool.crmspring.service.StudentService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentServiceImpl implements StudentService {

    @NonNull StudentRepository studentRepository;


    StudentMapper studentMapper = StudentMapper.INSTANCE;
    GroupMapper groupMapper = GroupMapper.INSTANCE;

    @Override
    public StudentDto save(CreateStudentRequest request) {
        Student student = Student
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .dob(request.getDob())
                .group(groupMapper.toEntity(request.getGroup()))
                .phoneNumber(request.getPhoneNumber())
                .isActive(true)
                .build();

         Student savedStudent = studentRepository.save(student);


         return studentMapper.toDto(savedStudent);

    }

    @Override
    public StudentDto delete(StudentDto studentDto) {

        Student student = studentMapper
                .toEntity(
                        findById(studentDto.getId())
                );

        student.setIsActive(false);

        studentRepository.save(student);

        return studentMapper.toDto(student);
    }

    @Override
    public List<StudentDto> findStudentsByGroupId(Long id) {

        List<Student> students = studentRepository.findAllByGroup_Id(id);

        return studentMapper.toDtoList(students);
    }

    @Override
    public StudentDto findById(Long id) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Not found Student with" + id + " id"));
        return studentMapper.toDto(student);
    }
}
