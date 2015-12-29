-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2015 at 05:08 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `hardware`
--

-- --------------------------------------------------------

--
-- Table structure for table `credict_pay`
--

CREATE TABLE IF NOT EXISTS `credict_pay` (
  `pay_id` varchar(7) NOT NULL DEFAULT '0',
  `cheq_number` varchar(15) DEFAULT NULL,
  `pay_date` date DEFAULT NULL,
  `invoice_number` varchar(6) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `cus_id` varchar(5) DEFAULT NULL,
  `method` varchar(10) NOT NULL,
  `bank` varchar(20) NOT NULL,
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `credict_pay`
--

INSERT INTO `credict_pay` (`pay_id`, `cheq_number`, `pay_date`, `invoice_number`, `amount`, `cus_id`, `method`, `bank`) VALUES
('PI0001', '0', '2015-11-03', 'I001', 2000, 'C0006', '', ''),
('PI0002', '0', '2015-11-03', 'I001', 2000, 'C0006', '', ''),
('PI0003', '111111', NULL, '', -6, 'C0006', 'Cheq', 'Sampath Bank'),
('PI0004', '1111', '2015-11-28', '', -6, 'C0006', 'Cheq', 'Sampath Bank');

--
-- Triggers `credict_pay`
--
DROP TRIGGER IF EXISTS `tg_credict_pay_insert`;
DELIMITER //
CREATE TRIGGER `tg_credict_pay_insert` BEFORE INSERT ON `credict_pay`
 FOR EACH ROW BEGIN
  INSERT INTO credict_pay_seq VALUES (NULL);
  SET NEW.pay_id = CONCAT('PI', LPAD(LAST_INSERT_ID(), 4, '0'));
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `credict_pay_seq`
--

CREATE TABLE IF NOT EXISTS `credict_pay_seq` (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `credict_pay_seq`
--

INSERT INTO `credict_pay_seq` (`pay_id`) VALUES
(1),
(2),
(3),
(4);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `cus_id` varchar(5) NOT NULL DEFAULT '0',
  `cus_name` varchar(45) DEFAULT NULL,
  `cus_adress` varchar(100) DEFAULT NULL,
  `cus_contact_mobile` varchar(15) DEFAULT NULL,
  `cus_contact_work` varchar(15) DEFAULT NULL,
  `cus_credict_level` double DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_id`, `cus_name`, `cus_adress`, `cus_contact_mobile`, `cus_contact_work`, `cus_credict_level`) VALUES
('C0004', '', NULL, NULL, NULL, NULL),
('C0005', 'Udayanga', 'Mihinthale', '0715612313', '0375789980', 10000),
('C0006', 'a', 'adress', 'a mobile', 'a work', 2222),
('C0008', 'Asha', 'Hikkaduwa town', '01111 222', '022222 111', 3500);

--
-- Triggers `customer`
--
DROP TRIGGER IF EXISTS `tg_customer_insert`;
DELIMITER //
CREATE TRIGGER `tg_customer_insert` BEFORE INSERT ON `customer`
 FOR EACH ROW BEGIN
  INSERT INTO hardware.customer_seq VALUES (NULL);
  SET NEW.cus_id = CONCAT('C', LPAD(LAST_INSERT_ID(), 4, '0'));
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `customer_seq`
--

CREATE TABLE IF NOT EXISTS `customer_seq` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `customer_seq`
--

INSERT INTO `customer_seq` (`cus_id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8);

-- --------------------------------------------------------

--
-- Table structure for table `cus_invoice`
--

CREATE TABLE IF NOT EXISTS `cus_invoice` (
  `cus_invoice_number` varchar(6) NOT NULL DEFAULT '0',
  `name` varchar(30) DEFAULT NULL,
  `cus_id` varchar(5) DEFAULT NULL,
  `bill_date` date DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_bill_discount` double DEFAULT NULL,
  `total_discount` double DEFAULT NULL,
  `pay_amount` double NOT NULL,
  PRIMARY KEY (`cus_invoice_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cus_invoice`
--

INSERT INTO `cus_invoice` (`cus_invoice_number`, `name`, `cus_id`, `bill_date`, `state`, `total_amount`, `total_bill_discount`, `total_discount`, `pay_amount`) VALUES
('CI0001', 'dd', 'c0006', '2015-11-18', 'paid', 100, 20, 20, 80),
('CI0002', 'Book', 'C0006', '2015-11-20', 'credict', 1560, 20, 302, 1258),
('CI0003', 'Pen', 'C0006', '2015-11-20', 'Credict', 125, 20, 25, 100),
('CI0004', 'b', 'C0007', '2015-11-21', 'paid', 100, 20, 20, 80),
('CI0005', 'somthing', 'C0006', '2015-11-21', 'Credict', 870, 0, 0, 870);

--
-- Triggers `cus_invoice`
--
DROP TRIGGER IF EXISTS `tg_cus_invoice_insert`;
DELIMITER //
CREATE TRIGGER `tg_cus_invoice_insert` BEFORE INSERT ON `cus_invoice`
 FOR EACH ROW BEGIN
  INSERT INTO cus_invoice_seq VALUES (NULL);
  SET NEW.cus_invoice_number = CONCAT('CI', LPAD(LAST_INSERT_ID(), 4, '0'));
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `cus_invoice_seq`
--

CREATE TABLE IF NOT EXISTS `cus_invoice_seq` (
  `cus_invoice_number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`cus_invoice_number`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `cus_invoice_seq`
--

INSERT INTO `cus_invoice_seq` (`cus_invoice_number`) VALUES
(1),
(2),
(3),
(4),
(5);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_number` varchar(5) NOT NULL DEFAULT '0',
  `item_code` varchar(4) DEFAULT NULL,
  `qty` double DEFAULT NULL,
  `total_item` double DEFAULT NULL,
  `number_of_item` int(11) DEFAULT NULL,
  PRIMARY KEY (`invoice_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoice_number`, `item_code`, `qty`, `total_item`, `number_of_item`) VALUES
('I001', '', 5, NULL, NULL);

--
-- Triggers `invoice`
--
DROP TRIGGER IF EXISTS `invoice`;
DELIMITER //
CREATE TRIGGER `invoice` BEFORE INSERT ON `invoice`
 FOR EACH ROW BEGIN
  INSERT INTO hardware.invoice_seq VALUES (NULL);
  SET NEW.invoice_number = CONCAT('I', LPAD(LAST_INSERT_ID(), 3, '0'));
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `invoice_seq`
--

CREATE TABLE IF NOT EXISTS `invoice_seq` (
  `invoice_number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`invoice_number`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `invoice_seq`
--

INSERT INTO `invoice_seq` (`invoice_number`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `item_code` varchar(5) NOT NULL DEFAULT '0',
  `sup_id` varchar(5) DEFAULT NULL,
  `dicription` varchar(20) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `sell_price` double DEFAULT NULL,
  `max_discount` double DEFAULT NULL,
  PRIMARY KEY (`item_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_code`, `sup_id`, `dicription`, `cost`, `sell_price`, `max_discount`) VALUES
('A001', NULL, 'Mango', NULL, NULL, NULL);

--
-- Triggers `item`
--
DROP TRIGGER IF EXISTS `tg_item_insert`;
DELIMITER //
CREATE TRIGGER `tg_item_insert` BEFORE INSERT ON `item`
 FOR EACH ROW BEGIN
  INSERT INTO hardware.item_seq VALUES (NULL);
  SET NEW.item_code = CONCAT('A', LPAD(LAST_INSERT_ID(), 3, '0'));
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `item_seq`
--

CREATE TABLE IF NOT EXISTS `item_seq` (
  `item_code` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`item_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `item_seq`
--

INSERT INTO `item_seq` (`item_code`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `supply`
--

CREATE TABLE IF NOT EXISTS `supply` (
  `id` varchar(7) NOT NULL DEFAULT '0',
  `sup_name` varchar(45) DEFAULT NULL,
  `sup_adress` varchar(100) NOT NULL,
  `sup_contact_mobile` varchar(15) NOT NULL,
  `sup_contact_work` varchar(15) NOT NULL,
  `sup_credict_level` double DEFAULT '1000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supply`
--

INSERT INTO `supply` (`id`, `sup_name`, `sup_adress`, `sup_contact_mobile`, `sup_contact_work`, `sup_credict_level`) VALUES
('S0002', 'Udayanga', 'Anuradhapura', '0715612313', '0375789980', 5000),
('S0003', 'Senanayake', 'Colombo', '0774903212', '0115521453', 10000),
('S0004', 'yyy', 'yrr', 'yryryrt', 'rtytrty', NULL),
('S0005', 'ddd', 'sss', '4435543', '787', 1000),
('S0006', 'gvdfg', 'vsd', 'dfsg', 'dgsgs', 1000),
('S0007', 'name', 'adress', 'mobile', 'work', 1000),
('S0008', 'NAME2', 'ADRESS2', 'CONTACT2', 'WORK2', 125);

--
-- Triggers `supply`
--
DROP TRIGGER IF EXISTS `tg_supply_insert`;
DELIMITER //
CREATE TRIGGER `tg_supply_insert` BEFORE INSERT ON `supply`
 FOR EACH ROW BEGIN
  INSERT INTO supply_seq VALUES (NULL);
  SET NEW.id = CONCAT('S', LPAD(LAST_INSERT_ID(), 4, '0'));
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `supply_payment`
--

CREATE TABLE IF NOT EXISTS `supply_payment` (
  `pay_id` varchar(7) NOT NULL DEFAULT '0',
  `amount` double DEFAULT NULL,
  `bank` varchar(20) DEFAULT NULL,
  `CHEQ_NUMBER` varchar(15) DEFAULT NULL,
  `sup_id` varchar(6) DEFAULT NULL,
  `invoice_number` varchar(6) DEFAULT NULL,
  `method` varchar(10) DEFAULT NULL,
  `pay_date` date DEFAULT NULL,
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supply_payment`
--

INSERT INTO `supply_payment` (`pay_id`, `amount`, `bank`, `CHEQ_NUMBER`, `sup_id`, `invoice_number`, `method`, `pay_date`) VALUES
('SI0001', 200, 'Sampath bank', '012548', 's0002', '', 'cheq', '2015-11-21');

--
-- Triggers `supply_payment`
--
DROP TRIGGER IF EXISTS `tg_supply_payment_insert`;
DELIMITER //
CREATE TRIGGER `tg_supply_payment_insert` BEFORE INSERT ON `supply_payment`
 FOR EACH ROW BEGIN
  INSERT INTO supply_payment_seq VALUES (NULL);
  SET NEW.pay_id = CONCAT('SI', LPAD(LAST_INSERT_ID(), 4, '0'));
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `supply_payment_seq`
--

CREATE TABLE IF NOT EXISTS `supply_payment_seq` (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `supply_payment_seq`
--

INSERT INTO `supply_payment_seq` (`pay_id`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `supply_seq`
--

CREATE TABLE IF NOT EXISTS `supply_seq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `supply_seq`
--

INSERT INTO `supply_seq` (`id`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8);

-- --------------------------------------------------------

--
-- Table structure for table `sup_invoice`
--

CREATE TABLE IF NOT EXISTS `sup_invoice` (
  `sup_invoice_number` varchar(6) NOT NULL DEFAULT '0',
  `sup_id` varchar(5) DEFAULT NULL,
  `bill_date` date DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_bill_discount` double DEFAULT NULL,
  `total_discount` double DEFAULT NULL,
  `pay_amount` double NOT NULL,
  PRIMARY KEY (`sup_invoice_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sup_invoice`
--

INSERT INTO `sup_invoice` (`sup_invoice_number`, `sup_id`, `bill_date`, `state`, `total_amount`, `total_bill_discount`, `total_discount`, `pay_amount`) VALUES
('SI0001', 's0002', '2015-11-18', 'credict', 100, 20, 20, 80),
('SI0002', 's0002', '2015-11-21', 'credict', 200, 20, 40, 160),
('SI0003', 's0002', '2015-11-21', 'paid', 300, 20, 60, 240);

--
-- Triggers `sup_invoice`
--
DROP TRIGGER IF EXISTS `tg_sup_invoice_insert`;
DELIMITER //
CREATE TRIGGER `tg_sup_invoice_insert` BEFORE INSERT ON `sup_invoice`
 FOR EACH ROW BEGIN
  INSERT INTO hardware.sup_invoice_seq VALUES (NULL);
  SET NEW.sup_invoice_number = CONCAT('SI', LPAD(LAST_INSERT_ID(), 4, '0'));
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `sup_invoice_seq`
--

CREATE TABLE IF NOT EXISTS `sup_invoice_seq` (
  `sup_invoice_number` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`sup_invoice_number`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `sup_invoice_seq`
--

INSERT INTO `sup_invoice_seq` (`sup_invoice_number`) VALUES
(1),
(2),
(3);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
