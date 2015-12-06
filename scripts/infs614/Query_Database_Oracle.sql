-- Matthew Fadoul
-- INFS 614
-- Project: Part 2: SQL Queries
-- Nov 16, 2014

-- Summary:
--   Below are the ten SQL queries specified in the project.
--   All queries were tested to successfully run on GMU's Oracle 
--   database server. These queries were also tested on MySQL.  
--   With the exception of #4, all run on MySQL without modification.
--   For #4, the decode() function is not recognized, so I replaced 
--   it with an IF statement.  This is a snippit that shows the change:
--     SELECT A.sname, 
--	100.0 * sum(if(A.iscarn='T',1,0))/count(*) AS carnivores,
--	100.0 * sum(if(A.iscarn='T',0,1))/count(*) AS noncarnivores

-- +-------------+
-- |   Queries   |
-- +-------------+

-- 1) List the cabins that contain animals that eat some other animal in that cabin.

SELECT DISTINCT A1.sname, A1.cabinnum
FROM Animal A1, Animal A2, PreysOn P
WHERE A1.sname = A2.sname AND A1.cabinnum = A2.cabinnum
	AND P.predatorname = A1.aname AND P.preyname = A2.aname
ORDER BY A1.sname, A1.cabinnum;
	
-- 2) List all pairs of animals that eat each other.

SELECT *
FROM PreysOn P1
WHERE EXISTS (
	SELECT *
	FROM PreysOn P2
	WHERE P1.predatorname=P2.preyname AND  P2.predatorname=P1.preyname);

-- 3) List the cabins that are over capacity (i.e., too many animals).

SELECT C.sname, C.cabinnum, C.capacity, count(*) AS animal_count
FROM Cabin C, Animal A
WHERE C.sname=A.sname AND C.cabinnum=A.cabinnum
GROUP BY C.sname, C.cabinnum, C.capacity
HAVING count(*)>C.capacity
ORDER BY C.sname, C.cabinnum;

-- 4) List the percent of carnivores and non-carnivores for each ship

SELECT A.sname, 
	100.0 * sum(decode(A.iscarn, 'T', 1.0, 0.0))/count(*) AS carnivores,
	100.0 * sum(decode(A.iscarn, 'T', 0.0, 1.0))/count(*) AS noncarnivores
FROM Animal A
GROUP BY A.sname
HAVING count(*)>0
UNION
SELECT S.sname, 0.0  AS carnivores,  0.0  AS noncarnivores 
FROM Ship S
WHERE S.sname NOT IN (
	SELECT A.sname
	FROM Animal A
	GROUP BY A.sname
	HAVING count(*)>0);
 
-- 5) List the dietitians involved with peanut-free menus.  (That is, they approved any food appearing on a menu which has no food named “peanut”).

SELECT DISTINCT C1.dietician
FROM Contains C1
WHERE NOT EXISTS (
	SELECT *
	FROM Contains C2
	WHERE C1.dietician=C2.dietician AND C2.menuid IN (
		-- Peanut menus
		SELECT C3.menuid
		FROM Contains C3
		WHERE EXISTS (
			SELECT *
			FROM Contains C4
			WHERE C3.menuid=C4.menuid AND C4.fname LIKE '%peanut%')))
ORDER BY C1.dietician;

-- 6) List the cabins, and the menuid eaten by the animals in that cabin.  If a cabin is empty, list it anyhow.

SELECT DISTINCT C.sname, C.cabinnum, Temp.menuid
FROM Cabin C LEFT OUTER JOIN 
	(SELECT A.sname, A.cabinnum, A.aname, E.menuid
	FROM Animal A, Eats E
	WHERE A.aname=E.aname) Temp
ON (C.sname=Temp.sname AND C.cabinnum=Temp.cabinnum)
ORDER BY C.sname, C.cabinnum, Temp.menuid;

-- 7) Find a heaviest bird without using an aggregation function such as MAX.
-- Definition of bird: Any species that has the word “bird” in it.

SELECT *
FROM Animal A1
WHERE A1.species LIKE '%bird%' AND NOT EXISTS (
	SELECT *
	FROM Animal A2
	WHERE A1.weight<A2.weight AND A2.species LIKE '%bird%');

-- 8) Which ships have an animal in all cabins?

SELECT S.sname
FROM Ship S
WHERE S.sname NOT IN (
	SELECT DISTINCT C.sname
	FROM Cabin C
	WHERE NOT EXISTS (
		SELECT *
		FROM Animal A
		WHERE A.sname=C.sname AND A.cabinnum=C.cabinnum))
ORDER BY S.sname;

-- 9) List the animal species with the lowest average weight, and the animals in that species.

SELECT A1.species, A1.aname
FROM Animal A1
WHERE EXISTS (
	SELECT A2.species, AVG(A2.weight)
	FROM Animal A2
	WHERE A1.species=A2.species
	GROUP BY A2.species
	HAVING NOT EXISTS (
		SELECT A3.species, AVG(A3.weight)
		FROM Animal A3
		GROUP BY A3.species
		HAVING AVG(A3.weight) < AVG(A2.weight)))
ORDER BY A1.aname;

-- 10) List animals who have fewer calories in a breakfast menu they eat, than the number of animals on their ship. (That is:  for animal X, the total of the calories on some breakfast menu they eat is less than the total of the animals on their ship).

SELECT DISTINCT A1.aname
FROM Animal A1, Eats E
WHERE A1.aname=E.aname AND E.mealtype='breakfast' AND
	(SELECT SUM(F.calories)
	FROM Contains C, Food F
	WHERE E.menuid=C.menuid AND C.fname=F.fname)
	<
	(SELECT count(*)
	FROM Animal A2
	WHERE A1.sname=A2.sname AND A1.cabinnum=A2.cabinnum)
ORDER BY A1.aname;
