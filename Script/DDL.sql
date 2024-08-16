--database: ../DataBase/CCTabla.sqlite

CREATE TABLE CCRegion (
        CodigoRegion      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreRegion       VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE CCPais (
        CodigoPais      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombrePais       VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE CCProvincia (
        CodigoProvincia      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreProvincia       VARCHAR(30) NOT NULL UNIQUE
        ,CodigoPais     INTEGER NOT NULL
        ,CodigoRegion INTEGER NOT NULL
);

CREATE TABLE CCTipoHormiga (
        CodigoTipoHormiga      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreTipoHormiga       VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE CCSexo (
        CodigoSexo      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreSexo       VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE CCEstado (
        CodigoEstado      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreEstado       VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE CCIngestaNativa (
        CodigoIngestaNativa      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreIngestaNativa       VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE CCGenoAlimento (
        CodigoGenoAlimento      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreGenoAlimento       VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE CCAlimento (
        CodigoAlimento      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreAlimento       VARCHAR(20) NOT NULL UNIQUE
        ,CodigoIngestaNativa INTEGER     NOT NULL  
        ,CodigoGenoAlimento INTEGER     NOT NULL 
        ,DescripcionAlimento  VARCHAR(500) NOT NULL 
);

CREATE TABLE CCHormigaAlimento (
        CodigoHormigaAlimento      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,CodigoHormiga       INTEGER NOT NULL
        ,CodigoAlimento       INTEGER NOT NULL
);


CREATE TABLE CCHormiga (
        CodigoHormiga      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT     
        ,NombreHormiga       VARCHAR(30) NOT NULL UNIQUE
        ,CodigoSexo INTEGER NOT NULL
        ,CodigoTipoHormiga INTEGER NOT NULL
        ,CodigoEstado INTEGER NOT NULL
        ,CodigoProvincia INTEGER NOT NULL
        ,CodigoAlimento INTEGER NOT NULL
);

