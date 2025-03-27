package presentation;

import entity.Customer;
import entity.Order;
import business.CustomerBusiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static business.CustomerBusiness.addCustomer;

public class ShopManagement {
    public static List<Order> orders = new ArrayList<Order>();
    public static List<Customer> customers = new ArrayList<Customer>();
    public static void main(String[] args) {
		int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("**********************SHOP MENU*******************");
            System.out.println("1. Quản lý khách hàng");
            System.out.println("2. Quản lý đơn hàng");
            System.out.println("3. Thoát");
            System.out.println("*************************************************");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    int choice1;
                    do {
                        System.out.println("**********************QUẢN LÝ KHÁCH HÀNG*******************");
                        System.out.println("1. Thêm khách hàng");
                        System.out.println("2. Hiển thị danh sách khách hàng");
                        System.out.println("3. Thoát");
                        System.out.println("*************************************************");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        choice1 = sc.nextInt();
                        sc.nextLine();
                        switch (choice1){
                            case 1:
                                CustomerBusiness.addCustomer(new Scanner(System.in));
                                break;
                            case 2:
                                CustomerBusiness.displayCustomers();
                                break;
                            case 3:
                                System.out.println("Thoát chương trình.");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ.");
                        }
                    }while (choice1 != 3);
                    break;
                case 2:
                    int choice2;
                    CustomerBusiness customerBusiness = new CustomerBusiness();
                            do {
                                System.out.println("**********************QUẢN LÝ ĐƠN HÀNG*******************");
                                System.out.println("1. Danh sách đơn hàng");
                                System.out.println("2. Thêm mới đơn hàng");
                                System.out.println("3. Cập nhật trạng thái đơn hàng");
                                System.out.println("4. Danh sách đơn hàng quá hạn");
                                System.out.println("5. Thống kê số lượng đơn hàng đã giao");
                                System.out.println("6. Tính tổng doanh thu các đơn hàng đã giao");
                                System.out.println("7. Thoát");
                                System.out.print("Nhập lựa chọn của bạn: ");
                                choice2 = sc.nextInt();
                                sc.nextLine();
                                switch (choice2){
                                    case 1:
                                        customerBusiness.displayOrders();
                                        break;
                                    case 2:
                                        customerBusiness.addOrder(new Scanner(System.in));
                                        break;
                                    case 3:
                                        customerBusiness.updateOrderStatus(new Scanner(System.in));
                                        break;
                                    case 4:
                                        customerBusiness.getOrderOverdue();
                                        break;
                                    case 5:
                                        customerBusiness.getOrderDelivied();
                                        break;
                                    case 6:
                                        customerBusiness.getTotalRevenue();
                                        break;
                                    case 7:
                                        System.out.println("Thoát chương trình.");
                                        break;
                                    default:
                                        System.out.println("Lựa chọn không hợp lệ.");
                                }
                            }while (choice2 != 7);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice !=3);
    }
}
