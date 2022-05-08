package kg.itschool.crmspring.service.Impl;


import kg.itschool.crmspring.models.dto.CourseFormatDto;
import kg.itschool.crmspring.models.entity.CourseFormat;
import kg.itschool.crmspring.models.mapper.CourseFormatMapper;
import kg.itschool.crmspring.models.request.CreateCourseFormatRequest;
import kg.itschool.crmspring.respository.CourseFormatRepository;
import kg.itschool.crmspring.service.CourseFormatService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseFormatServiceImpl implements CourseFormatService {
    @NonNull CourseFormatRepository courseFormatRepository;

    CourseFormatMapper courseFormatMapper = CourseFormatMapper.INSTANCE;

    @Override
    public CourseFormatDto save(CreateCourseFormatRequest request) {
        CourseFormat courseFormat = CourseFormat
                .builder()
                .format(request.getFormat())
                .courseDurationWeeks(request.getCourseDurationWeeks())
                .isOnline(request.getIsOnline())
                .lessonDuration(request.getLessonDuration())
                .lessonsPerWeek(request.getLessonsPerWeek())
                .isActive(true)
                .build();
       CourseFormat savedCourseFormat = courseFormatRepository.save(courseFormat);

        return courseFormatMapper.toDto(savedCourseFormat);
    }

    @Override
    public CourseFormatDto delete(CourseFormatDto courseFormatDto) {
        CourseFormat courseFormat = courseFormatMapper.toEntity(findById(courseFormatDto.getId()));

        courseFormat.setIsActive(false);


        courseFormatRepository.save(courseFormat);


        return courseFormatMapper.toDto(courseFormat);
    }

    @Override
    public List<CourseFormatDto> findAll() {

        List<CourseFormat> courseFormats = courseFormatRepository.findAll();

        return courseFormatMapper.toDtoList(courseFormats);
    }

    @Override
    public CourseFormatDto findById(Long id) {
        CourseFormat courseFormat = courseFormatRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Not Found CourseFormat with " + id + " id")
                );

       return courseFormatMapper.toDto(courseFormat);
    }
}
