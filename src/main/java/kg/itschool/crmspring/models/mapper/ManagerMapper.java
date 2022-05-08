package kg.itschool.crmspring.models.mapper;

import kg.itschool.crmspring.models.dto.ManagerDto;
import kg.itschool.crmspring.models.entity.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ManagerMapper{

    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);

    Manager toEntity(ManagerDto dto);
    ManagerDto toDto(Manager entity);
    List<Manager> toEntityList(List<ManagerDto> dtoList);
    List<ManagerDto> toDtoList(List<Manager> entityList);
}
