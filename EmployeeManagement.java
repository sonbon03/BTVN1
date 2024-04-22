import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "ID: " + id + ", Ten: " + name + ", Tuoi: " + age + ", Department: " + department + ", Code: " + code + ", Salary Rate: " + salaryRate;
    }
}

public class EmployeeManagement {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        initializeEmployees();
        displayEmployees();

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Thoat");
            System.out.print("Lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    deleteEmployee(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Hay chon lai.");
            }
        } while (choice != 3);
        
        scanner.close();
    }

    private static void initializeEmployees() {
        employees.add(new Employee(nextId++, "Son", 30, "IT", "IT001", 2500));
        employees.add(new Employee(nextId++, "Nga", 35, "HR", "HR001", 2800));
        employees.add(new Employee(nextId++, "Tuan", 40, "Finance", "FIN002", 3000));
        employees.add(new Employee(nextId++, "Kien", 45, "Finance", "FIN001", 3500));
        employees.add(new Employee(nextId++, "Son", 33, "IT", "IT002", 2800));
        employees.add(new Employee(nextId++, "Nga", 35, "HR", "HR002", 2800));
        employees.add(new Employee(nextId++, "Tuan", 40, "Finance", "FIN003", 3000));
        employees.add(new Employee(nextId++, "Son", 30, "IT", "IT003", 2800));
        employees.add(new Employee(nextId++, "Nga", 35, "HR", "HR003", 3000));
    }

    private static void displayEmployees() {
        System.out.println("Employee List:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Ho ten: ");
        String name = scanner.nextLine();
        System.out.print("Tuoi: ");
        int age = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Code: ");
        String code = scanner.nextLine();
        System.out.print("Salary rate: ");
        double salaryRate = scanner.nextDouble();
        scanner.nextLine();  

        employees.add(new Employee(nextId++, name, age, department, code, salaryRate));
        System.out.println("Them thanh cong.");
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Nhap ID nhan vien muon xoa: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();  

        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getId() == idToDelete) {
                employees.remove(emp);
                found = true;
                System.out.println("Xoa thanh cong.");
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan vien co ID la: " + idToDelete);
        }
    }
}
