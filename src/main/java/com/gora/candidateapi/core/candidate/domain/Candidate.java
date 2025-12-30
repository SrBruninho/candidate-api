package com.gora.candidateapi.core.candidate.domain;

import com.gora.candidateapi.infra.persistence.auditing.AuditableEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
@Table
public class Candidate extends AuditableEntity {

    @Id
    @NonNull
    private CandidateId candidateId;

    private String firstName;
    private String surname;

    @NonNull
    private String email;
    private String telephone;
    private String celphone;
    private String located;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "candidateId", referencedColumnName = "candidateId", nullable = false, insertable = false)
    private List<CandidateSkill> candidateSkills;

    public Candidate(CandidateBuilder candidateBuilder){
        this.candidateId = candidateBuilder.candidateId;
        this.firstName = candidateBuilder.firstName;
        this.surname = candidateBuilder.surname;
        this.email = candidateBuilder.email;
        this.telephone = candidateBuilder.telephone;
        this.celphone = candidateBuilder.celphone;
        this.located = candidateBuilder.located;
        this.candidateSkills = candidateBuilder.candidateSkills;
    }

    public static CandidateBuilder builder() {
        return new CandidateBuilder();
    }

}
