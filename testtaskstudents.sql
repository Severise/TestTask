-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2021 at 06:15 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.1.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testtaskstudents`
--

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `group` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `first_name`, `middle_name`, `last_name`, `birth_date`, `group`) VALUES
(1, 'Иван', 'Иванович', 'Иванов', '1992-01-02', 'ф-123'),
(2, 'Сергей', 'Сергеевич', 'Сергеев', '1998-10-08', 'ф-122'),
(3, 'Антон', 'Антонович', 'Антонов', '1997-10-28', 'ф-123'),
(4, 'Алексей', 'Алексеевич', 'Алексеев', '1997-01-01', 'и-888'),
(5, 'Борис', 'Борисович', 'Борисов', '1996-02-02', 'с-332'),
(6, 'Богдан', 'Богданович', 'Богданов', '1995-03-04', 'ф-123'),
(7, 'Виталий', 'Владимирович', 'Владимиров', '1994-05-05', 'ф-122'),
(8, 'Денис', 'Денисович', 'Денисов', '1999-06-06', 'и-888'),
(9, 'Павел', 'Павлович', 'Павлов', '1999-07-07', 'и-888'),
(10, 'Андрей', 'Андреевич', 'Андреев', '2000-12-08', 'ф-122'),
(11, 'Олег', 'Олегович', 'Олегов', '2000-09-09', 'с-332'),
(12, 'Михаил', 'Михаилович', 'Михаилов', '1998-10-18', 'с-332');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
