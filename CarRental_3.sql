CREATE OR REPLACE PROCEDURE SP_SubscribeReservation(
id_reservation NUMERIC(3,0),
id_vehicle NUMERIC(3,0),
id_client NUMERIC(3,0),
id_typevehicle NUMERIC(3,0),
deliver_date DATE,
return_date DATE)
LANGUAGE plpgsql
AS $$
DECLARE total_price NUMERIC(6,0);
BEGIN
	IF id_typevehicle = 1 THEN
		total_price = 1000;
	ELSE IF id_typevehicle = 2 THEN
		total_price = 1300;
	ELSE 
		total_price = 1500;
	END IF;
	END if;
	INSERT INTO reservation VALUES(id_reservation,id_vehicle,id_client,id_typevehicle,deliver_date,return_date,total_price);
END; $$