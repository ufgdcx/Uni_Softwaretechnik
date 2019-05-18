-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 18. Mai 2019 um 17:04
-- Server-Version: 5.7.23-0ubuntu0.16.04.1
-- PHP-Version: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `swt_datenbank`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Dozent`
--

CREATE TABLE `Dozent` (
  `Fakultaet` varchar(255) NOT NULL,
  `EMailadresse` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Dozent`
--

INSERT INTO `Dozent` (`Fakultaet`, `EMailadresse`) VALUES
('Physik', 'email@adresse.de'),
('Informatik', 'Max@Muster.Mann'),
('Meeresbiologie', 'Patrick@Star.org');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Gehoert_zu`
--

CREATE TABLE `Gehoert_zu` (
  `Matrikelnummer` int(9) NOT NULL,
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Gehoert_zu`
--

INSERT INTO `Gehoert_zu` (`Matrikelnummer`, `TeamID`, `GruppenID`, `Veranstaltungsname`) VALUES
(123456789, 4, 12, 'Musterung');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Gruppe`
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
-- Daten für Tabelle `Gruppe`
--

INSERT INTO `Gruppe` (`GruppenID`, `EMailadresse`, `Veranstaltungsname`, `Einschreibungsfrist`, `Uhrzeit`, `Wochentag`, `Wochenrhytmus`) VALUES
(12, 'email@adresse.de', 'Musterung', '1212-12-12', '12:12:12', 'Dienstag', 'nie');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Leistungsblock`
--

CREATE TABLE `Leistungsblock` (
  `Matrikelnummer` int(9) NOT NULL,
  `Leistungsblock_name` varchar(255) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Leitet`
--

CREATE TABLE `Leitet` (
  `Name` varchar(255) NOT NULL,
  `EMailadresse` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Leitet`
--

INSERT INTO `Leitet` (`Name`, `EMailadresse`) VALUES
('Musterung', 'email@adresse.de');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Nutzer`
--

CREATE TABLE `Nutzer` (
  `EMailadresse` varchar(255) NOT NULL,
  `Titel` varchar(255) DEFAULT NULL,
  `Vorname` varchar(255) NOT NULL,
  `Nachname` varchar(255) NOT NULL,
  `Passwort` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Nutzer`
--

INSERT INTO `Nutzer` (`EMailadresse`, `Titel`, `Vorname`, `Nachname`, `Passwort`) VALUES
('email@adresse.de', NULL, 'Sebastian', 'Kuchen', 'qwertz'),
('Hans@maier.org', 'Gangster', 'Hans', 'Maier', 'abc'),
('Max@Muster.Mann', 'Maxmusteressor', 'Max', 'Mustermann', '1234'),
('Patrick@Star.org', 'Seestern', 'Patrick', 'Star', 'Majonaise');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Student`
--

CREATE TABLE `Student` (
  `Matrikelnummer` int(9) NOT NULL,
  `EMailadresse` varchar(255) NOT NULL,
  `Studiengang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Student`
--

INSERT INTO `Student` (`Matrikelnummer`, `EMailadresse`, `Studiengang`) VALUES
(3, 'Hans@maier.org', 'Biologie'),
(123456789, 'Max@Muster.Mann', 'Informatik');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Studienganganteil`
--

CREATE TABLE `Studienganganteil` (
  `Studiengang` varchar(255) NOT NULL,
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Anteil` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Studienganganteil`
--

INSERT INTO `Studienganganteil` (`Studiengang`, `TeamID`, `GruppenID`, `Veranstaltungsname`, `Anteil`) VALUES
('Informatik', 4, 12, 'Musterung', 50);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Team`
--

CREATE TABLE `Team` (
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Thema` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Team`
--

INSERT INTO `Team` (`TeamID`, `GruppenID`, `Veranstaltungsname`, `Thema`) VALUES
(4, 12, 'Musterung', 'Mustererkennung');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Teamleistung`
--

CREATE TABLE `Teamleistung` (
  `Teamleistungsname` varchar(255) NOT NULL,
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Punkte` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Unterblock`
--

CREATE TABLE `Unterblock` (
  `Matrikelnummer` int(9) NOT NULL,
  `Leistungsblock_name` varchar(255) NOT NULL,
  `Unterblock_name` varchar(255) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Punkte` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Veranstaltung`
--

CREATE TABLE `Veranstaltung` (
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Fakultaet` varchar(255) NOT NULL,
  `Teamanzahl_je_Gruppe` int(11) DEFAULT NULL,
  `maximale_Teilnehmeranzahl_je_Team` int(11) DEFAULT NULL,
  `Beschreibung` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Veranstaltung`
--

INSERT INTO `Veranstaltung` (`Veranstaltungsname`, `Fakultaet`, `Teamanzahl_je_Gruppe`, `maximale_Teilnehmeranzahl_je_Team`, `Beschreibung`) VALUES
('Musterung', 'Informatik', 12, 5, 'Musterbeschreibung des Moduls Musterung');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `Dozent`
--
ALTER TABLE `Dozent`
  ADD PRIMARY KEY (`EMailadresse`);

--
-- Indizes für die Tabelle `Gehoert_zu`
--
ALTER TABLE `Gehoert_zu`
  ADD PRIMARY KEY (`Matrikelnummer`,`TeamID`,`GruppenID`,`Veranstaltungsname`),
  ADD KEY `TeamID` (`TeamID`,`GruppenID`,`Veranstaltungsname`);

--
-- Indizes für die Tabelle `Gruppe`
--
ALTER TABLE `Gruppe`
  ADD PRIMARY KEY (`GruppenID`,`Veranstaltungsname`),
  ADD KEY `EMailadresse` (`EMailadresse`),
  ADD KEY `Name` (`Veranstaltungsname`);

--
-- Indizes für die Tabelle `Leistungsblock`
--
ALTER TABLE `Leistungsblock`
  ADD PRIMARY KEY (`Matrikelnummer`,`Leistungsblock_name`,`Veranstaltungsname`),
  ADD KEY `Veranstaltungsname` (`Veranstaltungsname`);

--
-- Indizes für die Tabelle `Leitet`
--
ALTER TABLE `Leitet`
  ADD PRIMARY KEY (`EMailadresse`,`Name`),
  ADD KEY `Name` (`Name`);

--
-- Indizes für die Tabelle `Nutzer`
--
ALTER TABLE `Nutzer`
  ADD PRIMARY KEY (`EMailadresse`);

--
-- Indizes für die Tabelle `Student`
--
ALTER TABLE `Student`
  ADD PRIMARY KEY (`EMailadresse`),
  ADD UNIQUE KEY `Matrikelnummer` (`Matrikelnummer`);

--
-- Indizes für die Tabelle `Studienganganteil`
--
ALTER TABLE `Studienganganteil`
  ADD PRIMARY KEY (`Studiengang`,`TeamID`,`GruppenID`,`Veranstaltungsname`),
  ADD KEY `TeamID` (`TeamID`,`GruppenID`,`Veranstaltungsname`);

--
-- Indizes für die Tabelle `Team`
--
ALTER TABLE `Team`
  ADD PRIMARY KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`),
  ADD KEY `GruppenID` (`GruppenID`,`Veranstaltungsname`);

--
-- Indizes für die Tabelle `Teamleistung`
--
ALTER TABLE `Teamleistung`
  ADD PRIMARY KEY (`Teamleistungsname`,`TeamID`,`GruppenID`,`Veranstaltungsname`),
  ADD KEY `TeamID` (`TeamID`,`GruppenID`,`Veranstaltungsname`);

--
-- Indizes für die Tabelle `Unterblock`
--
ALTER TABLE `Unterblock`
  ADD PRIMARY KEY (`Matrikelnummer`,`Leistungsblock_name`,`Unterblock_name`,`Veranstaltungsname`),
  ADD KEY `Matrikelnummer` (`Matrikelnummer`,`Leistungsblock_name`,`Veranstaltungsname`);

--
-- Indizes für die Tabelle `Veranstaltung`
--
ALTER TABLE `Veranstaltung`
  ADD PRIMARY KEY (`Veranstaltungsname`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `Dozent`
--
ALTER TABLE `Dozent`
  ADD CONSTRAINT `Dozent_ibfk_1` FOREIGN KEY (`EMailadresse`) REFERENCES `Nutzer` (`EMailadresse`);

--
-- Constraints der Tabelle `Gehoert_zu`
--
ALTER TABLE `Gehoert_zu`
  ADD CONSTRAINT `Gehoert_zu_ibfk_1` FOREIGN KEY (`Matrikelnummer`) REFERENCES `Student` (`Matrikelnummer`),
  ADD CONSTRAINT `Gehoert_zu_ibfk_2` FOREIGN KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`) REFERENCES `Team` (`TeamID`, `GruppenID`, `Veranstaltungsname`);

--
-- Constraints der Tabelle `Gruppe`
--
ALTER TABLE `Gruppe`
  ADD CONSTRAINT `Gruppe_ibfk_1` FOREIGN KEY (`EMailadresse`) REFERENCES `Dozent` (`EMailadresse`),
  ADD CONSTRAINT `Gruppe_ibfk_2` FOREIGN KEY (`Veranstaltungsname`) REFERENCES `Veranstaltung` (`Veranstaltungsname`);

--
-- Constraints der Tabelle `Leistungsblock`
--
ALTER TABLE `Leistungsblock`
  ADD CONSTRAINT `Leistungsblock_ibfk_1` FOREIGN KEY (`Matrikelnummer`) REFERENCES `Student` (`Matrikelnummer`),
  ADD CONSTRAINT `Leistungsblock_ibfk_2` FOREIGN KEY (`Veranstaltungsname`) REFERENCES `Veranstaltung` (`Veranstaltungsname`);

--
-- Constraints der Tabelle `Leitet`
--
ALTER TABLE `Leitet`
  ADD CONSTRAINT `Leitet_ibfk_1` FOREIGN KEY (`Name`) REFERENCES `Veranstaltung` (`Veranstaltungsname`),
  ADD CONSTRAINT `Leitet_ibfk_2` FOREIGN KEY (`EMailadresse`) REFERENCES `Dozent` (`EMailadresse`);

--
-- Constraints der Tabelle `Student`
--
ALTER TABLE `Student`
  ADD CONSTRAINT `Student_ibfk_1` FOREIGN KEY (`EMailadresse`) REFERENCES `Nutzer` (`EMailadresse`);

--
-- Constraints der Tabelle `Studienganganteil`
--
ALTER TABLE `Studienganganteil`
  ADD CONSTRAINT `Studienganganteil_ibfk_1` FOREIGN KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`) REFERENCES `Team` (`TeamID`, `GruppenID`, `Veranstaltungsname`);

--
-- Constraints der Tabelle `Team`
--
ALTER TABLE `Team`
  ADD CONSTRAINT `Team_ibfk_1` FOREIGN KEY (`GruppenID`,`Veranstaltungsname`) REFERENCES `Gruppe` (`GruppenID`, `Veranstaltungsname`);

--
-- Constraints der Tabelle `Teamleistung`
--
ALTER TABLE `Teamleistung`
  ADD CONSTRAINT `Teamleistung_ibfk_1` FOREIGN KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`) REFERENCES `Team` (`TeamID`, `GruppenID`, `Veranstaltungsname`);

--
-- Constraints der Tabelle `Unterblock`
--
ALTER TABLE `Unterblock`
  ADD CONSTRAINT `Unterblock_ibfk_1` FOREIGN KEY (`Matrikelnummer`,`Leistungsblock_name`,`Veranstaltungsname`) REFERENCES `Leistungsblock` (`Matrikelnummer`, `Leistungsblock_name`, `Veranstaltungsname`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
