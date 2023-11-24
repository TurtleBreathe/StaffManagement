import java.io.IOException;
import java.nio.file.Path;

public interface Service {
    void addEmployee(Employee employee);
    void edit(int ID, Employee employee);
    void fire(int ID);
    void list();
    void saveToFile() throws IOException;

    void search(String info);
}
