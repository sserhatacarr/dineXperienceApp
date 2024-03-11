--
-- PostgreSQL database dump
--

-- Dumped from database version 15.6 (Ubuntu 15.6-0ubuntu0.23.10.1)
-- Dumped by pg_dump version 15.6 (Ubuntu 15.6-0ubuntu0.23.10.1)

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: user_reviews; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_reviews (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    creator_id bigint,
    updated_at timestamp(6) without time zone,
    updated_id bigint,
    comment character varying(255),
    restaurant_id bigint,
    user_rate numeric(38,2),
    user_id bigint
);


ALTER TABLE public.user_reviews OWNER TO postgres;

--
-- Name: user_reviews_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_reviews_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_reviews_id_seq OWNER TO postgres;

--
-- Name: user_reviews_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_reviews_id_seq OWNED BY public.user_reviews.id;


--
-- Name: user_reviews_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_reviews_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_reviews_seq OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    creator_id bigint,
    updated_at timestamp(6) without time zone,
    updated_id bigint,
    birth_date date,
    email character varying(100) NOT NULL,
    gender character varying(30),
    latitude double precision NOT NULL,
    longitude double precision NOT NULL,
    name character varying(50) NOT NULL,
    surname character varying(50) NOT NULL,
    user_status character varying(30) NOT NULL,
    CONSTRAINT users_gender_check CHECK (((gender)::text = ANY ((ARRAY['MALE'::character varying, 'FEMALE'::character varying])::text[]))),
    CONSTRAINT users_user_status_check CHECK (((user_status)::text = ANY ((ARRAY['ACTIVE'::character varying, 'INACTIVE'::character varying])::text[])))
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: user_reviews id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_reviews ALTER COLUMN id SET DEFAULT nextval('public.user_reviews_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: user_reviews; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_reviews (id, created_at, creator_id, updated_at, updated_id, comment, restaurant_id, user_rate, user_id) FROM stdin;
1	2024-03-11 17:57:10.354737	3	2024-03-11 17:57:10.354737	1	Great food!	1	1.00	1
2	2024-03-11 17:57:10.354737	2	2024-03-11 17:57:10.354737	2	Good service	1	2.00	2
3	2024-03-11 17:57:10.354737	4	2024-03-11 17:57:10.354737	3	Excellent atmosphere	2	3.00	3
4	2024-03-11 17:57:10.354737	1	2024-03-11 17:57:10.354737	4	Could be better	2	4.00	4
5	2024-03-11 17:57:10.354737	3	2024-03-11 17:57:10.354737	5	Nice place	3	5.00	5
6	2024-03-11 17:57:10.354737	2	2024-03-11 17:57:10.354737	6	Average food	3	1.00	6
7	2024-03-11 17:57:10.354737	4	2024-03-11 17:57:10.354737	7	Loved it!	4	2.00	7
8	2024-03-11 17:57:10.354737	1	2024-03-11 17:57:10.354737	8	Not my favorite	4	3.00	8
9	2024-03-11 17:57:10.354737	3	2024-03-11 17:57:10.354737	9	Good overall	5	4.00	9
10	2024-03-11 17:57:10.354737	2	2024-03-11 17:57:10.354737	10	Okay experience	5	5.00	10
11	2024-03-11 20:58:29.54239	\N	2024-03-11 20:58:29.542434	\N	string	1	0.00	1
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, created_at, creator_id, updated_at, updated_id, birth_date, email, gender, latitude, longitude, name, surname, user_status) FROM stdin;
1	2022-01-01 00:00:00	1	2022-01-01 00:00:00	1	1990-01-15	john.doe@example.com	MALE	40.7128	-74.006	John	Doe	ACTIVE
2	2022-01-02 00:00:00	2	2022-01-02 00:00:00	2	1985-05-20	jane.smith@example.com	FEMALE	34.0522	-118.2437	Jane	Smith	ACTIVE
3	2022-01-03 00:00:00	1	2022-01-03 00:00:00	1	1998-08-10	bob.jones@example.com	MALE	51.5074	-0.1278	Bob	Jones	ACTIVE
4	2022-01-04 00:00:00	3	2022-01-04 00:00:00	3	1980-03-25	alice.miller@example.com	FEMALE	52.52	13.405	Alice	Miller	INACTIVE
5	2022-01-05 00:00:00	2	2022-01-05 00:00:00	2	1995-12-03	david.wilson@example.com	MALE	37.7749	-122.4194	David	Wilson	ACTIVE
6	2022-01-06 00:00:00	3	2022-01-06 00:00:00	3	1987-09-18	emily.brown@example.com	FEMALE	41.8781	-87.6298	Emily	Brown	INACTIVE
7	2022-01-07 00:00:00	1	2022-01-07 00:00:00	1	1993-07-12	charlie.anderson@example.com	MALE	45.4215	-75.6993	Charlie	Anderson	ACTIVE
8	2022-01-08 00:00:00	2	2022-01-08 00:00:00	2	1983-11-30	olivia.white@example.com	FEMALE	32.7157	-117.1611	Olivia	White	INACTIVE
9	2022-01-09 00:00:00	3	2022-01-09 00:00:00	3	1991-04-22	samuel.martin@example.com	MALE	34.0522	-118.2437	Samuel	Martin	ACTIVE
10	2022-01-10 00:00:00	1	2022-01-10 00:00:00	1	1989-06-05	ava.thompson@example.com	FEMALE	51.1657	10.4515	Ava	Thompson	ACTIVE
11	2024-03-11 20:57:52.535353	\N	2024-03-11 20:57:52.535395	\N	2024-03-11	string	MALE	0	0	string	string	ACTIVE
\.


--
-- Name: user_reviews_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_reviews_id_seq', 11, true);


--
-- Name: user_reviews_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_reviews_seq', 1, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 11, true);


--
-- Name: user_reviews user_reviews_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_reviews
    ADD CONSTRAINT user_reviews_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: user_reviews fkff3hcd0mnxdfage2x1j6fp4x7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_reviews
    ADD CONSTRAINT fkff3hcd0mnxdfage2x1j6fp4x7 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- PostgreSQL database dump complete
--

