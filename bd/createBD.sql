/*
Etudiant(@EtudiantId,LastName,FirstName,#ClassId,#FilierId);
Class(@ClassId,ClassName,#FilierId);
Filier(@FilierId,FilierName);
Matier(@MatierId,MatierName,coefficient,#FilierId)
Notes(@[#EtudiantId,#MatierId],Note);
Administration(@adminUserName,password);//admin admin default user
*/
-----------------------------------------------------------------------


CREATE TABLE Etudiant (
    EtudiantId Number NOT NULL,
    LastName varchar2(25),
    FirstName varchar2(25),
    ClassId Number NOT NULL,
    FilierId Number NOT NULL,
    PRIMARY KEY (EtudiantId),
    FOREIGN KEY (ClassId) REFERENCES Class(ClassId),
    FOREIGN KEY (FilierId) REFERENCES Filier(FilierId),
    FOREIGN KEY (MatierId) REFERENCES Matier(MatierId)
);
-----------------------------------------------------------------------
CREATE TABLE Class (
    ClassId Number NOT NULL,
    ClassName varchar2(25),
    FilierId Number NOT NULL,
    PRIMARY KEY (ClassId),
    FOREIGN KEY (FilierId) REFERENCES Filier(FilierId),
);
------------------------------------------------------------------------
CREATE TABLE Filier (
    FilierId Number NOT NULL,
    FilierName varchar2(25),
    PRIMARY KEY (FilierId),
);
-------------------------------------------------------------------------
CREATE TABLE Matier (
    MatierId Number NOT NULL,
    MatierName varchar2(25),
    FilierId Number NOT NULL,
    coefficient Number NOT NULL,
    PRIMARY KEY (MatierId),
    FOREIGN KEY (FilierId) REFERENCES Filier(FilierId)
);
-------------------------------------------------------------------------
CREATE TABLE Note (
    EtudiantId Number NOT NULL,
    MatierId Number NOT NULL,
    Note Number ,
    PRIMARY KEY (EtudiantId,MatierId),
    FOREIGN KEY (EtudiantId) REFERENCES Etudiant(EtudiantId),
    FOREIGN KEY (MatierId) REFERENCES Matier(MatierId)
);
-------------------------------------------------------------------------
CREATE TABLE Administration (
    AdminUserName varchar2(45),
    Password varchar2(45),
    PRIMARY KEY (AdminUserName)
);
