-- public.user_details definition

-- Drop table

-- DROP TABLE public.user_details;

CREATE TABLE user_details (
	id int4 NOT NULL,
	email varchar(255) NULL,
	user_password varchar(255) NULL,
	ph_number varchar(255) NULL,
	user_name varchar(255) NULL,
	users_id varchar(255) NULL,
	CONSTRAINT user_details_pkey PRIMARY KEY (id)
);

-- db/migration/V2__Create_USER_DETAILS_SEQ.sql

CREATE SEQUENCE USER_DETAILS_SEQ START WITH 1 INCREMENT BY 1;
