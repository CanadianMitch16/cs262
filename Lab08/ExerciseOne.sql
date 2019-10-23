-- A)
SELECT * FROM Game ORDER BY time DESC;

-- B)
SELECT * From Game WHERE time > '2006-06-24 23:59:59' ORDER BY time DESC;

-- C) 
SELECT * FROM Player WHERE name is NOT NULL;

-- D) 
SELECT * FROM PlayerGame WHERE score > 2000 ORDER BY playerID;

-- E) 
SELECT * FROM Player WHERE emailAddress LIKE '%gmail%';
  
  

	
	
	
	
	
