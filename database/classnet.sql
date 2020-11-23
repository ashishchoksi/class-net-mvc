-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 23, 2020 at 03:51 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `classnet`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` varchar(100) NOT NULL,
  `ssid` varchar(10) NOT NULL,
  `comment_content` varchar(600) NOT NULL,
  `comment_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`),
  KEY `message_id` (`message_id`),
  KEY `ssid` (`ssid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `message_id` varchar(100) NOT NULL,
  `ssid` varchar(10) NOT NULL,
  `message_content` varchar(800) NOT NULL,
  `message_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_document` int(2) NOT NULL DEFAULT '0',
  `status` int(2) NOT NULL DEFAULT '0',
  `priority` int(2) NOT NULL DEFAULT '0',
  `batch_id` varchar(10) NOT NULL,
  `message_title` varchar(100) NOT NULL,
  `Message_type` int(11) NOT NULL,
  PRIMARY KEY (`message_id`),
  KEY `ssid` (`ssid`),
  KEY `Message_type` (`Message_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`message_id`, `ssid`, `message_content`, `message_date`, `is_document`, `status`, `priority`, `batch_id`, `message_title`, `Message_type`) VALUES
('msg101', '201912106', 'hey this is test message.', '2020-11-23 11:52:38', 0, 1, 0, '201912', 'Test Message!!!!', 2),
('msg1606138383335', '201912106', 'This is inserted', '2020-11-23 00:00:00', 0, 1, 1, '201912', 'TM 2', 1),
('msg1606138535662', '201912106', 'This is inserted 3', '2020-11-23 00:00:00', 0, 1, 1, '201912', 'TM3', 1),
('msg1606141255399', '201912106', 'this is m4', '2020-11-23 00:00:00', 0, 1, 1, '201912', 'TM4', 1);

-- --------------------------------------------------------

--
-- Table structure for table `message_document`
--

DROP TABLE IF EXISTS `message_document`;
CREATE TABLE IF NOT EXISTS `message_document` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` varchar(100) NOT NULL,
  `document_url` varchar(100) NOT NULL,
  PRIMARY KEY (`document_id`),
  KEY `message_id` (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `poll`
--

DROP TABLE IF EXISTS `poll`;
CREATE TABLE IF NOT EXISTS `poll` (
  `poll_id` int(11) NOT NULL AUTO_INCREMENT,
  `poll_title` varchar(100) NOT NULL,
  `poll_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0-not active\r\n1- active',
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `ssid` varchar(10) NOT NULL,
  PRIMARY KEY (`poll_id`),
  KEY `ssid` (`ssid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `poll_answer`
--

DROP TABLE IF EXISTS `poll_answer`;
CREATE TABLE IF NOT EXISTS `poll_answer` (
  `poll_id` int(11) NOT NULL,
  `poll_option_id` int(11) NOT NULL,
  `ssid` varchar(10) NOT NULL,
  KEY `poll_id` (`poll_id`),
  KEY `poll_option_id` (`poll_option_id`),
  KEY `ssid` (`ssid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `poll_option`
--

DROP TABLE IF EXISTS `poll_option`;
CREATE TABLE IF NOT EXISTS `poll_option` (
  `poll_option_id` int(11) NOT NULL AUTO_INCREMENT,
  `poll_id` int(11) NOT NULL,
  `poll_option_data` varchar(100) NOT NULL,
  PRIMARY KEY (`poll_option_id`),
  KEY `poll_id` (`poll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
CREATE TABLE IF NOT EXISTS `program` (
  `program_id` varchar(2) NOT NULL,
  `program_name` varchar(11) NOT NULL,
  `duration` int(2) NOT NULL,
  PRIMARY KEY (`program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `program`
--

INSERT INTO `program` (`program_id`, `program_name`, `duration`) VALUES
('01', 'Btech', 4),
('12', 'mscit', 2);

-- --------------------------------------------------------

--
-- Table structure for table `student_detail`
--

DROP TABLE IF EXISTS `student_detail`;
CREATE TABLE IF NOT EXISTS `student_detail` (
  `ssid` varchar(10) NOT NULL,
  `student_name` varchar(100) NOT NULL,
  `email_id` varchar(100) NOT NULL,
  `student_type_id` int(11) NOT NULL,
  `password` varchar(150) NOT NULL,
  `status` int(2) NOT NULL DEFAULT '0',
  `registration_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `program_id` varchar(2) NOT NULL,
  PRIMARY KEY (`ssid`),
  KEY `student_type_id` (`student_type_id`),
  KEY `program_id` (`program_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_detail`
--

INSERT INTO `student_detail` (`ssid`, `student_name`, `email_id`, `student_type_id`, `password`, `status`, `registration_date`, `program_id`) VALUES
('201912019', 'Vruttant', '201912019@daiict.ac.in', 1, '264181581d95492289e7881b450e0ae9', 0, '2020-11-23 20:08:28', '12'),
('201912106', 'Ashish Choksi', '201912106@daiict.ac.in', 1, '123456', 0, '2020-11-22 21:14:10', '12');

-- --------------------------------------------------------

--
-- Table structure for table `student_pin`
--

DROP TABLE IF EXISTS `student_pin`;
CREATE TABLE IF NOT EXISTS `student_pin` (
  `ssid` varchar(10) NOT NULL,
  `message_id` varchar(100) NOT NULL,
  KEY `ssid` (`ssid`),
  KEY `message_id` (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student_type`
--

DROP TABLE IF EXISTS `student_type`;
CREATE TABLE IF NOT EXISTS `student_type` (
  `student_type_id` int(11) NOT NULL,
  `student_type_name` varchar(50) NOT NULL,
  PRIMARY KEY (`student_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_type`
--

INSERT INTO `student_type` (`student_type_id`, `student_type_name`) VALUES
(1, 'student'),
(2, 'Class Representative'),
(3, 'Election Representative');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`message_id`) REFERENCES `message` (`message_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`ssid`) REFERENCES `student_detail` (`ssid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `message_ibfk_1` FOREIGN KEY (`ssid`) REFERENCES `student_detail` (`ssid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `message_ibfk_2` FOREIGN KEY (`Message_type`) REFERENCES `student_type` (`student_type_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `message_document`
--
ALTER TABLE `message_document`
  ADD CONSTRAINT `message_document_ibfk_1` FOREIGN KEY (`message_id`) REFERENCES `message` (`message_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `poll`
--
ALTER TABLE `poll`
  ADD CONSTRAINT `poll_ibfk_1` FOREIGN KEY (`ssid`) REFERENCES `student_detail` (`ssid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `poll_answer`
--
ALTER TABLE `poll_answer`
  ADD CONSTRAINT `poll_answer_ibfk_1` FOREIGN KEY (`poll_id`) REFERENCES `poll` (`poll_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `poll_answer_ibfk_2` FOREIGN KEY (`poll_option_id`) REFERENCES `poll_option` (`poll_option_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `poll_answer_ibfk_3` FOREIGN KEY (`ssid`) REFERENCES `student_detail` (`ssid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `poll_option`
--
ALTER TABLE `poll_option`
  ADD CONSTRAINT `poll_option_ibfk_1` FOREIGN KEY (`poll_id`) REFERENCES `poll` (`poll_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student_detail`
--
ALTER TABLE `student_detail`
  ADD CONSTRAINT `student_detail_ibfk_1` FOREIGN KEY (`student_type_id`) REFERENCES `student_type` (`student_type_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_detail_ibfk_2` FOREIGN KEY (`program_id`) REFERENCES `program` (`program_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student_pin`
--
ALTER TABLE `student_pin`
  ADD CONSTRAINT `student_pin_ibfk_1` FOREIGN KEY (`ssid`) REFERENCES `student_detail` (`ssid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_pin_ibfk_2` FOREIGN KEY (`message_id`) REFERENCES `message` (`message_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
