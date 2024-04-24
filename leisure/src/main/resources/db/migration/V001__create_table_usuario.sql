-- Migration V001__create_table_usuario.sql
IF NOT EXISTS(SELECT * FROM sysobjects WHERE name='usuario' and xtype='U')
CREATE TABLE usuario
(
 id				BIGINT				IDENTITY,
 nome				VARCHAR(100)			NOT NULL,
 email				VARCHAR(100)			NOT NULL,
 senha				CHAR(60)			NOT NULL,
 nascimento			DATE				NULL,
 celular			VARCHAR(11)			NOT NULL,
 cpf				CHAR(11)			NOT NULL,
 perfil_principal		VARCHAR(30)			NOT NULL,

 CONSTRAINT PK_USUARIO PRIMARY KEY(id),

 CONSTRAINT UK_EMAIL UNIQUE(email),

 CONSTRAINT UK_CELULAR UNIQUE(celular),

 CONSTRAINT UK_CPF UNIQUE(cpf),

 CONSTRAINT CK_PERFIL_PRINCIPAL CHECK(perfil_principal IN
						('ROLE_USER', 'ROLE_ADMIN','ROLE_VENDEDOR'))
)
