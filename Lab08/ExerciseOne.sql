-- A)
SELECT score
FROM Player, PlayerGame
WHERE Player.ID = PlayerGame.playerID AND Player.name = 'The King';

-- B) 
SELECT Player.name, score
FROM Player, PlayerGame, Game
WHERE Player.ID = PlayerGame.playerID
  AND PlayerGame.gameID = Game.ID
  AND Game.ID = 2
  AND winnerID = true;
  
-- C) 
SELECT P1.name
FROM Player AS P1, Player AS P2
WHERE P1.name = P2.name
  AND P1.ID < P2.ID;
  
-- The P1 < P2.ID is saying take the person who had that username first. Since whoever made it first will have the smaller
-- ID number.

-- D) 
-- You could use this in a game where people score values from 1-25 and if they tie, there time is logged. 
-- the user with the lower time will win the game. In order to compare these users together we could do something like 
-- P1.time < P2.time, hence the user with the lower time would be the winner and logged as such.
-- You would need to reference back to the table to get both players and compare their times.
  
  
  

	
	
	
	
	
