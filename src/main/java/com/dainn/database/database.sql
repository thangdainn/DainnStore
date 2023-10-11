-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 11, 2023 lúc 06:13 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

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
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1,
  `role_id` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`id`, `username`, `password`, `fullname`, `phone`, `address`, `status`, `role_id`) VALUES
(1, 'admin', 'admin', 'Administrator', '123123123', 'Buôn Ma Thuột', 1, 'ADMIN'),
(2, 'ducthang', '123', 'dao duc thang', '123123123', 'thu duc', 1, 'STAFF'),
(3, 'hongson', '111', 'Hồng Sơn', '0123456789', 'Vũng Tàu', 1, 'STAFF');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `rom_id` int(11) NOT NULL DEFAULT 0,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name`, `description`, `status`) VALUES
(1, 'iPhone', 'iPhone', 1),
(2, 'iPad', 'iPad', 1),
(3, 'Mac', 'Mac', 1),
(4, 'Watch', 'Watch', 1),
(5, 'AirPods', 'AirPods', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `points` int(11) NOT NULL DEFAULT 0,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `fullname`, `address`, `phone`, `points`, `status`) VALUES
(1, 'dao duc thang', 'thu duc', '0123123111', 2, 1),
(2, 'hong son', 'vung tau', '0123123112', 0, 1),
(3, 'luong chi  tai', 'binh tan', '0123123113', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `createddate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `totalprice` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL
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
(15, '2023-10-11 16:05:43', 12450000, 2, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderdetail`
--

CREATE TABLE `orderdetail` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `rom_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL
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
(15, 3, 1, 1, 12450000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `image` varchar(255) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `category_id`, `name`, `price`, `quantity`, `image`, `status`) VALUES
(1, 1, 'iPhone 11', 11000000, 80, '/iphones/iPhone11.png', 1),
(2, 1, 'iPhone 11 Pro Max', 13000000, 67, '/iphones/iPhone11_ProMax.png', 1),
(3, 1, 'iPhone 12', 12450000, 65, '/iphones/iPhone12.png', 1),
(4, 1, 'iPhone 12 Pro Max', 17490000, 74, '/iphones/iPhone12_ProMax.png', 1),
(5, 1, 'iPhone 13 Pro', 18500000, 57, '/iphones/iPhone13_Pro.png', 1),
(6, 1, 'iPhone 13 Pro Max', 23000000, 79, '/iphones/iPhone13_ProMax.png', 1),
(7, 1, 'iPhone 14 Plus', 21290000, 58, '/iphones/iPhone14_Plus.png', 1),
(8, 1, 'iPhone 14 Pro Max', 26290000, 50, '/iphones/iPhone14_ProMax.png', 1),
(9, 1, 'iPhone 15 Plus', 24490000, 19, '/iphones/iPhone15_Plus.png', 1),
(10, 1, 'iPhone 15 Pro Max', 34000000, 38, '/iphones/iPhone15_ProMax.png', 1),
(11, 2, 'iPad Pro M2', 23990000, 47, '/ipads/iPad_ProM2.png', 1),
(12, 2, 'iPad 10', 14290000, 37, '/ipads/iPad_10.png', 1),
(13, 2, 'iPad mini 6', 15790000, 29, '/ipads/iPad_Mini6.png', 1),
(14, 2, 'iPad Air 5', 17790000, 45, '/ipads/iPad_Air5.png', 1),
(15, 2, 'iPad Pro M1', 44900000, 77, '/ipads/iPad_ProM1.png', 1),
(16, 3, 'MacBook Air 15 inch M2', 36490000, 32, '/macbooks/Macbook_Air15M2.png', 1),
(17, 3, 'MacBook Pro 16 inch M2 Pro', 54990000, 0, '/macbooks/Macbook_ProM2.png', 1),
(18, 3, 'MacBook Air 13 inch M2', 26790000, 39, '/macbooks/Macbook_AirM2.png', 1),
(19, 3, 'MacBook Air 13 inch M1', 19490000, 30, '/macbooks/Macbook_AirM1.png', 1),
(20, 4, 'Apple Watch SE GPS 44mm Sport Loop', 7190000, 12, '/applewatchs/Watch_SEGPS.png', 1),
(21, 4, 'Apple Watch SE Cellular 44mm Sport Loop', 8490000, 1, '/applewatchs/Watch_SECellular.png', 1),
(22, 4, 'Apple Watch Ultra 2 LTE 49mm Titanium', 21990000, 16, '/applewatchs/Watch_Ultra2.png', 1),
(23, 4, 'Apple Watch S9 GPS', 10490000, 11, '/applewatchs/Watch_S9.png', 1),
(24, 5, 'AirPods Pro (2nd Gen) USB-C', 6200000, 0, '/airpods/AirPods_ProUSBC.png', 1),
(25, 5, 'AirPods 3', 4290000, 19, '/airpods/AirPods_3.png', 1),
(26, 5, 'AirPods 2', 2600000, 15, '/airpods/AirPods_2.png', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_rom`
--

CREATE TABLE `product_rom` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `rom_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product_rom`
--

INSERT INTO `product_rom` (`id`, `product_id`, `rom_id`, `quantity`) VALUES
(1, 1, 1, 25),
(2, 1, 2, 31),
(3, 1, 3, 24),
(4, 2, 1, 18),
(5, 2, 2, 22),
(6, 2, 3, 27),
(7, 3, 1, 23),
(8, 3, 2, 19),
(9, 3, 3, 23),
(10, 4, 1, 20),
(11, 4, 2, 43),
(12, 4, 3, 11),
(13, 5, 1, 22),
(14, 5, 2, 20),
(15, 5, 3, 15),
(16, 6, 1, 20),
(17, 6, 2, 30),
(18, 6, 3, 29),
(19, 7, 2, 12),
(20, 7, 3, 24),
(21, 7, 4, 22),
(22, 8, 3, 20),
(23, 8, 4, 14),
(24, 8, 5, 16),
(25, 9, 3, 19),
(26, 9, 4, 0),
(27, 9, 5, 0),
(28, 10, 3, 0),
(29, 10, 4, 0),
(30, 10, 5, 0),
(31, 11, 2, 0),
(32, 11, 3, 0),
(33, 11, 4, 0),
(34, 11, 5, 0),
(35, 12, 1, 0),
(36, 12, 2, 0),
(37, 12, 3, 0),
(38, 13, 2, 0),
(39, 13, 3, 0),
(40, 13, 4, 0),
(41, 14, 2, 0),
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
(56, 20, 6, 12),
(57, 21, 6, 1),
(58, 22, 6, 16),
(59, 23, 6, 11),
(60, 24, 6, 0),
(61, 25, 6, 19),
(62, 26, 6, 15),
(63, 10, 3, 17),
(64, 10, 4, 10),
(65, 10, 5, 11),
(66, 11, 3, 13),
(67, 11, 4, 16),
(68, 11, 5, 18),
(69, 12, 1, 18),
(70, 12, 2, 12),
(71, 12, 3, 7),
(72, 13, 1, 10),
(73, 13, 2, 11),
(74, 13, 3, 8),
(75, 14, 2, 20),
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
(89, 19, 2, 18),
(90, 19, 3, 12);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `receipt`
--

CREATE TABLE `receipt` (
  `id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `createddate` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `totalprice` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `receipt`
--

INSERT INTO `receipt` (`id`, `supplier_id`, `account_id`, `createddate`, `totalprice`, `status`) VALUES
(2, 1, 2, '2023-10-09 15:01:53', 24000000, 1),
(3, 1, 2, '2023-10-09 15:05:53', 24000000, 1),
(4, 2, 2, '2023-10-10 07:58:55', 66000000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `receiptdetail`
--

CREATE TABLE `receiptdetail` (
  `receipt_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `rom_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `importprice` int(11) NOT NULL,
  `amount` int(11) NOT NULL
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
  `id` varchar(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL
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
  `id` int(11) NOT NULL,
  `capacity` varchar(255) NOT NULL,
  `percent` int(11) NOT NULL
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
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `order`
--
ALTER TABLE `order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT cho bảng `product_rom`
--
ALTER TABLE `product_rom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT cho bảng `receipt`
--
ALTER TABLE `receipt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `rom`
--
ALTER TABLE `rom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
