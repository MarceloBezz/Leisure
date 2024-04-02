IF NOT EXISTS(SELECT * FROM sysobjects WHERE name='roles' and xtype='U')

create table roles(
roleId BIGINT NOT NULL IDENTITY (1,1) PRIMARY KEY,
role VARCHAR(45) NOT NULL
)
