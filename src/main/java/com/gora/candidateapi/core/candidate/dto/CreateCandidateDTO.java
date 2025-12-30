package com.gora.candidateapi.core.candidate.dto;

import com.gora.candidateapi.core.candidate.domain.CandidateSkill;
import lombok.Data;

import java.util.List;

@Data
public class CreateCandidateDTO {

    private String email;
    private String firstName;
    private String surname;
    private String telephone;
    private String celphone;
    private String located;
    private List<CandidateSkillDTO> candidateSkills;

}
