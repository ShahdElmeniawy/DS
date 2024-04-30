import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String department;

    // Constructor
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Other getters and setters for name and department
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Override toString() method for better representation
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department + "]";
    }
}
