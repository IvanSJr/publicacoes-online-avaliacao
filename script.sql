--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-08-08 16:54:59

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 16397)
-- Name: processo; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.processo (
    id integer NOT NULL,
    codigo_processo integer,
    usuario_id integer
);


--
-- TOC entry 200 (class 1259 OID 16395)
-- Name: processo_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.processo ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.processo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 203 (class 1259 OID 16404)
-- Name: reu; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.reu (
    id integer NOT NULL,
    cpf_reu character varying(255),
    nome_reu character varying(255),
    processo_id integer
);


--
-- TOC entry 202 (class 1259 OID 16402)
-- Name: reu_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.reu ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.reu_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 205 (class 1259 OID 16414)
-- Name: usuario; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.usuario (
    id integer NOT NULL,
    email character varying(255),
    nome character varying(255),
    senha character varying(255)
);


--
-- TOC entry 204 (class 1259 OID 16412)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.usuario ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2865 (class 2606 OID 16401)
-- Name: processo processo_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.processo
    ADD CONSTRAINT processo_pkey PRIMARY KEY (id);


--
-- TOC entry 2869 (class 2606 OID 16411)
-- Name: reu reu_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.reu
    ADD CONSTRAINT reu_pkey PRIMARY KEY (id);


--
-- TOC entry 2867 (class 2606 OID 16423)
-- Name: processo uk_qgtuvvnr1836c4powclxw1su2; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.processo
    ADD CONSTRAINT uk_qgtuvvnr1836c4powclxw1su2 UNIQUE (codigo_processo);


--
-- TOC entry 2871 (class 2606 OID 16421)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2873 (class 2606 OID 16429)
-- Name: reu fk1qnk7d655vxp6na1l3ipv42sv; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.reu
    ADD CONSTRAINT fk1qnk7d655vxp6na1l3ipv42sv FOREIGN KEY (processo_id) REFERENCES public.processo(id);


--
-- TOC entry 2872 (class 2606 OID 16424)
-- Name: processo fkfbpkagl5i7rljm0pp7ip3uq7f; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.processo
    ADD CONSTRAINT fkfbpkagl5i7rljm0pp7ip3uq7f FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);


-- Completed on 2021-08-08 16:55:01

--
-- PostgreSQL database dump complete
--

