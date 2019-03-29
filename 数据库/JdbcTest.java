import java.sql.*;
public class JdbcTest {
public static Connection getConn(){
    //旧版本，路径是"com.mysql.jdbc.Driver"，新版本如下
    String driver="com.mysql.cj.jdbc.Driver";
    //数据库student
    //表students
    String url="jdbc:mysql://localhost:3306/student?"+"user=root&password=*****&useUnicode=true&characterEncoding=UTF8&"+
            "serverTimezone=GMT%2B8&useSSL=false";
    Connection conn=null;
    PreparedStatement statement=null;
    ResultSet result=null;
    try{
        Class.forName(driver);
        System.out.println("成功加载驱动");
        conn=DriverManager.getConnection(url);
        String sql="SELECT * FROM students WHERE Sno='2016141411122'";
        statement=conn.prepareStatement(sql);
        result=statement.executeQuery(sql);

        while (result.next()){
            String name=result.getString("Sname");
            String sex=result.getString("Sex");
            String dept=result.getString("Sdept");
            System.out.println(name+"\t"+sex+"\t"+dept);
        }

    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }catch (SQLException e){
        e.printStackTrace();
    }
    //剩下一定要捕获异常，否则bug发现不了很难受
    catch(Exception e){
    e.printStackTrace();
    }
    finally {

    }
    return conn;
}
public static void main(String []args){
    JdbcTest.getConn();
}
}
