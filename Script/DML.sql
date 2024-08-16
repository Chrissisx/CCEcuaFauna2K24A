--database: ../DataBase/CCTabla.sqlite

/*
|-----------------------------------------------|
| (©) 2K24, All rights reserved.                |
| chriscriollo2309@gmail.com        xchrisis    |
|-----------------------------------------------|
Autor : Chris 
Fecha : 16.agosto.2k24
Script: Insertando Datos Hormiga
*/

INSERT INTO CCRegion 
( NombreRegion   ) VALUES 
( "Costa"        ),
( "Sierra"       ),
( "Oriente"      ),
( "Galapagos"    );

INSERT INTO CCPais 
( NombrePais     ) VALUES 
( "Ecuador"      );

INSERT INTO CCProvincia 
( NombreProvincia                   , CodigoPais , CodigoRegion ) VALUES 
( "El Oro"                          , 1          , 1            ),
( "Esmeraldas"                      , 1          , 1            ),
( "Guayas"                          , 1          , 1            ),
( "Los Rios"                        , 1          , 1            ),
( "Manabí"                          , 1          , 1            ),
( "Santa Elena"                     , 1          , 1            ),
( "Santo Domingo de los Tsachilas"  , 1          , 1            ),
( "Azuay"                           , 1          , 2            ),
( "Bolivar"                         , 1          , 2            ),
( "Cañar"                           , 1          , 2            ),
( "Carchi"                          , 1          , 2            ),
( "Chimborazo"                      , 1          , 2            ),
( "Cotopaxi"                        , 1          , 2            ),
( "Imbabura"                        , 1          , 2            ),
( "Loja"                            , 1          , 2            ),
( "Pichincha"                       , 1          , 2            ),
( "Tungurahua"                      , 1          , 2            ),
( "Morona Santiago"                 , 1          , 3            ),
( "Napo"                            , 1          , 3            ),
( "Orellana"                        , 1          , 3            ),
( "Pastaza"                         , 1          , 3            ),
( "Sucumbios"                       , 1          , 3            ),
( "Zamora Chinchipe"                , 1          , 3            ),
( "Galapagos"                       , 1          , 4            );

INSERT INTO CCTipoHormiga 
( NombreTipoHormiga ) VALUES 
( "Larva"           ),
( "Soldado"         ),
( "Rastrera"        ),
( "Reina"           );

INSERT INTO CCSexo 
( NombreSexo       ) VALUES 
( "Macho"          ),
( "Hembra"         ),
( "Asexual"        );

INSERT INTO CCEstado 
( NombreEstado     ) VALUES 
( "Huevo"          ),
( "Larva"          ),
( "Pupa"           ),
( "Adulta"         );

INSERT INTO CCIngestaNativa 
( NombreIngestaNativa  ) VALUES 
( "Carnivoro"          ),
( "Herbivoro"          ),
( "Omnivoro"           ),
( "Insectivoro"        );

INSERT INTO CCGenoAlimento 
( NombreGenoAlimento   ) VALUES 
( "X"                  ),
( "XX"                 ),
( "XY"                 );
