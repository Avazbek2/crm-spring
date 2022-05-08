package kg.itschool.crmspring.service;

import kg.itschool.crmspring.models.dto.GroupDto;
import kg.itschool.crmspring.models.request.CreateGroupRequest;

import java.util.List;

public interface GroupService {

    GroupDto save(CreateGroupRequest request);

    GroupDto delete(GroupDto groupDto);

    List<GroupDto> findAllGroupByCourseId(Long id);

    GroupDto findById(Long id);


}
