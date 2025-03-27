package business;

import entity.Customer;
import entity.Order;
import presentation.ShopManagement;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static presentation.ShopManagement.customers;
import static presentation.ShopManagement.orders;

public class CustomerBusiness implements IOrderBusiness{
    public static void addCustomer(Scanner scanner){
        Customer customer = new Customer();
        customer.inputData(scanner);
        customers.add(customer);
    }
    public static void displayCustomers(){
        for (Customer customer : customers){
            System.out.println(customer);
        }
    }

    @Override
    public void addOrder(Scanner scanner) {
        Order order = new Order();
        order.inputData(scanner);
        ShopManagement.orders.add(order);
    }

    @Override
    public  void displayOrders() {
        for (Order order : ShopManagement.orders){
            System.out.println(order);
        }
    }

    @Override
    public void updateOrderStatus(Scanner scanner) {
        System.out.println("Nhập id đơn hàng cần cập nhật: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Order order : ShopManagement.orders){
            if (order.getId() == id){
                System.out.println("Nhập trạng thái mới: ");
                boolean status = scanner.nextBoolean();
                order.setStatus(status);
                return;
            }
        }
        System.out.println("Không tìm thấy đơn hàng có id = " + id);
    }

    @Override
    public List<Order> getOrderOverdue() {
		orders.stream().filter(order -> order.isStatus()== false && order.getOrderDate().isBefore(LocalDate.now())).collect(Collectors.toList()).forEach(order -> System.out.println(order));
        return orders;
    }

    @Override
    public List<Order> getOrderDelivied() {
        orders.stream().filter(order -> order.isStatus()== true).collect(Collectors.toList()).forEach(order -> System.out.println(order));
        return orders;
    }

    @Override
    public double getTotalRevenue() {
        return orders.stream().mapToDouble(Order::getTotalAmount).sum();
    }
}
