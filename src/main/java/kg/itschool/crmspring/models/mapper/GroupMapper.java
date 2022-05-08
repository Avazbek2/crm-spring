package kg.itschool.crmspring.models.mapper;

import kg.itschool.crmspring.models.dto.GroupDto;
import kg.itschool.crmspring.models.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GroupMapper {

    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    Group toEntity(GroupDto dto);
    GroupDto toDto(Group entity);
    List<Group> toEntityList(List<GroupDto> dtoList);
    List<GroupDto> toDtoList(List<Group> entityList);

}