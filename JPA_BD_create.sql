-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-12-14 19:12:19.632

-- tables
-- Table: ALUMNO
CREATE TABLE ALUMNO (
    CODPER int NOT NULL,
    NOMPER varchar(100) NOT NULL,
    APEPER varchar(100) NOT NULL,
    DNIPER char(8) NOT NULL,
    DIRPER varchar(200) NOT NULL,
    CONSTRAINT ALUMNO_pk PRIMARY KEY (CODPER)
);

-- Table: CLASE
CREATE TABLE CLASE (
    CODCLAS int NOT NULL,
    CODCUREDET int NOT NULL,
    CODPER_ALU int NOT NULL,
    NOTACLAS varchar(2) NOT NULL,
    FECHCLAS date NOT NULL,
    ASISCLAS char(1) NOT NULL,
    CONSTRAINT CLASE_pk PRIMARY KEY (CODCLAS)
);

-- Table: CURSO
CREATE TABLE CURSO (
    CODCUR int NOT NULL,
    NOMCUR varchar(50) NOT NULL,
    CONSTRAINT CURSO_pk PRIMARY KEY (CODCUR)
);

-- Table: CURSO_DET
CREATE TABLE CURSO_DET (
    CODCUREDET int NOT NULL,
    CODCUR int NOT NULL,
    CODPROF int NOT NULL,
    CONSTRAINT CURSO_DET_pk PRIMARY KEY (CODCUREDET)
);

-- Table: PROFESOR
CREATE TABLE PROFESOR (
    CODPROF int NOT NULL,
    NOMPROF varchar(100) NOT NULL,
    APEPROF varchar(100) NOT NULL,
    DNIPROF char(8) NOT NULL,
    DIRPROF varchar(200) NOT NULL,
    CONSTRAINT PROFESOR_pk PRIMARY KEY (CODPROF)
);

-- foreign keys
-- Reference: CLAS_CUR_DET_COD (table: CLASE)
ALTER TABLE CLASE ADD CONSTRAINT CLAS_CUR_DET_COD FOREIGN KEY CLAS_CUR_DET_COD (CODCUREDET)
    REFERENCES CURSO_DET (CODCUREDET);

-- Reference: CLAS_PER_CODPER_ALU (table: CLASE)
ALTER TABLE CLASE ADD CONSTRAINT CLAS_PER_CODPER_ALU FOREIGN KEY CLAS_PER_CODPER_ALU (CODPER_ALU)
    REFERENCES ALUMNO (CODPER);

-- Reference: CURSO_DET_PROF_CODPROF (table: CURSO_DET)
ALTER TABLE CURSO_DET ADD CONSTRAINT CURSO_DET_PROF_CODPROF FOREIGN KEY CURSO_DET_PROF_CODPROF (CODPROF)
    REFERENCES PROFESOR (CODPROF);

-- Reference: CUR_DET_CURSO_CODCUR (table: CURSO_DET)
ALTER TABLE CURSO_DET ADD CONSTRAINT CUR_DET_CURSO_CODCUR FOREIGN KEY CUR_DET_CURSO_CODCUR (CODCUR)
    REFERENCES CURSO (CODCUR);

-- End of file.
