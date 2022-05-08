package kg.itschool.crmspring.controller;

import kg.itschool.crmspring.models.dto.GroupDto;
import kg.itschool.crmspring.models.request.CreateGroupRequest;
import kg.itschool.crmspring.service.GroupService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/group")
public class GroupController {

    @NonNull GroupService groupService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CreateGroupRequest request){
        GroupDto savedGroup = groupService.save(request);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedGroup);

    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody GroupDto groupDto){
        GroupDto deletedGroup = groupService.delete(groupDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deletedGroup);

    }


    @GetMapping("/find-all-group-bycourse")
    public ResponseEntity findAllGroupByCourseId(@RequestParam Long id){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupService.findAllGroupByCourseId(id));
    }


    @GetMapping("find-by-id")
    public ResponseEntity findById(@RequestParam Long id){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(groupService.findById(id));
    }

}
