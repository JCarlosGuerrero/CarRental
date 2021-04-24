CREATE OR REPLACE PROCEDURE SP_SubscribeClient(
id_client NUMERIC(3,0),
name_client VARCHAR(255),
last_name VARCHAR(255),
phone VARCHAR(10))
LANGUAGE plpgsql
AS $$
BEGIN
	INSERT INTO client VALUES(id_client,name_client,last_name,phone);
END; $$