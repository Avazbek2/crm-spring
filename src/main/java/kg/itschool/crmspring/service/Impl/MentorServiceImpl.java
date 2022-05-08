package kg.itschool.crmspring.service.Impl;


import kg.itschool.crmspring.models.dto.MentorDto;
import kg.itschool.crmspring.models.entity.Mentor;
import kg.itschool.crmspring.models.mapper.MentorMapper;
import kg.itschool.crmspring.models.request.CreateMentorRequest;
import kg.itschool.crmspring.respository.MentorRepository;
import kg.itschool.crmspring.service.MentorService;
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
public class MentorServiceImpl implements MentorService {

    @NonNull MentorRepository mentorRepository;

    MentorMapper mentorMapper = MentorMapper.INSTANCE;


    @Override
    public MentorDto save(CreateMentorRequest request) {
        Mentor mentor = Mentor
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dob(request.getDob())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .salary(request.getSalary())
                .isActive(true)
                .build();
        Mentor savedMentor = mentorRepository.save(mentor);

        return mentorMapper.toDto(savedMentor);
    }

    @Override
    public MentorDto delete(MentorDto mentorDto) {
        Mentor mentor = mentorMapper.toEntity(findById(mentorDto.getId()));

        mentor.setIsActive(false);


        return mentorMapper.toDto(mentor);
    }

    @Override
    public List<MentorDto> findAllMentors() {
        List<Mentor> mentors = mentorRepository.findAll();


        return mentorMapper.toDtoList(mentors);
    }

    @Override
    public MentorDto findById(Long id) {
        Mentor mentor = mentorRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Not found Mentor with " + id + " id")
                );


        return mentorMapper.toDto(mentor);
    }
}
