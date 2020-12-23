-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 23, 2020 at 08:54 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `classnet`
--
CREATE DATABASE IF NOT EXISTS `classnet` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `classnet`;

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` varchar(100) NOT NULL,
  `ssid` varchar(10) NOT NULL,
  `comment_content` varchar(600) NOT NULL,
  `comment_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`),
  KEY `message_id` (`message_id`),
  KEY `ssid` (`ssid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`comment_id`, `message_id`, `ssid`, `comment_content`, `comment_date`) VALUES
(1, 'msg101', '201912106', 'demo', '2020-11-23 21:57:44'),
(2, 'msg101', '201912106', 'test comment ', '2020-11-23 21:57:57'),
(3, 'msg101', '201912106', 'my comment', '2020-11-23 22:15:17'),
(4, 'msg1606138383335', '201912106', 'yes', '2020-11-23 22:15:25'),
(5, 'msg101', '201912106', 'comment', '2020-11-23 22:16:32'),
(6, 'msg1606149208688', '201912106', 'post 11 comment 1', '2020-11-23 22:21:12'),
(7, 'msg101', '201912106', '5th comment', '2020-11-24 12:19:55'),
(8, 'msg101', '201912106', 'comment 6', '2020-11-25 11:26:47'),
(9, 'msg1606138383335', '201912106', 'ok', '2020-11-28 10:18:59'),
(10, 'msg1606138535662', '201912106', 'good', '2020-11-29 19:52:50');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

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
('msg101', '201912106', 'hey this is test message.', '2020-11-23 11:52:38', 0, 0, 0, '201912', 'Test Message!!!!', 2),
('msg1606138383335', '201912106', 'This is inserted', '2020-11-23 00:00:00', 0, 0, 1, '201912', 'TM 2', 1),
('msg1606138535662', '201912106', 'This is inserted 3', '2020-11-23 00:00:00', 0, 1, 1, '201912', 'TM3', 1),
('msg1606141255399', '201912106', 'this is m4', '2020-11-23 00:00:00', 0, 1, 1, '201912', 'TM4', 1),
('msg1606147412241', '201912106', 'demo from @', '2020-11-23 00:00:00', 0, 1, 1, '201912', 'new message', 1),
('msg1606148975198', '201912106', 'new thread', '2020-11-23 00:00:00', 0, 1, 1, '201912', 'new message', 1),
('msg1606149208688', '201912106', 'post msg 11', '2020-11-23 00:00:00', 0, 1, 1, '201912', 'post 11', 1),
('msg1606210213525', '201912106', '', '2020-11-24 00:00:00', 0, 1, 1, '201912', '', 1),
('msg1606289780284', '201912106', 'msg with documents', '2020-11-25 00:00:00', 0, 1, 1, '201912', 'dummy msg ', 1),
('msg1606308883636', '201912106', 'demo with docs 12', '2020-11-25 00:00:00', 0, 1, 1, '201912', 'title 12', 1),
('msg1606309153718', '201912106', 'comment ', '2020-11-25 00:00:00', 0, 1, 1, '201912', 'just text', 1),
('msg1606309237061', '201912106', 'cmd', '2020-11-25 00:00:00', 0, 1, 1, '201912', 'msg 12', 1),
('msg1606309406603', '201912106', 'cot', '2020-11-25 00:00:00', 0, 1, 1, '201912', 'msg 13', 1),
('msg1606309552184', '201912106', 'cmmc', '2020-11-25 00:00:00', 0, 1, 1, '201912', 'msg 15', 1),
('msg1606309623592', '201912106', 'this message thread contains document', '2020-11-25 00:00:00', 0, 1, 1, '201912', 'tilte last', 1),
('msg1606312279242', '201912106', 'images', '2020-11-25 00:00:00', 0, 1, 1, '201912', 'my message', 1),
('msg1606480543491', '201912106', 'msg with doc', '2020-11-27 00:00:00', 0, 1, 1, '201912', 'latest msg 1', 1),
('msg1606538502683', '201912106', 'msg with new document morning', '2020-11-28 00:00:00', 0, 0, 1, '201912', 'lastest msg 2', 1),
('msg1606539069471', '201912106', 'kjhkjh', '2020-11-28 00:00:00', 0, 1, 1, '201912', 'msg 10', 1),
('msg1606539498295', '201912106', 'with image', '2020-11-28 00:00:00', 0, 1, 1, '201912', 'new msg posted w', 1),
('msg1606539643731', '201912106', 'text and image', '2020-11-28 00:00:00', 0, 1, 1, '201912', 'title', 1),
('msg1606658851969', '201912106', 'cr msg', '2020-11-29 00:00:00', 0, 1, 1, '201912', 'msg as cr', 1),
('msg1606658917056', '201912106', 'I am cr', '2020-11-29 00:00:00', 0, 0, 1, '201912', 'msg as CR', 1),
('msg1606658982529', '201912106', 'CR on the go', '2020-11-29 00:00:00', 0, 1, 1, '201912', 'hello cr', 2),
('msg1607144977626', '201912106', 'hurry', '2020-12-05 00:00:00', 0, 1, 1, '201912', 'my msg', 2),
('msg1607152477042', '201912106', 'change', '2020-12-05 00:00:00', 0, 1, 1, '201912', 'after change', 2);

-- --------------------------------------------------------

--
-- Table structure for table `message_document`
--

CREATE TABLE IF NOT EXISTS `message_document` (
  `document_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` varchar(100) NOT NULL,
  `document_url` varchar(100) NOT NULL,
  PRIMARY KEY (`document_id`),
  KEY `message_id` (`message_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `message_document`
--

INSERT INTO `message_document` (`document_id`, `message_id`, `document_url`) VALUES
(4, 'msg1606309623592', '1606309623590_pom.xml'),
(5, 'msg1606309623592', '1606309623591_.classpath'),
(6, 'msg1606312279242', '1606312279235_19993880.jpg'),
(7, 'msg1606312279242', '1606312279239_Capture2.PNG'),
(8, 'msg1606480543491', '1606480543216_Capture.PNG'),
(9, 'msg1606538502683', '1606538502679_pexels-photo.jpg'),
(10, 'msg1606539069471', '1606539069469_Capture3.PNG'),
(11, 'msg1606539498295', '1606539498293_Screenshot (5).png'),
(12, 'msg1606539643731', '1606539643688_fall-autumn-red-season.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `poll`
--

CREATE TABLE IF NOT EXISTS `poll` (
  `poll_id` int(11) NOT NULL AUTO_INCREMENT,
  `poll_title` varchar(100) NOT NULL,
  `poll_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0-not active\r\n1- active',
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `ssid` varchar(10) NOT NULL,
  `batch_id` varchar(10) NOT NULL,
  PRIMARY KEY (`poll_id`),
  KEY `ssid` (`ssid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `poll`
--

INSERT INTO `poll` (`poll_id`, `poll_title`, `poll_date`, `status`, `start_date`, `end_date`, `ssid`, `batch_id`) VALUES
(1, 'my first poll', '2020-12-05 05:31:16', 1, '2020-12-05 11:01:00', '2020-12-06 11:01:00', '201912106', '201912'),
(2, 'my second', '2020-12-05 06:13:48', 1, '2020-12-05 11:43:00', '2020-12-19 11:43:00', '201912106', '201912'),
(3, 'my 3rd poll', '2020-12-05 06:20:18', 1, '2020-12-05 11:50:00', '2020-12-08 11:50:00', '201912106', '201912'),
(4, 'after chnage', '2020-12-05 07:15:16', 1, '2020-12-04 12:45:00', '2020-12-06 12:45:00', '201912106', '201912');

-- --------------------------------------------------------

--
-- Table structure for table `poll_answer`
--

CREATE TABLE IF NOT EXISTS `poll_answer` (
  `poll_id` int(11) NOT NULL,
  `poll_option_id` int(11) NOT NULL,
  `ssid` varchar(10) NOT NULL,
  KEY `poll_id` (`poll_id`),
  KEY `poll_option_id` (`poll_option_id`),
  KEY `ssid` (`ssid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `poll_answer`
--

INSERT INTO `poll_answer` (`poll_id`, `poll_option_id`, `ssid`) VALUES
(1, 1, '201912106'),
(2, 4, '201912106');

-- --------------------------------------------------------

--
-- Table structure for table `poll_option`
--

CREATE TABLE IF NOT EXISTS `poll_option` (
  `poll_option_id` int(11) NOT NULL AUTO_INCREMENT,
  `poll_id` int(11) NOT NULL,
  `poll_option_data` varchar(100) NOT NULL,
  PRIMARY KEY (`poll_option_id`),
  KEY `poll_id` (`poll_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `poll_option`
--

INSERT INTO `poll_option` (`poll_option_id`, `poll_id`, `poll_option_data`) VALUES
(1, 1, 'op1'),
(2, 1, 'op2'),
(3, 2, 'op1'),
(4, 2, 'op2'),
(5, 2, 'op3'),
(6, 3, 'codechef'),
(7, 3, 'codeforces'),
(8, 3, 'leetcode'),
(9, 4, 'a1'),
(10, 4, 'a2');

-- --------------------------------------------------------

--
-- Table structure for table `program`
--

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
('201912106', 'Ashish', '201912106@daiict.ac.in', 2, '123456', 0, '2020-11-22 21:14:10', '12');

-- --------------------------------------------------------

--
-- Table structure for table `student_pin`
--

CREATE TABLE IF NOT EXISTS `student_pin` (
  `ssid` varchar(10) NOT NULL,
  `message_id` varchar(100) NOT NULL,
  KEY `ssid` (`ssid`),
  KEY `message_id` (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_pin`
--

INSERT INTO `student_pin` (`ssid`, `message_id`) VALUES
('201912106', 'msg101'),
('201912106', 'msg1606539643731'),
('201912106', 'msg1606141255399');

-- --------------------------------------------------------

--
-- Table structure for table `student_type`
--

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
