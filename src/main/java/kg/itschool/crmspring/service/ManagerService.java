package kg.itschool.crmspring.service;

import kg.itschool.crmspring.models.dto.ManagerDto;
import kg.itschool.crmspring.models.request.CreateManagerRequest;
import sun.util.resources.cldr.mg.LocaleNames_mg;

import java.util.List;

public interface ManagerService {

    ManagerDto save(CreateManagerRequest request);

    ManagerDto delete(ManagerDto managerDto);

    List<ManagerDto> findAllManagers();

    ManagerDto findById(Long id);


}
