package entity;
import java.time.LocalDate;
import java.util.Scanner;

public class Order implements IApp {
    private int id;
    private Customer customer;
   	private LocalDate orderDate;
       private double totalAmount;
    private boolean status;
    public Order() {
    }
    public Order(int id, Customer customer, LocalDate orderDate, double totalAmount, boolean status) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập id oder: ");
        setId(scanner.nextInt());
        scanner.nextLine();
        Customer customer = new Customer();
        customer.inputData(scanner);
        setCustomer(customer);
        System.out.println("Nhập ngày đặt hàng: ");
        setOrderDate(LocalDate.parse(scanner.nextLine()));
        System.out.println("Nhập tổng tiền: ");
        setTotalAmount(scanner.nextDouble());
        scanner.nextLine();
        setStatus(false);
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
    }

}
