CREATE DATABASE LEISURE
GO

USE LEISURE
GO

CREATE TABLE ENDERECO (
CEP CHAR(8) PRIMARY KEY,
RUA VARCHAR(100) NOT NULL,
CIDADE VARCHAR(50) NOT NULL, 
ESTADO CHAR(2) NOT NULL
)
GO

CREATE TABLE USUARIO (
ID INT PRIMARY KEY IDENTITY,
NOME VARCHAR(100),
EMAIL VARCHAR(50) NOT NULL UNIQUE,
SENHA VARCHAR(20) NOT NULL,
TELEFONE CHAR(11),
CPF CHAR(11) UNIQUE,
ATIVO BIT NOT NULL,

CEP_ENDERECO CHAR(8) NOT NULL,
NUM_RESIDENCIA SMALLINT NOT NULL,
COMPLEMENTO VARCHAR(20)
)
GO

ALTER TRIGGER ADDCOMPLEMENTO 
ON USUARIO FOR INSERT AS
BEGIN
IF (SELECT ISNULL(COMPLEMENTO, NULL) FROM INSERTED) IS NULL
	BEGIN
		UPDATE USUARIO SET COMPLEMENTO = 'Nenhum' WHERE ID = (SELECT ID FROM INSERTED)
	END
END
GO

INSERT INTO USUARIO VALUES ('enzo', 'enzo@gmail.com', '123', '1198763987', '11122233396', 1, '06401160', '1330', 'BL 12 AP 233')

SELECT * FROM USUARIO;