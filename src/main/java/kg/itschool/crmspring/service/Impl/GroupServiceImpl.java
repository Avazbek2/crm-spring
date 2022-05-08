package kg.itschool.crmspring.service.Impl;


import kg.itschool.crmspring.models.dto.GroupDto;
import kg.itschool.crmspring.models.entity.Group;
import kg.itschool.crmspring.models.mapper.CourseMapper;
import kg.itschool.crmspring.models.mapper.GroupMapper;
import kg.itschool.crmspring.models.mapper.MentorMapper;
import kg.itschool.crmspring.models.request.CreateGroupRequest;
import kg.itschool.crmspring.respository.GroupRepository;
import kg.itschool.crmspring.service.GroupService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class GroupServiceImpl implements GroupService {

    @NonNull GroupRepository groupRepository;

    GroupMapper groupMapper = GroupMapper.INSTANCE;

    CourseMapper courseMapper  = CourseMapper.INSTANCE;

    MentorMapper mentorMapper = MentorMapper.INSTANCE;

    @Override
    public GroupDto save(CreateGroupRequest request) {

        Group group = Group
                .builder()
                .name(request.getName())
                .groupTime(request.getGroupTime())
                .course(courseMapper.toEntity(request.getCourse()))
                .mentor(mentorMapper.toEntity(request.getMentor()))
                .isActive(true)
                .build();

         Group savedGroup = groupRepository.save(group);

        return groupMapper.toDto(savedGroup);
    }

    @Override
    public GroupDto delete(GroupDto groupDto) {
        Group group = groupMapper.toEntity(findById(groupDto.getId()));

        group.setIsActive(false);

        groupRepository.save(group);

        return groupMapper.toDto(group);
    }

    @Override
    public List<GroupDto> findAllGroupByCourseId(Long id) {
        List<Group> groups = groupRepository.findAll();

        return groupMapper.toDtoList(groups);
    }

    @Override
    public GroupDto findById(Long id) {
         Group group = groupRepository
                 .findById(id)
                 .orElseThrow(
                         () -> new RuntimeException("Not Found Group with " + id + " id")
                 );

        return groupMapper.toDto(group);
    }
}
