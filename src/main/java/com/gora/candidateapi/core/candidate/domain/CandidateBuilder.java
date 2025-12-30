package com.gora.candidateapi.core.candidate.domain;

import java.util.List;

import static java.util.Objects.isNull;

public class CandidateBuilder {

    protected CandidateId candidateId;
    protected String firstName;
    protected String surname;
    protected String email;
    protected String telephone;
    protected String celphone;
    protected String located;
    protected List<CandidateSkill> candidateSkills;

    public CandidateBuilder candidateId(CandidateId candidateId){
        this.candidateId = candidateId;
        return this;
    }

    public CandidateBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public CandidateBuilder surname(String surname){
        this.surname = surname;
        return this;
    }

    public CandidateBuilder email(String email){
        this.email = email;
        return this;
    }

    public CandidateBuilder telephone(String telephone){
        this.telephone = telephone;
        return this;
    }

    public CandidateBuilder celphone(String celphone){
        this.celphone = celphone;
        return this;
    }

    public CandidateBuilder located(String located){
        this.located = located;
        return this;
    }

    public CandidateBuilder candidateSkills(List<CandidateSkill> candidateSkills){
        this.candidateSkills = candidateSkills;
        return this;
    }

    public Candidate build(){
        if(isNull(this.candidateId))
            this.candidateId = CandidateId.generate();

        return new Candidate(this);
    }

}
