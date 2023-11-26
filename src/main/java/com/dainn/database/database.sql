-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th10 26, 2023 lúc 12:19 PM
-- Phiên bản máy phục vụ: 8.0.30
-- Phiên bản PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dainnstore`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id` int NOT NULL,
  `username` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `fullname` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` int NOT NULL DEFAULT '1',
  `role_id` varchar(11) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id`, `username`, `password`, `fullname`, `phone`, `address`, `status`, `role_id`) VALUES
(1, 'admin', 'admin', 'Administrator', '0123123123', NULL, 1, 'ADMIN'),
(2, 'ducthang', '123', 'dao duc thang', '0123123123', NULL, 1, 'STAFF'),
(3, 'hongson', '111', 'Hồng Sơn', '0123456789', NULL, 1, 'STAFF'),
(5, 'zzzz', 'zzzz', 'zzzz', '0123123123', NULL, 0, 'STAFF');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `id` int NOT NULL,
  `account_id` int NOT NULL,
  `product_id` int NOT NULL,
  `rom_id` int NOT NULL DEFAULT '0',
  `price` int NOT NULL,
  `quantity` int NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `status` int NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name`, `description`, `status`) VALUES
(1, 'iPhone', 'Cac sp iPhone', 1),
(2, 'iPad', 'iPad', 1),
(3, 'Mac', 'Mac', 1),
(4, 'Watch', 'Watch', 1),
(5, 'AirPods', 'AirPods', 1),
(6, 'adad', 'adad', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` int NOT NULL,
  `fullname` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `points` int NOT NULL DEFAULT '0',
  `status` int NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `fullname`, `address`, `phone`, `points`, `status`) VALUES
(1, 'dao duc thangg', 'thu duc', '0123123111', 12, 1),
(2, 'hong son', 'vung tau', '0123123112', 4, 1),
(3, 'luong chi  tai', 'binh tan', '0123123113', 3, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order`
--

CREATE TABLE `order` (
  `id` int NOT NULL,
  `createddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `totalprice` int NOT NULL,
  `account_id` int NOT NULL,
  `customer_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order`
--

INSERT INTO `order` (`id`, `createddate`, `totalprice`, `account_id`, `customer_id`) VALUES
(6, '2023-10-08 11:46:46', 22926600, 2, 1),
(7, '2023-10-08 11:49:41', 48284670, 2, 1),
(8, '2023-10-08 11:56:22', 16090800, 2, 1),
(9, '2023-10-08 12:04:09', 5642000, 2, 1),
(10, '2023-10-08 12:04:37', 32957550, 2, 1),
(11, '2023-10-09 15:06:43', 21360000, 2, 1),
(12, '2023-10-10 08:00:42', 62998320, 2, 1),
(13, '2023-10-10 08:08:35', 1047401979, 2, 1),
(14, '2023-10-10 08:09:42', 1150730671, 2, 1),
(15, '2023-10-11 16:05:43', 12450000, 2, 3),
(16, '2023-10-14 06:19:34', 344985480, 2, 1),
(17, '2023-10-14 08:10:13', 43211560, 2, 1),
(18, '2023-10-14 08:13:00', 78872640, 2, 1),
(19, '2023-10-14 08:14:13', 53069000, 3, 2),
(20, '2023-10-14 08:27:48', 9692100, 2, 3),
(21, '2023-10-14 08:41:14', 17140200, 2, 3),
(22, '2023-10-14 09:10:46', 12418875, 2, 1),
(23, '2023-10-14 09:12:47', 16440600, 2, 1),
(24, '2023-10-14 09:44:05', 11578500, 2, 1),
(25, '2023-10-14 09:45:23', 16090800, 2, 1),
(26, '2023-10-14 09:48:07', 12870000, 2, 2),
(27, '2023-10-14 09:49:30', 12740000, 2, 2),
(28, '2023-10-17 08:44:48', 20342595, 2, 1),
(29, '2023-10-26 07:21:34', 20119050, 2, 1),
(30, '2023-11-13 07:06:18', 33753250, 2, 1),
(31, '2023-11-17 06:35:54', 49735295, 2, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderdetail`
--

CREATE TABLE `orderdetail` (
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `rom_id` int NOT NULL,
  `quantity` int NOT NULL,
  `price` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orderdetail`
--

INSERT INTO `orderdetail` (`order_id`, `product_id`, `rom_id`, `quantity`, `price`) VALUES
(6, 1, 1, 1, 11390000),
(6, 2, 1, 1, 13000000),
(7, 6, 1, 1, 23000000),
(7, 8, 3, 1, 28919000),
(8, 4, 1, 1, 17490000),
(9, 24, 6, 1, 6200000),
(10, 18, 2, 1, 28129500),
(10, 21, 6, 1, 8490000),
(11, 1, 1, 2, 12000000),
(12, 2, 1, 2, 13000000),
(12, 3, 1, 1, 12450000),
(12, 9, 3, 1, 26939000),
(12, 24, 6, 1, 6200000),
(13, 17, 5, 16, 65988000),
(14, 17, 4, 18, 63238500),
(15, 3, 1, 1, 12450000),
(16, 1, 1, 1, 11000000),
(16, 2, 1, 1, 13000000),
(16, 3, 1, 1, 12450000),
(16, 4, 1, 1, 17490000),
(16, 5, 1, 1, 18500000),
(16, 6, 1, 1, 23000000),
(16, 7, 2, 1, 22354500),
(16, 8, 3, 1, 28919000),
(16, 9, 3, 1, 26939000),
(16, 10, 3, 1, 37400000),
(16, 11, 3, 1, 25189500),
(16, 12, 1, 1, 14290000),
(16, 13, 1, 1, 15790000),
(16, 14, 2, 1, 18679500),
(16, 19, 2, 1, 20464500),
(16, 20, 6, 1, 7190000),
(16, 22, 6, 1, 21990000),
(16, 23, 6, 1, 10490000),
(16, 25, 6, 1, 4290000),
(16, 26, 6, 1, 2600000),
(17, 2, 1, 1, 13000000),
(17, 8, 5, 1, 31548000),
(18, 3, 3, 2, 13695000),
(18, 10, 3, 1, 37400000),
(18, 13, 3, 1, 17369000),
(19, 6, 2, 1, 24150000),
(19, 8, 3, 1, 28919000),
(20, 20, 6, 1, 7190000),
(20, 26, 6, 1, 2600000),
(21, 4, 1, 1, 17490000),
(22, 3, 2, 1, 13072500),
(23, 4, 1, 1, 17490000),
(24, 3, 1, 1, 12450000),
(25, 4, 1, 1, 17490000),
(26, 2, 1, 1, 13000000),
(27, 2, 1, 1, 13000000),
(28, 7, 2, 1, 22354500),
(29, 7, 2, 1, 22354500),
(30, 5, 1, 1, 18500000),
(30, 5, 2, 1, 19425000),
(31, 7, 2, 1, 22354500),
(31, 8, 3, 1, 28919000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int NOT NULL,
  `category_id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `status` int NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `category_id`, `name`, `price`, `quantity`, `image`, `status`) VALUES
(1, 1, 'iPhone 11', 11000000, 79, '/iphones/iPhone11.png', 1),
(2, 1, 'iPhone 11 Pro Max', 13000000, 63, '/iphones/iPhone11_ProMax.png', 1),
(3, 1, 'iPhone 12', 12450000, 60, '/iphones/iPhone12.png', 1),
(4, 1, 'iPhone 12 Pro Max', 17490000, 70, '/iphones/iPhone12_ProMax.png', 1),
(5, 1, 'iPhone 13 Pro', 18500000, 54, '/iphones/iPhone13_Pro.png', 1),
(6, 1, 'iPhone 13 Pro Max', 23000000, 77, '/iphones/iPhone13_ProMax.png', 1),
(7, 1, 'iPhone 14 Plus', 21290000, 54, '/iphones/iPhone14_Plus.png', 1),
(8, 1, 'iPhone 14 Pro Max', 26290000, 46, '/iphones/iPhone14_ProMax.png', 1),
(9, 1, 'iPhone 15 Plus', 24490000, 18, '/iphones/iPhone15_Plus.png', 1),
(10, 1, 'iPhone 15 Pro Max', 34000000, 36, '/iphones/iPhone15_ProMax.png', 1),
(11, 2, 'iPad Pro M2', 23990000, 46, '/ipads/iPad_ProM2.png', 1),
(12, 2, 'iPad 10', 14290000, 36, '/ipads/iPad_10.png', 1),
(13, 2, 'iPad mini 6', 15790000, 27, '/ipads/iPad_Mini6.png', 1),
(14, 2, 'iPad Air 5', 17790000, 44, '/ipads/iPad_Air5.png', 1),
(15, 2, 'iPad Pro M1', 44900000, 77, '/ipads/iPad_ProM1.png', 1),
(16, 3, 'MacBook Air 15 inch M2', 36490000, 32, '/macbooks/Macbook_Air15M2.png', 1),
(17, 3, 'MacBook Pro 16 inch M2 Pro', 54990000, 0, '/macbooks/Macbook_ProM2.png', 1),
(18, 3, 'MacBook Air 13 inch M2', 26790000, 39, '/macbooks/Macbook_AirM2.png', 1),
(19, 3, 'MacBook Air 13 inch M1', 19490000, 29, '/macbooks/Macbook_AirM1.png', 1),
(20, 4, 'Apple Watch SE GPS 44mm Sport Loop', 7190000, 10, '/applewatchs/Watch_SEGPS.png', 1),
(21, 4, 'Apple Watch SE Cellular 44mm Sport Loop', 8490000, 1, '/applewatchs/Watch_SECellular.png', 1),
(22, 4, 'Apple Watch Ultra 2 LTE 49mm Titanium', 21990000, 15, '/applewatchs/Watch_Ultra2.png', 1),
(23, 4, 'Apple Watch S9 GPS', 10490000, 10, '/applewatchs/Watch_S9.png', 1),
(24, 5, 'AirPods Pro (2nd Gen) USB-C', 6200000, 10, '/iphones/iPhone11.png', 1),
(25, 5, 'AirPods 3', 4290000, 18, '/airpods/AirPods_3.png', 1),
(26, 5, 'AirPods 2', 2600000, 13, '/airpods/AirPods_2.png', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_rom`
--

CREATE TABLE `product_rom` (
  `id` int NOT NULL,
  `product_id` int NOT NULL,
  `rom_id` int NOT NULL,
  `quantity` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_rom`
--

INSERT INTO `product_rom` (`id`, `product_id`, `rom_id`, `quantity`) VALUES
(1, 1, 1, 24),
(2, 1, 2, 31),
(3, 1, 3, 24),
(4, 2, 1, 14),
(5, 2, 2, 22),
(6, 2, 3, 27),
(7, 3, 1, 21),
(8, 3, 2, 18),
(9, 3, 3, 21),
(10, 4, 1, 16),
(11, 4, 2, 43),
(12, 4, 3, 11),
(13, 5, 1, 20),
(14, 5, 2, 19),
(15, 5, 3, 15),
(16, 6, 1, 19),
(17, 6, 2, 29),
(18, 6, 3, 29),
(19, 7, 2, 8),
(20, 7, 3, 24),
(21, 7, 4, 22),
(22, 8, 3, 17),
(23, 8, 4, 14),
(24, 8, 5, 15),
(25, 9, 3, 18),
(26, 9, 4, 0),
(27, 9, 5, 0),
(28, 10, 3, 31),
(29, 10, 4, 0),
(30, 10, 5, 0),
(31, 11, 2, 0),
(32, 11, 3, 12),
(33, 11, 4, 0),
(34, 11, 5, 0),
(35, 12, 1, 17),
(36, 12, 2, 0),
(37, 12, 3, 0),
(38, 13, 2, 0),
(39, 13, 3, 7),
(40, 13, 4, 0),
(41, 14, 2, 19),
(42, 14, 3, 0),
(43, 14, 4, 0),
(44, 15, 2, 0),
(45, 15, 3, 0),
(46, 15, 4, 0),
(47, 16, 3, 0),
(48, 16, 4, 0),
(49, 16, 5, 0),
(50, 17, 4, 0),
(51, 17, 5, 0),
(52, 18, 3, 0),
(53, 18, 4, 0),
(54, 19, 3, 0),
(55, 19, 4, 0),
(56, 20, 6, 10),
(57, 21, 6, 1),
(58, 22, 6, 15),
(59, 23, 6, 10),
(60, 24, 6, 0),
(61, 25, 6, 18),
(62, 26, 6, 13),
(63, 10, 3, 31),
(64, 10, 4, 10),
(65, 10, 5, 11),
(66, 11, 3, 12),
(67, 11, 4, 16),
(68, 11, 5, 18),
(69, 12, 1, 17),
(70, 12, 2, 12),
(71, 12, 3, 7),
(72, 13, 1, 9),
(73, 13, 2, 11),
(74, 13, 3, 7),
(75, 14, 2, 19),
(76, 14, 3, 15),
(77, 14, 4, 10),
(78, 15, 2, 28),
(79, 15, 3, 18),
(80, 15, 4, 18),
(81, 15, 5, 13),
(82, 16, 4, 18),
(83, 16, 5, 14),
(84, 17, 4, 0),
(85, 17, 5, 0),
(86, 18, 2, 1),
(87, 18, 3, 20),
(88, 18, 4, 18),
(89, 19, 2, 17),
(90, 19, 3, 12);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `receipt`
--

CREATE TABLE `receipt` (
  `id` int NOT NULL,
  `supplier_id` int NOT NULL,
  `account_id` int NOT NULL,
  `createddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `totalprice` int NOT NULL,
  `status` int NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `receipt`
--

INSERT INTO `receipt` (`id`, `supplier_id`, `account_id`, `createddate`, `totalprice`, `status`) VALUES
(2, 3, 2, '2023-11-22 16:22:01', 24000000, 1),
(3, 1, 2, '2023-11-23 14:34:21', 24000000, 1),
(4, 2, 2, '2023-11-22 16:22:01', 66000000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `receiptdetail`
--

CREATE TABLE `receiptdetail` (
  `receipt_id` int NOT NULL,
  `product_id` int NOT NULL,
  `rom_id` int NOT NULL,
  `quantity` int NOT NULL,
  `importprice` int NOT NULL,
  `amount` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `receiptdetail`
--

INSERT INTO `receiptdetail` (`receipt_id`, `product_id`, `rom_id`, `quantity`, `importprice`, `amount`) VALUES
(2, 1, 1, 2, 12000000, 24000000),
(3, 1, 1, 2, 12000000, 24000000),
(4, 1, 1, 5, 11000000, 55000000),
(4, 1, 2, 1, 11000000, 11000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `id` varchar(11) COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`id`, `name`, `description`) VALUES
('ADMIN', 'Administrator', 'Quyền quản lý mọi dữ liệu'),
('STAFF', 'Staff', 'Thực hiện bán hàng và nhập hàng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `rom`
--

CREATE TABLE `rom` (
  `id` int NOT NULL,
  `capacity` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `percent` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `rom`
--

INSERT INTO `rom` (`id`, `capacity`, `percent`) VALUES
(1, '64GB', 0),
(2, '128GB', 5),
(3, '256GB', 10),
(4, '512GB', 15),
(5, '1TB', 20),
(6, '', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
--

CREATE TABLE `supplier` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`id`, `name`, `address`, `phone`) VALUES
(1, 'Foxconn', 'Đài Loan', '0123456789'),
(2, 'Wistron', 'Đài Loan', '0123123123'),
(3, 'Goertek', 'Trung Quốc', '0123123123');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role_id` (`role_id`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `account_id` (`account_id`),
  ADD KEY `rom_id` (`rom_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `account_id` (`account_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Chỉ mục cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`order_id`,`product_id`,`rom_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `rom_id` (`rom_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`);

--
-- Chỉ mục cho bảng `product_rom`
--
ALTER TABLE `product_rom`
  ADD PRIMARY KEY (`id`),
  ADD KEY `rom_id` (`rom_id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`id`),
  ADD KEY `account_id` (`account_id`),
  ADD KEY `supplier_id` (`supplier_id`);

--
-- Chỉ mục cho bảng `receiptdetail`
--
ALTER TABLE `receiptdetail`
  ADD PRIMARY KEY (`receipt_id`,`product_id`,`rom_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `rom_id` (`rom_id`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `rom`
--
ALTER TABLE `rom`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=141;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `order`
--
ALTER TABLE `order`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT cho bảng `product_rom`
--
ALTER TABLE `product_rom`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT cho bảng `receipt`
--
ALTER TABLE `receipt`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `rom`
--
ALTER TABLE `rom`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Các ràng buộc cho bảng `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `cart_ibfk_6` FOREIGN KEY (`rom_id`) REFERENCES `rom` (`id`);

--
-- Các ràng buộc cho bảng `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `order_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

--
-- Các ràng buộc cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  ADD CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `orderdetail_ibfk_3` FOREIGN KEY (`rom_id`) REFERENCES `rom` (`id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Các ràng buộc cho bảng `product_rom`
--
ALTER TABLE `product_rom`
  ADD CONSTRAINT `product_rom_ibfk_1` FOREIGN KEY (`rom_id`) REFERENCES `rom` (`id`),
  ADD CONSTRAINT `product_rom_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Các ràng buộc cho bảng `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `receipt_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`);

--
-- Các ràng buộc cho bảng `receiptdetail`
--
ALTER TABLE `receiptdetail`
  ADD CONSTRAINT `receiptdetail_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `receiptdetail_ibfk_2` FOREIGN KEY (`receipt_id`) REFERENCES `receipt` (`id`),
  ADD CONSTRAINT `receiptdetail_ibfk_3` FOREIGN KEY (`rom_id`) REFERENCES `rom` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
