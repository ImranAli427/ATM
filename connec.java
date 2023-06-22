package ATM_management;

import java.sql.*;
public class connec {
//    for connection
    Connection c;
//    for statement
    Statement s;
    connec(){
        try{
            //1.generate the driver
           // Class.forName("com.mysql.cj.jdbc.Driver");
            //2.create connection
            c = DriverManager.getConnection("jdbc:mysql:///bankATM","root","imran9081");
            //3.create statement
            s = c.createStatement();


        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
