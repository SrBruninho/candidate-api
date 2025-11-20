package com.gora.candidateapi.core.candidate.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.gora.candidateapi.infra.persistence.uuid.UUIDWrapper;

import java.util.UUID;

public class CandidateSkillId extends UUIDWrapper {

    protected CandidateSkillId(UUID value) {
        super(value);
    }

    public static CandidateSkillId generate() {
        return new CandidateSkillId(UUID.randomUUID());
    }

    @JsonCreator
    public static CandidateSkillId from(String value) {
        return value != null ? new CandidateSkillId(UUID.fromString(value)) : null;
    }
}
