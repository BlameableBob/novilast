-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 16, 2019 at 07:55 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31
-- user: admin 
-- Password: admin

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(75) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `birthdate` varchar(45) NOT NULL,
  `city` varchar(75) NOT NULL,
  `address` varchar(75) NOT NULL,
  `patient` varchar(75) DEFAULT NULL,
  
  
  
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`id`, `name`, `email`, `phone`,`sex`, `birthdate`,`city`, `address`, `patient`) VALUES
(1, 'Jean-Luc Picard', 'contact1@email.com', '(111) 111-1111', 'man', '2305-01-01', 'Earth', 'Arizona 61', 'Remco'),
(2, 'James T. Kirk', 'contact2@email.com', '(222) 222-2222', 'man', '2233-01-01','New York', 'Manhattan 200', 'Bart'),
(3, 'Jonathan Archer', 'contact3@email.com', '(333) 333-3333', 'man', '1980-01-01','Den Haag', 'Oude Molstraat 80', 'Zafira'),
(4, 'Kathryn Janeway', 'contact4@email.com', '(444) 444-4444', 'vrouw', '1950-01-01','Zoetermeer', 'Cesar Franckrode 61', 'Jay-Z'),
(5, 'Jamie Lannister', 'contact5@email.com', '(111) 111-1111', 'man', '1922-08-09','Almere', 'Kerkenstraat 15', 'Eva'),
(6, 'Ned Stark', 'contact6@email.com', '(888) 888-8888', 'man', '1880-01-01','Rotterdam', 'Rotjeknor 67', 'Inge'),
(7, 'James Bond', '007@email.com', '(007) 007-0007', 'man', '1968-05-04','London', 'Thamesriver 890', 'Tim'),
(8, 'Albert Einstein', 'contact8@email.com', '(111) 111-1111', 'man', '1879-01-01','Ulm', 'Deutschlandlahn 2', 'Remco'),
(9, 'Sigourney Weaver', 'contact9@email.com', '(999) 131-1199', 'vrouw', '1960-01-01','Zoetermeer', 'Cesar Franckrode 61', 'Jane'),
(10, 'Scarlett Johansson', 'contact10@email.com', '(111) 111-1111', 'vrouw', '1984-03-07','New York', 'second street 25', 'Bert');

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wachtwoord` varchar(75) NOT NULL,
  `email` varchar(150) NOT NULL,
  
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);
INSERT INTO `admin` (`id`, `wachtwoord`, `email`) VALUES
(1, 'Welkom2019', 'admin@email.com'),
(2, 'VeiligWW666', 'ookadmin@gmail.com');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
