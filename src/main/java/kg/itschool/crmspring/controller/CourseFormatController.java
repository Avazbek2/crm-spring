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
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody CourseFormatDto courseFormatDto){
        CourseFormatDto deletedCourseFormatDto = courseFormatService.delete(courseFormatDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deletedCourseFormatDto);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity findById(@RequestParam Long id){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courseFormatService.findById(id));
    }


    @GetMapping("/get-all")
    public ResponseEntity findAll(){


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(courseFormatService.findAll());
    }



}
