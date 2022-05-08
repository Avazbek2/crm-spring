package kg.itschool.crmspring.service;

import kg.itschool.crmspring.models.dto.CourseFormatDto;
import kg.itschool.crmspring.models.request.CreateCourseFormatRequest;


import java.util.List;

public interface CourseFormatService {

    CourseFormatDto save(CreateCourseFormatRequest request);

    CourseFormatDto delete(CourseFormatDto courseFormatDto);

    List<CourseFormatDto> findAll();

    CourseFormatDto findById(Long id);





}
