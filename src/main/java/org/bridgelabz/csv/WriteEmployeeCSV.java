package org.bridgelabz.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEmployeeCSV {

    public static void main(String[] args) {
        String fileName = "src/main/java/org/bridgelabz/csv/students.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("ID,Name,Department,Salary");
            writer.newLine();


            writer.write("101,Alice,HR,5000");
            writer.newLine();
            writer.write("102,Bob,IT,60000");
            writer.newLine();
            writer.write("103,Charlie,Finance,55000");
            writer.newLine();
            writer.write("104,Diana,Marketing,50000");
            writer.newLine();
            writer.write("105,Ethan,Sales,48000");
            writer.newLine();

            System.out.println("Employee records written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
