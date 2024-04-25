-- Migration V002__create_table_perfil.sql
IF NOT EXISTS(SELECT * FROM sysobjects WHERE name='perfil' and xtype='U')
CREATE TABLE perfil
(
 id	 TINYINT		IDENTITY,
 tipo	 VARCHAR(30)		NOT NULL,

 CONSTRAINT PK_PERFIL PRIMARY KEY(id),

 CONSTRAINT UK_TIPO UNIQUE(tipo)
)
