package SQLiteDemo;

import java.sql.*;

public class SQLiteDemo {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:src/main/resources/db/Student.db";
        try ( Connection connection = DriverManager.getConnection(url)) {
            if (connection != null) {
                System.out.println("Connect to database success");
                String sqlSelectAllCommand = "SELECT * FROM userAccount";
                Statement statement = connection.createStatement();
//                // read data from resources/classes.csv
////                then conve


                ResultSet resultSet = statement.executeQuery(sqlSelectAllCommand);
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("Id"));
                    System.out.println(resultSet.getString("Name"));
                    System.out.println(resultSet.getString("Username"));
                    System.out.println(resultSet.getString("Password"));
                    System.out.println(resultSet.getString("Role"));

//                DatabaseMetaData m = connection.getMetaData();
//                ResultSet rs = m.getTables(null, null, "%", null);
//                while (rs.next()) {
//                    System.out.println(rs.getString(3));
//                }



            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
