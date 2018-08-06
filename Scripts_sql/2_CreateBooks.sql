CREATE SEQUENCE public.ouvrage_id_ouvrage_seq;

CREATE TABLE public.ouvrage (
  id_ouvrage INTEGER NOT NULL DEFAULT nextval('public.ouvrage_id_ouvrage_seq'),
  titre VARCHAR(100) NOT NULL,
  auteur VARCHAR(100) NOT NULL,
  nombre_disponible INTEGER NOT NULL,
  CONSTRAINT ouvrage_pk PRIMARY KEY (id_ouvrage)
);


ALTER SEQUENCE public.ouvrage_id_ouvrage_seq OWNED BY public.ouvrage.id_ouvrage;
