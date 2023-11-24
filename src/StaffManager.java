import java.util.Scanner;

public class StaffManager extends Manager{
    public StaffManager(Service service){
        this.staffService = service;
    }

    @Override
    public void execute(String command) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = command.split(" ");

        switch (tokens[0]) {

            case "Add":
                String[] info = scanner.nextLine().split(", ");
                Employee employee = new Employee(
                        Integer.parseInt(info[0]),
                        info[1],
                        info[2],
                        info[3],
                        Double.parseDouble(info[4]));
                staffService.addEmployee(employee);
                System.out.println("Added Employee");
                break;

            case  "Edit":
                String[] employeeToEdit = scanner.nextLine().split(", ");
                 employee = new Employee(
                        Integer.parseInt(employeeToEdit[0]),
                         employeeToEdit[1],
                         employeeToEdit[2],
                         employeeToEdit[3],
                        Double.parseDouble(employeeToEdit[4]));
                staffService.edit(Integer.parseInt(tokens[1]),employee);
                System.out.println("Edited Employee");
                break;

            case "Fire":
                staffService.fire(Integer.parseInt(tokens[1]));
                System.out.println("Fired Employee");
                break;

            case  "List":
                staffService.list();
                break;
        }
    }
}
