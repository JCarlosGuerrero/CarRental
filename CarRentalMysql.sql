DROP DATABASE IF EXISTS carrental;
CREATE DATABASE carrental; 

USE carrental;

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
id_typevehicle NUMERIC(3,0) NOT NULL,
price NUMERIC(5,0) NOT NULL,
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

DELIMITER //
CREATE PROCEDURE SP_SubscribeClient
(
name_client VARCHAR(255),
last_name VARCHAR(255),
phone VARCHAR(10)
)
BEGIN
	DECLARE id_cliente INT DEFAULT 0;
    SET id_cliente = (SELECT MAX(id_client) FROM carrental.client);
	IF id_cliente IS NULL THEN 
		SET id_cliente = 1;
    ELSE
		SET id_cliente = id_cliente + 1;
    END IF;    
	INSERT INTO client VALUES(id_cliente,name_client,last_name,phone);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE SP_SubscribeReservation
(
id_vehicle NUMERIC(3,0),
id_client INT,
id_typevehicle NUMERIC(3,0),
deliver_date DATE,
return_date DATE
)
BEGIN
	DECLARE id_reservacion INT DEFAULT 0;
    DECLARE dia INT DEFAULT 0;
    DECLARE total_price NUMERIC(6,0) DEFAULT 0;
    
	SET id_reservacion = (SELECT MAX(id_reservation) FROM carrental.reservation);
	IF id_reservacion IS null THEN 
		SET id_reservacion = 1;
    ELSE
		SET id_reservacion = id_reservacion + 1;
    END IF;
    SET dia = DATEDIFF(return_date,deliver_date);
    IF id_typevehicle = 1 THEN
		SET total_price = 1000 * dia;
    ELSEIF id_typevehicle = 2 THEN
		SET total_price = 1300 * dia;
	ELSE SET total_price = 1500 * dia;
    END IF;
    
	INSERT INTO reservation VALUES(id_reservacion,id_vehicle,id_client,id_typevehicle,deliver_date,return_date,total_price);
END //
DELIMITER ;


CALL SP_SubscribeClient('Carlos','Guerrero','5548423117');
CALL SP_SubscribeClient('Juan','Sanchez','5502135478');
CALL SP_SubscribeClient('Jessica','Aranza','5536984502');
CALL SP_SubscribeClient('Eskarlet','Gutierrez','5595347825');
CALL SP_SubscribeClient('Eduardo','Parada','5545003698');
CALL SP_SubscribeClient('Fernando','Pacheco','5500265482');
CALL SP_SubscribeClient('Reyna','Lopez','5501020304');
CALL SP_SubscribeClient('Carla','Quiñones','5569024571');
CALL SP_SubscribeClient('Erick','Lopez','5598979695');
CALL SP_SubscribeClient('Mariel','Gopar','5536148502');

INSERT INTO type_vehicle
VALUES	(001,'car'),
		(002,'van'),
		(003,'sport');
        
INSERT INTO vehicle
VALUES	(001,'march','nissan','a',1,1000),
		(002,'altima','nissan','s',1,1000),
		(003,'gt_r','nissan','a',3,1500),
		(004,'gt_r','nissan','s',3,1500),
		(005,'maxima','nissan','a',2,1300),
		(006,'polo','volkswagen','s',1,1000),
		(007,'vento','volkswagen','a',1,1000),
		(008,'jetta','volkswagen','s',1,1000),
		(009,'jetta_gli','volkswagen','s',3,1500),
		(010,'t_cross','volkswagen','a',2,1300),
		(011,'hilux','toyota','a',2,1300),
		(012,'rav4','toyota','s',2,1300),
		(013,'yaris','toyota','s',1,1000),
		(014,'corolla','toyota','a',1,1000),
		(015,'camry','toyota','s',3,1500),
		(016,'sportage','kia','s',2,1300),
		(017,'sorento','kia','s',2,1300),
		(018,'rio','kia','a',1,1000),
		(019,'seltos','kia','a',2,1300),
		(020,'stinger','kia','s',3,1500),
		(021,'silverado','chevrolet','s',2,1300),
		(022,'camaro','chevrolet','a',3,1500),
		(023,'aveo','chevrolet','s',1,1000),
		(024,'tahoe','chevrolet','s',2,1300),
		(025,'spark','chevrolet','a',1,1000),
		(026,'civic','honda','s',1,1000),
		(027,'cr_v','honda','a',2,1300),
		(028,'fit','honda','a',1,1000),
		(029,'accord','honda','a',1,1000),
		(030,'nsx','honda','s',3,1500),
		(031,'cx_5','mazda','a',2,1300),
		(032,'mx_5','mazda','s',3,1500),
		(033,'cx_3','mazda','a',2,1300),
		(034,'cx_9','mazda','a',2,1300),
		(035,'i8','bmw','s',3,1500),
		(036,'i3','bmw','s',3,1500),
		(037,'z4','bmw','s',3,1500),
		(038,'coupe','bmw','a',1,1000);

CALL SP_SubscribeReservation(6,1,1,'2021-04-02','2021-04-04');
CALL SP_SubscribeReservation(9,2,2,'2021-04-10','2021-04-15');
CALL SP_SubscribeReservation(10,3,3,'2021-04-01','2021-05-01');
CALL SP_SubscribeReservation(25,4,1,'2021-04-26','2021-05-09');
CALL SP_SubscribeReservation(38,5,2,'2021-04-28','2021-04-30');
CALL SP_SubscribeReservation(2,6,3,'2021-04-15','2021-04-18');
CALL SP_SubscribeReservation(16,7,1,'2021-04-20','2021-04-28');
CALL SP_SubscribeReservation(30,8,2,'2021-04-21','2021-04-24');
CALL SP_SubscribeReservation(12,9,3,'2021-04-14','2021-04-19');
CALL SP_SubscribeReservation(29,10,1,'2021-04-05','2021-04-15');