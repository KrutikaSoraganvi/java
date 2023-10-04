import java.io.File;
import java.io.IOException;
import java.util.*;
public class EmployeeAnalysis {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("employee_data.csv");
        Scanner scanner = new Scanner(inputFile);
        List<String> consecutiveDaysEmployees = new ArrayList<>();
        int consecutiveDays = 0;
        String previousDate = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            String employeeName = data[0];
            String position = data[1];
            String date = data[2];
            if (date.equals(previousDate)) {
                consecutiveDays++;
            } else {
                consecutiveDays = 1;
            }
            if (consecutiveDays == 7) {
                consecutiveDaysEmployees.add(employeeName + " - " + position);
            }
            previousDate = date;
        }
        System.out.println("Employees who have worked for 7 consecutive days:");
        for (String employee : consecutiveDaysEmployees) {
            System.out.println(employee);
        }
        // b) who have less than 10 hours of time between shifts but greater than 1 hour
        List<String> shortBreakEmployees = new ArrayList<>();
        long previousShiftEndTime = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(",");
            String employeeName = data[0];
            String position = data[1];
            String date = data[2];
            long shiftStartTime = Long.parseLong(data[3]);
            long shiftEndTime = Long.parseLong(data[4]);
            if (previousShiftEndTime != 0 && shiftStartTime - previousShiftEndTime > 3600 && shiftStartTime - previousShiftEndTime < 36000) {
                shortBreakEmployees.add(employeeName + " - " + position);
