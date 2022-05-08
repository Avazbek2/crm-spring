package kg.itschool.crmspring.controller;

import kg.itschool.crmspring.models.dto.StudentDto;
import kg.itschool.crmspring.models.request.CreateStudentRequest;
import kg.itschool.crmspring.service.StudentService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentController {

    @NonNull StudentService studentService;


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CreateStudentRequest request){
        StudentDto studentDto = studentService.save(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentDto);
    }

    public ResponseEntity delete(@RequestBody StudentDto studentDto){
        StudentDto deletedStudentDto = studentService.delete(studentDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deletedStudentDto);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity findById(@RequestParam Long id){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.findById(id));
    }

    @GetMapping("/find-by-groupid")
    public ResponseEntity findStudentsByGroupId(@RequestParam Long id){


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.findStudentsByGroupId(id));
    }


}
