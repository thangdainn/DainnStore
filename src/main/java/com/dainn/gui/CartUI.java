package com.dainn.gui;

import com.dainn.controller.user.UserProductController;
import com.dainn.dto.*;
import com.dainn.service.ICartService;
import com.dainn.service.IOrderDetailService;
import com.dainn.service.IProductService;
import com.dainn.service.IRomService;
import com.dainn.service.impl.CartService;
import com.dainn.service.impl.OrderDetailService;
import com.dainn.service.impl.ProductService;
import com.dainn.service.impl.RomService;
import com.dainn.utils.ImageUtil;
import com.dainn.utils.NumberTextField;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CartUI extends JFrame {

    private static JFrame frame;
    private static ICartService cartService = new CartService();
    private IProductService productService = new ProductService();
    private IRomService romService = new RomService();
    public JFrame frameHome;
    private static AccountDTO account;
    private JPanel currentPanel;
    private static List<CartDTO> carts;
    private JPanel contentPane;
    private JTextField cartCusName;
    private JTextField cartAddress;
    private JTextField cartPhone;
    private JTextField tF_quantity;
    private JPanel panel_container;
    private static JLabel totalPrice;
    private static JLabel totalPayment;
    private static JLabel discount;


    public CartUI(JFrame frameHome, AccountDTO account) {
        this.frame = this;
        this.frameHome = frameHome;
        this.account = account;
        this.carts = cartService.findByAccount_Id(account.getId());
        this.init();
        this.currentPanel = addPanelCart(panel_container, carts);
    }


    public void init() {
        setSize(1097, 657);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 128));
        panel.setBounds(0, 0, 1083, 90);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("ĐƠN ĐẶT HÀNG");
        lblNewLabel.setForeground(new Color(192, 192, 192));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(385, 15, 324, 50);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(140, 171, 181));
        panel_1.setBounds(0, 89, 563, 531);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Họ và tên:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(98, 96, 93, 38);
        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(98, 171, 93, 38);
        panel_1.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại:");
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_1_2.setBounds(98, 251, 93, 38);
        panel_1.add(lblNewLabel_1_2);

        JButton btnOrder = new JButton("Đặt hàng");
        btnOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnOrder.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnOrder.setBorderPainted(false);
        btnOrder.setBackground(new Color(64, 128, 128));
        btnOrder.setBounds(146, 346, 271, 51);
        panel_1.add(btnOrder);

        cartCusName = new JTextField();
        cartCusName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        cartCusName.setBounds(199, 103, 245, 27);
        panel_1.add(cartCusName);
        cartCusName.setColumns(10);

        cartAddress = new JTextField();
        cartAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        cartAddress.setColumns(10);
        cartAddress.setBounds(199, 178, 245, 27);
        panel_1.add(cartAddress);

        cartPhone = new JTextField();
        cartPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        cartPhone.setColumns(10);
        cartPhone.setBounds(199, 258, 245, 27);
        NumberTextField.numberTextField(cartPhone);
        panel_1.add(cartPhone);

        JButton cartFind = new JButton("Kiểm tra");
        cartFind.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cartFind.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cartFind.setBounds(199, 302, 85, 21);
        panel_1.add(cartFind);

        JPanel btnBackHome = new JPanel();
        btnBackHome.setLayout(null);
        btnBackHome.setName("logOut");
        btnBackHome.setBackground(new Color(140, 171, 181));
        btnBackHome.setBounds(10, 476, 45, 45);
        btnBackHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                frameHome.setVisible(true);
            }
        });
        panel_1.add(btnBackHome);

        JLabel lblBack = new JLabel("");
        lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblBack.setBounds(0, 0, 45, 45);
        lblBack.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-log-in-42.png")));
        btnBackHome.add(lblBack);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(564, 89, 519, 531);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setBounds(26, 63, 245, 7);
        panel_2.add(separator);

        JLabel lblNewLabel_2 = new JLabel("Giỏ hàng");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_2.setBounds(43, 13, 133, 40);
        panel_2.add(lblNewLabel_2);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(10, 435, 499, 86);
        panel_2.add(panel_3);
        panel_3.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("Tổng tiền:");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(0, 6, 91, 20);
        panel_3.add(lblNewLabel_3);

        JLabel lblNewLabel_3_1 = new JLabel("Giảm giá:");
        lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_3_1.setBounds(0, 28, 91, 20);
        panel_3.add(lblNewLabel_3_1);

        JLabel lblNewLabel_3_1_1 = new JLabel("Tổng thanh toán:");
        lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_3_1_1.setBounds(0, 58, 104, 20);
        panel_3.add(lblNewLabel_3_1_1);

        totalPrice = new JLabel(totalPrice(carts) + "");
        totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
        totalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        totalPrice.setBounds(395, 7, 83, 19);
        panel_3.add(totalPrice);

        JLabel lblNewLabel_4_1 = new JLabel("đ");
        lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_4_1.setBounds(482, 7, 17, 19);
        panel_3.add(lblNewLabel_4_1);

        discount = new JLabel("0");
        discount.setHorizontalAlignment(SwingConstants.RIGHT);
        discount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        discount.setBounds(395, 33, 83, 19);
        panel_3.add(discount);

        JLabel lblNewLabel_4_1_1 = new JLabel("%");
        lblNewLabel_4_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_4_1_1.setBounds(482, 33, 17, 19);
        panel_3.add(lblNewLabel_4_1_1);

        totalPayment = new JLabel((Integer.parseInt(totalPrice.getText()) - Integer.parseInt(totalPrice.getText()) * Integer.parseInt(discount.getText()) / 100) + "");
        totalPayment.setHorizontalAlignment(SwingConstants.RIGHT);
        totalPayment.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        totalPayment.setBounds(395, 59, 83, 19);
        panel_3.add(totalPayment);

        JLabel lblNewLabel_4_1_2 = new JLabel("đ");
        lblNewLabel_4_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        lblNewLabel_4_1_2.setBounds(482, 59, 17, 19);
        panel_3.add(lblNewLabel_4_1_2);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 51, 499, 2);
        panel_3.add(separator_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 71, 499, 354);
        panel_2.add(scrollPane);

        panel_container = new JPanel();
        panel_container.setAlignmentX(10.0f);
        scrollPane.setViewportView(panel_container);
        panel_container.setLayout(null);

        this.setVisible(true);
    }

    public JPanel addPanelCart(JPanel panel, List<CartDTO> carts) {
        int length = 0;
        if (carts != null) {
            length = carts.size();
        }
        if (length < 4) {
            length += 4;
        }

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 0, 497, 352);
        panel.add(scrollPane_1);

        JPanel panel_productList = new JPanel();
        panel_productList.setBounds(10, 10, 477, 342);
        panel.add(panel_productList);
        panel_productList.setLayout(new GridLayout(length, 1));

        scrollPane_1.setViewportView(panel_productList);

        if (carts != null) {
            for (CartDTO cart : carts) {
                panel_productList.add(createPanelCartItem(cart));
            }
        }

        return panel_productList;
    }

    public JPanel createPanelCartItem(final CartDTO cart) {
        ProductDTO product = productService.findById(cart.getProductId());
        RomDTO romDTO = romService.findById(cart.getRomId());

        final JPanel panel_product = new JPanel();
        panel_product.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        panel_product.setBounds(341, 386, 477, 119);

        JLabel img = new JLabel("");
        img.setBackground(new Color(255, 128, 0));
        img.setForeground(new Color(140, 171, 181));
        img.setHorizontalAlignment(SwingConstants.CENTER);
        img.setPreferredSize(new Dimension(95, 95));
        img.setSize(new Dimension(87, 87));
        ImageUtil.scaleImage(product.getImage(), img);
        panel_product.add(img);

        JPanel panel_2 = new JPanel();
        panel_2.setPreferredSize(new Dimension(360, 100));
        panel_product.add(panel_2);

        JLabel productName = new JLabel(product.getName());
        productName.setBackground(new Color(128, 128, 128));
        panel_2.add(productName);
        productName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        productName.setHorizontalAlignment(SwingConstants.LEFT);
        productName.setPreferredSize(new Dimension(354, 24));

        JPanel panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(360, 30));
        panel_2.add(panel_3);

        JLabel lblpricee = new JLabel("Đơn giá:");
        panel_3.add(lblpricee);
        lblpricee.setPreferredSize(new Dimension(46, 24));
        lblpricee.setHorizontalAlignment(SwingConstants.LEFT);
        lblpricee.setFont(new Font("Times New Roman", Font.PLAIN, 12));

        JLabel price = new JLabel(cart.getPrice() + "đ");
        price.setPreferredSize(new Dimension(55, 24));
        price.setHorizontalAlignment(SwingConstants.LEFT);
        price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        panel_3.add(price);

        JLabel lblNewLabel_1_1_1_2_1 = new JLabel("");
        lblNewLabel_1_1_1_2_1.setPreferredSize(new Dimension(20, 24));
        lblNewLabel_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        panel_3.add(lblNewLabel_1_1_1_2_1);

        String rom;
        JLabel romName = new JLabel();
        if (romDTO.getCapacity().equals("")) {
            rom = "";
        } else {
            rom = "Rom: " + romDTO.getCapacity();
        }
        romName.setText(rom);
        romName.setPreferredSize(new Dimension(219, 24));
        romName.setHorizontalAlignment(SwingConstants.LEFT);
        romName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        panel_3.add(romName);

        final JPanel panel_3_1 = new JPanel();
        panel_3_1.setPreferredSize(new Dimension(360, 30));
        panel_2.add(panel_3_1);

        JButton btnMinus = new JButton("");
        btnMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnMinus.setPreferredSize(new Dimension(24, 24));
        btnMinus.setSize(24, 24);
        btnMinus.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-minus-13.png")));
//        btnMinus.add
        panel_3_1.add(btnMinus);

        final JTextField tF_quantity = new JTextField(cart.getQuantity().toString());
        tF_quantity.setPreferredSize(new Dimension(24, 24));
        tF_quantity.setHorizontalAlignment(SwingConstants.CENTER);
        tF_quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        NumberTextField.numberTextFieldStartWithoutZero(tF_quantity);
        tF_quantity.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                updateTotal(tF_quantity, cart);
            }
        });
        panel_3_1.add(tF_quantity);

        JButton btnAdd = new JButton("");
        btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAdd.setPreferredSize(new Dimension(24, 24));
        btnAdd.setSize(24, 24);
        btnAdd.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-add-13.png")));
        panel_3_1.add(btnAdd);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("");
        lblNewLabel_1_1_1_1.setPreferredSize(new Dimension(200, 24));
        lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        panel_3_1.add(lblNewLabel_1_1_1_1);

        JButton btnDelete = new JButton("Xóa");
        btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnDelete.setPreferredSize(new Dimension(53, 24));
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container parentContainer = panel_product.getParent();
                if (parentContainer != null){
                    cartService.delete(cart.getId());
                    parentContainer.remove(panel_product);
                    parentContainer.revalidate();
                    parentContainer.repaint();
                    carts = cartService.findByAccount_Id(account.getId());
                    int totalPriceInt = totalPrice(carts);
                    int totalPaymentInt = totalPriceInt - totalPriceInt * Integer.parseInt(discount.getText()) / 100;
                    totalPrice.setText(totalPriceInt + "");
                    totalPayment.setText(totalPaymentInt + "");
                }
            }
        });
        panel_3_1.add(btnDelete);

        return panel_product;
    }

    private static void updateTotal(JTextField tF_quantity, CartDTO cart) {
        try {
            int qty = Integer.parseInt(tF_quantity.getText());
            cart.setQuantity(qty);
            cart = cartService.update(cart);
            carts = cartService.findByAccount_Id(account.getId());
            int totalPriceInt = totalPrice(carts);
            int totalPaymentInt = totalPriceInt - totalPriceInt * Integer.parseInt(discount.getText()) / 100;
            totalPrice.setText(totalPriceInt + "");
            totalPayment.setText(totalPaymentInt + "");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Vui lòng nhập số lượng");
        }
    }

    private static int totalPrice(List<CartDTO> carts) {
        int total = 0;
        if (carts == null) {
            return total;
        }
        for (CartDTO cart : carts) {
            total += cart.getPrice() * cart.getQuantity();
        }
        return total;
    }
}
