package com.dainn.controller.user;

import com.dainn.dao.impl.AbstractDAO;
import com.dainn.dto.*;
import com.dainn.gui.CartUI;
import com.dainn.service.*;
import com.dainn.service.impl.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserCartController implements ActionListener {

    private CartUI cartUI;
    private ICartService cartService = new CartService();
    private IOrderService orderService = new OrderService();
    private IOrderDetailService orderDetailService = new OrderDetailService();
    private IRomService romService = new RomService();
    private IProductService productService = new ProductService();
    private ICustomerService customerService = new CustomerService();
    private CustomerDTO customer;
    private Integer orderId = null;

    public UserCartController(CartUI cartUI) {
        this.cartUI = cartUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Kiểm tra")){
            String phone = cartUI.cartPhone.getText();
            CustomerDTO customerDTO = getByPhone(phone);
            if (customerDTO != null) {
                cartUI.cartCusName.setText(customerDTO.getName());
                cartUI.cartAddress.setText(customerDTO.getAddress());
                cartUI.discount.setText(customerDTO.getPoints().toString());
                cartUI.setAllTFTotal();
                cartUI.btnOrder.setEnabled(true);
                this.customer = customerDTO;
            } else {
                cartUI.cartCusName.setText("");
                cartUI.cartAddress.setText("");
                cartUI.discount.setText("0");
                cartUI.setAllTFTotal();
                cartUI.btnOrder.setEnabled(false);
            }
        } else if (action.equals("Đặt hàng")){
            if (cartUI.carts != null){
                OrderDTO order = new OrderDTO();
                order.setTotalPrice(Integer.valueOf(cartUI.totalPayment.getText()));
                order.setAccountId(cartUI.account.getId());
                order.setCustomerId(customer.getId());
                order = orderService.save(order);
                orderId = order.getId();
                handleSaveOrderDetail(cartUI.carts, order);
                Integer points = customer.getPoints();
                if (points < 15){
                    customer.setPoints(points + 1);
                    customerService.update(customer);
                }
                cartService.dropTable();
                cartUI.currentPanel.setVisible(false);
                cartUI.setAllTFTotal();
                JOptionPane.showMessageDialog(cartUI, "Đặt hàng thành công!!!");
                cartUI.btnExportBill.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(cartUI, "Giỏ hàng đang trống!!!");
            }
        } else if (action.equals("In hóa đơn")){
            exportBill();
        }
    }

    private CustomerDTO getByPhone(String phone) {
        if (!phone.equals("")) {
            CustomerDTO customer = customerService.findByPhone(phone, 1);
            if (customer != null) {
                return customer;
            }
            JOptionPane.showMessageDialog(cartUI, "Số điện thoại không tồn tại!!!");
            return null;
        } else {
            JOptionPane.showMessageDialog(cartUI, "Vui lòng nhập số điện thoại!!!");
            return null;
        }
    }

    private void handleSaveOrderDetail(List<CartDTO> carts, OrderDTO order){
        for (CartDTO cart : carts){
            OrderDetailDTO orderDetail = new OrderDetailDTO(order.getId(), cart.getProductId(), cart.getRomId(),
                    cart.getQuantity(), cart.getPrice());
            orderDetailService.save(orderDetail);
            romService.updateQuantityOfPR(cart.getProductId(), cart.getRomId(), - cart.getQuantity());
            ProductDTO product = productService.findById(cart.getProductId());
            product.setQuantity(product.getQuantity() - cart.getQuantity());
            productService.update(product);
        }
    }

    private void exportBill(){
        try {
            Hashtable map = new Hashtable();
            JasperReport rpt = JasperCompileManager.compileReport("src/main/java/com/dainn/report/ReportOrder.jrxml");
            map.put("orderId", orderId);
            Connection conn = cartService.getConnection();
            JasperPrint p = JasperFillManager.fillReport(rpt, map, conn);
            JasperViewer.viewReport(p, false);
        } catch (JRException ex){
            Logger.getLogger(cartUI.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
