package com.fengfeiyang.week4.demo;
import java.sql.Statement;
import java.util.ArrayList;
import com.fengfeiyang.week4.demo.JDBCDemoServlet;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GetPostDao
{
    public  List<student> selectAll() {//extends f{//查询所有
    List<student> list =new ArrayList<student>();
    JDBCDemoServlet dbno=new JDBCDemoServlet();
    if(dbno.con!=null) {
        try{
            String sql="select * from userdb";
            Statement stmt = dbno.con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                student r =new student();
                r.setId(rs.getInt("ID"));
                r.setUsername(rs.getString("username"));
                r.setPassword(rs.getString("password"));

                r.setEmail(rs.getString("email"));
                r.setGender(rs.getString("gender"));
                r.setDate(rs.getString("date"));


                list.add(r);
            }

            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    return list;
}
}
