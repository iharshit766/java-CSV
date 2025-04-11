package org.bridgelabz.csv;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class DuplicateDetector {
    public static void main(String[] args) {
        String filePath = "src/main/resources/students.csv";

        Set<String> seenIds = new HashSet<>();
        List<String[]> duplicateRows = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            boolean isFirstLine = true;

            while ((row = reader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip header
                    continue;
                }

                String id = row[0].trim();

                if (!seenIds.add(id)) {
                    duplicateRows.add(row);
                }
            }

            if (duplicateRows.isEmpty()) {
                System.out.println("No duplicate IDs found.");
            } else {
                System.out.println("Duplicate Records Found:");
                for (String[] dup : duplicateRows) {
                    System.out.println(Arrays.toString(dup));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
