package kg.itschool.crmspring.models.mapper;

import kg.itschool.crmspring.models.dto.StudentDto;
import kg.itschool.crmspring.models.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper{
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student toEntity(StudentDto dto);
    StudentDto toDto(Student entity);
    List<Student> toEntityList(List<StudentDto> dtoList);
    List<StudentDto> toDtoList(List<Student> entityList);

}
