package text11;

import java.sql.*;

public class JBDCTest {
    public static void main(String[] args) {
        String uri = "jdbc:mysql://localhost:3306/students?useSSL=true";
        String user = "test";
        String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(uri,user,password);
            Statement sql = con.createStatement();
            ResultSet rs = sql.executeQuery("select * from mess order by birthday asc");
            int column = rs.getMetaData().getColumnCount();
            while (rs.next()){
                for (int i = 1;i <= column;i++){
                    System.out.print(rs.getObject(i)+"\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
