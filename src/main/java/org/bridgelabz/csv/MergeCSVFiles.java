package org.bridgelabz.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "src/main/resources/students1.csv";
        String file2 = "src/main/resources/students2.csv";
        String output = "src/main/resources/merged_students.csv";

        // Step 1: Read students1.csv into a map: ID → [Name, Age]
        Map<String, String[]> map1 = new HashMap<>();
        try (CSVReader r1 = new CSVReader(new FileReader(file1))) {
            String[] row;
            r1.readNext(); // skip header
            while ((row = r1.readNext()) != null) {
                // row = { ID, Name, Age }
                map1.put(row[0], new String[]{ row[1], row[2] });
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Open students2.csv and merged_students.csv writer
        try (CSVReader r2 = new CSVReader(new FileReader(file2));
             CSVWriter w = new CSVWriter(new FileWriter(output))) {

            // Write header
            w.writeNext(new String[]{ "ID", "Name", "Age", "Marks", "Grade" });

            String[] row;
            r2.readNext(); // skip header
            while ((row = r2.readNext()) != null) {
                // row = { ID, Marks, Grade }
                String id = row[0];
                String marks = row[1];
                String grade = row[2];

                // lookup name & age
                String[] info = map1.get(id);
                if (info != null) {
                    String name = info[0];
                    String age  = info[1];
                    // merge
                    w.writeNext(new String[]{ id, name, age, marks, grade });
                }
                // else: ID present in students2 but not in students1 → skip or handle as needed
            }

            System.out.println("Merged file written to: " + output);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
