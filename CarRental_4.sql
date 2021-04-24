CALL SP_SubscribeClient(1,'Carlos','Guerrero','5548423117');
CALL SP_SubscribeClient(2,'Juan','Sanchez','5502135478');
CALL SP_SubscribeClient(3,'Jessica','Aranza','5536984502');
CALL SP_SubscribeClient(4,'Eskarlet','Gutierrez','5595347825');
CALL SP_SubscribeClient(5,'Eduardo','Parada','5545003698');
CALL SP_SubscribeClient(6,'Fernando','Pacheco','5500265482');
CALL SP_SubscribeClient(7,'Reyna','Lopez','5501020304');
CALL SP_SubscribeClient(8,'Carla','Quiñones','5569024571');
CALL SP_SubscribeClient(9,'Erick','Lopez','5598979695');
CALL SP_SubscribeClient(10,'Mariel','Gopar','5536148502');

INSERT INTO type_vehicle
VALUES	(001,'car'),
		(002,'van'),
		(003,'sport');
							
INSERT INTO vehicle
VALUES	(001,'march','nissan','a',1,1),
		(002,'altima','nissan','s',1,1),
		(003,'gt_r','nissan','a',1,3),
		(004,'gt_r','nissan','s',1,3),
		(005,'maxima','nissan','a',1,2),
		(006,'polo','volkswagen','s',1,1),
		(007,'vento','volkswagen','a',1,1),
		(008,'jetta','volkswagen','s',1,1),
		(009,'jetta_gli','volkswagen','s',1,3),
		(010,'t_cross','volkswagen','a',1,2),
		(011,'hilux','toyota','a',1,2),
		(012,'rav4','toyota','s',1,2),
		(013,'yaris','toyota','s',1,1),
		(014,'corolla','toyota','a',1,1),
		(015,'camry','toyota','s',1,3),
		(016,'sportage','kia','s',1,2),
		(017,'sorento','kia','s',1,2),
		(018,'rio','kia','a',1,1),
		(019,'seltos','kia','a',1,2),
		(020,'stinger','kia','s',1,3),
		(021,'silverado','chevrolet','s',1,2),
		(022,'camaro','chevrolet','a',1,3),
		(023,'aveo','chevrolet','s',1,1),
		(024,'tahoe','chevrolet','s',1,2),
		(025,'spark','chevrolet','a',1,1),
		(026,'civic','honda','s',1,1),
		(027,'cr_v','honda','a',1,2),
		(028,'fit','honda','a',1,1),
		(029,'accord','honda','a',1,1),
		(030,'nsx','honda','s',1,3),
		(031,'cx_5','mazda','a',1,2),
		(032,'mx_5','mazda','s',1,3),
		(033,'cx_3','mazda','a',1,2),
		(034,'cx_9','mazda','a',1,2),
		(035,'i8','bmw','s',1,3),
		(036,'i3','bmw','s',1,3),
		(037,'z4','bmw','s',1,3),
		(038,'coupe','bmw','a',1,1);

CALL SP_SubscribeReservation(1,6,1,1,'2021-04-02','2021-04-04');
CALL SP_SubscribeReservation(2,9,2,2,'2021-04-10','2021-04-15');
CALL SP_SubscribeReservation(3,10,3,3,'2021-04-01','2021-05-01');
CALL SP_SubscribeReservation(4,25,4,1,'2021-04-26','2021-05-09');
CALL SP_SubscribeReservation(5,38,5,2,'2021-04-28','2021-04-30');
CALL SP_SubscribeReservation(6,2,6,3,'2021-04-15','2021-04-18');
CALL SP_SubscribeReservation(7,16,7,1,'2021-04-20','2021-04-28');
CALL SP_SubscribeReservation(8,30,8,2,'2021-04-21','2021-04-24');
CALL SP_SubscribeReservation(9,12,9,3,'2021-04-14','2021-04-19');
CALL SP_SubscribeReservation(10,29,10,1,'2021-04-05','2021-04-15');

