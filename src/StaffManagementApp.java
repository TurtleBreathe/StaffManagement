import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class StaffManagementApp {
    public static void main(String[] args) throws IOException, CsvException {
// implement fileReader/fileWriter to handle saving into csv/json
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("D:\\Java\\SirmaAcademy\\textfile.csv");
        File file = new File(String.valueOf(path));
        File file2 = new File(String.valueOf(path));

        FileReader fileReader = new FileReader(file);
        CSVReader reader = new CSVReader(fileReader);

        FileWriter outputFile = new FileWriter(file2, true);
        CSVWriter writer = (CSVWriter) new CSVWriterBuilder(outputFile).withSeparator(';').withQuoteChar(CSVWriter.NO_QUOTE_CHARACTER)
                .build();

        Service service = new StaffService(reader, writer);
        Manager manager = new StaffManager(service);
        System.out.println("Welcome to Staff Management System");
        displayCommands();
        boolean isRunning = true;

        while (isRunning) {
            String command = scanner.nextLine();
            if (command.equals("Save & Exit")) {
                service.saveToFile();
                break;
            }
            manager.execute(command);
////// Add Employee
////// 1, Peter Peterson, IT, Junior Java Developer, 1400.50
////// Add Employee
////// 2, Ivan Ivanson, IT, Junior Front-End Developer, 1400.00
////// Edit 1
////// 1, Peter Peterson, IT, Java Developer, 2500.00
////// List employees
////// Search Department Marketing
////// Search Id 1
////// Fire 1
////// Search Name Peter
////// Save & Exit
        }
    }
    private static void displayCommands() {
        System.out.println("1. Add Employee");
        System.out.println("2. Edit Employee");
        System.out.println("3. Fire Employee");
        System.out.println("4. List Employees");
        System.out.println("5. Save & Exit");
    }
}
