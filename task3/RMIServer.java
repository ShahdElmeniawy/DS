import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(8080); // Start the RMI registry on port 8080
            EmployeeService employeeService = new EmployeeServiceImpl();
            Naming.rebind("rmi://localhost/EmployeeService", employeeService);
            System.out.println("Server started...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
