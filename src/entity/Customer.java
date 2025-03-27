package entity;

import java.util.Optional;
import java.util.Scanner;

public class Customer implements IApp{
    private int id;
    private String name;
    private Optional<String> email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập id kh: ");
        setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhập tên kh: ");
        setName(scanner.nextLine());
        System.out.println("Nhập email: ");
        setEmail(Optional.ofNullable(scanner.nextLine()));
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email=" + email +
                '}';
    }
}
