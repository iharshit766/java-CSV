package org.bridgelabz.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "src/main/resources/large_file.csv";
        int batchSize = 100;
        int totalProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<String> batch = new ArrayList<>();


            String header = br.readLine();
            System.out.println("Header: " + header);

            while ((line = br.readLine()) != null) {
                batch.add(line);

                if (batch.size() == batchSize) {
                    processBatch(batch);
                    totalProcessed += batch.size();
                    System.out.println("Processed so far: " + totalProcessed + " records");
                    batch.clear(); // clear the list for next batch
                }
            }

            // Process remaining lines
            if (!batch.isEmpty()) {
                processBatch(batch);
                totalProcessed += batch.size();
                System.out.println("Processed so far: " + totalProcessed + " records");
            }

            System.out.println("Finished processing all records.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processBatch(List<String> batch) {
    }
}
