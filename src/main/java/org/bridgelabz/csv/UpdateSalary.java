package org.bridgelabz.csv;

import java.io.*;

public class UpdateSalary {

    public static void main(String[] args) {
        String inputFile = "src/main/java/org/bridgelabz/csv/employees.csv";
        String outputFile = "src/main/java/org/bridgelabz/csv/updated_employees.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line = reader.readLine(); // Read header
            writer.write(line);
            writer.newLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");


                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                if (department.equalsIgnoreCase("IT")) {
                    salary *= 1.10; // Increase by 10%
                }

                // Write updated line
                writer.write(data[0] + "," + data[1] + "," + department + "," + String.format("%.2f", salary));
                writer.newLine();
            }

            System.out.println("Updated records saved to " + outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
