INSERT INTO Owner(first_name, last_name)
VALUES ('Vaiva', 'Nostyte');
INSERT INTO Owner(first_name, last_name)
VALUES ('John', 'Smith');
INSERT INTO Owner(first_name, last_name)
VALUES ('Albert', 'Fleming');
INSERT INTO Owner(first_name, last_name)
VALUES ('Anna', 'Rivera');


INSERT INTO PropertyType (type, tax_rate)
VALUES ('Residential', 0.034);
INSERT INTO PropertyType (type, tax_rate)
VALUES ('Commercial', 0.124);
INSERT INTO PropertyType (type, tax_rate)
VALUES ('Industrial', 0.164);
INSERT INTO PropertyType (type, tax_rate)
VALUES ('Land', 0.0008);

INSERT INTO REALESTATE (city, street, number, size, market_value, PropertyType_id)
VALUES ('Vilnius', 'Vilniaus', 1, 50, 100000, 1);
INSERT INTO REALESTATE (city, street, number, size, market_value, PropertyType_id)
VALUES ('Vilnius', 'Vilniaus', 2, 100, 56565656, 1);
INSERT INTO REALESTATE (city, street, number, size, market_value, PropertyType_id)
VALUES ('Vilnius', 'Vilniaus', 3, 133.34, 1000000, 2);
INSERT INTO REALESTATE (city, street, number, size, market_value, PropertyType_id)
VALUES ('Vilnius', 'Kauno', 3, 25, 20000, 4);



INSERT INTO BUILDING_OWNER (fk_real_estate, fk_owner)
VALUES (1, 1);
INSERT INTO BUILDING_OWNER (fk_real_estate, fk_owner)
VALUES (2, 1);