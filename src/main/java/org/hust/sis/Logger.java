package org.hust.sis;

import java.util.List;

public class Logger {



//    private List<String> studentNameList;
//    private static List<String> studentNameList(DataLoader dataLoader) {
//       return dataLoader.studentNameList;
//    };



    public static String  checkLogin(String username, String password) {
        if ( DataLoader.getUsername().contains(username)) {
            if(DataLoader.getPassword().get(DataLoader.getUsername().indexOf(username)).equals(password)){
                return DataLoader.getUserType().get(DataLoader.getUsername().indexOf(username));
            }

        } return "Invalid";
    }
    public void logout(){

    }

}
