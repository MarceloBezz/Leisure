﻿IF NOT EXISTS(SELECT * FROM sysobjects WHERE name='USUARIO' and xtype='U')

CREATE TABLE USUARIO
(
	id					BIGINT			IDENTITY,
	nome				VARCHAR(200)	NOT NULL,
	email				VARCHAR(100)	NOT NULL,
	nascimento			DATE			NULL,
	senha				CHAR(60)		NOT NULL,
	telefone			CHAR(11)		NOT NULL,
	cpf					CHAR(11)		NOT NULL,
	caminho_imagem		VARCHAR(200)	NULL,
	perfil				VARCHAR(50)		NOT NULL,

	CONSTRAINT PK_USUARIO PRIMARY KEY(id),
	CONSTRAINT UK_EMAIL   UNIQUE(email)
);
