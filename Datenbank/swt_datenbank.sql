-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 29, 2019 at 04:15 PM
-- Server version: 5.7.23-0ubuntu0.16.04.1
-- PHP Version: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `swt_datenbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `Dozent`
--

CREATE TABLE `Dozent` (
  `Fakultaet` varchar(255) NOT NULL,
  `EMailadresse` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Dozent`
--

INSERT INTO `Dozent` (`Fakultaet`, `EMailadresse`) VALUES
('', '@uni-rostock.de'),
('Physik', 'email@adresse.de'),
('ABC', 'Klaus@uni-rostock.de'),
('IEF', 'marie.bach@uni-rostock.de'),
('Informatik', 'Max@Muster.Mann'),
('Meeresbiologie', 'Patrick@Star.org');

-- --------------------------------------------------------

--
-- Table structure for table `Einzelleistung`
--

CREATE TABLE `Einzelleistung` (
  `Matrikelnummer` int(11) NOT NULL,
  `Leistungsblock_name` varchar(255) NOT NULL,
  `Unterblock_name` varchar(255) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Einzelleistung_name` varchar(255) NOT NULL,
  `Punkte` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Gehoert_zu`
--

CREATE TABLE `Gehoert_zu` (
  `Matrikelnummer` int(9) NOT NULL,
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Gehoert_zu`
--

INSERT INTO `Gehoert_zu` (`Matrikelnummer`, `TeamID`, `GruppenID`, `Veranstaltungsname`) VALUES
(123456789, 4, 12, 'Musterung');

-- --------------------------------------------------------

--
-- Table structure for table `Gruppe`
--

CREATE TABLE `Gruppe` (
  `GruppenID` int(11) NOT NULL,
  `EMailadresse` varchar(255) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Einschreibungsfrist` date DEFAULT NULL,
  `Uhrzeit` time NOT NULL,
  `Wochentag` varchar(255) NOT NULL,
  `Wochenrhytmus` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Gruppe`
--

INSERT INTO `Gruppe` (`GruppenID`, `EMailadresse`, `Veranstaltungsname`, `Einschreibungsfrist`, `Uhrzeit`, `Wochentag`, `Wochenrhytmus`) VALUES
(12, 'email@adresse.de', 'Musterung', '1212-12-12', '12:12:12', 'Dienstag', 'nie');

-- --------------------------------------------------------

--
-- Table structure for table `Leistungsblock`
--

CREATE TABLE `Leistungsblock` (
  `Matrikelnummer` int(9) NOT NULL,
  `Leistungsblock_name` varchar(255) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Leistungsblock`
--

INSERT INTO `Leistungsblock` (`Matrikelnummer`, `Leistungsblock_name`, `Veranstaltungsname`) VALUES
(3, 'abc', '5.Veranstaltung');

-- --------------------------------------------------------

--
-- Table structure for table `Leitet`
--

CREATE TABLE `Leitet` (
  `Name` varchar(255) NOT NULL,
  `EMailadresse` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Leitet`
--

INSERT INTO `Leitet` (`Name`, `EMailadresse`) VALUES
('5.Veranstaltung', 'Klaus@uni-rostock.de'),
('5.Veranstaltung', 'marie.bach@uni-rostock.de'),
('Musterung', 'email@adresse.de'),
('Rechnernetze und Datensicherheit', 'Patrick@Star.org'),
('Softwaretechnik 2019', 'marie.bach@uni-rostock.de'),
('Stochastik', 'Max@Muster.Mann');

-- --------------------------------------------------------

--
-- Table structure for table `Nutzer`
--

CREATE TABLE `Nutzer` (
  `EMailadresse` varchar(255) NOT NULL,
  `Titel` varchar(255) DEFAULT NULL,
  `Vorname` varchar(255) NOT NULL,
  `Nachname` varchar(255) NOT NULL,
  `Passwort` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Nutzer`
--

INSERT INTO `Nutzer` (`EMailadresse`, `Titel`, `Vorname`, `Nachname`, `Passwort`) VALUES
('@uni-rostock.de', '', '', '', 'j'),
('email@adresse.de', NULL, 'Sebastian', 'Kuchen', 'qwertz'),
('hans.mueller@uni-rostock.de', '', 'Hans', 'Müller', '987'),
('Hans@maier.org', 'Gangster', 'Hans', 'Maier', 'abc'),
('j@uni-rostock.de', '', 'a', 'b', 'l'),
('k@uni-rostock.de', '', 'mm', 'm', '123'),
('Klaus@uni-rostock.de', 'Meister', 'Bob', 'Bau', '123456'),
('lisbeth.gruber@uni-rostock.de', '', 'Lisbeth', 'Gruber', '123456'),
('marie.bach@uni-rostock.de', 'Prof', 'Marie', 'Bach', '9876'),
('Max@Muster.Mann', 'Maxmusteressor', 'Max', 'Mustermann', '1234'),
('Patrick@Star.org', 'Seestern', 'Patrick', 'Star', 'Majonaise');

-- --------------------------------------------------------

--
-- Table structure for table `Student`
--

CREATE TABLE `Student` (
  `Matrikelnummer` int(9) NOT NULL,
  `EMailadresse` varchar(255) NOT NULL,
  `Studiengang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Student`
--

INSERT INTO `Student` (`Matrikelnummer`, `EMailadresse`, `Studiengang`) VALUES
(1234, 'hans.mueller@uni-rostock.de', 'Informatik'),
(3, 'Hans@maier.org', 'Biologie'),
(8, 'j@uni-rostock.de', 't'),
(123, 'k@uni-rostock.de', 'j'),
(12345, 'lisbeth.gruber@uni-rostock.de', 'Informatik'),
(123456789, 'Max@Muster.Mann', 'Informatik');

-- --------------------------------------------------------

--
-- Table structure for table `Studienganganteil`
--

CREATE TABLE `Studienganganteil` (
  `Studiengang` varchar(255) NOT NULL,
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Anteil` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Team`
--

CREATE TABLE `Team` (
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Thema` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Team`
--

INSERT INTO `Team` (`TeamID`, `GruppenID`, `Veranstaltungsname`, `Thema`) VALUES
(4, 12, 'Musterung', 'Mustererkennung');

-- --------------------------------------------------------

--
-- Table structure for table `Teamleistung`
--

CREATE TABLE `Teamleistung` (
  `Teamleistungsblockname` varchar(255) NOT NULL,
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Teamleistungsname` varchar(255) NOT NULL,
  `Punkte` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Teamleistungsblock`
--

CREATE TABLE `Teamleistungsblock` (
  `Teamleistungsblockname` varchar(255) NOT NULL,
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Unterblock`
--

CREATE TABLE `Unterblock` (
  `Matrikelnummer` int(9) NOT NULL,
  `Leistungsblock_name` varchar(255) NOT NULL,
  `Unterblock_name` varchar(255) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Unterblock`
--

INSERT INTO `Unterblock` (`Matrikelnummer`, `Leistungsblock_name`, `Unterblock_name`, `Veranstaltungsname`) VALUES
(3, 'abc', 'blub', '5.Veranstaltung');

-- --------------------------------------------------------

--
-- Table structure for table `Veranstaltung`
--

CREATE TABLE `Veranstaltung` (
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Fakultaet` varchar(255) NOT NULL,
  `Teamanzahl_je_Gruppe` int(11) DEFAULT NULL,
  `maximale_Teilnehmeranzahl_je_Team` int(11) DEFAULT NULL,
  `Beschreibung` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Veranstaltung`
--

INSERT INTO `Veranstaltung` (`Veranstaltungsname`, `Fakultaet`, `Teamanzahl_je_Gruppe`, `maximale_Teilnehmeranzahl_je_Team`, `Beschreibung`) VALUES
('5.Veranstaltung', 'Veranstaltung', 2, 15, '5.Veranstaltung'),
('Musterung', 'Informatik', 12, 5, 'Musterbeschreibung des Moduls Musterung'),
('Rechnernetze und Datensicherheit', 'Informatik', 6, 4, 'Hashen'),
('Softwaretechnik 2019', 'Informatik', 4, 8, 'Bla Bla Bla'),
('Stochastik', 'Mathematik', 20, 1, 'Sinnlos, da Einzelarbeit');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Dozent`
--
ALTER TABLE `Dozent`
  ADD PRIMARY KEY (`EMailadresse`);

--
-- Indexes for table `Einzelleistung`
--
ALTER TABLE `Einzelleistung`
  ADD PRIMARY KEY (`Matrikelnummer`,`Leistungsblock_name`,`Unterblock_name`,`Veranstaltungsname`,`Einzelleistung_name`),
  ADD KEY `Matrikelnummer` (`Matrikelnummer`,`Leistungsblock_name`,`Veranstaltungsname`,`Unterblock_name`);

--
-- Indexes for table `Gehoert_zu`
--
ALTER TABLE `Gehoert_zu`
  ADD PRIMARY KEY (`Matrikelnummer`,`TeamID`,`GruppenID`,`Veranstaltungsname`),
  ADD KEY `TeamID` (`TeamID`,`GruppenID`,`Veranstaltungsname`);

--
-- Indexes for table `Gruppe`
--
ALTER TABLE `Gruppe`
  ADD PRIMARY KEY (`GruppenID`,`Veranstaltungsname`),
  ADD KEY `EMailadresse` (`EMailadresse`),
  ADD KEY `Name` (`Veranstaltungsname`);

--
-- Indexes for table `Leistungsblock`
--
ALTER TABLE `Leistungsblock`
  ADD PRIMARY KEY (`Matrikelnummer`,`Leistungsblock_name`,`Veranstaltungsname`),
  ADD KEY `Veranstaltungsname` (`Veranstaltungsname`);

--
-- Indexes for table `Leitet`
--
ALTER TABLE `Leitet`
  ADD PRIMARY KEY (`EMailadresse`,`Name`),
  ADD KEY `Name` (`Name`);

--
-- Indexes for table `Nutzer`
--
ALTER TABLE `Nutzer`
  ADD PRIMARY KEY (`EMailadresse`);

--
-- Indexes for table `Student`
--
ALTER TABLE `Student`
  ADD PRIMARY KEY (`EMailadresse`),
  ADD UNIQUE KEY `Matrikelnummer` (`Matrikelnummer`);

--
-- Indexes for table `Studienganganteil`
--
ALTER TABLE `Studienganganteil`
  ADD PRIMARY KEY (`Studiengang`,`TeamID`,`GruppenID`,`Veranstaltungsname`),
  ADD KEY `TeamID` (`TeamID`,`GruppenID`,`Veranstaltungsname`);

--
-- Indexes for table `Team`
--
ALTER TABLE `Team`
  ADD PRIMARY KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`),
  ADD KEY `GruppenID` (`GruppenID`,`Veranstaltungsname`);

--
-- Indexes for table `Teamleistung`
--
ALTER TABLE `Teamleistung`
  ADD PRIMARY KEY (`Teamleistungsblockname`,`TeamID`,`GruppenID`,`Veranstaltungsname`,`Teamleistungsname`),
  ADD KEY `TeamID` (`TeamID`,`GruppenID`,`Veranstaltungsname`,`Teamleistungsblockname`);

--
-- Indexes for table `Teamleistungsblock`
--
ALTER TABLE `Teamleistungsblock`
  ADD PRIMARY KEY (`Teamleistungsblockname`,`TeamID`,`GruppenID`,`Veranstaltungsname`),
  ADD KEY `TeamID` (`TeamID`,`GruppenID`,`Veranstaltungsname`);

--
-- Indexes for table `Unterblock`
--
ALTER TABLE `Unterblock`
  ADD PRIMARY KEY (`Matrikelnummer`,`Leistungsblock_name`,`Unterblock_name`,`Veranstaltungsname`),
  ADD KEY `Matrikelnummer` (`Matrikelnummer`,`Leistungsblock_name`,`Veranstaltungsname`);

--
-- Indexes for table `Veranstaltung`
--
ALTER TABLE `Veranstaltung`
  ADD PRIMARY KEY (`Veranstaltungsname`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Dozent`
--
ALTER TABLE `Dozent`
  ADD CONSTRAINT `Dozent_ibfk_1` FOREIGN KEY (`EMailadresse`) REFERENCES `Nutzer` (`EMailadresse`);

--
-- Constraints for table `Einzelleistung`
--
ALTER TABLE `Einzelleistung`
  ADD CONSTRAINT `Einzelleistung_ibfk_1` FOREIGN KEY (`Matrikelnummer`,`Leistungsblock_name`,`Veranstaltungsname`,`Unterblock_name`) REFERENCES `Unterblock` (`Matrikelnummer`, `Leistungsblock_name`, `Veranstaltungsname`, `Unterblock_name`);

--
-- Constraints for table `Gehoert_zu`
--
ALTER TABLE `Gehoert_zu`
  ADD CONSTRAINT `Gehoert_zu_ibfk_1` FOREIGN KEY (`Matrikelnummer`) REFERENCES `Student` (`Matrikelnummer`),
  ADD CONSTRAINT `Gehoert_zu_ibfk_2` FOREIGN KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`) REFERENCES `Team` (`TeamID`, `GruppenID`, `Veranstaltungsname`);

--
-- Constraints for table `Gruppe`
--
ALTER TABLE `Gruppe`
  ADD CONSTRAINT `Gruppe_ibfk_1` FOREIGN KEY (`EMailadresse`) REFERENCES `Dozent` (`EMailadresse`),
  ADD CONSTRAINT `Gruppe_ibfk_2` FOREIGN KEY (`Veranstaltungsname`) REFERENCES `Veranstaltung` (`Veranstaltungsname`);

--
-- Constraints for table `Leistungsblock`
--
ALTER TABLE `Leistungsblock`
  ADD CONSTRAINT `Leistungsblock_ibfk_1` FOREIGN KEY (`Matrikelnummer`) REFERENCES `Student` (`Matrikelnummer`),
  ADD CONSTRAINT `Leistungsblock_ibfk_2` FOREIGN KEY (`Veranstaltungsname`) REFERENCES `Veranstaltung` (`Veranstaltungsname`);

--
-- Constraints for table `Leitet`
--
ALTER TABLE `Leitet`
  ADD CONSTRAINT `Leitet_ibfk_1` FOREIGN KEY (`Name`) REFERENCES `Veranstaltung` (`Veranstaltungsname`),
  ADD CONSTRAINT `Leitet_ibfk_2` FOREIGN KEY (`EMailadresse`) REFERENCES `Dozent` (`EMailadresse`);

--
-- Constraints for table `Student`
--
ALTER TABLE `Student`
  ADD CONSTRAINT `Student_ibfk_1` FOREIGN KEY (`EMailadresse`) REFERENCES `Nutzer` (`EMailadresse`);

--
-- Constraints for table `Studienganganteil`
--
ALTER TABLE `Studienganganteil`
  ADD CONSTRAINT `Studienganganteil_ibfk_1` FOREIGN KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`) REFERENCES `Team` (`TeamID`, `GruppenID`, `Veranstaltungsname`);

--
-- Constraints for table `Team`
--
ALTER TABLE `Team`
  ADD CONSTRAINT `Team_ibfk_1` FOREIGN KEY (`GruppenID`,`Veranstaltungsname`) REFERENCES `Gruppe` (`GruppenID`, `Veranstaltungsname`);

--
-- Constraints for table `Teamleistung`
--
ALTER TABLE `Teamleistung`
  ADD CONSTRAINT `Teamleistung_ibfk_1` FOREIGN KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`,`Teamleistungsblockname`) REFERENCES `Teamleistungsblock` (`TeamID`, `GruppenID`, `Veranstaltungsname`, `Teamleistungsblockname`);

--
-- Constraints for table `Teamleistungsblock`
--
ALTER TABLE `Teamleistungsblock`
  ADD CONSTRAINT `Teamleistungsblock_ibfk_1` FOREIGN KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`) REFERENCES `Team` (`TeamID`, `GruppenID`, `Veranstaltungsname`);

--
-- Constraints for table `Unterblock`
--
ALTER TABLE `Unterblock`
  ADD CONSTRAINT `Unterblock_ibfk_1` FOREIGN KEY (`Matrikelnummer`,`Leistungsblock_name`,`Veranstaltungsname`) REFERENCES `Leistungsblock` (`Matrikelnummer`, `Leistungsblock_name`, `Veranstaltungsname`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
