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
import org.springframework.web.bind.annotation.*;


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


    @PostMapping ("/delete")
    public ResponseEntity delete(@RequestBody CourseDto courseDto){
        CourseDto deletedCourseDto = courseService.delete(courseDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deletedCourseDto);
    }


    @GetMapping("/find-all")
    public ResponseEntity findAll(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courseService.findAll());
    }


    @GetMapping("/find-by-id")
    public ResponseEntity findById(@RequestParam Long id){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courseService.findById(id));
    }

    @GetMapping("/find-all-by-courseformat")
    public ResponseEntity findByAllByCourseFormatId(@RequestParam Long id){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courseService.findAllByCourseFormatId(id));
    }
}
