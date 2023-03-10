package org.hust.sis;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataLoader {

    private static List<String> userTypeList = Arrays.asList("student", "manager");// TODO: need to read this from config file

    private static List<String> userPath() {
        List<String> userPath = new ArrayList<>();
        for (String userType : userTypeList) {
            userPath.add("src/main/resources/user" + userType + ".csv");//TODO: Need to read user path from config file
        }
        return userPath;
    }


    public static List<String> getName() {
        List<String> Name = new ArrayList<>();
        for (String path : userPath()) {
            Path pathToFile = Paths.get(path);
            try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
                String line = br.readLine();
                while (line != null) {
                    String[] attributes = line.split(",");
                    Name.add(attributes[0]);
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return Name;
    }

    public static List<String> getId() {
        List<String> Id = new ArrayList<>();
        for (String path : userPath()) {
            Path pathToFile = Paths.get(path);
            try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
                String line = br.readLine();
                while (line != null) {
                    String[] attributes = line.split(",");
                    Id.add(attributes[1]);
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return Id;
    }

    public static List<String> getUsername() {
        List<String> Username = new ArrayList<>();
        for (String path : userPath()) {
            Path pathToFile = Paths.get(path);
            try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
                String line = br.readLine();
                while (line != null) {
                    String[] attributes = line.split(",");
                    Username.add(attributes[2]);
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return Username;
    }

    public static List<String> getPassword() {
        List<String> Password = new ArrayList<>();
        for (String path : userPath()) {
            Path pathToFile = Paths.get(path);
            try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
                String line = br.readLine();
                while (line != null) {
                    String[] attributes = line.split(",");
                    Password.add(attributes[3]);
                    line = br.readLine();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return Password;
    }

    public static List<String> getUserType() {
        List<String> userType = new ArrayList<>();
        for (String path : userPath()) {
            Path pathToFile = Paths.get(path);
            try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
                String line = br.readLine();
                while (line != null) {
                    userType.add(userTypeList.get(userPath().indexOf(path)));
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return userType;
    }

    public static List<String> getClass2() {
        List<String> classList = new ArrayList<>();
        Path pathToFile = Paths.get("src/main/resources/classes/classList.csv");

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                classList.add(attributes[0]);
                line = br.readLine();
                ;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return classList;
    }

}




