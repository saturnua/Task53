import java.sql.*;


public class Main {
    public static Connection connection = null;
    public static String userName = "root";
    public static String password = "cthdbc1";
    public static String url = "jdbc:mysql://localhost:3306/computerstore";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,userName,password);
        if(conn != null)
            System.out.println("Connection Successful !\n");
        else
            System.exit(0);


        Statement st = conn.createStatement();
        // Результирующий запрос
        ResultSet rs = st.executeQuery("select * from manufacturer");
        // Количество колонок в результирующем запросе
        int columns = rs.getMetaData().getColumnCount();
        // Перебор строк с данными
        while(rs.next()){
            for (int i = 1; i <= columns; i++){
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        System.out.println();
        if(rs != null)
            rs.close();
        if(st != null)
            st.close();
        if(conn != null)
            conn.close();
    }
}
