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
public interface CourseFormatMapper {

    CourseFormatMapper INSTANCE = Mappers.getMapper(CourseFormatMapper.class);

    CourseFormat toEntity(CourseFormatDto dto);
    CourseFormatDto toDto(CourseFormat entity);
    List<CourseFormat> toEntityList(List<CourseFormatDto> dtoList);
    List<CourseFormatDto> toDtoList(List<CourseFormat> entityList);

}


