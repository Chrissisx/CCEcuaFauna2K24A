--database: ../DataBase/CCTabla.sqlite

CREATE TABLE CCRegion (
        CodigoRegion      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreRegion       VARCHAR(30) NOT NULL UNIQUE
        ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
        ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
        ,FechaModifica  DATETIME
);

INSERT INTO CCRegion (NombreRegion)
VALUES 
("Costa"),
("Sierra"),
("Oriente"),
("Galapagos");


CREATE TABLE CCPais (
        CodigoPais      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombrePais       VARCHAR(30) NOT NULL UNIQUE
        ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
        ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
        ,FechaModifica  DATETIME
);

INSERT INTO CCPais (NombrePais)
VALUES 
("Ecuador");

CREATE TABLE CCProvincia (
        CodigoProvincia      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreProvincia       VARCHAR(30) NOT NULL UNIQUE
        ,CodigoPais     INTEGER NOT NULL
        ,CodigoRegion INTEGER NOT NULL
        ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
        ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
        ,FechaModifica  DATETIME
);

INSERT INTO CCProvincia (NombreProvincia, CodigoPais, CodigoRegion)
VALUES 
-- Costa (CodigoRegion = 1)
("El Oro", 1, 1),
("Esmeraldas", 1, 1),
("Guayas", 1, 1),
("Los Ríos", 1, 1),
("Manabí", 1, 1),
("Santa Elena", 1, 1),
("Santo Domingo de los Tsáchilas", 1, 1),

-- Sierra (CodigoRegion = 2)
("Azuay", 1, 2),
("Bolívar", 1, 2),
("Cañar", 1, 2),
("Carchi", 1, 2),
("Chimborazo", 1, 2),
("Cotopaxi", 1, 2),
("Imbabura", 1, 2),
("Loja", 1, 2),
("Pichincha", 1, 2),
("Tungurahua", 1, 2),

-- Oriente (CodigoRegion = 3)
("Morona Santiago", 1, 3),
("Napo", 1, 3),
("Orellana", 1, 3),
("Pastaza", 1, 3),
("Sucumbíos", 1, 3),
("Zamora Chinchipe", 1, 3),

-- Galápagos (CodigoRegion = 4)
("Galápagos", 1, 4);


CREATE TABLE CCTipoHormiga (
        CodigoTipoHormiga      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreTipoHormiga       VARCHAR(30) NOT NULL UNIQUE
        ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
        ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
        ,FechaModifica  DATETIME
);

INSERT INTO CCTipoHormiga (NombreTipoHormiga)
VALUES 
("Larva"),
("Soldado"),
("Rastrera"),
("Reina");

CREATE TABLE CCSexo (
        CodigoSexo      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreSexo       VARCHAR(15) NOT NULL UNIQUE
        ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
        ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
        ,FechaModifica  DATETIME
);

INSERT INTO CCSexo (NombreSexo)
VALUES 
("Macho"),
("Hembra"),
("Asexual");


CREATE TABLE CCEstado (
        CodigoEstado      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreEstado       VARCHAR(20) NOT NULL UNIQUE
        ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
        ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
        ,FechaModifica  DATETIME
);

INSERT INTO CCEstado (NombreEstado)
VALUES 
("Huevo"),
("Larva"),
("Pupa"),
("Adulta");

CREATE TABLE CCIngestaNativa (
        CodigoIngestaNativa      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreIngestaNativa       VARCHAR(20) NOT NULL UNIQUE
        ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
        ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
        ,FechaModifica  DATETIME
);

INSERT INTO CCIngestaNativa (NombreIngestaNativa)
VALUES 
("Carnivoro"),
("Herbivoro"),
("Omnivoro"),
("Insectivoro");

CREATE TABLE CCGenoAlimento (
        CodigoGenoAlimento      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreGenoAlimento       VARCHAR(20) NOT NULL UNIQUE
        ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
        ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
        ,FechaModifica  DATETIME
);

INSERT INTO CCGenoAlimento (NombreGenoAlimento)
VALUES 
("X"),
("XX"),
("XY");

CREATE TABLE CCAlimento (
        CodigoAlimento      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreAlimento       VARCHAR(20) NOT NULL UNIQUE
        ,CodigoIngestaNativa INTEGER     NOT NULL  
        ,CodigoGenoAlimento INTEGER     NOT NULL 
        ,DescripcionAlimento  VARCHAR(500) NOT NULL
        ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
        ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
        ,FechaModifica  DATETIME
);


CREATE TABLE CCHormigaAlimento (
        CodigoHormigaAlimento      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,CodigoHormiga       INTEGER NOT NULL
        ,CodigoAlimento       INTEGER NOT NULL
        ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
        ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
        ,FechaModifica  DATETIME
);


CREATE TABLE CCHormiga (
        CodigoHormiga      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreHormiga       VARCHAR(30) NOT NULL UNIQUE
        ,CodigoSexo INTEGER NOT NULL
        ,CodigoTipoHormiga INTEGER NOT NULL
        ,CodigoEstado INTEGER NOT NULL
        ,CodigoProvincia INTEGER NOT NULL
        ,CodigoAlimento INTEGER NOT NULL
        ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
        ,FechaCrea      DATETIME    DEFAULT(datetime('now','localtime'))
        ,FechaModifica  DATETIME
);

