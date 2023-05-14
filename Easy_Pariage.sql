-- Creation de la base
create database Easy_Pariage;
use Easy_Pariage;

create table Compte(
 code_C int PRIMARY KEY auto_increment,
 Nom varchar(100),
 Prenom varchar(100),
 Sexe char(10),
 Adresse varchar(100),
 Lieu_de_naissance varchar(200),
 Date_de_naissance date,
 Tel varchar(10),
 Nif_Cin char(10),
 Password text(100),
 Solde DOUBLE,
 Etat char(10)
);

create table rencontre(
 Code_rencontre int PRIMARY KEY auto_increment,
 Type_rencontre char(50),
 Date_rencontre date,
 Pays char(30),
 heure_rencontre time,
 Equipe_receveuse char(10),
 Equipe_visiteuse char(10),
 Cote float,
 Srore_final char(30),
 Etat_rencontre char(10)
);

create table Parriage(
 Code_P int PRIMARY KEY auto_increment,
 Date_P datetime,
 Score_prevu varchar(10),
 Montan_mise DOUBLE,
 Solde_fiche DOUBLE,
 Id_C int,
 Id_rencontre int
);

-- les clef etrangere dans la table Parriage
   alter table Parriage add CONSTRAINT fk_rencontre FOREIGN KEY(Id_rencontre) REFERENCES rencontre(Code_rencontre);
   alter table Parriage add CONSTRAINT fk_Id_C FOREIGN KEY(Id_C) REFERENCES Compte(code_C);

   
create table Paiement(
 Code_Paiement int PRIMARY KEY auto_increment,
 Date_paiement datetime,
 Montant DOUBLE,
 Id_Parriage int,
 Id_C int
);

-- La clef etrangere dans la table Paiement
alter table Paiement add CONSTRAINT fk_Parriage FOREIGN KEY(Id_Parriage) REFERENCES Parriage(Code_P);
alter table Paiement add CONSTRAINT fk_Id_C_p FOREIGN KEY(Id_C) REFERENCES Compte(code_C);
