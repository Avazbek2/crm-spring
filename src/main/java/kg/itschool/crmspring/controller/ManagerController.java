package kg.itschool.crmspring.controller;

import kg.itschool.crmspring.models.dto.ManagerDto;
import kg.itschool.crmspring.models.request.CreateManagerRequest;
import kg.itschool.crmspring.service.ManagerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/manager")
public class ManagerController {

    @NonNull ManagerService managerService;

    @PostMapping("/save")
    public ResponseEntity save(CreateManagerRequest request){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(managerService.save(request));
    }


    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody ManagerDto managerDto){
        ManagerDto deletedManagerDto = managerService.delete(managerDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(deletedManagerDto);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity findById(@RequestParam Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(managerService.findById(id));
    }


    @GetMapping("/find-all-managers")
    public ResponseEntity findAllManagers(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(managerService.findAllManagers());
    }
}
