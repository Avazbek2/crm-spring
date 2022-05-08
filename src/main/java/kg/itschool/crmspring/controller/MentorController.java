package kg.itschool.crmspring.controller;

import kg.itschool.crmspring.models.dto.MentorDto;
import kg.itschool.crmspring.models.request.CreateMentorRequest;
import kg.itschool.crmspring.service.MentorService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mentor")
public class MentorController {

    @NonNull MentorService mentorService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CreateMentorRequest request){
        MentorDto mentorDto = mentorService.save(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mentorDto);

    }


    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody MentorDto mentorDto){
        MentorDto deletedMentorDto = mentorService.delete(mentorDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deletedMentorDto);

    }

    @GetMapping("/find-by-id")
    public ResponseEntity findById(@RequestParam Long id){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mentorService.findById(id));
    }

    @GetMapping("/find-all-mentors")
    public ResponseEntity findAllMentors(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mentorService.findAllMentors());
    }
}
