package kg.itschool.crmspring.models.mapper;

import kg.itschool.crmspring.models.dto.CourseDto;
import kg.itschool.crmspring.models.dto.CourseFormatDto;
import kg.itschool.crmspring.models.entity.Course;
import kg.itschool.crmspring.models.entity.CourseFormat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CourseMapper {

    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    Course toEntity(CourseDto dto);
    CourseDto toDto(Course entity);
    List<Course> toEntityList(List<CourseDto> dtoList);
    List<CourseDto> toDtoList(List<Course> entityList);


}
