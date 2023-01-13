/*
Etudiant(@EtudiantId,LastName,FirstName,#ClassId,#FilierId);
Class(@ClassId,ClassName,#FilierId);
Filier(@FilierId,FilierName);
Matier(@MatierId,MatierName,coefficient,#FilierId)
Notes(@[#EtudiantId,#MatierId],Note);
Administration(@adminUserName,password);//admin admin default user
*/
-----------------------------------------------------------------------






-------------------------------------------------------------------------
CREATE TABLE Note (
    EtudiantId int NOT NULL,
    MatierId int NOT NULL,
    Note int ,
   CONSTRAINT PRIMARY KEY (EtudiantId,MatierId),
   CONSTRAINT FOREIGN KEY (EtudiantId) REFERENCES Etudiant(EtudiantId),
   CONSTRAINT FOREIGN KEY (MatierId) REFERENCES Matier(MatierId)
);
-------------------------------------------------------------------------
CREATE TABLE Administration (
    AdminUserName varchar(45),
    Password varchar(45),
   CONSTRAINT pk_Ad PRIMARY KEY (AdminUserName)
);
------------------------------------------------------------------------
CREATE TABLE Filier (
    FilierId int NOT NULL,
    FilierName varchar(25),
    CONSTRAINT KEY (FilierId)
);
-----------------------------------------------------------------------
CREATE TABLE Class (
    ClassId int NOT NULL,
    ClassName varchar(25),
    FilierId int NOT NULL,
    CONSTRAINT PRIMARY KEY (ClassId),
    CONSTRAINT FOREIGN KEY (FilierId) REFERENCES Filier(FilierId)
);
-------------------------------------------------------------------------
CREATE TABLE Etudiant (
    EtudiantId int NOT NULL,
    LastName varchar(25),
    FirstName varchar(25),
    ClassId int NOT NULL,
    FilierId int NOT NULL,
    CONSTRAINT PRIMARY KEY (EtudiantId),
    CONSTRAINT FOREIGN KEY (ClassId) REFERENCES Class(ClassId),
    CONSTRAINT FOREIGN KEY (FilierId) REFERENCES Filier(FilierId)
);
-------------------------------------------------------------------------
CREATE TABLE Matier (
    MatierId int NOT NULL,
    MatierName varchar(25),
    FilierId int NOT NULL,
    coefficient int NOT NULL,
    CONSTRAINT PRIMARY KEY (MatierId),
    CONSTRAINT FOREIGN KEY (FilierId) REFERENCES Filier(FilierId)
);
