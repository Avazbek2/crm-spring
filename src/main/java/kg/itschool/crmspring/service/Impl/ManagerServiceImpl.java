package kg.itschool.crmspring.service.Impl;

import kg.itschool.crmspring.models.dto.ManagerDto;
import kg.itschool.crmspring.models.entity.Manager;
import kg.itschool.crmspring.models.mapper.ManagerMapper;
import kg.itschool.crmspring.models.request.CreateManagerRequest;
import kg.itschool.crmspring.respository.ManagerRepository;
import kg.itschool.crmspring.service.ManagerService;
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
public class ManagerServiceImpl implements ManagerService {

    @NonNull ManagerRepository managerRepository;

    ManagerMapper managerMapper = ManagerMapper.INSTANCE;



    @Override
    public ManagerDto save(CreateManagerRequest request) {
        Manager manager = Manager
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .dob(request.getDob())
                .phoneNumber(request.getPhoneNumber())
                .salary(request.getSalary())
                .isActive(true)
                .build();
         Manager savedManager = managerRepository.save(manager);



        return managerMapper.toDto(savedManager);
    }

    @Override
    public ManagerDto delete(ManagerDto managerDto) {
        Manager manager = managerMapper.toEntity(findById(managerDto.getId()));

        manager.setIsActive(false);

        return managerMapper.toDto(manager);
    }

    @Override
    public List<ManagerDto> findAllManagers() {
        List<Manager> managers = managerRepository.findAll();

        return managerMapper.toDtoList(managers);
    }

    @Override
    public ManagerDto findById(Long id) {
        Manager manager = managerRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Not found Manager with " + id + " id")
                );


        return managerMapper.toDto(manager);
    }
}
