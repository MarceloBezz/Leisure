IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='USUARIO_PERFIL' AND xtype='U')

CREATE TABLE USUARIO_PERFIL
(
	id_usuario		BIGINT		NOT NULL,
	id_perfil		INT			NOT NULL,

	CONSTRAINT PK_USUARIO_PERFIL         PRIMARY KEY(id_usuario, id_perfil),

	CONSTRAINT FK_USUARIO_USUARIO_PERFIL FOREIGN KEY(id_usuario) 
										 REFERENCES USUARIO(id),

    CONSTRAINT FK_PERFIL_USUARIO_PERFIL  FOREIGN KEY(id_perfil)
										 REFERENCES PERFIL(id)
);