-- Matthew Fadoul
-- INFS 614
-- Project: Part 2: Populate Tables
-- Nov 16, 2014

-- ---------
-- Due to a circular dependency, I need the animal's ship/cabin# fields to be NULL until the ships are instantiated.
-- ---------

INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Skipper', 'T', NULL, NULL, 'penguin', 'USA', 55);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Private', 'T', NULL, NULL, 'penguin', 'USA', 50);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Kowalski', 'T', NULL, NULL, 'penguin', 'USA', 55);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Rico', 'T', NULL, NULL, 'penguin', 'USA', 52);

INSERT INTO Penguin (aname) VALUES ('Skipper');
INSERT INTO Penguin (aname) VALUES ('Private');
INSERT INTO Penguin (aname) VALUES ('Kowalski');
INSERT INTO Penguin (aname) VALUES ('Rico');

INSERT INTO Ship (sname, capacity, aname) VALUES ('Titanic', 1000, 'Skipper');
INSERT INTO Ship (sname, capacity, aname) VALUES ('Minnow', 10, 'Private');
INSERT INTO Ship (sname, capacity, aname) VALUES ('Bounty', 200, 'Kowalski');
INSERT INTO Ship (sname, capacity, aname) VALUES ('Yamato', 200, 'Rico');

-- An example of an empty ship
INSERT INTO Ship (sname, capacity, aname) VALUES ('Ghostship', 2, 'Rico');

INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (1, 'Minnow', 2);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (2, 'Minnow', 3);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (3, 'Minnow', 2);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (1, 'Titanic', 5);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (2, 'Titanic', 5);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (3, 'Titanic', 5);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (4, 'Titanic', 5);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (1, 'Bounty', 3);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (2, 'Bounty', 3);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (3, 'Bounty', 3);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (4, 'Bounty', 3);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (5, 'Bounty', 3);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (1, 'Yamato', 4);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (2, 'Yamato', 1);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (3, 'Yamato', 4);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (4, 'Yamato', 4);
INSERT INTO Cabin (cabinnum, sname, capacity) VALUES (1, 'Ghostship', 4);

-- Update the Penguins
UPDATE Animal SET cabinnum=1, sname='Bounty' WHERE aname='Kowalski';
UPDATE Animal SET cabinnum=1, sname='Minnow' WHERE aname='Private';
UPDATE Animal SET cabinnum=1, sname='Titanic' WHERE aname='Skipper';
UPDATE Animal SET cabinnum=1, sname='Yamato' WHERE aname='Rico';

-- Other birds
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Bob', 'T', 2, 'Minnow', 'bluebird', 'USA', 2);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Bill', 'T', 3, 'Minnow', 'blackbird', 'USA', 2);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Jill', 'T', 3, 'Minnow', 'blackbird', 'USA', 3);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Jan', 'T', 3, 'Minnow', 'bluebird', 'USA', 2);

-- Mammals
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Alex', 'T', 2, 'Titanic', 'lion', 'USA', 450);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Marty', 'F', 2, 'Titanic', 'zebra', 'USA', 500);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Melman', 'F', 3, 'Titanic', 'giraffe', 'USA', 1200);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Gloria', 'F', 4, 'Titanic', 'hippo', 'USA', 1600);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Ms Piggy', 'F', 2, 'Yamato', 'pig', 'USA', 30);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Merv', 'T', 2, 'Bounty', 'mongoose', 'Africa', 14);

-- Others
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Sam', 'T', 2, 'Bounty', 'snake', 'Africa', 10);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Kermit', 'T', 2, 'Yamato', 'frog', 'USA', 1);
INSERT INTO Animal (aname, iscarn, cabinnum, sname, species, country, weight) VALUES ('Mr Slime', 'T', 2, 'Yamato', 'frog', 'USA', 2);


-- Food Table
INSERT INTO Food (fname,calories) VALUES ('apple',60);
INSERT INTO Food (fname,calories) VALUES ('banana',90);
INSERT INTO Food (fname,calories) VALUES ('carrot',25);
INSERT INTO Food (fname,calories) VALUES ('celery',30);
INSERT INTO Food (fname,calories) VALUES ('cheerios',100);
INSERT INTO Food (fname,calories) VALUES ('chocolate',300);
INSERT INTO Food (fname,calories) VALUES ('earthworm',3);
INSERT INTO Food (fname,calories) VALUES ('flies',1);
INSERT INTO Food (fname,calories) VALUES ('hay',100);
INSERT INTO Food (fname,calories) VALUES ('leaves',50);
INSERT INTO Food (fname,calories) VALUES ('lettuce',30);
INSERT INTO Food (fname,calories) VALUES ('mealworm',2);
INSERT INTO Food (fname,calories) VALUES ('mosquitos',1);
INSERT INTO Food (fname,calories) VALUES ('mouse',200);
INSERT INTO Food (fname,calories) VALUES ('orange',40);
INSERT INTO Food (fname,calories) VALUES ('peanut',4);
INSERT INTO Food (fname,calories) VALUES ('rat',200);
INSERT INTO Food (fname,calories) VALUES ('salmon',350);
INSERT INTO Food (fname,calories) VALUES ('seeds',2);
INSERT INTO Food (fname,calories) VALUES ('squid',90);
INSERT INTO Food (fname,calories) VALUES ('steak',250);
INSERT INTO Food (fname,calories) VALUES ('venison',450);


-- Menus
INSERT INTO Menu (menuid) VALUES (1);
INSERT INTO contains (fname, menuid, dietician) VALUES ('mealworm', 1, 'Dr. Who');
INSERT INTO contains (fname, menuid, dietician) VALUES ('earthworm', 1, 'Dr. Wiggly');

INSERT INTO Menu (menuid) VALUES (2);
INSERT INTO contains (fname, menuid, dietician) VALUES ('earthworm', 2, 'Dr. Knut');

INSERT INTO Menu (menuid) VALUES (3);
INSERT INTO contains (fname, menuid, dietician) VALUES ('seeds', 3, 'Dr. Birdy');

INSERT INTO Menu (menuid) VALUES (4);
INSERT INTO contains (fname, menuid, dietician) VALUES ('salmon', 4, 'Dr. Peng');

INSERT INTO Menu (menuid) VALUES (5);
INSERT INTO contains (fname, menuid, dietician) VALUES ('peanut', 5, 'Dr. Knut');

INSERT INTO Menu (menuid) VALUES (6);
INSERT INTO contains (fname, menuid, dietician) VALUES ('steak', 6, 'Dr. Carne');

INSERT INTO Menu (menuid) VALUES (7);
INSERT INTO contains (fname, menuid, dietician) VALUES ('hay', 7, 'Dr. Herba');
INSERT INTO contains (fname, menuid, dietician) VALUES ('chocolate', 7, 'Dr. Herba');

INSERT INTO Menu (menuid) VALUES (8);
INSERT INTO contains (fname, menuid, dietician) VALUES ('orange', 8, 'Dr. Fruity');
INSERT INTO contains (fname, menuid, dietician) VALUES ('apple', 8, 'Dr. Fruity');
INSERT INTO contains (fname, menuid, dietician) VALUES ('banana', 8, 'Dr. Fruity');

INSERT INTO Menu (menuid) VALUES (9);
INSERT INTO contains (fname, menuid, dietician) VALUES ('earthworm', 9, 'Dr. Wiggly');

INSERT INTO Menu (menuid) VALUES (10);
INSERT INTO contains (fname, menuid, dietician) VALUES ('mealworm', 10, 'Dr. Wiggly');

INSERT INTO Menu (menuid) VALUES (11);
INSERT INTO contains (fname, menuid, dietician) VALUES ('squid', 11, 'Dr. Wiggly');

INSERT INTO Menu (menuid) VALUES (12);
INSERT INTO contains (fname, menuid, dietician) VALUES ('leaves', 12, 'Dr. Herba');

INSERT INTO Menu (menuid) VALUES (13);
INSERT INTO contains (fname, menuid, dietician) VALUES ('mouse', 13, 'Dr. Pest');
INSERT INTO contains (fname, menuid, dietician) VALUES ('rat', 13, 'Dr. Pest');

INSERT INTO Menu (menuid) VALUES (14);
INSERT INTO contains (fname, menuid, dietician) VALUES ('flies', 14, 'Dr. Secto');

INSERT INTO Menu (menuid) VALUES (15);
INSERT INTO contains (fname, menuid, dietician) VALUES ('mosquitos', 15, 'Dr. Secto');

INSERT INTO Menu (menuid) VALUES (16);
INSERT INTO contains (fname, menuid, dietician) VALUES ('venison', 16, 'Dr. Carne');

-- Duplicate menus...for when an animal eats the same thing for two meals.
INSERT INTO Menu (menuid) VALUES (104);
INSERT INTO contains (fname, menuid, dietician) VALUES ('salmon', 104, 'Dr. Peng');

INSERT INTO Menu (menuid) VALUES (106);
INSERT INTO contains (fname, menuid, dietician) VALUES ('steak', 106, 'Dr. Carne');

INSERT INTO Menu (menuid) VALUES (108);
INSERT INTO contains (fname, menuid, dietician) VALUES ('orange', 108, 'Dr. Fruity');
INSERT INTO contains (fname, menuid, dietician) VALUES ('apple', 108, 'Dr. Fruity');
INSERT INTO contains (fname, menuid, dietician) VALUES ('banana', 108, 'Dr. Fruity');

INSERT INTO Menu (menuid) VALUES (111);
INSERT INTO contains (fname, menuid, dietician) VALUES ('squid', 111, 'Dr. Wiggly');

INSERT INTO Menu (menuid) VALUES (112);
INSERT INTO contains (fname, menuid, dietician) VALUES ('leaves', 112, 'Dr. Herba');

INSERT INTO Menu (menuid) VALUES (114);
INSERT INTO contains (fname, menuid, dietician) VALUES ('flies', 114, 'Dr. Secto');

INSERT INTO Menu (menuid) VALUES (115);
INSERT INTO contains (fname, menuid, dietician) VALUES ('mosquitos', 115, 'Dr. Secto');

-- For testing the peanunt free menus
INSERT INTO Menu (menuid) VALUES (200);
INSERT INTO contains (fname, menuid, dietician) VALUES ('mosquitos', 200, 'Dr. Secto');
INSERT INTO contains (fname, menuid, dietician) VALUES ('squid', 200, 'Dr. Wiggly');
INSERT INTO contains (fname, menuid, dietician) VALUES ('peanut', 200, 'Dr. Nut');
INSERT INTO contains (fname, menuid, dietician) VALUES ('apple', 200, 'Dr. Fruity');
INSERT INTO contains (fname, menuid, dietician) VALUES ('leaves', 200, 'Dr. Herba');

-- Birds
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Kowalski', 4, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Kowalski', 11, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Kowalski', 104, 'dinner');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Kowalski', 111, 'nite-snack');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Private', 4, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Private', 11, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Private', 104, 'dinner');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Private', 111, 'nite-snack');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Skipper', 4, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Skipper', 11, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Skipper', 104, 'dinner');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Skipper', 111, 'nite-snack');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Rico', 4, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Rico', 11, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Rico', 104, 'dinner');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Rico', 111, 'nite-snack');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Bob', 10, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Bob', 9, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Bob', 1, 'dinner');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Bob', 3, 'nite-snack');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Bill', 1, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Bill', 10, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Bill', 9, 'dinner');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Bill', 3, 'nite-snack');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Jill', 10, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Jill', 9, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Jill', 1, 'dinner');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Jill', 3, 'nite-snack');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Jan', 10, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Jan', 1, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Jan', 9, 'dinner');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Jan', 3, 'nite-snack');

-- Mammals
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Alex', 6, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Alex', 16, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Alex', 106, 'dinner');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Marty', 8, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Marty', 7, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Marty', 108, 'dinner');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Melman', 8, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Melman', 12, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Melman', 112, 'dinner');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Gloria', 7, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Gloria', 8, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Gloria', 108, 'dinner');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Ms Piggy', 7, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Ms Piggy', 8, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Ms Piggy', 5, 'dinner');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Merv', 8, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Merv', 108, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Merv', 13, 'dinner');

-- Others
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Kermit', 15, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Kermit', 14, 'brunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Kermit', 9, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Kermit', 115, 'dinner');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Kermit', 114, 'snack');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Mr Slime', 15, 'breakfast');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Mr Slime', 14, 'brunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Mr Slime', 9, 'lunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Mr Slime', 115, 'dinner');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Mr Slime', 114, 'snack');

INSERT INTO eats (aname, menuid, mealtype) VALUES ('Sam', 8, 'brunch');
INSERT INTO eats (aname, menuid, mealtype) VALUES ('Sam', 13, 'dinner');

-- Preditor/Prey
INSERT INTO preyson (predatorname, preyname) VALUES ('Alex', 'Marty');
INSERT INTO preyson (predatorname, preyname) VALUES ('Alex', 'Melman');
INSERT INTO preyson (predatorname, preyname) VALUES ('Alex', 'Gloria');
INSERT INTO preyson (predatorname, preyname) VALUES ('Alex', 'Kowalski');
INSERT INTO preyson (predatorname, preyname) VALUES ('Alex', 'Private');
INSERT INTO preyson (predatorname, preyname) VALUES ('Alex', 'Skipper');
INSERT INTO preyson (predatorname, preyname) VALUES ('Alex', 'Rico');
INSERT INTO preyson (predatorname, preyname) VALUES ('Alex', 'Ms Piggy');
INSERT INTO preyson (predatorname, preyname) VALUES ('Sam', 'Merv');
INSERT INTO preyson (predatorname, preyname) VALUES ('Merv', 'Sam');

