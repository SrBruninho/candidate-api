package com.gora.candidateapi.core.candidate.dto;

import com.gora.candidateapi.core.candidate.domain.CandidateId;
import lombok.Data;

@Data
public class CandidateSkillDTO {

    private CandidateId candidateId;
    private String nameSkill;
    private String levelSkill;

}
