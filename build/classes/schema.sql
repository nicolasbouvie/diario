-- DROP DATABASE diarioclasse;
-- Create database diarioclasse
CREATE DATABASE diarioclasse
  WITH OWNER = diario
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       CONNECTION LIMIT = -1;

-- Connect to database diarioclasse

-- Create sequence pessoa_codigo
CREATE SEQUENCE pessoa_codigo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE pessoa_codigo OWNER TO diario;

-- Create table pessoa_codigo
CREATE TABLE public.pessoa
(
   codigo bigint NOT NULL DEFAULT nextval('pessoa_codigo'::regclass), 
   nome character varying(255) NOT NULL, 
   ddd int, 
   telefone bigint, 
   endereco character varying(255), 
   email character varying(128) NOT NULL, 
   tipo int NOT NULL, 
   CONSTRAINT pk_pessoa PRIMARY KEY (codigo)
) 
WITH (
  OIDS = FALSE
)
;
COMMENT ON COLUMN public.pessoa.codigo IS 'chave primaria da tabela pessoa';
COMMENT ON COLUMN public.pessoa.nome IS 'Nome completo da pessoa';
COMMENT ON COLUMN public.pessoa.ddd IS 'codigo de area do telefone';
COMMENT ON COLUMN public.pessoa.telefone IS 'Telefone da contato';
COMMENT ON COLUMN public.pessoa.endereco IS 'EnereÃ§o da pessoa';
COMMENT ON COLUMN public.pessoa.email IS 'Email de contato';
COMMENT ON COLUMN public.pessoa.tipo IS 'Determina a funÃ§Ã£o da pessoa na instituicao. 1:Professor - 2:Estudante';

-- Create sequence disciplina_codigo
CREATE SEQUENCE disciplina_codigo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE disciplina_codigo OWNER TO diario;

-- Create table disciplina
CREATE TABLE public.disciplina
(
   codigo bigint NOT NULL DEFAULT nextval('disciplina_codigo'::regclass), 
   nome character varying(255) NOT NULL,
   CONSTRAINT pk_disciplina PRIMARY KEY (codigo)
) 
WITH (
  OIDS = FALSE
);
COMMENT ON COLUMN public.disciplina.codigo IS 'chave primaria da tabela disciplina';
COMMENT ON COLUMN public.disciplina.nome IS 'Nome da disciplina';

-- Create sequence disciplina_codigo
CREATE SEQUENCE turma_codigo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE turma_codigo OWNER TO diario;

-- Create table turma
CREATE TABLE public.turma
(
   codigo bigint NOT NULL DEFAULT nextval('turma_codigo'::regclass), 
   codigo_disciplina bigint NOT NULL,
   codigo_professor bigint NOT NULL,
   datainicio timestamp without time zone,
   datafim timestamp without time zone,
   quantidadeaulas bigint,
   CONSTRAINT pk_turma PRIMARY KEY (codigo),
   CONSTRAINT fk_disciplina_codigo FOREIGN KEY (codigo_disciplina)
      REFERENCES public.disciplina (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT fk_professor_codigo FOREIGN KEY (codigo_professor)
      REFERENCES public.pessoa (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITH (
  OIDS = FALSE
);
COMMENT ON COLUMN public.turma.codigo IS 'chave primaria da tabela turma';
COMMENT ON COLUMN public.turma.codigo_disciplina IS 'codigo da disciplina';
COMMENT ON COLUMN public.turma.codigo_professor IS 'codigo do professor';
COMMENT ON COLUMN public.turma.datainicio IS 'data inicio da disciplina';
COMMENT ON COLUMN public.turma.datafim IS 'data fim da disciplina';
COMMENT ON COLUMN public.turma.quantidadeaulas IS 'quantidade de aulas que serÃ¡ realizado para a disciplina';

-- Create sequence alunoturma_codigo
CREATE TABLE public.alunoturma
( 
   codigo_aluno bigint NOT NULL,
   codigo_turma bigint NOT NULL,
   CONSTRAINT pk_alunoturma PRIMARY KEY (codigo_aluno, codigo_turma),
   CONSTRAINT fk_aluno_codigo FOREIGN KEY (codigo_aluno)
      REFERENCES public.pessoa (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT fk_turma_codigo FOREIGN KEY (codigo_turma)
      REFERENCES public.turma (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITH (
  OIDS = FALSE
);
COMMENT ON COLUMN public.alunoturma.codigo_aluno IS 'codigo do aluno';
COMMENT ON COLUMN public.alunoturma.codigo_turma IS 'codigo da turma';

-- Create sequence frequencia_codigo
CREATE SEQUENCE frequencia_codigo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE frequencia_codigo OWNER TO diario;

-- Create table frequencia_codigo
CREATE TABLE public.frequencia
(
   codigo bigint NOT NULL DEFAULT nextval('frequencia_codigo'::regclass), 
   codigo_aluno bigint NOT NULL,
   codigo_turma bigint NOT NULL,
   aula bigint,
   presenca character(1),
   CONSTRAINT pk_frequencia PRIMARY KEY (codigo),
   CONSTRAINT fk_frequencia_aluno_codigo FOREIGN KEY (codigo_aluno)
      REFERENCES public.pessoa (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
   CONSTRAINT fk_frequencia_turma_codigo FOREIGN KEY (codigo_turma)
      REFERENCES public.turma (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITH (
  OIDS = FALSE
);
COMMENT ON COLUMN public.frequencia.codigo IS 'chave primaria da tabela alunoturma';
COMMENT ON COLUMN public.frequencia.codigo_aluno IS 'codigo do aluno';
COMMENT ON COLUMN public.frequencia.codigo_turma IS 'codigo da turma';
COMMENT ON COLUMN public.frequencia.aula IS 'numero que representa a aula da disciplina';
COMMENT ON COLUMN public.frequencia.presenca IS 'P : aluno presente - F : aluno faltou - J : falta justificada';
