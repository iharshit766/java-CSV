package org.bridgelabz.csv;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVToStudents {

    // Inner class representing a Student
    static class Student {
        int id;
        String name;
        int age;
        String email;

        public Student(int id, String name, int age, String email) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Student [ID=" + id + ", Name=" + name + ", Age=" + age + ", Email=" + email + "]";
        }
    }

    public static void main(String[] args) {
        String csvFile = "src/main/java/org/bridgelabz/csv/students_new.csv"; // Adjust path as needed
        List<Student> studentList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            int lineCount = 0;

            while ((nextLine = reader.readNext()) != null) {
                if (lineCount++ == 0) continue; // Skip header

                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                int age = Integer.parseInt(nextLine[2]);
                String email = nextLine[3];

                studentList.add(new Student(id, name, age, email));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print the list
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}
