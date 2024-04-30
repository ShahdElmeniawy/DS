import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class RMIClient {
    private static final String LINE_SEPARATOR = "+------------------+------------------+------------------+\n";

    public static void main(String[] args) {
        try {
            EmployeeService employeeService = (EmployeeService) Naming.lookup("rmi://localhost/EmployeeService");

            Scanner scanner = new Scanner(System.in);
            int choice = 0, id = 0;

            while (choice != 5) {
                System.out.println("Choose an option:");
                System.out.println("1. Add new employee");
                System.out.println("2. Update employee");
                System.out.println("3. Delete employee");
                System.out.println("4. View all employees");
                System.out.println("5. Exit");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Add new employee
                        System.out.print("Enter employee name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter employee department: ");
                        String department = scanner.nextLine();

                        Employee newEmployee = new Employee(id++, name, department);
                        employeeService.addEmployee(newEmployee);
                        System.out.println("Employee added successfully.");
                        break;
                    case 2:
                        // Update employee
                        System.out.print("Enter employee ID to update: ");
                        int idToUpdate = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        Employee existingEmployee = employeeService.getEmployee(idToUpdate);
                        if (existingEmployee != null) {
                            System.out.print("Enter new name: ");
                            String updatedName = scanner.nextLine();
                            System.out.print("Enter new department: ");
                            String updatedDept = scanner.nextLine();

                            existingEmployee.setName(updatedName);
                            existingEmployee.setDepartment(updatedDept);
                            employeeService.updateEmployee(existingEmployee);
                            System.out.println("Employee updated successfully.");
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;
                    case 3:
                        // Delete employee
                        System.out.print("Enter employee ID to delete: ");
                        int idToDelete = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        employeeService.deleteEmployee(idToDelete);
                        System.out.println("Employee deleted successfully.");
                        break;
                    case 4:
                        // View all employees as table
                        List<Employee> allEmployees = employeeService.getAllEmployees();
                        displayEmployeesTable(allEmployees);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                        break;
                }
            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void displayEmployeesTable(List<Employee> employees) {
        System.out.println("\nEmployee List:");
        System.out.print(LINE_SEPARATOR);
        System.out.printf("| %-16s | %-16s | %-16s |\n", "ID", "Name", "Department");
        System.out.print(LINE_SEPARATOR);

        for (Employee emp : employees) {
            System.out.printf("| %-16d | %-16s | %-16s |\n", emp.getId(), emp.getName(), emp.getDepartment());
        }
        System.out.print(LINE_SEPARATOR);
    }
}
