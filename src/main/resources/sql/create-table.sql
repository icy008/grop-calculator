CREATE TABLE age (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255),
    value FLOAT,
    units VARCHAR(255),
    timestamp TIMESTAMPTZ

);

CREATE TABLE gender (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255),
    value FLOAT,
    units VARCHAR(255),
    timestamp TIMESTAMPTZ

);

CREATE TABLE barthel_index (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255),
    value FLOAT,
    units VARCHAR(255),
    timestamp TIMESTAMPTZ

);

CREATE TABLE history_hf (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255),
    value FLOAT,
    units VARCHAR(255),
    timestamp TIMESTAMPTZ

);

CREATE TABLE sbp_admission (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255),
    value FLOAT,
    units VARCHAR(255),
    timestamp TIMESTAMPTZ

);

CREATE TABLE hemoglobin (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255),
    value FLOAT,
    units VARCHAR(255),
    timestamp TIMESTAMPTZ

);

CREATE TABLE albumin (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255),
    value FLOAT,
    units VARCHAR(255),
    timestamp TIMESTAMPTZ

);

CREATE TABLE bun (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255),
    value FLOAT,
    units VARCHAR(255),
    timestamp TIMESTAMPTZ

);

CREATE TABLE bnp (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255),
    value FLOAT,
    units VARCHAR(255),
    timestamp TIMESTAMPTZ

);

CREATE TABLE sodium (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255),
    value FLOAT,
    units VARCHAR(255),
    timestamp TIMESTAMPTZ

);

CREATE TABLE ace_arm_use (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255),
    value FLOAT,
    units VARCHAR(255),
    timestamp TIMESTAMPTZ

);
