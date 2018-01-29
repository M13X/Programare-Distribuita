connect 'jdbc:derby:AgendaEMail;create=true';
create table tablou(
  id int generated always as identity(start with 1, increment by 1) primary key,
  valori char(25) not null
);
