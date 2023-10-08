package com.dainn.controller.user;

import com.dainn.dto.CartDTO;
import com.dainn.dto.CustomerDTO;
import com.dainn.dto.OrderDTO;
import com.dainn.dto.OrderDetailDTO;
import com.dainn.gui.CartUI;
import com.dainn.service.*;
import com.dainn.service.impl.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserCartController implements ActionListener {

    private CartUI cartUI;
    private ICartService cartService = new CartService();
    private IOrderService orderService = new OrderService();
    private IOrderDetailService orderDetailService = new OrderDetailService();
    private IRomService romService = new RomService();
    private IProductService productService = new ProductService();
    private ICustomerService customerService = new CustomerService();
    private CustomerDTO customer;

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
            } else {
                JOptionPane.showMessageDialog(cartUI, "Giỏ hàng đang trống!!!");
            }
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
        for (CartDTO cart : cartUI.carts){
            OrderDetailDTO orderDetail = new OrderDetailDTO(order.getId(), cart.getProductId(), cart.getRomId(),
                    cart.getQuantity(), cart.getPrice());
            orderDetailService.save(orderDetail);
            romService.updateQuantityOfPR(cart.getProductId(), cart.getRomId(), cart.getQuantity());
            productService.updateQuantityById(cart.getProductId());
        }
    }
}
