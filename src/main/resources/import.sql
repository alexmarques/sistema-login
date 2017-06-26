insert into usuario(login, senha) values('user1', '$2a$10$UjJeZj7WCqN7K1W/lEPgDutb/VzbEeZncE2gxxgYxYaT/YLn2j06K');
insert into usuario(login, senha) values('user2', '$2a$10$CRY8z/WErLSVBw7l8f9HVetVNCxaJLxEkDLnp0t7sSbX4Ymr6pmA.');

insert into permissao(role, login) values ('ROLE_ADMIN', 'user1');
insert into permissao(role, login) values ('ROLE_USER', 'user2');