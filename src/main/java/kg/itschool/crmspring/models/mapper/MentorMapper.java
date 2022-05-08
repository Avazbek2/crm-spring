package kg.itschool.crmspring.models.mapper;

import kg.itschool.crmspring.models.dto.MentorDto;
import kg.itschool.crmspring.models.entity.Mentor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MentorMapper {
    MentorMapper INSTANCE = Mappers.getMapper(MentorMapper.class);

    Mentor toEntity(MentorDto dto);
    MentorDto toDto(Mentor entity);
    List<Mentor> toEntityList(List<MentorDto> dtoList);
    List<MentorDto> toDtoList(List<Mentor> entityList);

}
