--Jose Carlos Guerrero
--Script in Postgresql

DROP DATABASE IF EXISTS carrental;
CREATE DATABASE carrental; 

\c carrental

CREATE TABLE client
(
id_client INT,
name_client VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
phone VARCHAR(10) NOT NULL,
PRIMARY KEY(id_client)
);

CREATE TABLE vehicle
(
id_vehicle NUMERIC(3,0) NOT NULL,
model VARCHAR(255) NOT NULL,
brand VARCHAR(255) NOT NULL,
transmission VARCHAR(1) NOT NULL,
availability_flag NUMERIC(1) NOT NULL,
id_typevehicle NUMERIC(3,0) NOT NULL,
PRIMARY KEY(id_vehicle)
);

CREATE TABLE reservation
(
id_reservation INT,
id_vehicle NUMERIC(3,0) NOT NULL,
id_client INT NOT NULL,
id_typevehicle NUMERIC(3,0) NOT NULL,
deliver_date DATE NOT NULL,
return_date DATE NOT NULL,
total_price NUMERIC(6,0) NULL,
PRIMARY KEY(id_reservation)
);

CREATE TABLE type_vehicle
(
id_typevehicle NUMERIC(3,0),
type_vehicle VARCHAR(5) NOT NULL,
PRIMARY KEY(id_typevehicle)
);

ALTER TABLE vehicle
ADD CONSTRAINT fkVehicleType
FOREIGN KEY(id_typevehicle) REFERENCES type_vehicle(id_typevehicle);

ALTER TABLE reservation
ADD CONSTRAINT fkReservationVehicle
FOREIGN KEY(id_vehicle) REFERENCES vehicle(id_vehicle);

ALTER TABLE reservation
ADD CONSTRAINT fkReservationClient
FOREIGN KEY(id_client) REFERENCES client(id_client);

ALTER TABLE reservation
ADD CONSTRAINT fkReservationType
FOREIGN KEY(id_typevehicle) REFERENCES type_vehicle(id_typevehicle);

ALTER TABLE reservation
ADD CONSTRAINT ckDeliver
CHECK (deliver_date < return_date);

