package org.bridgelabz.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.regex.*;

public class CSVValidator {
    public static void main(String[] args) {
        String filePath = "src/main/resources/data.csv";

        // Email regex pattern
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        // Phone regex: exactly 10 digits
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (CSVReader br = new CSVReader(new FileReader(filePath))) {
            int lineNum = 0;
            String[] fields;

            while ((fields = br.readNext()) != null) {
                lineNum++;
                // Skip header
                if (lineNum == 1) continue;

                String email = fields[1].trim();
                String phone = fields[2].trim();

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Line " + lineNum + ": Invalid email - " + email);
                }

                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Line " + lineNum + ": Invalid phone number - " + phone);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}