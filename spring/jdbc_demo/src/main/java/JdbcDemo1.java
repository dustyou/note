import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1. 注册驱动
        //2. 获取连接
        //3. 获取操作数据库的预处理对象
        //4. 执行SQL，得到结果
        
        //1. 注册驱动
//        DriverManager是java.sql包下的一个类，用于管理JDBC驱动程序
//                在这里，DriverManager注册了mysql中的驱动程序
//        两种方式注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());//第一种
//        Class.forName("com.mysql.jdbc.Driver");//第二种
        
        //2. 获取连接
//         使用DriverManager.getConnection()方法，提供url，username，password，建立Connection连接
        //url：数据库连接地址，
        //      组成：
        //          jdbc协议:JDBC URL中的协议总是jdbc
        //          子协议：驱动程序名或连接机制的名称的名称，如 mysql
        //          子名称：一种标识数据库的方法。必须遵循“/主机名：端口/子协议”的标准URL命名约定，如/localhost：3306/mldn
//        Connection java.sql下用于建立与特定数据库的连接，一个连接就是一个会话，
//        可用于执行SQL语句，和获得检索结果
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        
        //3. 获取操作数据库的预处理对象
//        一个Statement用于执行静态SQL语句，并获得语句执行后的结果
//                PreparedStatement是Statement的子接口，创建一个可以编译的SQL语句对象，该对象可以被运行多次，以提高运行效率
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        
        //4. 执行SQL，得到结果
//        ResultSet,java.sql下的，用于创建表示SQL检索的结果集，用户通过结果集完成对数据库的访问
        ResultSet rs = pstm.executeQuery();
        
        //5. 遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        
        //6. 释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
