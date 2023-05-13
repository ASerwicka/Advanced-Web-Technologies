CREATE TABLE "Diet goal" (ID SERIAL NOT NULL, UserID int4, DietetiicianID int4, Calories int4, Fat int4, Carbohydrates int4, Sugar int4, Protein int4, Salt int4, PRIMARY KEY (ID));
CREATE TABLE "Inspiration Data" (ID SERIAL NOT NULL, Text varchar(255), ImagePath varchar(255), PRIMARY KEY (ID));
CREATE TABLE Product (ID SERIAL NOT NULL, Name varchar(255), Calories int4 NOT NULL, Fat int4 NOT NULL, Carbohydrates int4 NOT NULL, Sugar int4 NOT NULL, Protein int4 NOT NULL, Salt int4 NOT NULL, UserID int4 NOT NULL, PRIMARY KEY (ID));
CREATE TABLE Texts (ID SERIAL NOT NULL, Type int4, Data varchar(255), TextTypeID int4 NOT NULL, PRIMARY KEY (ID));
CREATE TABLE TextType (ID SERIAL NOT NULL, Name varchar(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE "User" (ID SERIAL NOT NULL, Name varchar(255) NOT NULL, Email varchar(255) NOT NULL, BirthDate date, Type int4 NOT NULL, "Diet goalID" int4, UserTypeID int4 NOT NULL, PRIMARY KEY (ID));
CREATE TABLE UserType (ID SERIAL NOT NULL, Type varchar(255), PRIMARY KEY (ID));
ALTER TABLE Texts ADD CONSTRAINT FKTexts729328 FOREIGN KEY (TextTypeID) REFERENCES TextType (ID);
ALTER TABLE "User" ADD CONSTRAINT FKUser365120 FOREIGN KEY (UserTypeID) REFERENCES UserType (ID);
ALTER TABLE "User" ADD CONSTRAINT FKUser787976 FOREIGN KEY ("Diet goalID") REFERENCES "Diet goal" (ID);
ALTER TABLE Product ADD CONSTRAINT FKProduct336623 FOREIGN KEY (UserID) REFERENCES "User" (ID);

