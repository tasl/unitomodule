-- Firs, you need to create a schema tasl on your postgres database 

-- log in postgres psql -U postgres postgres (ask pwd)

-- run this query to see if the post gis is installed SELECT postgis_full_version(); 


create database tasl;

create schema context;

create table context.person(id character varying (20) primary key, name character varying (20),surname character varying (20), ruolo character varying (20));
create table context.dpi( id character varying (20) primary key, description text);
create table context.sensor(id character varying (20) primary key, description text);
create table context.tool(id character varying (20) primary key, description text);
create table context.sensor_value(id character varying (20),value double precision, timestamp time, primary key (id,time));
create table context.polygon(id character varying (20) primary key,description text);
create table context.polygon_status(id character varying (20),status boolean, timestamp time_start, timestamp time_end, primary key(id,time_start,time_end));
create table context.tools_association(id_person character varying (20), id_tool character varying (20),timestamp time_start, timestamp time_end, primary key(id_person,id_tools,time_start,time_end));
create table context.dpi_association(id_person character varying (20), id_dpi character varying (20),timestamp time_start, timestamp time_end, primary key(id_person,id_dpi,time_start,time_end));
create table context.person_location(id_person character varying (20), timestamp time, lon double precision, lat double precision,timestamp time_start,timestamp time_end,primary key (id_person,time_start,time_end));
create table context.sensor_location(id_sensor character varying (20), timestamp time, lon double precision, lat double precision,timestamp time_start,timestamp time_end,primary key (id_person,time_start,time_end));
create table context.tool_location(id_tool character varying (20), timestamp time, lon double precision, lat double precision,timestamp time_start,timestamp time_end,primary key (id_person,time_start,time_end));



SELECT AddGeometryColumn('context', 'polygon','geom', ,4326, 'POLYGON',2);
SELECT AddGeometryColumn('context', 'person_location','geom', ,4326, 'POINT',2);
SELECT AddGeometryColumn('context', 'sensor_location','geom', ,4326, 'POINT',2);
SELECT AddGeometryColumn('context', 'tools_location','geom', ,4326, 'POINT',2);



ALTER TABLE  context.polygon_status ADD FOREIGN KEY (id ) REFERENCES context.polygon(id);
ALTER TABLE  context.tools_association ADD FOREIGN KEY (id_person ) REFERENCES context.person(id);
ALTER TABLE  context.tools_association ADD FOREIGN KEY (id_tool ) REFERENCES context.tool(id);
ALTER TABLE  context.dpi_association ADD FOREIGN KEY (id_person ) REFERENCES context.person(id);
ALTER TABLE  context.dpi_association ADD FOREIGN KEY (id_dpi ) REFERENCES context.dpi(id);
ALTER TABLE  context.person_location ADD FOREIGN KEY (id_person ) REFERENCES context.person(id);
ALTER TABLE  context.sensor_location ADD FOREIGN KEY (id_sensor ) REFERENCES context.sensor(id);
ALTER TABLE  context.tool_location ADD FOREIGN KEY (id_tool ) REFERENCES context.tool(id);
ALTER TABLE  context.sensor_value ADD FOREIGN KEY (id_sensor ) REFERENCES context.sensor(id);


--
-- Table structure for table `idtable`
--

DROP TABLE IF EXISTS  idtable;

CREATE TABLE idtable (
  high int(11) DEFAULT NULL,
  maxlow int(11) DEFAULT NULL
);

INSERT INTO idtable VALUES (1600,100);
