import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaffService implements Service {
    private final List<Employee> employees;
    private final CSVReader reader;
    private final CSVWriter writer;

    public StaffService(CSVReader reader, CSVWriter writer) throws IOException {
        this.reader = reader;
        this.writer = writer;
        this.employees = new ArrayList<>();
        loadFromCSV();
        System.out.println(employees);
    }

    private void loadFromCSV() throws IOException {
        try  {
            List<String[]> lines = reader.readAll();
            if (lines.size() == 1 && lines.get(0)[0].isEmpty()) {
                return;
            }
            for (int i = 0; i < lines.size(); i++) {
                String[]row = lines.get(i)[0].split(";");
                Employee employee = new Employee(
                        Integer.parseInt(row[0]),
                        row[1],
                        row[2],
                        row[3],
                        Double.parseDouble(row[4])
                );
                employees.add(employee);
            }
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        reader.close();
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void edit(int ID, Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID() == ID) {
                employees.set(i,employee);
            }
        }
    }

    @Override
    public void fire(int ID) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID() == ID) {
                employees.remove(i);
                return;
            }
        }
    }

    @Override
    public void list() {
        System.out.println(employees);
    }
@Override
    public void saveToFile() throws IOException {
            List<String[]> tolist = employees.stream().map(e -> e.convertToStringArray()).toList();
            writer.writeAll(tolist);
            writer.flush();
    }
    @Override
    public void search(String info){
    }
}
