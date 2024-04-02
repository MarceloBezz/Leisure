IF NOT EXISTS(SELECT * FROM sysobjects WHERE name='usuario_roles' and xtype='U')

create table usuario_roles(
usuario_id BIGINT NOT NULL,
role_id BIGINT NOT NULL,
CONSTRAINT fk_usuarios_papeis_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuario(id),
CONSTRAINT fk_usuarios_papeis_roles_id FOREIGN KEY (role_id) REFERENCES roles(role_id)
);
