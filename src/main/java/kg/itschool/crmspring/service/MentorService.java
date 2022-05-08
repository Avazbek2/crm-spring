package kg.itschool.crmspring.service;

import kg.itschool.crmspring.models.dto.MentorDto;
import kg.itschool.crmspring.models.request.CreateMentorRequest;

import java.util.List;

public interface MentorService {

    MentorDto save(CreateMentorRequest request);

    MentorDto delete(MentorDto mentorDto);

    List<MentorDto> findAllMentors();

    MentorDto findById(Long id);
}
