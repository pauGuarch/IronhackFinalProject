DROP SCHEMA IF EXISTS bank;
create schema bank;
use bank;

-- Insert users
INSERT INTO address (address, city, postal_code) values ('Gran Vía nº 666', 'Barcelona', '08025');
INSERT INTO address (address, city, postal_code) values ('Aragó 23', 'Barcelona', '08055');
INSERT INTO address (address, city, postal_code) values ('Diagonal 365', 'Barcelona', '08015');

INSERT INTO user (name, password, role, user_name) values('Perro Xanxe', 'qwerty', 'USER', 'perro_xanxe');
INSERT INTO account_holder (date_of_birth, user_id) values('1988-09-09', 1);

INSERT INTO user (name, password, role, user_name) values('Juan Palomo', '12345', 'USER', 'juan_palomo');
INSERT INTO account_holder (date_of_birth, user_id) values('2000-09-09', 2);

INSERT INTO user (name, password, role, user_name) values('Apu Nahasamapetilan', 'fresisuis', 'USER', 'apu_badulake');
INSERT INTO account_holder (date_of_birth, user_id) values('1987-05-12', 3);

INSERT INTO user (name, password, role, user_name) values('Marge Buvier', 'fresisuis', 'ADMIN', 'apu_badulake');
INSERT INTO account_holder (date_of_birth, user_id) values('1987-05-12', 4);

INSERT INTO user (name, password, role, user_name) values('Perry Tomajo', 'abcde', 'ADMIN', 'perry_tomas');
INSERT INTO admin (level, user_id) values('Tecnician', 4);
-- Inser de account con joined table
INSERT INTO `bank`.`account` (`amount`, `currency`, `penalty_fee`, `secret_key`, `status_`, `primary_owner`, `secondary_owner`) VALUES ('10.00', 'EUR', '40.00', 'qwerty', 'ACTIVE', '2', '1');
-- Insert de checking con joined table
INSERT INTO `bank`.`checking` (`creation_date`, `minimum_balance`, `monthly_maintenance_fee`, `id`) VALUES ('2008-01-09', '150.00', '2.00', '1');

-- Inser de account con joined table
INSERT INTO `bank`.`account` (`amount`, `currency`, `penalty_fee`, `secret_key`, `status_`, `primary_owner`, `secondary_owner`) VALUES ('2000.00', 'EUR', '40.00', 'asdfg', 'ACTIVE', '3', '4');
-- Insert de checking con joined table
INSERT INTO `bank`.`checking` (`creation_date`, `minimum_balance`, `monthly_maintenance_fee`, `id`) VALUES ('2008-01-09', '200.00', '2.00', '2');

INSERT INTO transaction (amount, destiny_account, origin_account) values(250.00, 1, 2);






