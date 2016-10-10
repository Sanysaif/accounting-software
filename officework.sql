-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2015 at 07:49 PM
-- Server version: 5.6.11
-- PHP Version: 5.5.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `officework`
--
CREATE DATABASE IF NOT EXISTS `officework` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `officework`;

-- --------------------------------------------------------

--
-- Table structure for table `accdb`
--

CREATE TABLE IF NOT EXISTS `accdb` (
  `acc_id` int(11) NOT NULL AUTO_INCREMENT,
  `acc_hd` varchar(50) DEFAULT NULL,
  `rept_hd` varchar(30) DEFAULT NULL,
  `vhcr_hd` varchar(20) DEFAULT NULL,
  `bill_amnt` double NOT NULL,
  PRIMARY KEY (`acc_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `accdb`
--

INSERT INTO `accdb` (`acc_id`, `acc_hd`, `rept_hd`, `vhcr_hd`, `bill_amnt`) VALUES
(1, 'Bill from Client', 'Bill from', NULL, 5000),
(3, 'Earnest Deposit to Projece', 'Earnest', NULL, 48025.25),
(4, 'Advance of office staff', 'Advance', NULL, 100500);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) DEFAULT NULL,
  `design` varchar(30) DEFAULT NULL,
  `joindate` date NOT NULL,
  `basic` double NOT NULL DEFAULT '0',
  `day_rate` double DEFAULT '0',
  `rcv` double NOT NULL DEFAULT '0',
  `bill` double NOT NULL DEFAULT '0',
  `blnc` double NOT NULL DEFAULT '0',
  `vat` double NOT NULL DEFAULT '0',
  `jobsts` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `emp_name`, `design`, `joindate`, `basic`, `day_rate`, `rcv`, `bill`, `blnc`, `vat`, `jobsts`) VALUES
(1, 'Md. Ebrahim Hossain', 'Asstt. Surveyor', '2015-03-04', 25000, 0, 0, 0, 0, 0, 0),
(2, 'Mosharof Ahmed', 'Accountant', '2013-11-03', 18000, 0, 0, 0, 0, 0, 0),
(5, 'Taimul Rahman', 'Developer', '2010-03-05', 45000, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE IF NOT EXISTS `project` (
  `prjct_id` int(11) NOT NULL AUTO_INCREMENT,
  `prjct_name` varchar(40) DEFAULT NULL,
  `prjct_completation` varchar(8) DEFAULT NULL,
  `cntr_amnt` double NOT NULL,
  `prjct_exp` double NOT NULL,
  `rcvbl` double NOT NULL,
  `client` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`prjct_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`prjct_id`, `prjct_name`, `prjct_completation`, `cntr_amnt`, `prjct_exp`, `rcvbl`, `client`) VALUES
(1, 'Maea River Bank Protection', 'going on', 12507525.54, 0, 507500, 'Government'),
(2, 'Purbachal New Town', 'yes', 180654845, 210021544, 2012540, 'KDB Co. Ltd');

-- --------------------------------------------------------

--
-- Table structure for table `trans`
--

CREATE TABLE IF NOT EXISTS `trans` (
  `trans_id` int(11) NOT NULL AUTO_INCREMENT,
  `tdate` date NOT NULL,
  `acc_id` int(11) NOT NULL,
  `acc_hd` varchar(50) DEFAULT NULL,
  `donor_id` int(11) NOT NULL,
  `rcvr_id` int(11) NOT NULL,
  `vchr_no` int(11) NOT NULL,
  `amount` double NOT NULL,
  `donor_bal` double NOT NULL,
  `revr_bal` double NOT NULL,
  `rmrk` varchar(50) DEFAULT NULL,
  `rmrk2` varchar(30) DEFAULT NULL,
  `prjct_id` int(11) NOT NULL,
  PRIMARY KEY (`trans_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `trans`
--

INSERT INTO `trans` (`trans_id`, `tdate`, `acc_id`, `acc_hd`, `donor_id`, `rcvr_id`, `vchr_no`, `amount`, `donor_bal`, `revr_bal`, `rmrk`, `rmrk2`, `prjct_id`) VALUES
(1, '2015-04-02', 1, 'Bill from', 0, 0, 10, 5000, 0, 0, NULL, NULL, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
