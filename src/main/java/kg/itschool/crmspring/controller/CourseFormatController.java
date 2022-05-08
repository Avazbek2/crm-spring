package kg.itschool.crmspring.controller;

import kg.itschool.crmspring.models.dto.CourseFormatDto;
import kg.itschool.crmspring.models.request.CreateCourseFormatRequest;
import kg.itschool.crmspring.service.CourseFormatService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course-format")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseFormatController {

    @NonNull CourseFormatService courseFormatService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CreateCourseFormatRequest request){

         CourseFormatDto courseFormatDto = courseFormatService.save(request);

         return ResponseEntity
                 .status(HttpStatus.CREATED)
                 .body(courseFormatDto);

    }
}
