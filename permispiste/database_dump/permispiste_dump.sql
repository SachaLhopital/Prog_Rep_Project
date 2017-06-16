-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 16 Juin 2017 à 08:47
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `permispiste`
--

CREATE DATABASE `permispiste`;
use `permispiste`;

-- --------------------------------------------------------

--
-- Structure de la table `action`
--

CREATE TABLE `action` (
  `NUMACTION` int(11) NOT NULL,
  `ACT_NUMACTION` int(11) DEFAULT NULL,
  `LIBACTION` char(25) DEFAULT NULL,
  `SCOREMIN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `action`
--

INSERT INTO `action` (`NUMACTION`, `ACT_NUMACTION`, `LIBACTION`, `SCOREMIN`) VALUES
(1, NULL, 'Se mettre en tenue', 7),
(2, 1, 'Préparation véhicule', 7),
(3, NULL, 'Respect sécurité', 11),
(4, 3, 'Effectuer manoeuvre', 7),
(5, NULL, 'Emettre hypothèse', 12),
(6, 5, 'Proposer solution', 7),
(7, 6, 'Evaluation solution', 11),
(8, 7, 'Effectuer solution', 10),
(9, NULL, 'Accéder mécanique', 7),
(10, 9, 'Vérifications mécanique', 9),
(11, 10, 'Analyser panne(s)', 11),
(12, 10, 'Effectuer niveaux', 10),
(13, NULL, 'Réaction', 7),
(14, 13, 'Action face au danger', 13),
(15, NULL, 'Prise d\'informations', 7),
(16, 15, 'Placement', 12),
(17, 15, 'Utilisation outils comm', 9),
(18, NULL, 'Respect protocole comm', 15),
(19, NULL, 'Travail rendu à temps', 13);

-- --------------------------------------------------------

--
-- Structure de la table `appartient`
--

CREATE TABLE `appartient` (
  `NUMJEU` int(11) NOT NULL,
  `NUMACTION` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `appartient`
--

INSERT INTO `appartient` (`NUMJEU`, `NUMACTION`) VALUES
(1, 1),
(1, 2),
(1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `apprenant`
--

CREATE TABLE `apprenant` (
  `NUMAPPRENANT` int(11) NOT NULL,
  `NOMAPPRENANT` char(25) DEFAULT NULL,
  `PRENOMAPPRENANT` char(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `apprenant`
--

INSERT INTO `apprenant` (`NUMAPPRENANT`, `NOMAPPRENANT`, `PRENOMAPPRENANT`) VALUES
(1, 'Caron', 'Antoine'),
(2, 'Chauslende', 'Adrien'),
(3, 'Galdeano', 'Alexandre'),
(4, 'Reynaud', 'Pierre'),
(11, 'Premilieu', 'Laura'),
(12, 'Fagno', 'Corinne'),
(13, 'Rodarie', 'Dimitri'),
(14, 'Ferjani', 'Gael');

-- --------------------------------------------------------

--
-- Structure de la table `calendrier`
--

CREATE TABLE `calendrier` (
  `DATEJOUR` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `calendrier`
--

INSERT INTO `calendrier` (`DATEJOUR`) VALUES
('2015-06-01'),
('2015-06-10'),
('2015-06-15'),
('2015-06-16'),
('2015-06-19'),
('2015-06-24'),
('2015-06-29'),
('2015-06-30');

-- --------------------------------------------------------

--
-- Structure de la table `est_associe`
--

CREATE TABLE `est_associe` (
  `NUMACTION` int(11) NOT NULL,
  `NUMOBJECTIF` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `est_associe`
--

INSERT INTO `est_associe` (`NUMACTION`, `NUMOBJECTIF`) VALUES
(1, 5),
(2, 5),
(3, 1),
(3, 5),
(3, 6),
(4, 1),
(6, 2),
(7, 2),
(8, 2),
(10, 3),
(11, 3),
(12, 3),
(13, 4),
(14, 4),
(15, 6),
(15, 7),
(16, 6),
(17, 7),
(18, 7),
(19, 8);

-- --------------------------------------------------------

--
-- Structure de la table `fixe`
--

CREATE TABLE `fixe` (
  `NUMMISSION` int(11) NOT NULL,
  `NUMOBJECTIF` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `fixe`
--

INSERT INTO `fixe` (`NUMMISSION`, `NUMOBJECTIF`) VALUES
(1, 1),
(1, 4),
(1, 5),
(1, 6),
(2, 2),
(2, 3),
(2, 5),
(3, 5),
(3, 7),
(3, 8),
(4, 3),
(4, 4),
(5, 1),
(5, 5),
(5, 7),
(5, 8),
(6, 2),
(7, 7),
(8, 5);

-- --------------------------------------------------------

--
-- Structure de la table `indicateur`
--

CREATE TABLE `indicateur` (
  `NUMINDIC` int(11) NOT NULL,
  `NUMACTION` int(11) NOT NULL,
  `LIBINDIC` char(20) DEFAULT NULL,
  `POIDS` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `indicateur`
--

INSERT INTO `indicateur` (`NUMINDIC`, `NUMACTION`, `LIBINDIC`, `POIDS`) VALUES
(1, 1, NULL, 1),
(2, 2, NULL, 2),
(3, 3, NULL, 5),
(4, 4, NULL, 4),
(5, 5, NULL, 1),
(6, 6, NULL, 2),
(7, 7, NULL, 3),
(8, 8, NULL, 2),
(9, 9, NULL, 1),
(10, 10, NULL, 2),
(11, 11, NULL, 3),
(12, 12, NULL, 1),
(13, 13, NULL, 1),
(14, 14, NULL, 3),
(15, 15, NULL, 1),
(16, 16, NULL, 2),
(17, 17, NULL, 1),
(18, 18, NULL, 5),
(19, 19, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `inscrit`
--

CREATE TABLE `inscrit` (
  `NUMJEU` int(11) NOT NULL,
  `NUMAPPRENANT` int(11) NOT NULL,
  `DATEJOUR` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `inscrit`
--

INSERT INTO `inscrit` (`NUMJEU`, `NUMAPPRENANT`, `DATEJOUR`) VALUES
(1, 1, '2015-06-15'),
(2, 1, '2015-06-15'),
(1, 1, '2015-06-16'),
(2, 1, '2015-06-16'),
(1, 1, '2015-06-19'),
(1, 1, '2015-06-30');

-- --------------------------------------------------------

--
-- Structure de la table `jeu`
--

CREATE TABLE `jeu` (
  `NUMJEU` int(11) NOT NULL,
  `LIBELLEJEU` char(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jeu`
--

INSERT INTO `jeu` (`NUMJEU`, `LIBELLEJEU`) VALUES
(1, 'Jeu n°1'),
(2, 'Jeu n°2');

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

CREATE TABLE `mission` (
  `NUMMISSION` int(11) NOT NULL,
  `NUMJEU` int(11) NOT NULL,
  `LIBMISSION` char(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `mission`
--

INSERT INTO `mission` (`NUMMISSION`, `NUMJEU`, `LIBMISSION`) VALUES
(1, 1, 'Mission A'),
(2, 1, 'Mission B'),
(3, 1, 'Mission C'),
(4, 1, 'Mission 3'),
(5, 2, 'Mission A2'),
(6, 2, 'Mission B2'),
(7, 2, 'Mission C2'),
(8, 2, 'Mission D2');

-- --------------------------------------------------------

--
-- Structure de la table `objectif`
--

CREATE TABLE `objectif` (
  `NUMOBJECTIF` int(11) NOT NULL,
  `LIBOBECTIF` char(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `objectif`
--

INSERT INTO `objectif` (`NUMOBJECTIF`, `LIBOBECTIF`) VALUES
(1, 'Réussir manoeuvre'),
(2, 'Analyse des problèmes'),
(3, 'Vérifier mécanique'),
(4, 'Réagir au danger'),
(5, 'Prise de poste correcte'),
(6, 'Placement sur la voie'),
(7, 'Interaction avec pilote'),
(8, 'Respect délai');

-- --------------------------------------------------------

--
-- Structure de la table `obtient`
--

CREATE TABLE `obtient` (
  `NUMAPPRENANT` int(11) NOT NULL,
  `DATEJOUR` date NOT NULL,
  `NUMACTION` int(11) NOT NULL,
  `VALEURDEBUT` int(11) DEFAULT NULL,
  `VALEURFIN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `obtient`
--

INSERT INTO `obtient` (`NUMAPPRENANT`, `DATEJOUR`, `NUMACTION`, `VALEURDEBUT`, `VALEURFIN`) VALUES
(1, '2015-06-15', 1, 10, 12),
(1, '2015-06-16', 1, 5, 5),
(1, '2015-06-24', 1, 1, 10),
(1, '2015-06-29', 1, 1, 5),
(1, '2015-06-30', 1, 1, 2),
(1, '2015-06-30', 4, 2, 4);

-- --------------------------------------------------------

--
-- Structure de la table `possede`
--

CREATE TABLE `possede` (
  `NUMACTION` int(11) NOT NULL,
  `NUMREGLE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `possede`
--

INSERT INTO `possede` (`NUMACTION`, `NUMREGLE`) VALUES
(1, 1),
(1, 3),
(2, 2),
(3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `regle`
--

CREATE TABLE `regle` (
  `NUMREGLE` int(11) NOT NULL,
  `LIBREGLE` char(25) DEFAULT NULL,
  `SCOREMIN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `regle`
--

INSERT INTO `regle` (`NUMREGLE`, `LIBREGLE`, `SCOREMIN`) VALUES
(1, 'UneRegle', 10),
(2, 'Ma seconde règle', 2),
(3, 'Regle numero 3', 3);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `action`
--
ALTER TABLE `action`
  ADD PRIMARY KEY (`NUMACTION`),
  ADD KEY `A_POUR_SUCCESSEUR_FK` (`ACT_NUMACTION`);

--
-- Index pour la table `appartient`
--
ALTER TABLE `appartient`
  ADD PRIMARY KEY (`NUMJEU`,`NUMACTION`),
  ADD KEY `APPARTIENT_FK` (`NUMJEU`),
  ADD KEY `APPARTIENT2_FK` (`NUMACTION`);

--
-- Index pour la table `apprenant`
--
ALTER TABLE `apprenant`
  ADD PRIMARY KEY (`NUMAPPRENANT`);

--
-- Index pour la table `calendrier`
--
ALTER TABLE `calendrier`
  ADD PRIMARY KEY (`DATEJOUR`);

--
-- Index pour la table `est_associe`
--
ALTER TABLE `est_associe`
  ADD PRIMARY KEY (`NUMACTION`,`NUMOBJECTIF`),
  ADD KEY `EST_ASSOCIE_FK` (`NUMACTION`),
  ADD KEY `EST_ASSOCIE2_FK` (`NUMOBJECTIF`);

--
-- Index pour la table `fixe`
--
ALTER TABLE `fixe`
  ADD PRIMARY KEY (`NUMMISSION`,`NUMOBJECTIF`),
  ADD KEY `FIXE_FK` (`NUMMISSION`),
  ADD KEY `FIXE2_FK` (`NUMOBJECTIF`);

--
-- Index pour la table `indicateur`
--
ALTER TABLE `indicateur`
  ADD PRIMARY KEY (`NUMINDIC`),
  ADD KEY `EST_VALORISE_FK` (`NUMACTION`);

--
-- Index pour la table `inscrit`
--
ALTER TABLE `inscrit`
  ADD PRIMARY KEY (`NUMJEU`,`NUMAPPRENANT`,`DATEJOUR`),
  ADD KEY `fk_inscrit_apprenant` (`NUMAPPRENANT`),
  ADD KEY `fk_inscrit_calendrier` (`DATEJOUR`);

--
-- Index pour la table `jeu`
--
ALTER TABLE `jeu`
  ADD PRIMARY KEY (`NUMJEU`);

--
-- Index pour la table `mission`
--
ALTER TABLE `mission`
  ADD PRIMARY KEY (`NUMMISSION`),
  ADD KEY `SE_COMPOSE_FK` (`NUMJEU`);

--
-- Index pour la table `objectif`
--
ALTER TABLE `objectif`
  ADD PRIMARY KEY (`NUMOBJECTIF`);

--
-- Index pour la table `obtient`
--
ALTER TABLE `obtient`
  ADD PRIMARY KEY (`NUMAPPRENANT`,`DATEJOUR`,`NUMACTION`),
  ADD KEY `OBTIENT_FK` (`NUMAPPRENANT`),
  ADD KEY `OBTIENT3_FK` (`DATEJOUR`),
  ADD KEY `OBTIENT3_FK2` (`NUMACTION`);

--
-- Index pour la table `possede`
--
ALTER TABLE `possede`
  ADD PRIMARY KEY (`NUMACTION`,`NUMREGLE`),
  ADD KEY `POSSEDE_FK` (`NUMACTION`),
  ADD KEY `POSSEDE2_FK` (`NUMREGLE`);

--
-- Index pour la table `regle`
--
ALTER TABLE `regle`
  ADD PRIMARY KEY (`NUMREGLE`);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `action`
--
ALTER TABLE `action`
  ADD CONSTRAINT `FK_ACTION_A_POUR_SU_ACTION` FOREIGN KEY (`ACT_NUMACTION`) REFERENCES `action` (`NUMACTION`);

--
-- Contraintes pour la table `appartient`
--
ALTER TABLE `appartient`
  ADD CONSTRAINT `FK_APPARTIE_APPARTIEN_ACTION` FOREIGN KEY (`NUMACTION`) REFERENCES `action` (`NUMACTION`),
  ADD CONSTRAINT `FK_APPARTIE_APPARTIEN_JEU` FOREIGN KEY (`NUMJEU`) REFERENCES `jeu` (`NUMJEU`);

--
-- Contraintes pour la table `est_associe`
--
ALTER TABLE `est_associe`
  ADD CONSTRAINT `FK_EST_ASSO_EST_ASSOC_ACTION` FOREIGN KEY (`NUMACTION`) REFERENCES `action` (`NUMACTION`),
  ADD CONSTRAINT `FK_EST_ASSO_EST_ASSOC_OBJECTIF` FOREIGN KEY (`NUMOBJECTIF`) REFERENCES `objectif` (`NUMOBJECTIF`);

--
-- Contraintes pour la table `fixe`
--
ALTER TABLE `fixe`
  ADD CONSTRAINT `FK_FIXE_FIXE2_OBJECTIF` FOREIGN KEY (`NUMOBJECTIF`) REFERENCES `objectif` (`NUMOBJECTIF`),
  ADD CONSTRAINT `FK_FIXE_FIXE_MISSION` FOREIGN KEY (`NUMMISSION`) REFERENCES `mission` (`NUMMISSION`);

--
-- Contraintes pour la table `indicateur`
--
ALTER TABLE `indicateur`
  ADD CONSTRAINT `FK_INDICATE_EST_VALOR_ACTION` FOREIGN KEY (`NUMACTION`) REFERENCES `action` (`NUMACTION`);

--
-- Contraintes pour la table `inscrit`
--
ALTER TABLE `inscrit`
  ADD CONSTRAINT `fk_inscrit_apprenant` FOREIGN KEY (`NUMAPPRENANT`) REFERENCES `apprenant` (`NUMAPPRENANT`),
  ADD CONSTRAINT `fk_inscrit_calendrier` FOREIGN KEY (`DATEJOUR`) REFERENCES `calendrier` (`DATEJOUR`),
  ADD CONSTRAINT `fk_inscrit_jeu` FOREIGN KEY (`NUMJEU`) REFERENCES `jeu` (`NUMJEU`);

--
-- Contraintes pour la table `mission`
--
ALTER TABLE `mission`
  ADD CONSTRAINT `FK_MISSION_SE_COMPOS_JEU` FOREIGN KEY (`NUMJEU`) REFERENCES `jeu` (`NUMJEU`);

--
-- Contraintes pour la table `obtient`
--
ALTER TABLE `obtient`
  ADD CONSTRAINT `FK_OBTIENT_OBTIENT2_CALENDRI` FOREIGN KEY (`DATEJOUR`) REFERENCES `calendrier` (`DATEJOUR`),
  ADD CONSTRAINT `FK_OBTIENT_OBTIENT3_ACTION` FOREIGN KEY (`NUMACTION`) REFERENCES `action` (`NUMACTION`),
  ADD CONSTRAINT `FK_OBTIENT_OBTIENT_APPRENAN` FOREIGN KEY (`NUMAPPRENANT`) REFERENCES `apprenant` (`NUMAPPRENANT`);

--
-- Contraintes pour la table `possede`
--
ALTER TABLE `possede`
  ADD CONSTRAINT `FK_POSSEDE_POSSEDE2_REGLE` FOREIGN KEY (`NUMREGLE`) REFERENCES `regle` (`NUMREGLE`),
  ADD CONSTRAINT `FK_POSSEDE_POSSEDE_ACTION` FOREIGN KEY (`NUMACTION`) REFERENCES `action` (`NUMACTION`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
