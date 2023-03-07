package org.example2.data;



import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
class Main {
    public static void main(String[] args) throws IOException {
        try {
            // create a file object for the current location
            FileWriter file = new FileWriter("newFile.csv");
            String data = "First output file!!!";


            file.write(data);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> studentName = new ArrayList<>();
        Path studentPath1 = Paths.get("studentAccount.csv");
        try (BufferedReader br = Files.newBufferedReader(studentPath1, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");

                studentName.add(attributes[0]);
                studentName.remove("DungTran");
                line = br.readLine();
//                System.out.println(line);

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        studentName.add(null);

        System.out.println(studentName);

    }

    public static void loadData() {
        //load data.csv


    }
}
