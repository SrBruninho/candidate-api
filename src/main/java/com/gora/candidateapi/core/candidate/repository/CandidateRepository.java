package com.gora.candidateapi.core.candidate.repository;

import com.gora.candidateapi.core.candidate.domain.Candidate;
import com.gora.candidateapi.core.candidate.domain.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {
}
