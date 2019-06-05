-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 05. Jun 2019 um 13:58
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
('', '@uni-rostock.de'),
('IEF', 'ben.schuster@uni-rostock.de'),
('IEF', 'daniel.mueller@uni-rostock.de'),
('IEF', 'dieter.blau@uni-rostock.de'),
('MNF', 'dirk.hirsch@uni-rostock.de'),
('Physik', 'email@adresse.de'),
('IEF', 'felix.nadel@uni-rostock.de'),
('IEF', 'florian.loewe@uni-rostock.de'),
('IEF', 'jan.wurm@uni-rostock.de'),
('IEF', 'jana.klug@uni-rostock.de'),
('ABC', 'Klaus@uni-rostock.de'),
('IEF', 'lian.yin@uni-rostock.de'),
('IEF', 'luca.bosch@uni-rostock.de'),
('IEF', 'maik.berg@uni-rostock.de'),
('IEF', 'marie.bach@uni-rostock.de'),
('IEF', 'max.seiler@uni-rostock.de'),
('Informatik', 'Max@Muster.Mann'),
('Meeresbiologie', 'Patrick@Star.org'),
('IEF', 'paul.finkel@uni-rostock.de'),
('IEF', 'ralf.mauer@uni-rostock.de'),
('s', 'ssss@uni-rostock.de'),
('Ameise', 'test@email.com'),
('IEF', 'ute.baer@uni-rostock.de');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Einzelleistung`
--

CREATE TABLE `Einzelleistung` (
  `Matrikelnummer` int(11) NOT NULL,
  `Leistungsblock_name` varchar(255) NOT NULL,
  `Unterblock_name` varchar(255) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Einzelleistung_name` varchar(255) NOT NULL,
  `Punkte` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Einzelleistung`
--

INSERT INTO `Einzelleistung` (`Matrikelnummer`, `Leistungsblock_name`, `Unterblock_name`, `Veranstaltungsname`, `Einzelleistung_name`, `Punkte`) VALUES
(3, 'abc', 'blub', '5.Veranstaltung', 'Aufgabe x', 2019);

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
(79, 3, 42, 'Mobbing'),
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
(12, 'email@adresse.de', 'Musterung', '1212-12-12', '12:12:12', 'Dienstag', 'nie'),
(42, 'test@email.com', 'Mobbing', '2019-06-02', '14:57:09', 'Mittwoch', 'ger'),
(191, 'marie.bach@uni-rostock.de', 'Softwaretechnik 2019', '2019-12-31', '09:00:00', 'Montag', 'gerade Wochen'),
(192, 'marie.bach@uni-rostock.de', 'Softwaretechnik 2019', '2019-12-31', '11:15:00', 'Dienstag', 'gerade Wochen');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Leistungsblock`
--

CREATE TABLE `Leistungsblock` (
  `Matrikelnummer` int(9) NOT NULL,
  `Leistungsblock_name` varchar(255) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Leistungsblock`
--

INSERT INTO `Leistungsblock` (`Matrikelnummer`, `Leistungsblock_name`, `Veranstaltungsname`) VALUES
(3, 'abc', '5.Veranstaltung'),
(79, 'Bob', 'Mobbing');

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
('5.Veranstaltung', 'Klaus@uni-rostock.de'),
('5.Veranstaltung', 'marie.bach@uni-rostock.de'),
('Aktuelle Themen des Ubiquitous Computing 2019\r\n', 'luca.bosch@uni-rostock.de'),
('Algorithmen und Datenstrukturen2019\r\n', 'maik.berg@uni-rostock.de'),
('Architektur und Entwicklung von Kommunikationsdiensten 2019', 'paul.finkel@uni-rostock.de'),
('Betriebssysteme 2019\r\n', 'ralf.mauer@uni-rostock.de'),
('Computergraphik 2019\r\n', 'daniel.mueller@uni-rostock.de'),
('Datenbank-Anwendungsprogrammierung 2019\r\n', 'dieter.blau@uni-rostock.de'),
('Datenbanken II 2019\r\n', 'florian.loewe@uni-rostock.de'),
('Digitale Systeme 2019\r\n', 'jan.wurm@uni-rostock.de'),
('Komplexität und Formale Sprachen 2019\r\n', 'lian.yin@uni-rostock.de'),
('Kryptographie 2019\r\n', 'lian.yin@uni-rostock.de'),
('KSWS: Datenbanken 2019\r\n', 'dieter.blau@uni-rostock.de'),
('KSWS: Datenbanken 2019\r\n', 'florian.loewe@uni-rostock.de'),
('KSWS: Erweiterung des Funktionsumfang für Petrinetz-Analysewerkzeug 2019\r\n', 'max.seiler@uni-rostock.de'),
('KSWS: Interaktive Systeme 2019', 'ben.schuster@uni-rostock.de'),
('KSWS: Smart Computing 2019\r\n', 'felix.nadel@uni-rostock.de'),
('Künstliche Intelligenz (Modul: Smart Computing) 2019\r\n', 'ute.baer@uni-rostock.de'),
('Logische Programmierung 2019', 'felix.nadel@uni-rostock.de'),
('Mathematik für Elektrotechnik und Informatik 2 2019\r\n', 'dirk.hirsch@uni-rostock.de'),
('Mobbing', 'test@email.com'),
('Modell und Analyse verteilter Systeme 2019\r\n', 'max.seiler@uni-rostock.de'),
('Modellbildung und Simulation 2019', 'jana.klug@uni-rostock.de'),
('Musterung', 'email@adresse.de'),
('Operations Research 2019\r\n', 'lian.yin@uni-rostock.de'),
('Projekt: DBIS 2019\r\n', 'dieter.blau@uni-rostock.de'),
('Projekt: DBIS 2019\r\n', 'florian.loewe@uni-rostock.de'),
('Projekt: Interaktive Systeme 2019\r\n', 'ben.schuster@uni-rostock.de'),
('Projekt: Smart Computing 2019', 'felix.nadel@uni-rostock.de'),
('Rechnernetze und Datensicherheit', 'Patrick@Star.org'),
('Simulation und Gesellschaft 2019\r\n', 'jana.klug@uni-rostock.de'),
('Softwaretechnik 2019', 'marie.bach@uni-rostock.de'),
('Softwaretechnik für Informatik 2019\r\n', 'ben.schuster@uni-rostock.de'),
('Stochastik', 'Max@Muster.Mann'),
('Verteilte Systeme 2019', 'maik.berg@uni-rostock.de');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `MaxPunktzahl`
--

CREATE TABLE `MaxPunktzahl` (
  `Leistungsblock_name` varchar(255) NOT NULL,
  `Unterblock_name` varchar(255) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Leistung_name` varchar(255) NOT NULL,
  `Punkte` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
('@uni-rostock.de', '', '', '', 'j'),
('albert.tritschler@uni-rostock.de', NULL, 'Albert', 'Tritschler', 'qw'),
('alexander.hillen@uni-rostock.de', NULL, 'Alexander', 'Hillen', 'er'),
('anette.wettstein@uni-rostock.de', NULL, 'Anette', 'Wettstein', 'tz'),
('bastian.schilling@uni-rostock.de', NULL, 'Bastian', 'Schilling', 'ui'),
('bcd@uni-rostock.de', 'm', 'm', '&m', 'b'),
('ben.schuster@uni-rostock.de', 'Prof.', 'Ben', 'Schuster', '5e'),
('bernd.kroh@uni-rostock.de', '', 'Bernd', 'Kroh', 'op'),
('bjoern.rothstein@uni-rostock.de', NULL, 'Bernd', 'Rothstein', 'as'),
('bla@uni-rostock.de', '', '', '', ''),
('bob@baumeister.com', 'lord', 'bill', 'Clinton', 'polen'),
('carola.hohmeier@uni-rostock.de', NULL, 'Carola', 'Hohmeier', 'df'),
('charlotte.ahrens@uni-rostock.de', NULL, 'Charlotte', 'Ahrens', 'gh'),
('claudia.zauner@uni-rostock.de', NULL, 'Claudia', 'Zauner', 'jk'),
('daniel.mueller@uni-rostock.de', 'Prof.', 'Daniel', 'Müller', '6f'),
('dieter.blau@uni-rostock.de', 'Prof.', 'Dieter', 'Blau', '11k'),
('dirk.hirsch@uni-rostock.de', 'Prof.', 'Dirk', 'Hirsch', '12m'),
('dominik.jang@uni-rostock.de', NULL, 'Dominik', 'Jang', 'yx'),
('email@adresse.de', '', 'Sebastian', 'Kuchen', 'qwertz'),
('erik.netzes@uni-rostock.de', NULL, 'Erik', 'Netzes', 'cv'),
('eugen.haeberle@uni-rostock.de', NULL, 'Eugen', 'Häberle', 'bn'),
('felix.nadel@uni-rostock.de', 'Prof.', 'Felix', 'Nadel', '3c'),
('finn.segler@uni-rostock.de', NULL, 'Finn', 'Segler', 'qa'),
('florian.loewe@uni-rostock.de', 'Prof.', 'Florian', 'Löwe', '8h'),
('hans.mueller@uni-rostock.de', '', 'Hans', 'Müller', '987'),
('Hans@maier.org', 'Gangster', 'Hans', 'Maier', 'abc'),
('j@uni-rostock.de', '', 'a', 'b', 'l'),
('jakob.alisch@uni-rostock.de', NULL, 'Jakob', 'Alisch', 'ws'),
('jan.wurm@uni-rostock.de', 'Prof.', 'Jan', 'Wurm', '4d'),
('jana.klug@uni-rostock.de', 'Prof.', 'Jana', 'Klug', '9i'),
('john.goepfert@uni-rostock.de', NULL, 'John', 'Göpfert', 'ed'),
('julius.pesch@uni-rostock.de', NULL, 'Julius', 'Pesch', 'rf'),
('k@uni-rostock.de', '', 'mm', 'm', '123'),
('Klaus@uni-rostock.de', 'Meister', 'Bob', 'Bau', '123456'),
('lasse.heek@uni-rostock.de', NULL, 'Lasse', 'Heek', 'tg'),
('lian.yin@uni-rostock.de', 'Prof.', 'Lian', 'Yin', '1a'),
('lisbeth.gruber@uni-rostock.de', '', 'Lisbeth', 'Gruber', '123456'),
('lotte.hansel@uni-rostock.de', NULL, 'Lotte', 'Hansel', 'zh'),
('luca.bosch@uni-rostock.de', 'Prof.', 'Luca', 'Bosch', '2b'),
('luise.zuleeg@uni-rostock.de', NULL, 'Luise', 'Zuleeg', 'uj'),
('maik.berg@uni-rostock.de', 'Prof.', 'Maik', 'Berg', '10j'),
('marie.bach@uni-rostock.de', 'Prof', 'Marie', 'Bach', '9876'),
('mark.franz@uni-rostock.de', NULL, 'Mark', 'Franz', 'ik'),
('max.seiler@uni-rostock.de', 'Prof.', 'Max', 'Seiler', '7g'),
('Max@Muster.Mann', 'Maxmusteressor', 'Max', 'Mustermann', '1234'),
('merle.reuther@uni-rostock.de', NULL, 'Merle', 'Reuther', 'ol'),
('michel.bolle@uni-rostock.de', NULL, 'Michel', 'Bolle', 'ay'),
('moritz.baust@uni-rostock.de', NULL, 'Moritz', 'Baust', 'dc'),
('natascha.diedrich@uni-rostock.de', NULL, 'Natascha', 'Diedrich', 'fv'),
('nicholas.kippe@uni-rostock.de', NULL, 'Nicholas', 'Kippe', 'gb'),
('nick.goldhahn@uni-rostock.de', NULL, 'Nick', 'Goldhahn', 'sx'),
('nils.kreemers@uni-rostock.de', NULL, 'Nils', 'Kreemers', 'hn'),
('Patrick@Star.org', 'Seestern', 'Patrick', 'Star', 'Majonaise'),
('paul.finkel@uni-rostock.de', 'Prof.', 'Paul', 'Finkel', '13n'),
('pauline.ernst@uni-rostock.de', NULL, 'Pauline', 'Ernst', 'jm'),
('philipp.zwicker@uni-rostock.de', NULL, 'Philipp', 'Zwicker', 'qy'),
('ralf.mauer@uni-rostock.de', 'Prof.', 'Ralf', 'Mauer', '15p'),
('robert.brauchle@uni-rostock.de', NULL, 'Robert', 'Brauchle', 'wx'),
('robin.wach@uni-rostock.de', NULL, 'Robin', 'Wach', 'ec'),
('selina.kann@uni-rostock.de', NULL, 'Selina', 'Kann', 'rv'),
('ssss@uni-rostock.de', 'a', 'd', 's', 'sssss'),
('test@email.com', 'Herr', 'bob', 'boob', '123'),
('tina.gruenewald@uni-rostock.de', NULL, 'Tina', 'Grünewald', 'zn'),
('tom.schott@uni-rostock.de', NULL, 'Tom', 'Schott', 'tb'),
('ute.baer@uni-rostock.de', 'Prof.', 'Ute', 'Bär', '14o'),
('vincent.thielen@uni-rostock.de', NULL, 'Vincent', 'Thielen', 'um');

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
(201901, 'albert.tritschler@uni-rostock.de', 'IN'),
(201902, 'alexander.hillen@uni-rostock.de', 'ITTI'),
(201903, 'anette.wettstein@uni-rostock.de', 'WIN'),
(201904, 'bastian.schilling@uni-rostock.de', 'IN'),
(1, 'bcd@uni-rostock.de', 'abc'),
(201905, 'bernd.kroh@uni-rostock.de', 'ITTI'),
(201906, 'bjoern.rothstein@uni-rostock.de', 'WIN'),
(79, 'bob@baumeister.com', 'Imker'),
(201907, 'carola.hohmeier@uni-rostock.de', 'IN'),
(201908, 'charlotte.ahrens@uni-rostock.de', 'ITTI'),
(201909, 'claudia.zauner@uni-rostock.de', 'WIN'),
(201910, 'dominik.jang@uni-rostock.de', 'IN'),
(201911, 'erik.netzes@uni-rostock.de', 'ITTI'),
(201912, 'eugen.haeberle@uni-rostock.de', 'WIN'),
(201913, 'finn.segler@uni-rostock.de', 'IN'),
(1234, 'hans.mueller@uni-rostock.de', 'Informatik'),
(3, 'Hans@maier.org', 'Biologie'),
(8, 'j@uni-rostock.de', 't'),
(201914, 'jakob.alisch@uni-rostock.de', 'ITTI'),
(201915, 'john.goepfert@uni-rostock.de', 'WIN'),
(201916, 'julius.pesch@uni-rostock.de', 'IN'),
(123, 'k@uni-rostock.de', 'j'),
(201917, 'lasse.heek@uni-rostock.de', 'ITTI'),
(12345, 'lisbeth.gruber@uni-rostock.de', 'Informatik'),
(201918, 'lotte.hansel@uni-rostock.de', 'WIN'),
(201919, 'luise.zuleeg@uni-rostock.de', 'IN'),
(201920, 'mark.franz@uni-rostock.de', 'ITTI'),
(123456789, 'Max@Muster.Mann', 'Informatik'),
(201921, 'merle.reuther@uni-rostock.de', 'WIN'),
(201922, 'michel.bolle@uni-rostock.de', 'IN'),
(201924, 'moritz.baust@uni-rostock.de', 'IN'),
(201926, 'natascha.diedrich@uni-rostock.de', 'IN'),
(201925, 'nicholas.kippe@uni-rostock.de', 'IN'),
(201923, 'nick.goldhahn@uni-rostock.de', 'IN'),
(201935, 'nils.kreemers@uni-rostock.de', 'IN'),
(201927, 'pauline.ernst@uni-rostock.de', 'IN'),
(201928, 'philipp.zwicker@uni-rostock.de', 'IN'),
(201929, 'robert.brauchle@uni-rostock.de', 'IN'),
(201930, 'robin.wach@uni-rostock.de', 'IN'),
(201931, 'selina.kann@uni-rostock.de', 'IN'),
(201933, 'tina.gruenewald@uni-rostock.de', 'IN'),
(201932, 'tom.schott@uni-rostock.de', 'IN'),
(201934, 'vincent.thielen@uni-rostock.de', 'IN');

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
('Bilologie', 3, 42, 'Mobbing', 1);

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
(3, 42, 'Mobbing', 'Cybermobbing'),
(4, 12, 'Musterung', 'Mustererkennung');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Teamleistung`
--

CREATE TABLE `Teamleistung` (
  `Teamleistungsblockname` varchar(255) NOT NULL,
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Teamleistungsunterblockname` varchar(255) NOT NULL,
  `Teamleistungsname` varchar(255) NOT NULL,
  `Punkte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Teamleistung`
--

INSERT INTO `Teamleistung` (`Teamleistungsblockname`, `TeamID`, `GruppenID`, `Veranstaltungsname`, `Teamleistungsunterblockname`, `Teamleistungsname`, `Punkte`) VALUES
('Musteranalyse', 4, 12, 'Musterung', 'Musteranalyse 1', 'Aufgabe 1', 1337);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Teamleistungsblock`
--

CREATE TABLE `Teamleistungsblock` (
  `Teamleistungsblockname` varchar(255) NOT NULL,
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Teamleistungsblock`
--

INSERT INTO `Teamleistungsblock` (`Teamleistungsblockname`, `TeamID`, `GruppenID`, `Veranstaltungsname`) VALUES
('Musteranalyse', 4, 12, 'Musterung');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Teamleistungsunterblock`
--

CREATE TABLE `Teamleistungsunterblock` (
  `Teamleistungsblockname` varchar(255) NOT NULL,
  `TeamID` int(11) NOT NULL,
  `GruppenID` int(11) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL,
  `Teamleistungsunterblockname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Teamleistungsunterblock`
--

INSERT INTO `Teamleistungsunterblock` (`Teamleistungsblockname`, `TeamID`, `GruppenID`, `Veranstaltungsname`, `Teamleistungsunterblockname`) VALUES
('Musteranalyse', 4, 12, 'Musterung', 'Musteranalyse 1');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Unterblock`
--

CREATE TABLE `Unterblock` (
  `Matrikelnummer` int(9) NOT NULL,
  `Leistungsblock_name` varchar(255) NOT NULL,
  `Unterblock_name` varchar(255) NOT NULL,
  `Veranstaltungsname` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `Unterblock`
--

INSERT INTO `Unterblock` (`Matrikelnummer`, `Leistungsblock_name`, `Unterblock_name`, `Veranstaltungsname`) VALUES
(3, 'abc', 'blub', '5.Veranstaltung'),
(79, 'Bob', 'A1', 'Mobbing');

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
('5.Veranstaltung', 'Veranstaltung', 2, 15, ''),
('Aktuelle Themen des Ubiquitous Computing 2019\r\n', 'IEF', NULL, NULL, ''),
('Algorithmen und Datenstrukturen2019\r\n', 'IEF', 14, 4, ''),
('Architektur und Entwicklung von Kommunikationsdiensten 2019', 'IEF', NULL, NULL, ''),
('Betriebssysteme 2019\r\n', 'IEF', NULL, NULL, ''),
('Computergraphik 2019\r\n', 'IEF', NULL, NULL, ''),
('Datenbank-Anwendungsprogrammierung 2019\r\n', 'IEF', NULL, NULL, ''),
('Datenbanken II 2019\r\n', 'IEF', NULL, NULL, ''),
('Digitale Systeme 2019\r\n', 'IEF', NULL, NULL, ''),
('Komplexität und Formale Sprachen 2019\r\n', 'IEF', NULL, NULL, ''),
('Kryptographie 2019\r\n', 'IEF', NULL, NULL, ''),
('KSWS: Datenbanken 2019\r\n', 'IEF', 5, 3, ''),
('KSWS: Erweiterung des Funktionsumfang für Petrinetz-Analysewerkzeug 2019\r\n', 'IEF', 3, 4, ''),
('KSWS: Interaktive Systeme 2019', 'IEF', 5, 4, ''),
('KSWS: Smart Computing 2019\r\n', 'IEF', 5, 4, ''),
('Künstliche Intelligenz (Modul: Smart Computing) 2019\r\n', 'IEF', NULL, NULL, ''),
('Logische Programmierung 2019', 'IEF', 13, 6, ''),
('Mathematik für Elektrotechnik und Informatik 2 2019\r\n', 'MNF', NULL, NULL, ''),
('Mobbing', 'Hogwarts', 42, 10, '9/10 Menschen finden Mobbing gut'),
('Modell und Analyse verteilter Systeme 2019\r\n', 'IEF', NULL, NULL, ''),
('Modellbildung und Simulation 2019', 'IEF', NULL, NULL, ''),
('Musterung', 'Informatik', 12, 5, 'Musterbeschreibung des Moduls Musterung'),
('Operations Research 2019\r\n', 'IEF', NULL, NULL, ''),
('Projekt: DBIS 2019\r\n', 'IEF', 6, 3, ''),
('Projekt: Interaktive Systeme 2019\r\n', 'IEF', 3, 5, ''),
('Projekt: Smart Computing 2019', 'IEF', 6, 5, ''),
('Rechnernetze und Datensicherheit', 'Informatik', 6, 4, 'Hashen'),
('Simulation und Gesellschaft 2019\r\n', 'IEF', NULL, NULL, ''),
('Softwaretechnik 2019', 'Informatik', 4, 8, 'lalalala'),
('Softwaretechnik für Informatik 2019\r\n', 'IEF', 9, 8, ''),
('Stochastik', 'Mathematik', 20, 1, 'Zusatz für Informatiker'),
('Verteilte Systeme 2019', 'IEF', 5, 6, '');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `Dozent`
--
ALTER TABLE `Dozent`
  ADD PRIMARY KEY (`EMailadresse`);

--
-- Indizes für die Tabelle `Einzelleistung`
--
ALTER TABLE `Einzelleistung`
  ADD PRIMARY KEY (`Matrikelnummer`,`Leistungsblock_name`,`Unterblock_name`,`Veranstaltungsname`,`Einzelleistung_name`),
  ADD KEY `Matrikelnummer` (`Matrikelnummer`,`Leistungsblock_name`,`Veranstaltungsname`,`Unterblock_name`);

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
-- Indizes für die Tabelle `MaxPunktzahl`
--
ALTER TABLE `MaxPunktzahl`
  ADD PRIMARY KEY (`Leistungsblock_name`,`Unterblock_name`,`Veranstaltungsname`,`Leistung_name`),
  ADD KEY `Veranstaltungsname` (`Veranstaltungsname`);

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
  ADD PRIMARY KEY (`Teamleistungsblockname`,`TeamID`,`GruppenID`,`Veranstaltungsname`,`Teamleistungsunterblockname`,`Teamleistungsname`),
  ADD KEY `TeamID` (`TeamID`,`GruppenID`,`Veranstaltungsname`,`Teamleistungsblockname`,`Teamleistungsunterblockname`);

--
-- Indizes für die Tabelle `Teamleistungsblock`
--
ALTER TABLE `Teamleistungsblock`
  ADD PRIMARY KEY (`Teamleistungsblockname`,`TeamID`,`GruppenID`,`Veranstaltungsname`),
  ADD KEY `TeamID` (`TeamID`,`GruppenID`,`Veranstaltungsname`);

--
-- Indizes für die Tabelle `Teamleistungsunterblock`
--
ALTER TABLE `Teamleistungsunterblock`
  ADD PRIMARY KEY (`Teamleistungsblockname`,`TeamID`,`GruppenID`,`Veranstaltungsname`,`Teamleistungsunterblockname`),
  ADD KEY `TeamID` (`TeamID`,`GruppenID`,`Veranstaltungsname`,`Teamleistungsblockname`);

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
-- Constraints der Tabelle `Einzelleistung`
--
ALTER TABLE `Einzelleistung`
  ADD CONSTRAINT `Einzelleistung_ibfk_1` FOREIGN KEY (`Matrikelnummer`,`Leistungsblock_name`,`Veranstaltungsname`,`Unterblock_name`) REFERENCES `Unterblock` (`Matrikelnummer`, `Leistungsblock_name`, `Veranstaltungsname`, `Unterblock_name`);

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
-- Constraints der Tabelle `MaxPunktzahl`
--
ALTER TABLE `MaxPunktzahl`
  ADD CONSTRAINT `MaxPunktzahl_ibfk_1` FOREIGN KEY (`Veranstaltungsname`) REFERENCES `Veranstaltung` (`Veranstaltungsname`);

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
  ADD CONSTRAINT `Teamleistung_ibfk_1` FOREIGN KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`,`Teamleistungsblockname`,`Teamleistungsunterblockname`) REFERENCES `Teamleistungsunterblock` (`TeamID`, `GruppenID`, `Veranstaltungsname`, `Teamleistungsblockname`, `Teamleistungsunterblockname`);

--
-- Constraints der Tabelle `Teamleistungsblock`
--
ALTER TABLE `Teamleistungsblock`
  ADD CONSTRAINT `Teamleistungsblock_ibfk_1` FOREIGN KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`) REFERENCES `Team` (`TeamID`, `GruppenID`, `Veranstaltungsname`);

--
-- Constraints der Tabelle `Teamleistungsunterblock`
--
ALTER TABLE `Teamleistungsunterblock`
  ADD CONSTRAINT `Teamleistungsunterblock_ibfk_1` FOREIGN KEY (`TeamID`,`GruppenID`,`Veranstaltungsname`,`Teamleistungsblockname`) REFERENCES `Teamleistungsblock` (`TeamID`, `GruppenID`, `Veranstaltungsname`, `Teamleistungsblockname`);

--
-- Constraints der Tabelle `Unterblock`
--
ALTER TABLE `Unterblock`
  ADD CONSTRAINT `Unterblock_ibfk_1` FOREIGN KEY (`Matrikelnummer`,`Leistungsblock_name`,`Veranstaltungsname`) REFERENCES `Leistungsblock` (`Matrikelnummer`, `Leistungsblock_name`, `Veranstaltungsname`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
