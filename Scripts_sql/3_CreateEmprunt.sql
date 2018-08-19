CREATE SEQUENCE public.emprunt_id_emprunt_seq;

CREATE TABLE public.emprunt (
  id_emprunt INTEGER NOT NULL DEFAULT nextval('public.emprunt_id_emprunt_seq'),
  id_utilisateur INTEGER NOT NULL,
  id_ouvrage INTEGER NOT NULL,
  date_debut DATE NOT NULL,
  date_fin DATE NOT NULL,
  etat VARCHAR(80) NOT NULL,
  CONSTRAINT emprunt_pk PRIMARY KEY (id_emprunt)
);


ALTER SEQUENCE public.emprunt_id_emprunt_seq OWNED BY public.emprunt.id_emprunt;

ALTER TABLE public.emprunt ADD CONSTRAINT ouvrage_emprunt_fk
FOREIGN KEY (id_ouvrage)
REFERENCES public.ouvrage (id_ouvrage)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.emprunt ADD CONSTRAINT utilisateur_emprunt_fk
FOREIGN KEY (id_utilisateur)
REFERENCES public.utilisateur (id_utilisateur)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
