alter table if exists "User" drop constraint if exists FKnu6xei8rnc7efob4sgcpexx6c
 alter table if exists "User" drop constraint if exists FKbwib27aeno7xplwdvhy0g1mk
 alter table if exists DietGoal drop constraint if exists FKd6rv2i6fkb2dpbigyukbqf7s5
 alter table if exists InspirationData drop constraint if exists FKdp7wfmgx1gt8w8mh16w4ift4a
 alter table if exists Product drop constraint if exists FKnmvqhl8sw5dvqoqwvk85l7qmu
 alter table if exists Texts drop constraint if exists FKddcvkqxy8653qmfggq8clpmhs
 drop table if exists "User" cascade
 drop table if exists DietGoal cascade
 drop table if exists InspirationData cascade
 drop table if exists Product cascade
 drop table if exists Texts cascade
 drop table if exists TextType cascade
 drop table if exists UserType cascade
 create table "User" (ID serial not null, BirthDate date, Email varchar(255), Name varchar(255) not null, DietGoalID integer, UserTypeID integer, primary key (ID))
 create table DietGoal (ID serial not null, Calories integer, Carbohydrates integer, Fat integer, Protein integer, Salt integer, Sugar integer, DieteticianID integer not null, primary key (ID))
 create table InspirationData (ID bigserial not null, ImagePath varchar(255), TextsID bigint not null, primary key (ID))
 create table Product (ID bigserial not null, Calories integer not null, Carbohydrates integer not null, Fat integer not null, Name varchar(255) not null, Protein integer not null, Salt integer not null, Sugar integer not null, UserID integer not null, primary key (ID))
 create table Texts (ID bigserial not null, Data varchar(255), Type integer, TextTypeID bigint not null, primary key (ID))
 create table TextType (ID bigserial not null, Name varchar(255) not null, primary key (ID))
 create table UserType (ID serial not null, Type varchar(255) not null, primary key (ID))
 alter table if exists "User" add constraint UK_qqsmmdqx1od9cqsx5m1dfssbr unique (Name)
 alter table if exists "User" add constraint FKnu6xei8rnc7efob4sgcpexx6c foreign key (DietGoalID) references DietGoal
 alter table if exists "User" add constraint FKbwib27aeno7xplwdvhy0g1mk foreign key (UserTypeID) references UserType
 alter table if exists DietGoal add constraint FKd6rv2i6fkb2dpbigyukbqf7s5 foreign key (DieteticianID) references "User"
 alter table if exists InspirationData add constraint FKdp7wfmgx1gt8w8mh16w4ift4a foreign key (TextsID) references Texts
 alter table if exists Product add constraint FKnmvqhl8sw5dvqoqwvk85l7qmu foreign key (UserID) references "User"
 alter table if exists Texts add constraint FKddcvkqxy8653qmfggq8clpmhs foreign key (TextTypeID) references TextType