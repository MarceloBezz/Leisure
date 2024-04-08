IF NOT EXISTS(SELECT * FROM sysobjects WHERE name='usuario_perfil' and xtype='U')

create table usuario_perfil(
usuario_id BIGINT NOT NULL,
perfil_id BIGINT NOT NULL,
CONSTRAINT fk_usuarios_id FOREIGN KEY (usuario_id) REFERENCES usuario(id),
CONSTRAINT fk_usuarios_perfil_id FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);
