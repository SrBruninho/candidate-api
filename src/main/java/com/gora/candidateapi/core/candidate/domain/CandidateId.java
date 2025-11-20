package com.gora.candidateapi.core.candidate.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.gora.candidateapi.infra.persistence.uuid.UUIDWrapper;

import java.util.UUID;

public class CandidateId extends UUIDWrapper {

    protected CandidateId(UUID value) {
        super(value);
    }

    public static CandidateId generate() {
        return new CandidateId(UUID.randomUUID());
    }

    @JsonCreator
    public static CandidateId from(String value) {
        return value != null ? new CandidateId(UUID.fromString(value)) : null;
    }
}
