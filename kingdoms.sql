-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 10 dec 2018 om 11:14
-- Serverversie: 10.1.36-MariaDB
-- PHP-versie: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kingdoms`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `kingdom`
--

CREATE TABLE `kingdom` (
  `id`      int(11)     NOT NULL,
  `name`    varchar(32) NOT NULL,
  `members` varchar(32) DEFAULT NULL,
  `prefix`  varchar(16) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `kingdom_member`
--

CREATE TABLE `kingdom_member` (
  `id`                     int(11)     NOT NULL,
  `uuid`                   varchar(64) NOT NULL,
  `kingdom_id`             int(11) DEFAULT NULL,
  `member_permission_uuid` int(11) DEFAULT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Gegevens worden geëxporteerd voor tabel `kingdom_member`
--

INSERT INTO `kingdom_member` (`id`, `uuid`, `kingdom_id`, `member_permission_uuid`)
VALUES (1, 'f73aa17d-166f-4535-92bd-49eda5a27b31', NULL, NULL);

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `member_permission`
--

CREATE TABLE `member_permission` (
  `uuid`          varchar(64) NOT NULL,
  `permission_id` int(11)     NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `permission`
--

CREATE TABLE `permission` (
  `id`         int(11)     NOT NULL,
  `permission` varchar(64) NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `player`
--

CREATE TABLE `player` (
  `id`         int(11)     NOT NULL,
  `uuid`       varchar(32) NOT NULL,
  `first_join` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_join`  timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `kingdom`
--
ALTER TABLE `kingdom`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`),
  ADD KEY `members` (`members`);

--
-- Indexen voor tabel `kingdom_member`
--
ALTER TABLE `kingdom_member`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uuid_2` (`uuid`),
  ADD KEY `uuid` (`uuid`),
  ADD KEY `kingdom_id` (`kingdom_id`);

--
-- Indexen voor tabel `member_permission`
--
ALTER TABLE `member_permission`
  ADD PRIMARY KEY (`uuid`, `permission_id`),
  ADD KEY `uuid` (`uuid`, `permission_id`),
  ADD KEY `permission_id` (`permission_id`);

--
-- Indexen voor tabel `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `kingdom`
--
ALTER TABLE `kingdom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `kingdom_member`
--
ALTER TABLE `kingdom_member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 2;

--
-- AUTO_INCREMENT voor een tabel `permission`
--
ALTER TABLE `permission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT voor een tabel `player`
--
ALTER TABLE `player`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Beperkingen voor geëxporteerde tabellen
--

--
-- Beperkingen voor tabel `kingdom`
--
ALTER TABLE `kingdom`
  ADD CONSTRAINT `kingdom_ibfk_1` FOREIGN KEY (`members`) REFERENCES `kingdom_member` (`uuid`);

--
-- Beperkingen voor tabel `kingdom_member`
--
ALTER TABLE `kingdom_member`
  ADD CONSTRAINT `kingdom_member_ibfk_1` FOREIGN KEY (`kingdom_id`) REFERENCES `kingdom` (`id`);

--
-- Beperkingen voor tabel `member_permission`
--
ALTER TABLE `member_permission`
  ADD CONSTRAINT `member_permission_ibfk_1` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`),
  ADD CONSTRAINT `member_permission_ibfk_2` FOREIGN KEY (`uuid`) REFERENCES `kingdom_member` (`uuid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
