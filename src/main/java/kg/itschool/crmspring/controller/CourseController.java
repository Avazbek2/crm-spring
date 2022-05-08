package kg.itschool.crmspring.controller;

import kg.itschool.crmspring.models.dto.CourseDto;
import kg.itschool.crmspring.models.request.CreateCourseRequest;
import kg.itschool.crmspring.service.CourseService;
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
@RequestMapping("/api/v1/course")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseController {

    @NonNull CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CreateCourseRequest request){
        CourseDto courseDto = courseService.save(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(courseDto);
    }


}
