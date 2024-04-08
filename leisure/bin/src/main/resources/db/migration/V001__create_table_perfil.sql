IF NOT EXISTS(SELECT * FROM sysobjects WHERE name='perfil' and xtype='U')

create table perfil(
id BIGINT NOT NULL IDENTITY (1,1) PRIMARY KEY,
tipo VARCHAR(45) NOT NULL
)
