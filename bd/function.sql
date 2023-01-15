
CREATE or replace procedure chercheByClassName(in classNameInput) as
select EtudiantId,LastName,FirstName,ClassName,FilierName from Etudiant e 
inner join Class c on e.ClassId=c.ClassId
inner join  Filier f on c.FilierId=f.FilierId
where c.ClassName=classNameInput;
end chercheByClassName;
/
-----------------------------------------------------------------------
CREATE or replace procedure chercheByFilierName(in filierNameInput) as
select EtudiantId,LastName,FirstName,ClassName,FilierName from Etudiant e 
inner join Class c on e.ClassId=c.ClassId
inner join  Filier f on c.FilierId=f.FilierId
where f.FilierName = filierNameInput;
end chercheByFilierName;
/
-----------------------------------------------------------------------
CREATE or replace procedure chercheByFirstName(in firstNameInput) as
select EtudiantId,LastName,FirstName,ClassName,FilierName from Etudiant e 
inner join Class c on e.ClassId=c.ClassId
inner join  Filier f on c.FilierId=f.FilierId
where e.FirstName = firstNameInput;
end chercheByFirstName;
/
-----------------------------------------------------------------------
CREATE or replace procedure chercheByLastName(in lastNameInput) as
select EtudiantId,LastName,FirstName,ClassName,FilierName from Etudiant e 
inner join Class c on e.ClassId=c.ClassId
inner join  Filier f on c.FilierId=f.FilierId
where e.LastName = lastNameInput;
end chercheByLastName;
/
----------------------------------------------------------------------
CREATE or replace procedure chercheByFullName(in lastName,in firstName) as
select EtudiantId,LastName,FirstName,ClassName,FilierName from Etudiant e 
inner join Class c on e.ClassId=c.ClassId
inner join  Filier f on c.FilierId=f.FilierId
where e.LastName = lastName and e.FirstName=firstName;
end chercheByFullName;
/
------------------------------------------------------------------------
CREATE or replace procedure chercheByEtudiantId(in etudiantId) as
select EtudiantId,LastName,FirstName,ClassName,FilierName from Etudiant e 
inner join Class c on e.ClassId=c.ClassId
inner join  Filier f on c.FilierId=f.FilierId
where e.EtudiantId = etudiantId;
end chercheByEtudiantId;
/
--------------------------------------------------------------------------
CREATE or replace function adminVerification(in userName , in passwd) return boolean as
pass varch2(45)
begin
select Password into pass from Administration where AdminUserName=userName ;
if (pass=userName) then return true
else return false
end if ;
exeption 
when no data found then return false;
end ;
/
---------------------------------------------------------------------------
CREATE or replace function deleteEtudiant(in etudiantId)  as
DELETE FROM Etudiant ,Notes  
WHERE Notes.EtudiantId=etudiantId  and Etudiant.EtudiantId = etudiantId;
---------------------------------------------------------------------------
CREATE or replace function deleteClass(in classId)  as
DELETE FROM Class  
WHERE Class.ClassId=classId;
---------------------------------------------------------------------------
CREATE or replace function deleteFilier(in filierId)  as
DELETE FROM Filier  
WHERE Filier.FilierId=filierId ;
---------------------------------------------------------------------------
CREATE or replace function deleteNote(in etudiantId,in matierId)  as
DELETE FROM Notes  
WHERE Notes.EtudiantId=etudiantId  and Notes.MatierId = matierId;
---------------------------------------------------------------------------
CREATE or replace function deleteMatier(in matierId)  as
DELETE FROM Matier  
WHERE MatierId=matierid;
---------------------------------------------------------------------------
CREATE or replace function deleteEtudiant(in etudiantId)  as
DELETE FROM Etudiant ,Notes  
WHERE Notes.EtudiantId=etudiantId  and Etudiant.EtudiantId = etudiantId;
---------------------------------------------------------------------------



