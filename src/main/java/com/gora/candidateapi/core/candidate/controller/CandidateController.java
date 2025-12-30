package com.gora.candidateapi.core.candidate.controller;

import com.gora.candidateapi.core.candidate.domain.CandidateId;
import com.gora.candidateapi.core.candidate.dto.CreateCandidateDTO;
import com.gora.candidateapi.core.candidate.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.util.UriComponentsBuilder.fromPath;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = CandidateController.PATH, produces = APPLICATION_JSON_VALUE)
public class CandidateController {

    public static final String PATH = "/api/v1/candidates";

    private final CandidateService candidateService;

    @PostMapping
    public ResponseEntity<CandidateId> create(CreateCandidateDTO createCandidateDTO){
        var candidateId = candidateService.registerCandidate(createCandidateDTO);

        return ResponseEntity.created(
                fromPath(CandidateController.PATH + "/{id}").build(candidateId.asString())
        ).body(candidateId);
    }
}
