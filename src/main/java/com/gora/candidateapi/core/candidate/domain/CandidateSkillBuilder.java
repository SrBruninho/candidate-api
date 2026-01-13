package com.gora.candidateapi.core.candidate.domain;

import static java.util.Objects.isNull;

public class CandidateSkillBuilder {

    protected CandidateSkillId candidateSkillId;
    protected CandidateId candidateId;
    protected String nameSkill;
    protected String levelSkill;

    public CandidateSkillBuilder candidateSkillId(CandidateSkillId candidateSkillId){
        this.candidateSkillId = candidateSkillId;
        return this;
    }

    public CandidateSkillBuilder candidateId(CandidateId candidateId){
        this.candidateId = candidateId;
        return this;
    }

    public CandidateSkillBuilder nameSkill(String nameSkill){
        this.nameSkill = nameSkill;
        return this;
    }

    public CandidateSkillBuilder levelSkill(String levelSkill){
        this.levelSkill = levelSkill;
        return this;
    }

    public CandidateSkill build(){
        if(isNull(this.candidateSkillId))
            this.candidateSkillId = CandidateSkillId.generate();

        return new CandidateSkill(this);
    }
}
