public class Employee {


    private int ID;
    private String name;
    private String department;
    private String role;
    private double salary;
    public Employee(int ID, String name, String department, String role, double salary) {
        this.ID = ID;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }
    public int getID() {
        return ID;
    }

    public String[] convertToStringArray() {
        String result = Integer.toString(ID) + "," + name + "," + department + "," + role + "," + Double.toString(salary);
        return result.split(",");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }
}
