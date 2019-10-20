--
-- This SQL script builds a monopoly database, deleting any pre-existing version.
--
-- @author kvlinden
-- @modifier Mitchell Niesar (mon2)
-- @version 10/12/2019
--

-- Drop previous versions of the tables if they they exist, in reverse order of foreign keys.
DROP TABLE IF EXISTS Property;
DROP TABLE IF EXISTS PlayerGame;
DROP TABLE IF EXISTS Game;
DROP TABLE IF EXISTS Player;


	

-- Create the schema.
CREATE TABLE Game (
	ID integer PRIMARY KEY, 
	time timestamp
	);

CREATE TABLE Player (
	ID integer PRIMARY KEY, 
	emailAddress varchar(50) NOT NULL,
	name varchar(50)
	);

CREATE TABLE PlayerGame (
	gameID integer REFERENCES Game(ID), 
	playerID integer REFERENCES Player(ID),
	score integer, cash integer, position integer
 				
	);

CREATE TABLE PlayerGame (
	gameID integer REFERENCES Game(ID),
	playerID interger REFERENCES Player(ID)
	score integer, cash integer, position integer
	);

CREATE TABLE Property (
	position integer PRIMARY KEY,
	name varchar(50) NOT NULL,
	playerID integer REFERENCES Player(ID), playerHouses integer, playerHotels integer
	);

-- Allow users to select data from the tables.
GRANT SELECT ON Property TO PUBLIC;
GRANT SELECT ON PlayerGame TO PUBLIC;
GRANT SELECT ON Game TO PUBLIC;
GRANT SELECT ON Player TO PUBLIC;


-- Add sample records.

INSERT INTO Property VALUES (1, 'Mediterranean Avenue', 1,3,2);
INSERT INTO Property VALUES (5, 'RailRoad1, 2,0,1);
INSERT INTO Property VALUES (10, 'Jail', 3,0,0);
INSERT INTO Property VALUES (25, 'RailRoad3, 4,3,2);

INSERT INTO PlayerGame VALUES (1, 1, 0.00);
INSERT INTO PlayerGame VALUES (1, 2, 0.00);
INSERT INTO PlayerGame VALUES (1, 3, 2350.00);
INSERT INTO PlayerGame VALUES (2, 1, 1000.00);
INSERT INTO PlayerGame VALUES (2, 2, 0.00);
INSERT INTO PlayerGame VALUES (2, 3, 500.00);
INSERT INTO PlayerGame VALUES (3, 2, 0.00);
INSERT INTO PlayerGame VALUES (3, 3, 5500.00);
INSERT INTO PlayerGame VALUES (4, 1, 500.00);
INSERT INTO PlayerGame VALUES (4, 2, 1000.00);

INSERT INTO Game VALUES (1, '2006-06-27 08:00:00');
INSERT INTO Game VALUES (2, '2006-06-28 13:20:00');
INSERT INTO Game VALUES (3, '2006-06-29 18:41:00');
INSERT INTO Game VALUES (4, ,2006-06-30 18:42:00');
INSERT INTO Game VALUES (5, '2007-09-26 15:35:00');
INSERT INTO Game VALUES (6, '2019-10-17 20:42:00');

INSERT INTO Player(ID, emailAddress) VALUES (1, 'me@calvin.edu');
INSERT INTO Player VALUES (2, 'sansaStark@gmail.com', 'The Queen');
INSERT INTO Player VALUES (3, 'targaryianDragon2@gmail.edu', 'FireBreather');



