package kg.itschool.crmspring.service;

import kg.itschool.crmspring.models.dto.CourseDto;
import kg.itschool.crmspring.models.dto.CourseFormatDto;
import kg.itschool.crmspring.models.request.CreateCourseRequest;

import java.util.List;


public interface CourseService {

    CourseDto save(CreateCourseRequest request);

    CourseDto delete(CourseDto courseDto);

    List<CourseDto> findAll();

    CourseDto findById(Long id);

    List<CourseDto> findAllByCourseFormatId(Long id);



}
