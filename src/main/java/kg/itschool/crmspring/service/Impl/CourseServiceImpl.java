package kg.itschool.crmspring.service.Impl;

import kg.itschool.crmspring.models.dto.CourseDto;
import kg.itschool.crmspring.models.entity.Course;
import kg.itschool.crmspring.models.mapper.CourseFormatMapper;
import kg.itschool.crmspring.models.mapper.CourseMapper;
import kg.itschool.crmspring.models.request.CreateCourseRequest;
import kg.itschool.crmspring.respository.CourseRepository;
import kg.itschool.crmspring.service.CourseService;
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
public class CourseServiceImpl implements CourseService {

    @NonNull CourseRepository courseRepository;
    CourseMapper courseMapper = CourseMapper.INSTANCE;
    CourseFormatMapper courseFormatMapper = CourseFormatMapper.INSTANCE;


    @Override
    public CourseDto save(CreateCourseRequest request) {
        Course course = Course
                .builder()
                .name(request.getName())
                .price(request.getPrice())
                .courseFormat(courseFormatMapper.toEntity(request.getCourseFormat()))
                .isActive(true)
                .build();

         Course savedCourse = courseRepository.save(course);

        return courseMapper.toDto(savedCourse);
    }

    @Override
    public CourseDto delete(CourseDto courseDto) {
        Course course = courseMapper.toEntity(findById(courseDto.getId()));

        course.setIsActive(false);

        courseRepository.save(course);

        return courseMapper.toDto(course);
    }

    @Override
    public List<CourseDto> findAll() {
        List<Course> courses = courseRepository.findAll();


        return courseMapper.toDtoList(courses);
    }

    @Override
    public CourseDto findById(Long id) {
        Course course = courseRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Not found Course with " + id + " id")
                );

        return courseMapper.toDto(course);
    }

    @Override
    public List<CourseDto> findAllByCourseFormatId(Long id) {
        List<Course> courses = courseRepository.findAllByCourseFormatId(id);

        return courseMapper.toDtoList(courses);
    }
}
