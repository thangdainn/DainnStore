package com.dainn.gui;

import com.dainn.controller.user.UserHomeController;
import com.dainn.controller.user.UserProductController;
import com.dainn.controller.user.UserReceiptController;
import com.dainn.dto.AccountDTO;
import com.dainn.dto.ProductDTO;
import com.dainn.dto.RomDTO;
import com.dainn.dto.SupplierDTO;
import com.dainn.service.ICartService;
import com.dainn.service.IProductService;
import com.dainn.service.IRomService;
import com.dainn.service.ISupplierService;
import com.dainn.service.impl.CartService;
import com.dainn.service.impl.ProductService;
import com.dainn.service.impl.RomService;
import com.dainn.service.impl.SupplierService;
import com.dainn.utils.NumberTextField;
import com.dainn.utils.ImageUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class UserUI extends JFrame {

    private JFrame frame;
    private ICartService cartService = new CartService();
    private IProductService productService = new ProductService();
    private IRomService romService = new RomService();
    private ISupplierService supplierService = new SupplierService();
    public AccountDTO account;
    private List<ProductDTO> productList;
    private List<RomDTO> roms;
    private List<SupplierDTO> suppliers;
    public String currentCategoryName = "all";
    private JPanel contentPane;
    public JTextField tF_find;
    public JTextField tF_minPrice;
    public JTextField tF_maxPrice;
    public JPanel panel_3;
    private JTextField tF_quantity;
    public JTextField tF_receiptQuantity;
    public JTable table_receiptProd;
    public JTextField tF_receiptTotalPrice;
    private JPanel panel_card;
    private JLabel lbl_header;
    public JPanel currentPanel;
    private boolean drag_card = true;
    public UserProductController userProductController;
    public JTextField tF_receiptImportPrice;
    private JButton btn_find;
    private JButton btn_filterByPrice;
    public JLabel lblNewLabel_8_1;
    public JComboBox comboBox_receiptProdId;
    public JComboBox comboBox_receiptSuppName;
    public JComboBox comboBox_receiptRom;
    public static JLabel lblQtyInCart;

    public UserUI(AccountDTO account) {
        this.frame = this;
        this.account = account;
        this.userProductController = new UserProductController(this);
        this.productList = productService.findAll(1);
        this.roms = romService.findAll();
        this.suppliers = supplierService.findAll();
        this.init();
        UserUI.lblQtyInCart.setText(cartService.countProduct().toString());
        List<ProductDTO> products = productService.findByQuantityGreaterZero(1);
        this.currentPanel = this.addPanelProduct(this.panel_3, products, userProductController);
    }

    public void init() {
        setTitle("Dainn Store");
        setSize(1097, 657);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Bạn chắc chắn muốn thoát?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    cartService.dropTable();
                    System.exit(0);
                }
            }
        });

        UserHomeController userHomeController = new UserHomeController(this);
        UserReceiptController userReceiptController = new UserReceiptController(this);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(135, 206, 235));
        panel.setBounds(0, 0, 190, 620);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_5 = new JLabel("Dainn Store");
        lblNewLabel_5.setForeground(Color.BLACK);
        lblNewLabel_5.setFont(new Font("Segoe Print", Font.BOLD, 24));
        lblNewLabel_5.setBounds(10, 23, 169, 47);
        panel.add(lblNewLabel_5);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 80, 169, 15);
        panel.add(separator);

        JPanel btn_iPhone = new JPanel();
        btn_iPhone.addMouseListener(userHomeController);
        btn_iPhone.setLayout(null);
        btn_iPhone.setName("iPhone");
        btn_iPhone.setForeground(Color.BLACK);
        btn_iPhone.setBackground(new Color(123, 54, 199));
        btn_iPhone.setBounds(32, 189, 124, 47);
        panel.add(btn_iPhone);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBackground(Color.WHITE);
        lblNewLabel_2.setBounds(10, 7, 33, 33);
        lblNewLabel_2.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-iphone-30.png")));
        btn_iPhone.add(lblNewLabel_2);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("iPhone");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1.setForeground(new Color(102, 204, 255));
        lblNewLabel_1_1_1_1.setBackground(new Color(143, 88, 199));
        lblNewLabel_1_1_1_1.setBounds(47, 7, 77, 33);
        btn_iPhone.add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_2_1_1 = new JLabel("");
        lblNewLabel_2_1_1.setBackground(Color.WHITE);
        lblNewLabel_2_1_1.setBounds(10, 3, 40, 40);
        btn_iPhone.add(lblNewLabel_2_1_1);

        JPanel btn_iPad = new JPanel();
        btn_iPad.addMouseListener(userHomeController);
        btn_iPad.setLayout(null);
        btn_iPad.setName("iPad");
        btn_iPad.setForeground(Color.BLACK);
        btn_iPad.setBackground(new Color(123, 54, 199));
        btn_iPad.setBounds(32, 246, 125, 47);
        panel.add(btn_iPad);

        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setBackground(Color.WHITE);
        lblNewLabel_2_1.setBounds(10, 7, 33, 33);
        lblNewLabel_2_1.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-ipad-30.png")));
        btn_iPad.add(lblNewLabel_2_1);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("iPad");
        lblNewLabel_1_1_1_1_1.setForeground(new Color(102, 204, 255));
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1_1.setBackground(new Color(143, 88, 199));
        lblNewLabel_1_1_1_1_1.setBounds(48, 7, 77, 33);
        btn_iPad.add(lblNewLabel_1_1_1_1_1);

        JPanel btn_macbook = new JPanel();
        btn_macbook.addMouseListener(userHomeController);
        btn_macbook.setLayout(null);
        btn_macbook.setName("macBook");
        btn_macbook.setForeground(Color.BLACK);
        btn_macbook.setBackground(new Color(123, 54, 199));
        btn_macbook.setBounds(32, 303, 125, 47);
        panel.add(btn_macbook);

        JLabel lblNewLabel_2_2 = new JLabel("");
        lblNewLabel_2_2.setBackground(Color.WHITE);
        lblNewLabel_2_2.setBounds(10, 7, 33, 33);
        lblNewLabel_2_2.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-macbook-30.png")));
        btn_macbook.add(lblNewLabel_2_2);

        JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Mac");
        lblNewLabel_1_1_1_1_2.setForeground(new Color(102, 204, 255));
        lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1_2.setBackground(new Color(143, 88, 199));
        lblNewLabel_1_1_1_1_2.setBounds(48, 7, 77, 33);
        btn_macbook.add(lblNewLabel_1_1_1_1_2);

        JPanel btn_watch = new JPanel();
        btn_watch.addMouseListener(userHomeController);
        btn_watch.setLayout(null);
        btn_watch.setName("watch");
        btn_watch.setForeground(Color.BLACK);
        btn_watch.setBackground(new Color(123, 54, 199));
        btn_watch.setBounds(33, 360, 125, 47);
        panel.add(btn_watch);

        JLabel lblNewLabel_2_3 = new JLabel("");
        lblNewLabel_2_3.setBackground(Color.WHITE);
        lblNewLabel_2_3.setBounds(10, 7, 33, 33);
        lblNewLabel_2_3.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-apple-watch-30.png")));
        btn_watch.add(lblNewLabel_2_3);

        JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Watch");
        lblNewLabel_1_1_1_1_3.setForeground(new Color(102, 204, 255));
        lblNewLabel_1_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1_3.setBackground(new Color(143, 88, 199));
        lblNewLabel_1_1_1_1_3.setBounds(48, 7, 77, 33);
        btn_watch.add(lblNewLabel_1_1_1_1_3);

        JPanel btn_airPods = new JPanel();
        btn_airPods.addMouseListener(userHomeController);
        btn_airPods.setLayout(null);
        btn_airPods.setName("airPods");
        btn_airPods.setForeground(Color.BLACK);
        btn_airPods.setBackground(new Color(123, 54, 199));
        btn_airPods.setBounds(32, 417, 125, 47);
        panel.add(btn_airPods);

        JLabel lblNewLabel_2_4 = new JLabel("");
        lblNewLabel_2_4.setBackground(Color.WHITE);
        lblNewLabel_2_4.setBounds(10, 7, 33, 33);
        lblNewLabel_2_4.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-airpods-30.png")));
        btn_airPods.add(lblNewLabel_2_4);

        JLabel lblNewLabel_1_1_1_1_4 = new JLabel("AirPods");
        lblNewLabel_1_1_1_1_4.setForeground(new Color(102, 204, 255));
        lblNewLabel_1_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1_4.setBackground(new Color(143, 88, 199));
        lblNewLabel_1_1_1_1_4.setBounds(48, 7, 77, 33);
        btn_airPods.add(lblNewLabel_1_1_1_1_4);

        JPanel btn_logOut = new JPanel();
        btn_logOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_logOut.setName("logOut");
        btn_logOut.setBackground(new Color(135, 206, 235));
        btn_logOut.setBounds(10, 563, 45, 45);
        btn_logOut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cartService.dropTable();
                frame.dispose();
                new LoginUI();
            }
        });
        panel.add(btn_logOut);
        btn_logOut.setLayout(null);

        JLabel lblLogout = new JLabel("");

        lblLogout.setBounds(0, 0, 45, 45);
        btn_logOut.add(lblLogout);
        lblLogout.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-log-in-42.png")));


        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 474, 137, 15);
        panel.add(separator_1);

        JPanel btn_receipt = new JPanel();
        btn_receipt.addMouseListener(userHomeController);
        btn_receipt.setLayout(null);
        btn_receipt.setName("receipt");
        btn_receipt.setForeground(Color.BLACK);
        btn_receipt.setBackground(new Color(0, 102, 0));
        btn_receipt.setBounds(0, 499, 137, 42);
        panel.add(btn_receipt);

        JLabel lblNewLabel_2_5 = new JLabel("");
        lblNewLabel_2_5.setBackground(Color.WHITE);
        lblNewLabel_2_5.setBounds(10, 4, 33, 33);
        lblNewLabel_2_5.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-add-to-basket-30.png")));
        btn_receipt.add(lblNewLabel_2_5);

        JLabel lblNewLabel_1_1_1_1_5 = new JLabel("Nhập hàng");
        lblNewLabel_1_1_1_1_5.setForeground(new Color(102, 204, 255));
        lblNewLabel_1_1_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1_5.setBackground(new Color(143, 88, 199));
        lblNewLabel_1_1_1_1_5.setBounds(47, 4, 90, 33);
        btn_receipt.add(lblNewLabel_1_1_1_1_5);

        JLabel lblNewLabel_2_1_1_1 = new JLabel("");
        lblNewLabel_2_1_1_1.setBackground(Color.WHITE);
        lblNewLabel_2_1_1_1.setBounds(10, 3, 40, 40);
        btn_receipt.add(lblNewLabel_2_1_1_1);

        JPanel btn_allProduct = new JPanel();
        btn_allProduct.addMouseListener(userHomeController);
        btn_allProduct.setLayout(null);
        btn_allProduct.setName("allProduct");
        btn_allProduct.setForeground(Color.BLACK);
        btn_allProduct.setBackground(new Color(123, 54, 199));
        btn_allProduct.setBounds(32, 132, 124, 47);
        panel.add(btn_allProduct);

        JLabel lblNewLabel_2_6 = new JLabel("");
        lblNewLabel_2_6.setBackground(Color.WHITE);
        lblNewLabel_2_6.setBounds(10, 7, 33, 33);
        lblNewLabel_2_6.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-apple-30.png")));
        btn_allProduct.add(lblNewLabel_2_6);

        JLabel lblNewLabel_1_1_1_1_6 = new JLabel("Tất cả");
        lblNewLabel_1_1_1_1_6.setForeground(new Color(102, 204, 255));
        lblNewLabel_1_1_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1_6.setBackground(new Color(143, 88, 199));
        lblNewLabel_1_1_1_1_6.setBounds(47, 7, 77, 33);
        btn_allProduct.add(lblNewLabel_1_1_1_1_6);

        JLabel lblNewLabel_2_1_1_2 = new JLabel("");
        lblNewLabel_2_1_1_2.setBackground(Color.WHITE);
        lblNewLabel_2_1_1_2.setBounds(10, 3, 40, 40);
        btn_allProduct.add(lblNewLabel_2_1_1_2);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(190, 0, 893, 53);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lbl_name = new JLabel(account.getFullName());
        lbl_name.setForeground(new Color(72, 61, 139));
        lbl_name.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_name.setBounds(684, 14, 125, 25);
        panel_1.add(lbl_name);

        JPanel btn_cart = new JPanel();
        btn_cart.setName("cart");
        btn_cart.setBackground(new Color(255, 255, 255));
        btn_cart.addMouseListener(userHomeController);
        btn_cart.setBounds(819, 4, 51, 45);
        btn_cart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                JFrame currentFrame = (JFrame) SwingUtilities.getRoot((Component) e.getSource());
                new CartUI(currentFrame, account);
            }
        });
        panel_1.add(btn_cart);
        btn_cart.setLayout(null);

        JLabel lbl_cart = new JLabel("");
        lbl_cart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_cart.setBounds(0, 0, 51, 45);
        btn_cart.add(lbl_cart);
        lbl_cart.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_cart.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-cart-42.png")));
        
        lblQtyInCart = new JLabel("0");
        lblQtyInCart.setBounds(30, 27, 21, 18);
        btn_cart.add(lblQtyInCart);
        lblQtyInCart.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblQtyInCart.setForeground(new Color(255, 0, 0));
        lblQtyInCart.setHorizontalAlignment(SwingConstants.RIGHT);


        lbl_header = new JLabel("Tất cả");
        lbl_header.setForeground(new Color(0, 128, 128));
        lbl_header.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lbl_header.setBounds(21, 4, 182, 45);
        panel_1.add(lbl_header);

        JLabel cart_1 = new JLabel("");
        cart_1.setHorizontalAlignment(SwingConstants.CENTER);
        cart_1.setBounds(635, 4, 45, 45);
        cart_1.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-account-30.png")));
        panel_1.add(cart_1);

        tF_find = new JTextField();
        tF_find.setBounds(172, 12, 311, 29);
        panel_1.add(tF_find);
        tF_find.setColumns(10);

        btn_find = new JButton("");
        btn_find.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_find.setName("find");
        btn_find.addActionListener(userProductController);
        btn_find.setBounds(493, 11, 30, 30);
        btn_find.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-search-24.png")));
        panel_1.add(btn_find);

        panel_card = new JPanel();
        panel_card.setBounds(190, 52, 893, 568);
        contentPane.add(panel_card);
        panel_card.setLayout(new CardLayout(0, 0));

        JPanel card_product = new JPanel();
        panel_card.add(card_product, "card_product");
        card_product.setLayout(null);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(0, 0, 893, 39);
        card_product.add(panel_4);
        panel_4.setLayout(null);

        JLabel lblNewLabel_6 = new JLabel("Từ:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_6.setBounds(569, 5, 23, 29);
        panel_4.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Đến:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_7.setBounds(691, 5, 29, 29);
        panel_4.add(lblNewLabel_7);

        tF_minPrice = new JTextField();
        NumberTextField.numberTextField(tF_minPrice);
        tF_minPrice.setBounds(591, 10, 90, 19);
        panel_4.add(tF_minPrice);
        tF_minPrice.setColumns(10);

        tF_maxPrice = new JTextField();
        NumberTextField.numberTextField(tF_maxPrice);
        tF_maxPrice.setColumns(10);
        tF_maxPrice.setBounds(720, 10, 90, 19);
        panel_4.add(tF_maxPrice);

        JLabel lblNewLabel_4 = new JLabel("Lọc theo giá:");
        lblNewLabel_4.setForeground(new Color(0, 102, 102));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_4.setBounds(481, 7, 78, 24);
        panel_4.add(lblNewLabel_4);

        btn_filterByPrice = new JButton("");
        btn_filterByPrice.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn_filterByPrice.setName("filterByPrice");
        btn_filterByPrice.addActionListener(userProductController);
        btn_filterByPrice.setBounds(820, 6, 26, 26);
        btn_filterByPrice.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-filter-24.png")));
        panel_4.add(btn_filterByPrice);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 37, 893, 531);
        card_product.add(scrollPane);

        panel_3 = new JPanel();
        scrollPane.setViewportView(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(null);
        FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
        flowLayout_1.setHgap(10);
        panel_3.add(panel_6, BorderLayout.WEST);

        JPanel panel_7 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
        flowLayout.setHgap(10);
        panel_3.add(panel_7, BorderLayout.EAST);

        JPanel panel_8 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_8.getLayout();
        flowLayout_2.setVgap(10);
        panel_3.add(panel_8, BorderLayout.NORTH);

        JPanel panel_9 = new JPanel();
        FlowLayout flowLayout_3 = (FlowLayout) panel_9.getLayout();
        flowLayout_3.setVgap(10);
        panel_3.add(panel_9, BorderLayout.SOUTH);

//		this.addPanelProduct(panel_3, 100);

        JPanel card_receipt = new JPanel();
        panel_card.add(card_receipt, "card_receipt");
        card_receipt.setLayout(null);

        JPanel product_infor_1 = new JPanel();
        product_infor_1.setLayout(null);
        product_infor_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null), "Th\u00F4ng tin phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        product_infor_1.setBounds(10, 10, 873, 118);
        card_receipt.add(product_infor_1);

        JLabel lblNewLabel_9_4 = new JLabel("Tên nhà cung cấp:");
        lblNewLabel_9_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_9_4.setBounds(570, 30, 101, 13);
        product_infor_1.add(lblNewLabel_9_4);

        JLabel lblNewLabel_9_1_2 = new JLabel("Mã sản phẩm:");
        lblNewLabel_9_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_9_1_2.setBounds(59, 30, 91, 13);
        product_infor_1.add(lblNewLabel_9_1_2);

        comboBox_receiptProdId = new JComboBox();
        comboBox_receiptProdId.setFont(new Font("Tahoma", Font.PLAIN, 11));
        comboBox_receiptProdId.setBounds(138, 27, 144, 19);
        comboBox_receiptProdId.addItem("Chọn mã sản phẩm");
        for (ProductDTO product : productList) {
            comboBox_receiptProdId.addItem(product.getId());
        }
        product_infor_1.add(comboBox_receiptProdId);

        JLabel lblNewLabel_9_2_2_1 = new JLabel("Số lượng:");
        lblNewLabel_9_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_9_2_2_1.setBounds(327, 73, 57, 13);
        product_infor_1.add(lblNewLabel_9_2_2_1);

        comboBox_receiptSuppName = new JComboBox();
        comboBox_receiptSuppName.setFont(new Font("Tahoma", Font.PLAIN, 11));
        comboBox_receiptSuppName.setBounds(663, 27, 144, 19);
        comboBox_receiptSuppName.addItem("Chọn tên nhà cung cấp");
        for (SupplierDTO supplier : suppliers) {
            comboBox_receiptSuppName.addItem(supplier.getName());

        }
        product_infor_1.add(comboBox_receiptSuppName);

        tF_receiptQuantity = new JTextField();
        tF_receiptQuantity.setColumns(10);
        tF_receiptQuantity.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
        tF_receiptQuantity.setBounds(394, 70, 120, 19);
        NumberTextField.numberTextFieldStartWithoutZero(tF_receiptQuantity);
        product_infor_1.add(tF_receiptQuantity);

        JLabel lblNewLabel_9_2_2_1_1 = new JLabel("Giá nhập:");
        lblNewLabel_9_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_9_2_2_1_1.setBounds(327, 30, 57, 13);
        product_infor_1.add(lblNewLabel_9_2_2_1_1);

        tF_receiptImportPrice = new JTextField();
        NumberTextField.numberTextFieldStartWithoutZero(tF_receiptImportPrice);
        tF_receiptImportPrice.setColumns(10);
        tF_receiptImportPrice.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
        tF_receiptImportPrice.setBounds(391, 27, 123, 19);
        product_infor_1.add(tF_receiptImportPrice);

        JLabel lblNewLabel_9_1_2_1 = new JLabel("Dung lượng:");
        lblNewLabel_9_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_9_1_2_1.setBounds(59, 73, 77, 13);
        product_infor_1.add(lblNewLabel_9_1_2_1);

        comboBox_receiptRom = new JComboBox();
        comboBox_receiptRom.setFont(new Font("Tahoma", Font.PLAIN, 11));
        comboBox_receiptRom.setBounds(138, 70, 144, 19);
        comboBox_receiptRom.addItem("Chọn dung lượng");
        for (RomDTO rom : roms) {
            comboBox_receiptRom.addItem(rom.getCapacity());
        }
        product_infor_1.add(comboBox_receiptRom);
        
        JButton btn_importReceipt = new JButton("Nhập phiếu");
        btn_importReceipt.addActionListener(userReceiptController);
        btn_importReceipt.setFont(new Font("Tahoma", Font.BOLD, 10));
        btn_importReceipt.setBackground(new Color(149, 92, 211));
        btn_importReceipt.setBounds(706, 69, 101, 21);
        product_infor_1.add(btn_importReceipt);

        JPanel product_infor_1_1 = new JPanel();
        product_infor_1_1.setLayout(null);
        product_infor_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null), "S\u1EA3n ph\u1EA9m nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        product_infor_1_1.setBounds(10, 138, 873, 352);
        card_receipt.add(product_infor_1_1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 26, 853, 282);
        product_infor_1_1.add(scrollPane_1);

        table_receiptProd = new JTable();
        table_receiptProd.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Dung l\u01B0\u1EE3ng", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 nh\u1EADp", "Th\u00E0nh ti\u1EC1n"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        table_receiptProd.getColumnModel().getColumn(0).setResizable(false);
        table_receiptProd.getColumnModel().getColumn(1).setResizable(false);
        table_receiptProd.getColumnModel().getColumn(1).setPreferredWidth(222);
        table_receiptProd.getColumnModel().getColumn(2).setResizable(false);
        table_receiptProd.getColumnModel().getColumn(3).setResizable(false);
        table_receiptProd.getColumnModel().getColumn(4).setResizable(false);
        table_receiptProd.getColumnModel().getColumn(4).setPreferredWidth(89);
        table_receiptProd.getColumnModel().getColumn(5).setResizable(false);
        table_receiptProd.getColumnModel().getColumn(5).setPreferredWidth(109);
        scrollPane_1.setViewportView(table_receiptProd);

        tF_receiptTotalPrice = new JTextField("0");
        tF_receiptTotalPrice.setEditable(false);
        tF_receiptTotalPrice.setBounds(770, 318, 93, 19);
        product_infor_1_1.add(tF_receiptTotalPrice);
        tF_receiptTotalPrice.setColumns(10);

        JLabel lblNewLabel_9 = new JLabel("Tổng tiền:");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_9.setBounds(714, 318, 58, 19);
        product_infor_1_1.add(lblNewLabel_9);

        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_4_1.setLayout(null);
        panel_4_1.setBounds(83, 493, 727, 51);
        card_receipt.add(panel_4_1);

        JButton btn_receiptDeleteProd = new JButton("Xóa sản phẩm");
        btn_receiptDeleteProd.addActionListener(userReceiptController);
        btn_receiptDeleteProd.setBackground(new Color(149, 92, 211));
        btn_receiptDeleteProd.setBounds(138, 15, 107, 21);
        panel_4_1.add(btn_receiptDeleteProd);

        JButton btn_receiptDeleteAllProd = new JButton("Xóa tất cả");
        btn_receiptDeleteAllProd.addActionListener(userReceiptController);
        btn_receiptDeleteAllProd.setBackground(new Color(149, 92, 211));
        btn_receiptDeleteAllProd.setBounds(255, 15, 107, 21);
        panel_4_1.add(btn_receiptDeleteAllProd);

        JButton btn_createReceipt = new JButton("Tạo phiếu");
        btn_createReceipt.addActionListener(userReceiptController);
        btn_createReceipt.setBackground(new Color(149, 92, 211));
        btn_createReceipt.setBounds(606, 15, 85, 21);
        panel_4_1.add(btn_createReceipt);

        JButton btn_receiptAddProd = new JButton("Thêm vào phiếu");
        btn_receiptAddProd.addActionListener(userReceiptController);
        btn_receiptAddProd.setBounds(21, 15, 107, 21);
        panel_4_1.add(btn_receiptAddProd);
        btn_receiptAddProd.setBackground(new Color(149, 92, 211));

        this.setVisible(true);
    }

    public JPanel addPanelProduct(JPanel Panel, List<ProductDTO> products, UserProductController userProductController) {
        int length = products.size();
        int row = length / 5;
        int countEmptyPanel = 0;
        if (row <= 2) {
            row = 3;
            countEmptyPanel = 15 - length;
        } else {
            int temp = length % 5;
            if (temp != 0) {
                row = length / 5 + 1;
                countEmptyPanel = 5 - temp;
            }
        }
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(240, 240, 240));
        Panel.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new GridLayout(row, 5, 22, 20));

        for (ProductDTO product : products) {
            RomDTO rom = romService.findTop1ByProduct_Id(product.getId());
            panel_5.add(createPanelProduct(product, rom, userProductController));
        }

        for (int i = 1; i <= countEmptyPanel; i++) {
            panel_5.add(emptyPanelProduct());
        }
        return panel_5;
    }

    public JPanel createPanelProduct(final ProductDTO product, RomDTO rom, UserProductController userProductController) {
        JPanel panel_3_3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_3_3.addMouseListener(userProductController);
        panel_3_3.setBackground(new Color(255, 255, 255));
        panel_3_3.setPreferredSize(new Dimension(149, 190));


        JLabel lblNewLabel_3 = new JLabel();
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setPreferredSize(new Dimension(125, 125));
        lblNewLabel_3.setSize(new Dimension(125, 125));
        ImageUtil.scaleImage(product.getImage(), lblNewLabel_3);
        panel_3_3.add(lblNewLabel_3);

        JLabel lblNewLabel_8 = new JLabel(product.getName());
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setPreferredSize(new Dimension(129, 21));
        panel_3_3.add(lblNewLabel_8);

        JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pricePanel.setBackground(Color.WHITE);

        JLabel lblNewLabel_8_1_1 = new JLabel("Giá:");
        lblNewLabel_8_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_3_3.add(lblNewLabel_8_1_1);

        final Integer priceItem;
        if (rom != null) {
            priceItem = product.getPrice() + product.getPrice() * rom.getPercent() / 100;
        } else {
            priceItem = product.getPrice();
        }
        lblNewLabel_8_1 = new JLabel((priceItem + "đ"));
        lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.LEFT);
        panel_3_3.add(lblNewLabel_8_1);

        panel_3_3.add(pricePanel);
        panel_3_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ProductDetailUI(product, priceItem, account);
            }
        });
        return panel_3_3;
    }

    public JPanel emptyPanelProduct() {
        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(new Color(240, 240, 240));
        emptyPanel.setPreferredSize(new Dimension(149, 190));
        return emptyPanel;
    }

    public String handleShowCard(JPanel panel) {
        CardLayout cardLayout = (CardLayout) this.panel_card.getLayout();
        if (panel.getName().equals("receipt")) {
            this.lbl_header.setText("Nhập hàng");
            this.drag_card = false;
            cardLayout.show(panel_card, "card_receipt");
            this.currentCategoryName = "receipt";
        } else if (panel.getName().equals("allProduct")) {
            this.lbl_header.setText("Tất cả");
            if (!this.drag_card) {
                cardLayout.show(panel_card, "card_product");
                this.drag_card = true;
            }
            this.currentCategoryName = "all";
        } else if (panel.getName().equals("iPhone")) {
            this.lbl_header.setText("iPhone");
            if (!this.drag_card) {
                cardLayout.show(panel_card, "card_product");
                this.drag_card = false;
            }
            this.currentCategoryName = "iPhone";
        } else if (panel.getName().equals("iPad")) {
            this.lbl_header.setText("iPad");
            if (!this.drag_card) {
                cardLayout.show(panel_card, "card_product");
                this.drag_card = false;
            }
            this.currentCategoryName = "iPad";
        } else if (panel.getName().equals("watch")) {
            this.lbl_header.setText("Apple Watch");
            if (!this.drag_card) {
                cardLayout.show(panel_card, "card_product");
                this.drag_card = false;
            }
            this.currentCategoryName = "Watch";
        } else if (panel.getName().equals("macBook")) {
            this.lbl_header.setText("Mac");
            if (!this.drag_card) {
                cardLayout.show(panel_card, "card_product");
                this.drag_card = false;
            }
            this.currentCategoryName = "Mac";
        } else if (panel.getName().equals("airPods")) {
            this.lbl_header.setText("AirPods");
            if (!this.drag_card) {
                cardLayout.show(panel_card, "card_product");
                this.drag_card = false;
            }
            this.currentCategoryName = "AirPods";
        }
        return this.currentCategoryName;
    }
}
