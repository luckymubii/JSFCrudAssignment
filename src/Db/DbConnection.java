package Db;

import java.sql.*;

/**
 * Created by fawad.tariq on 9/26/2019.
 */
public class DbConnection {
    private String dbURL = "jdbc:mysql://localhost:3306/jsfcrud";
    private String username = "root";
    private String password = "";
    private Connection connection;
    public DbConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL,username,password);
            if(connection!=null){
                System.out.println("Success");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(String date,int nightStay,int adults,int children,String roomType,String bedType,String smoking,String name,String email,String phone){
        try {
            String sqlQuery = "INSERT INTO reservations(date,nightStay,adults,children,roomType,bedType,smoking,name,email,phone) VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            java.sql.Date datee=Date.valueOf(date);//converting string into sql date 2012-11-28
            System.out.println(datee);
            preparedStatement.setDate(1, datee);
            preparedStatement.setInt(2, nightStay);
            preparedStatement.setInt(3, adults);
            preparedStatement.setInt(4, children);

            preparedStatement.setString(5, roomType);
            preparedStatement.setString(6, bedType);
            preparedStatement.setString(7, smoking);
            preparedStatement.setString(8, name);
            preparedStatement.setString(9, email);
            preparedStatement.setString(10, phone);

            int noOfRowsInserted = preparedStatement.executeUpdate();
            if(noOfRowsInserted>0){
                System.out.println(noOfRowsInserted + " rows inserted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getRecords(){
        try {
            String sqlQuery = "SELECT * FROM reservations";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlQuery);
         return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void deleteRecord(int id){
        try {
            String sqlQuery = "DELETE from reservations WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getRecord(int id){
        try {
            String sqlQuery = "SELECT * FROM reservations where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateRecord(int id,String date,int nightStay,int adults,int children,String roomType,String bedType,String smoking,String name,String email,String phone){
        try {


        //    date,nightStay,adults,children,roomType,bedType,smoking,name,email,phone

            String sqlQuery = "UPDATE reservations SET date=?,nightStay=?,adults=?,children=?,roomType=?,bedType=?,smoking=?,name=?,email=?,phone=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            java.sql.Date datee=Date.valueOf(date);//converting string into sql date 2012-11-28
            System.out.println(datee);
            preparedStatement.setDate(1, datee);
            preparedStatement.setInt(2, nightStay);
            preparedStatement.setInt(3, adults);
            preparedStatement.setInt(4, children);
            preparedStatement.setString(5, roomType);
            preparedStatement.setString(6, bedType);
            preparedStatement.setString(7, smoking);
            preparedStatement.setString(8, name);
            preparedStatement.setString(9, email);
            preparedStatement.setString(10, phone);
            preparedStatement.setInt(11,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
