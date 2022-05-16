package all.util;

import java.sql.*;

public class DBUtil {
    private static final String URL="jdbc:mysql://localhost:3306/架构_name?characterEncoding=utf-8";
    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String URSERNAME ="root";
    private static final String PASSWORD = "020905Lyt...";

    public static Connection getConnection(){
        Connection connection=null;
        try{
           Class.forName(DRIVER);
           connection=DriverManager.getConnection(URL,URSERNAME,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet=null;
        }
        if (preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preparedStatement=null;
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection=null;
        }
    }
}
