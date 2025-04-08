package org.bridgelabz.csv;

import java.io.*;

public class ReadStudentCSV {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/bridgelabz/csv/students.csv"));
        String line;

        br.readLine(); // Skip header

        System.out.println("Student Records:");
        System.out.println("----------------");

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");


                System.out.println("Name    : " + data[0]);
                System.out.println("Age  : " + data[1]);
                System.out.println("Gender  : " + data[2]);

                System.out.println("----------------");
            
        }
        br.close();
    }
}
