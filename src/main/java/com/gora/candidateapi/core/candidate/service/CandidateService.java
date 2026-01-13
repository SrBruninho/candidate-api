package com.gora.candidateapi.core.candidate.service;

import com.gora.candidateapi.core.candidate.domain.Candidate;
import com.gora.candidateapi.core.candidate.domain.CandidateId;
import com.gora.candidateapi.core.candidate.domain.CandidateSkill;
import com.gora.candidateapi.core.candidate.domain.CandidateSkillBuilder;
import com.gora.candidateapi.core.candidate.domain.CandidateSkillId;
import com.gora.candidateapi.core.candidate.dto.CandidateSkillDTO;
import com.gora.candidateapi.core.candidate.dto.CreateCandidateDTO;
import com.gora.candidateapi.core.candidate.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateId registerCandidate(CreateCandidateDTO createCandidateDTO) {
        var candidate = Candidate
                .builder()
                .candidateId(CandidateId.generate())
                .email(createCandidateDTO.getEmail())
                .firstName(createCandidateDTO.getFirstName())
                .surname(createCandidateDTO.getSurname())
                .telephone(createCandidateDTO.getTelephone())
                .celphone(createCandidateDTO.getCelphone())
                .located(createCandidateDTO.getLocated())
                .candidateSkills(mapToCandidateSkills(createCandidateDTO.getCandidateSkills()))
                .build();

        return candidateRepository.save(candidate).getCandidateId();
    }

    private List<CandidateSkill> mapToCandidateSkills(List<CandidateSkillDTO> candidateSkillsDTO){
        return candidateSkillsDTO
                .stream()
                .map(candidateSkillDTO -> CandidateSkill
                        .builder()
                        .candidateId(candidateSkillDTO.getCandidateId())
                        .nameSkill(candidateSkillDTO.getNameSkill())
                        .levelSkill(candidateSkillDTO.getLevelSkill())
                        .build())
                .toList();
    }

}
