CREATE DATABASE IF NOT EXISTS `SqlProject`;

use `SqlProject`;

CREATE TABLE Ship
  (
    sname char(10),
    capacity integer,
    aname char(10) not null,
    primary key (sname)   
  );
  
  
    create table Cabin
  (
    cabinnum integer,
    sname char(10),
    capacity integer,
    primary key(cabinnum, sname),
    foreign key(sname) references Ship (sname) on delete cascade 
  );

  create table Animal
  (       
    aname char(10),
    iscarn char(1),
    cabinnum integer,
    sname char(10),
    species char(10),
    country char(10),
    weight integer,       
    primary key(aname),
    foreign key (cabinnum,sname) references Cabin(cabinnum, sname)   
  );

    create table Penguin
  (
    aname char(10),
    primary key(aname),
    foreign key(aname) references Animal (aname) on delete cascade
  );

alter table Ship add foreign key (aname) references Penguin (aname);

create table Food
  (
    fname char(10),
    calories integer,
    primary key (fname)
  );

  create table Menu
  (
    menuid integer,
    primary key(menuid)
  );
  
  
  create table eats
  (
    aname char(10),
    menuid integer,
    mealtype char(10),
    primary key (aname, menuid),
    foreign key (aname) references Animal (aname),
    foreign key (menuid) references Menu (menuid)
  );

  create table contains
  (
    fname char(10),
    menuid integer,
    dietician char(10),
    primary key (fname, menuid),
    foreign key (fname) references Food (fname),
    foreign key (menuid) references Menu (menuid)
  );

  create table preyson
  (
    predatorname char(10),
    preyname char(10),
    primary key(predatorname, preyname),
    foreign key(predatorname) references Animal (aname),
    foreign key(preyname) references Animal (aname)
  );
