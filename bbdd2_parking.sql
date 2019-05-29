create database parking;

use parking;

drop table if exists abonados;
create table abonados
(
	matricula char(8),
    dni char(9),
    nombre varchar(30),
    apellidos varchar(70),
    numerotarjeta char(16),    
    email varchar(60),
    pin int(6),
    
    constraint pk_abonados primary key abonados(matricula)
);

drop table if exists plazas;
create table plazas
(
	codplaza int,
    tipoplaza int,
    estado int,
    coste decimal(6,2),
    
    constraint pk_plazas primary key plazas(codplaza)
);

drop table if exists tickets;
create table tickets
(
	codticket int,
    tipovehi int,
    matricula char(8),
    codplaza int,
    fecingreso date,
    fecsalida date,
    horaingreso time,
    horasalida time,
    pin int(6),
    costeestancia decimal(8,2),
    
    constraint pk_tickets primary key tickets(codticket),
    constraint fk_tickets_plazas foreign key (codplaza) references plazas (codplaza)
		on delete no action on update cascade
);

drop table if exists detallesAbonados;

create table detallesAbonados
(
	matricula char(8),
    codplaza int,
    tipoabono int,
    feciniabono date,
    fecfinabono date,
    
    constraint pk_detallesAbonados primary key detallesAbonados (matricula, codplaza, feciniabono),
    constraint fk_detallesAbonados_plazas foreign key (codplaza) references plazas (codplaza)
		on delete no action on update cascade,
    constraint fk_detallesAbonados_abonados foreign key (matricula) references abonados (matricula)
		on delete no action on update cascade    
);

insert into plazas
(codplaza,tipoplaza,estado,coste)
values
(1,0,0,0.12),
(2,0,0,0.12),
(3,0,0,0.12),
(4,0,0,0.12),
(5,0,0,0.12),
(6,0,0,0.12),
(7,0,0,0.12),
(8,0,0,0.12),
(9,0,0,0.12),
(10,0,0,0.12),
(11,0,0,0.12),
(12,0,0,0.12),
(13,0,0,0.12),
(14,0,0,0.12),
(15,0,0,0.12),
(16,1,0,0.08),
(17,1,0,0.08),
(18,1,0,0.08),
(19,1,0,0.08),
(20,1,0,0.08),
(21,1,0,0.08),
(22,1,0,0.08),
(23,1,0,0.08),
(24,1,0,0.08),
(25,1,0,0.08),
(26,1,0,0.08),
(27,1,0,0.08),
(28,1,0,0.08),
(29,1,0,0.08),
(30,1,0,0.08),
(31,2,0,0.45),
(32,2,0,0.45),
(33,2,0,0.45),
(34,2,0,0.45),
(35,2,0,0.45),
(36,2,0,0.45),
(37,2,0,0.45),
(38,2,0,0.45),
(39,2,0,0.45),
(40,2,0,0.45),
(41,2,0,0.45),
(42,2,0,0.45),
(43,2,0,0.45),
(44,2,0,0.45),
(45,2,0,0.45);



