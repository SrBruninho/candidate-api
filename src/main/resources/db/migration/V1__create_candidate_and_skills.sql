CREATE TABLE candidate (
    id UUID  NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    telephone VARCHAR(20),
    celphone VARCHAR(20),
    located VARCHAR(50),

     created_at      TIMESTAMPTZ     NOT NULL DEFAULT NOW(),
     updated_at      TIMESTAMPTZ     NOT NULL DEFAULT NOW(),
     created_by      VARCHAR(64)     NOT NULL DEFAULT 'unknown',
     updated_by      VARCHAR(64)     NOT NULL DEFAULT 'unknown',

    CONSTRAINT pk_candidate PRIMARY KEY (id)
);

CREATE TABLE candidate_skills (
    id_skill UUID NOT NULL,
    id_candidate UUID NOT NULL,
    name_skill VARCHAR(100) NOT NULL,
    level_skill VARCHAR(50) NOT NULL,

    CONSTRAINT pk_candidate_skills PRIMARY KEY (id_skill),
    CONSTRAINT fk_candidate FOREIGN KEY(id_candidate) REFERENCES candidate(id)
);

CREATE INDEX idx_candidate_skills_id_candidate ON candidate_skills(id_candidate);
