-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 03, 2016 at 11:27 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cardsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `pass` varchar(32) NOT NULL,
  `type` varchar(10) NOT NULL,
  `name` varchar(60) NOT NULL,
  `surname` varchar(60) NOT NULL,
  `status` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `login`, `pass`, `type`, `name`, `surname`, `status`) VALUES
(1, 'admin', '202cb962ac59075b964b07152d234b70', 'ADMIN', 'admin', '', 0),
(2, 'fuad', '202cb962ac59075b964b07152d234b70', 'SELLER', '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE IF NOT EXISTS `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(12) NOT NULL,
  `card_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `card`
--

INSERT INTO `card` (`id`, `code`, `card_type_id`) VALUES
(1, '999999', 1),
(2, '888888', 2);

-- --------------------------------------------------------

--
-- Table structure for table `card_type`
--

CREATE TABLE IF NOT EXISTS `card_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `duration` int(2) NOT NULL,
  `passing_amount` double NOT NULL,
  `discount` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `card_type`
--

INSERT INTO `card_type` (`id`, `name`, `duration`, `passing_amount`, `discount`) VALUES
(1, 'Standart', 100, 600, 10),
(2, 'Silver', 3, 100, 20);

-- --------------------------------------------------------

--
-- Table structure for table `good`
--

CREATE TABLE IF NOT EXISTS `good` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `good`
--

INSERT INTO `good` (`id`, `name`, `price`) VALUES
(1, 'saat', 145);

-- --------------------------------------------------------

--
-- Table structure for table `good_order`
--

CREATE TABLE IF NOT EXISTS `good_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `otime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `odate` date NOT NULL,
  `total_amount` double NOT NULL,
  `total_discount` double NOT NULL,
  `seller_id` int(11) NOT NULL,
  `user_card_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `good_order`
--

INSERT INTO `good_order` (`id`, `otime`, `odate`, `total_amount`, `total_discount`, `seller_id`, `user_card_id`) VALUES
(1, '2016-07-02 15:00:46', '2016-07-02', 130, 13, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `order_detail`
--

CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_order_id` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  `gcount` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `order_detail`
--

INSERT INTO `order_detail` (`id`, `good_order_id`, `good_id`, `gcount`) VALUES
(1, 1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `surname` varchar(60) NOT NULL,
  `gender` int(2) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `phonework` varchar(20) NOT NULL,
  `specialty` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `pin` varchar(7) NOT NULL,
  `email` varchar(20) NOT NULL,
  `pass` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `surname`, `gender`, `phone`, `phonework`, `specialty`, `city`, `pin`, `email`, `pass`) VALUES
(1, 'Ali', 'Aliyev', 1, '1234567', '33333', 'doctor', 'Baku', '1234567', 'fff@mail.ru', '202cb962ac59075b964b07152d234b70');

-- --------------------------------------------------------

--
-- Table structure for table `user_card`
--

CREATE TABLE IF NOT EXISTS `user_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `card_id` int(11) NOT NULL,
  `status` int(2) NOT NULL,
  `valid_from` date NOT NULL,
  `valid_to` date NOT NULL,
  `seller_id` int(11) NOT NULL,
  `balance` double NOT NULL,
  `discount` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `user_card`
--

INSERT INTO `user_card` (`id`, `user_id`, `card_id`, `status`, `valid_from`, `valid_to`, `seller_id`, `balance`, `discount`) VALUES
(1, 1, 1, 1, '2016-07-01', '2016-07-31', 1, 123, 555);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
