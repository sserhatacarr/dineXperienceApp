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
-- Name: restaurants; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.restaurants (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    creator_id bigint,
    updated_at timestamp(6) without time zone,
    updated_id bigint,
    address character varying(200) NOT NULL,
    description character varying(500),
    email character varying(100),
    latitude double precision NOT NULL,
    longitude double precision NOT NULL,
    name character varying(50) NOT NULL,
    phone character varying(20) NOT NULL,
    restaurant_rate numeric(38,2) NOT NULL,
    status character varying(30) NOT NULL,
    website character varying(100),
    working_hours character varying(100),
    CONSTRAINT restaurants_status_check CHECK (((status)::text = ANY ((ARRAY['ACTIVE'::character varying, 'INACTIVE'::character varying])::text[])))
);


ALTER TABLE public.restaurants OWNER TO postgres;

--
-- Name: restaurants_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.restaurants_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.restaurants_id_seq OWNER TO postgres;

--
-- Name: restaurants_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.restaurants_id_seq OWNED BY public.restaurants.id;


--
-- Name: restaurants id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restaurants ALTER COLUMN id SET DEFAULT nextval('public.restaurants_id_seq'::regclass);


--
-- Data for Name: restaurants; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.restaurants (id, created_at, creator_id, updated_at, updated_id, address, description, email, latitude, longitude, name, phone, restaurant_rate, status, website, working_hours) FROM stdin;
1	2024-03-11 17:57:15.713186	1	2024-03-11 17:57:15.713186	1	Address 1	Description 1	email1@example.com	51.5074	-0.1278	Restaurant 1	1234567890	1.00	ACTIVE	www.restaurant1.com	9am - 9pm
2	2024-03-11 17:57:15.713186	2	2024-03-11 17:57:15.713186	2	Address 2	Description 2	email2@example.com	51.5075	-0.1279	Restaurant 2	1234567891	2.00	ACTIVE	www.restaurant2.com	9am - 9pm
3	2024-03-11 17:57:15.713186	3	2024-03-11 17:57:15.713186	3	Address 3	Description 3	email3@example.com	51.5076	-0.128	Restaurant 3	1234567892	3.00	ACTIVE	www.restaurant3.com	9am - 9pm
4	2024-03-11 17:57:15.713186	4	2024-03-11 17:57:15.713186	4	Address 4	Description 4	email4@example.com	51.5077	-0.1281	Restaurant 4	1234567893	4.00	ACTIVE	www.restaurant4.com	9am - 9pm
5	2024-03-11 17:57:15.713186	5	2024-03-11 17:57:15.713186	5	Address 5	Description 5	email5@example.com	51.5078	-0.1282	Restaurant 5	1234567894	5.00	ACTIVE	www.restaurant5.com	9am - 9pm
6	2024-03-11 17:57:15.713186	6	2024-03-11 17:57:15.713186	6	Address 6	Description 6	email6@example.com	51.5079	-0.1283	Restaurant 6	1234567895	1.00	ACTIVE	www.restaurant6.com	9am - 9pm
7	2024-03-11 17:57:15.713186	7	2024-03-11 17:57:15.713186	7	Address 7	Description 7	email7@example.com	51.508	-0.1284	Restaurant 7	1234567896	2.00	ACTIVE	www.restaurant7.com	9am - 9pm
8	2024-03-11 17:57:15.713186	8	2024-03-11 17:57:15.713186	8	Address 8	Description 8	email8@example.com	51.5081	-0.1285	Restaurant 8	1234567897	3.00	ACTIVE	www.restaurant8.com	9am - 9pm
9	2024-03-11 17:57:15.713186	9	2024-03-11 17:57:15.713186	9	Address 9	Description 9	email9@example.com	51.5082	-0.1286	Restaurant 9	1234567898	4.00	ACTIVE	www.restaurant9.com	9am - 9pm
10	2024-03-11 17:57:15.713186	10	2024-03-11 17:57:15.713186	10	Address 10	Description 10	email10@example.com	51.5083	-0.1287	Restaurant 10	1234567899	5.00	ACTIVE	www.restaurant10.com	9am - 9pm
\.


--
-- Name: restaurants_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.restaurants_id_seq', 1, false);


--
-- Name: restaurants restaurants_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restaurants
    ADD CONSTRAINT restaurants_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

