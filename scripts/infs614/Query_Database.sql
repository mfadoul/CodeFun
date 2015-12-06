use `SqlProject`;

-- 1) List the cabins that contain animals that eat some other animal in that cabin.

-- Alternative #1
SELECT DISTINCT A1.sname, A1.cabinnum
FROM Animal A1, Animal A2, PreysOn P
WHERE A1.sname = A2.sname AND A1.cabinnum = A2.cabinnum
	AND P.predatorname = A1.aname AND P.preyname = A2.aname;
	
-- Alternative #2
-- SELECT *
-- FROM Cabin C
-- WHERE EXISTS (
-- 	SELECT *
-- 	FROM Animal A1, Animal A2, PreysOn P
-- 	WHERE C.sname=A1.sname AND C.cabinnum=A1.cabinnum AND
-- 		C.sname=A2.sname AND C.cabinnum=A2.cabinnum AND
-- 		P.predatorname=A1.aname AND P.preyname=A2.aname);
	
-- 2) List all pairs of animals that eat each other.
SELECT *
FROM PreysOn P1
WHERE EXISTS (
	SELECT *
	FROM PreysOn P2
	WHERE P1.predatorname=P2.preyname AND  P2.predatorname=P1.preyname);

-- 3) List the cabins that are over capacity (i.e., too many animals).

SELECT C.sname, C.cabinnum
FROM Cabin C, Animal A
WHERE C.sname=A.sname AND C.cabinnum=A.cabinnum
GROUP BY C.sname, C.cabinnum, C.capacity
HAVING count(*)>C.capacity;

-- 4) List the percent of carnivores and non-carnivores for each ship

-- Doesn't work in MySQL.  :(
--	100.0 * sum(decode(A.iscarn, 'T', 1.0, 0.0))/count(*) AS carnivores,
--	100.0 * sum(decode(A.iscarn, 'T', 0.0, 1.0))/count(*) AS noncarnivores
	
SELECT A.sname, 
	100.0 * sum(if(A.iscarn='T',1,0))/count(*) AS carnivores,
	100.0 * sum(if(A.iscarn='T',0,1))/count(*) AS noncarnivores
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
			WHERE C3.menuid=C4.menuid AND C4.fname LIKE '%peanut%')));

-- 6) List the cabins, and the menuid eaten by the animals in that cabin.  If a cabin is empty, list it anyhow.

SELECT DISTINCT C.sname, C.cabinnum, Temp.menuid
FROM Cabin C LEFT OUTER JOIN 
	(SELECT A.sname, A.cabinnum, A.aname, E.menuid
	FROM Animal A, Eats E
	WHERE A.aname=E.aname) AS Temp
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

-- SELECT *
-- FROM Ship S
-- WHERE S.sname NOT IN
--	(SELECT emptyCabins.sname
--	FROM (SELECT A.sname, A.cabinnum
--		FROM Animal A
--		GROUP BY A.sname, A.cabinnum
--		HAVING 0=count(*)) AS emptyCabins);

SELECT S.sname
FROM Ship S
WHERE S.sname NOT IN (
	SELECT DISTINCT C.sname
	FROM Cabin C
	WHERE NOT EXISTS (
		SELECT *
		FROM Animal A
	    WHERE A.sname=C.sname AND A.cabinnum=C.cabinnum));

-- 9) List the animal species with the lowest average weight, and the animals in that species.

SELECT A1.species, A1.aname
FROM Animal A1
WHERE EXISTS (
	SELECT A2.species, AVG(A2.weight) AS avg_weight2
	FROM Animal A2
    WHERE A1.species=A2.species
	GROUP BY A2.species
	HAVING NOT EXISTS (
		SELECT A3.species, AVG(A3.weight) AS avg_weight3
		FROM Animal A3
		GROUP BY A3.species
		HAVING AVG(A3.weight) < avg_weight2));


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
	WHERE A1.sname=A2.sname AND A1.cabinnum=A2.cabinnum);
