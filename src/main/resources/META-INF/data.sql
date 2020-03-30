insert into roles (ROLE_NAME) values ('ROLE_ADMIN'); 
insert into roles (ROLE_NAME) values ('ROLE_USER');
insert into usuarios(username,password) values ('dbuser1', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi');
insert into usuarios(username,password) values ('dbadmin1', '$2a$10$9DIGx1gtTlRQAcb8Zod6YOs.IBVIyHtgjpy0Pi95El8FTp2YPc3fi');
insert into usuariorol (USER_ID, ROLE_ID) values (1, 2); 
insert into usuariorol (USER_ID, ROLE_ID) values (2, 1);