-- Migration V003__create_table_usuario_perfil.sql
IF NOT EXISTS(SELECT * FROM sysobjects WHERE name='usuario_perfil' and xtype='U')
CREATE TABLE usuario_perfil
(
 id_usuario		BIGINT		NOT NULL,
 id_perfil		TINYINT		NOT NULL,

 CONSTRAINT FK_ID_USUARIO FOREIGN KEY(id_usuario)
				REFERENCES USUARIO(id),

 CONSTRAINT FK_ID_PERFIL FOREIGN KEY(id_perfil) 
				REFERENCES PERFIL(id),

 CONSTRAINT PK_USUARIO_PERFIL PRIMARY KEY(id_usuario, id_perfil)
)