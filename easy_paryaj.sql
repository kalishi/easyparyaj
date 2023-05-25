create database easy_paryaj;
use easy_paryaj;

CREATE TABLE `compte` (
  `code_C` int(11) NOT NULL,
  `Nom` varchar(100) DEFAULT NULL,
  `Prenom` varchar(100) DEFAULT NULL,
  `Sexe` char(10) DEFAULT NULL,
  `Adresse` varchar(100) DEFAULT NULL,
  `Lieu_de_naissance` varchar(200) DEFAULT NULL,
  `Date_de_naissance` date DEFAULT NULL,
  `Tel` varchar(10) DEFAULT NULL,
  `Nif_Cin` char(10) DEFAULT NULL,
  `Password` text DEFAULT NULL,
  `Solde` double DEFAULT NULL,
  `Etat` char(10) DEFAULT NULL,
  `username` tinytext DEFAULT NULL,
  `isAdmin` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `paiement` (
  `Code_Paiement` int(11) NOT NULL,
  `Date_paiement` datetime DEFAULT NULL,
  `Montant` double DEFAULT NULL,
  `Id_Parriage` int(11) DEFAULT NULL,
  `Id_C` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `parriage` (
  `Code_P` int(11) NOT NULL,
  `Date_P` datetime DEFAULT NULL,
  `Score_prevu` varchar(10) DEFAULT NULL,
  `Montant_mise` double DEFAULT NULL,
  `Solde_fiche` double DEFAULT NULL,
  `Id_C` int(11) DEFAULT NULL,
  `Id_rencontre` int(11) DEFAULT NULL,
  `etat` varchar(10) NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `rencontre` (
  `Code_rencontre` int(11) NOT NULL,
  `Type_rencontre` char(50) DEFAULT NULL,
  `Date_rencontre` date DEFAULT NULL,
  `Pays` char(30) DEFAULT NULL,
  `heure_rencontre` time DEFAULT NULL,
  `Equipe_receveuse` char(10) DEFAULT NULL,
  `Equipe_visiteuse` char(10) DEFAULT NULL,
  `Cote` float DEFAULT NULL,
  `Score_final` char(30) DEFAULT NULL,
  `Etat_rencontre` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


ALTER TABLE `compte`
  ADD PRIMARY KEY (`code_C`),
  ADD UNIQUE KEY `unic_username` (`username`);

ALTER TABLE `paiement`
  ADD PRIMARY KEY (`Code_Paiement`),
  ADD KEY `fk_Parriage` (`Id_Parriage`),
  ADD KEY `fk_Id_C_p` (`Id_C`);

ALTER TABLE `parriage`
  ADD PRIMARY KEY (`Code_P`),
  ADD KEY `fk_rencontre` (`Id_rencontre`),
  ADD KEY `fk_Id_C` (`Id_C`);


ALTER TABLE `rencontre`
  ADD PRIMARY KEY (`Code_rencontre`);

ALTER TABLE `compte`
  MODIFY `code_C` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `paiement`
  ADD CONSTRAINT `fk_Id_C_p` FOREIGN KEY (`Id_C`) REFERENCES `compte` (`code_C`),
  ADD CONSTRAINT `fk_Parriage` FOREIGN KEY (`Id_Parriage`) REFERENCES `parriage` (`Code_P`);

ALTER TABLE `parriage`
  ADD CONSTRAINT `fk_Id_C` FOREIGN KEY (`Id_C`) REFERENCES `compte` (`code_C`),
  ADD CONSTRAINT `fk_rencontre` FOREIGN KEY (`Id_rencontre`) REFERENCES `rencontre` (`Code_rencontre`);