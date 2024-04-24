-- Migration V004__create_table_imovel
IF NOT EXISTS(SELECT * FROM sysobjects WHERE name='imovel' and xtype='U')
CREATE TABLE imovel
(
 id				BIGINT				IDENTITY,
 preco				DECIMAL(10,2)			NOT NULL,
 iptu				DECIMAL(7,2)			NOT NULL,
 tipo				VARCHAR(30)			NOT NULL,
 descricao			VARCHAR(6000)			NULL,
 cidade				VARCHAR(50)			NULL,
 bairro				VARCHAR(50)			NULL,
 cep				CHAR(8)				NOT NULL,
 num_residencia			SMALLINT			NULL,
 qtde_quarto			TINYINT				NULL,
 qtde_banheiro			TINYINT				NULL,
 qtde_vaga_garagem		TINYINT				NULL,
 area				DECIMAL(7,2)			NULL,
 sustentabilidade		VARCHAR(30)			NOT NULL,
 id_vendedor			BIGINT				NOT NULL,

 CONSTRAINT PK_IMOVEL PRIMARY KEY(id),

 CONSTRAINT CK_TIPO CHECK(tipo IN('Apartamento', 'Casa', 'Terreno', 'Sítio')),
 
 CONSTRAINT FK_ID_VENDEDOR_IMOVEL FOREIGN KEY(id_vendedor)
			    REFERENCES USUARIO(id) 
)
