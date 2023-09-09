INSERT INTO `role`(`id`, `name`, `description`) VALUES
    ('ADMIN','Administrator','Quyền quản lý mọi dữ liệu'),
    ('USER','User','Thực hiện bán hàng và nhập hàng');

INSERT INTO `account` (`id`, `username`, `password`, `fullname`, `phone`, `address`, `status`, `role_id`) VALUES
    (1, 'admin', 'admin', 'Administrator', '123123123', 'Buon Ma Thuot', 1, 'ADMIN'),
    (2, 'ducthang', '123', 'dao duc thang', '123123123', 'thu duc', 1, 'USER');
