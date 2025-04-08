package org.bridgelabz.csv;

import java.io.*;
import java.util.Scanner;

public class EmployeeSearch {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("   "));
        String line;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee name: ");
        String searchName = sc.nextLine(); // Change this name to search others

        br.readLine(); // Skip header

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[1].equalsIgnoreCase(searchName)) {
                System.out.println("Department: " + data[2]);
                System.out.println("Salary: " + data[3]);
                return;
            }
        }

        System.out.println("Employee not found.");
        br.close();
    }
}
