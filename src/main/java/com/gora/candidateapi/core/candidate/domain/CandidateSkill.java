package com.gora.candidateapi.core.candidate.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
@Table(name = "candidate_skills")
public class CandidateSkill {

    @Id
    @NonNull
    @Column(name = "id_skill")
    private CandidateSkillId candidateSkillId;

    @NonNull
    @Column(name = "id_candidate")
    private CandidateId candidateId;

    @NonNull
    private String nameSkill;

    @NonNull
    private String levelSkill;

    public CandidateSkill(CandidateSkillBuilder candidateSkillBuilder){
        this.candidateSkillId = candidateSkillBuilder.candidateSkillId;
        this.candidateId = candidateSkillBuilder.candidateId;
        this.nameSkill = candidateSkillBuilder.nameSkill;
        this.levelSkill = candidateSkillBuilder.levelSkill;
    }

    public static CandidateSkillBuilder builder() {
        return new CandidateSkillBuilder();
    }
}
