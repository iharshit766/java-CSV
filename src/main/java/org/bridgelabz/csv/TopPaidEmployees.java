package org.bridgelabz.csv;

import java.io.*;
import java.util.*;

public class TopPaidEmployees {
    public static void main(String[] args) {
        String fileName = "employees.csv";
        List<String[]> employeeData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String header = br.readLine(); // Skip and optionally store header

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                employeeData.add(data);
            }

            // Sort by salary (index 3) in descending order
            employeeData.sort((a, b) -> {
                double salA = Double.parseDouble(a[3]);
                double salB = Double.parseDouble(b[3]);
                return Double.compare(salB, salA);
            });

            System.out.println("Top 5 Highest Paid Employees:");
            System.out.println("-----------------------------");

            for (int i = 0; i < Math.min(5, employeeData.size()); i++) {
                String[] e = employeeData.get(i);
                System.out.println(e[1] + " | " + e[2] + " | ₹" + e[3]);
            }

        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
