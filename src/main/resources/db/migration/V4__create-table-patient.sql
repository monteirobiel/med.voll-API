create table patients
(

    id           bigint       not null auto_increment,
    name         varchar(100) not null,
    email        varchar(100) not null unique,
    phone        varchar(20)  NOT NULL,
    cpf          varchar(11)  not null unique,
    street       varchar(100) not null,
    neighborhood varchar(100) not null,
    zipcode      varchar(9)   not null,
    complement   varchar(100),
    number       varchar(20),
    uf           char(2)      not null,
    city         varchar(100),

    primary key (id)

);