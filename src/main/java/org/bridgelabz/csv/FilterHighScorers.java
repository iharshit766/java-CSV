package org.bridgelabz.csv;

import java.io.*;

public class FilterHighScorers {

    public static void main(String[] args) {
        String fileName = "src/main/java/org/bridgelabz/csv/student.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine(); // Read and skip header
            System.out.println("Students who scored more than 80 marks:");
            System.out.println("----------------------------------------");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                // Assuming columns: ID, Name, Age, Marks
                int marks = Integer.parseInt(data[3]);

                if (marks > 80) {
                    System.out.println("ID: " + data[0] + ", Name: " + data[1] + ", Age: " + data[2] + ", Marks: " + data[3]);
                }
            }

        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }
}
