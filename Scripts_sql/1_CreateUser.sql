CREATE SEQUENCE public.utilisateur_id_utilisateur_seq;

CREATE TABLE public.utilisateur (
  id_utilisateur INTEGER NOT NULL DEFAULT nextval('public.utilisateur_id_utilisateur_seq'),
  nom VARCHAR(100) NOT NULL,
  prenom VARCHAR(50) NOT NULL,
  mail VARCHAR(150) NOT NULL,
  mot_de_passe VARCHAR(50) NOT NULL,
  pseudonyme VARCHAR(100) NOT NULL,
  CONSTRAINT utilisateur_pk PRIMARY KEY (id_utilisateur)
);


ALTER SEQUENCE public.utilisateur_id_utilisateur_seq OWNED BY public.utilisateur.id_utilisateur;
