--database: ../DataBase/CCTabla.sqlite

/*
|-----------------------------------------------|
| (©) 2K24, All rights reserved.                |
| chriscriollo2309@gmail.com        xchrisis    |
|-----------------------------------------------|
Autor : Chris 
Fecha : 16.agosto.2k24
Script: Creando Tablas Hormiga
*/

DROP TABLE IF EXISTS CCHormigaAlimento;
DROP TABLE IF EXISTS CCHormiga;
DROP TABLE IF EXISTS CCAlimento;
DROP TABLE IF EXISTS CCGenoAlimento;
DROP TABLE IF EXISTS CCIngestaNativa;
DROP TABLE IF EXISTS CCEstado;
DROP TABLE IF EXISTS CCSexo;
DROP TABLE IF EXISTS CCTipoHormiga;
DROP TABLE IF EXISTS CCProvincia;
DROP TABLE IF EXISTS CCPais;
DROP TABLE IF EXISTS CCRegion;

CREATE TABLE CCRegion (
        CodigoRegion      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreRegion      VARCHAR(30) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE CCPais (
        CodigoPais        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombrePais        VARCHAR(30) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE CCProvincia (
        CodigoProvincia   INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreProvincia   VARCHAR(30) NOT NULL UNIQUE,
        CodigoPais        INTEGER     NOT NULL,
        CodigoRegion      INTEGER     NOT NULL,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE CCTipoHormiga (
        CodigoTipoHormiga INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreTipoHormiga VARCHAR(30) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE CCSexo (
        CodigoSexo        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreSexo        VARCHAR(15) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE CCEstado (
        CodigoEstado      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreEstado      VARCHAR(20) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE CCIngestaNativa (
        CodigoIngestaNativa INTEGER   NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreIngestaNativa VARCHAR(20) NOT NULL UNIQUE,
        Estado              VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea           DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica       DATETIME
);

CREATE TABLE CCGenoAlimento (
        CodigoGenoAlimento INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreGenoAlimento VARCHAR(20) NOT NULL UNIQUE,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE CCAlimento (
        CodigoAlimento     INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreAlimento     VARCHAR(20) NOT NULL UNIQUE,
        CodigoIngestaNativa INTEGER    NOT NULL,
        CodigoGenoAlimento INTEGER     NOT NULL,
        DescripcionAlimento VARCHAR(500) NOT NULL,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);

CREATE TABLE CCHormigaAlimento (
        CodigoHormigaAlimento INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
        CodigoHormiga        INTEGER   NOT NULL,
        CodigoAlimento       INTEGER   NOT NULL,
        Estado              VARCHAR(1) NOT NULL DEFAULT 'A',
        FechaCrea           DATETIME   DEFAULT(datetime('now','localtime')),
        FechaModifica       DATETIME
);

CREATE TABLE CCHormiga (
        CodigoHormiga      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
        NombreHormiga      VARCHAR(30) NOT NULL UNIQUE,
        CodigoSexo         INTEGER     NOT NULL,
        CodigoTipoHormiga  INTEGER     NOT NULL,
        CodigoEstado       INTEGER     NOT NULL,
        CodigoProvincia    INTEGER     NOT NULL,
        CodigoAlimento     INTEGER     NOT NULL,
        Estado            VARCHAR(1)  NOT NULL DEFAULT 'A',
        FechaCrea         DATETIME    DEFAULT(datetime('now','localtime')),
        FechaModifica     DATETIME
);