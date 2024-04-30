import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl extends UnicastRemoteObject implements EmployeeService {
    private List<Employee> employees;

    public EmployeeServiceImpl() throws RemoteException {
        super();
        employees = new ArrayList<>();
        // load from a database
    }

    @Override
    public void addEmployee(Employee employee) throws RemoteException {
        // Add employee to the database
        employees.add(employee);
    }

    @Override
    public void updateEmployee(Employee employee) throws RemoteException {
        // Update employee in the database
        for (Employee emp : employees) {
            if (emp.getId() == employee.getId()) {
                emp.setName(employee.getName());
                emp.setDepartment(employee.getDepartment());
                break;
            }
        }
    }

    @Override
    public void deleteEmployee(int id) throws RemoteException {
        // Delete employee from the database
        employees.removeIf(emp -> emp.getId() == id);
    }

    @Override
    public Employee getEmployee(int id) throws RemoteException {
        // Retrieve employee by ID from the database
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() throws RemoteException {
        // Return all employees from the database
        return employees;
    }
}
