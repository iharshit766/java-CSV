package org.bridgelabz.csv;

import java.io.*;

public class CountCSVRows {

    public static void main(String[] args) {
        String fileName = "src/main/java/org/bridgelabz/csv/students.csv";
        int rowCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                rowCount++;
            }

            System.out.println("Total Records (excluding header): " + rowCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
