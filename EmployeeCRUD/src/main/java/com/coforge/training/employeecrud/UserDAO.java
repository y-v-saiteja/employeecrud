package com.coforge.training.employeecrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private int id;
    private String name,password,email,sex,country;
  //DAO-- Data Access Object layer is used for communication with db
    public static Connection getConnection()
    {
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Training","root","teja1532");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
    
    public static List<User> getAllRecords(){
        List<User> list=new ArrayList<User>();

        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement("select * from user");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setSex(rs.getString("sex"));
                u.setCountry(rs.getString("country"));
                list.add(u);
            }
        }catch(Exception e){System.out.println(e);}
        return( list);
        }
    
        
    public static int save(User u){
        int status=0;
        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement(
    "insert into user(name,password,email,sex,country) values(?,?,?,?,?)");
            ps.setString(1,u.getName());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getEmail());
            ps.setString(4,u.getSex());
            ps.setString(5,u.getCountry());
            status=ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
    public static User getRecordById(int id){
        User u=null;
        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement("select * from user where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setSex(rs.getString("sex"));
                u.setCountry(rs.getString("country"));
            }
        }catch(Exception e){System.out.println(e);}
        return u;
    }
    public static int updateUser(User u){
        int status=0;
        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement(
    "update user set name=?,password=?,email=?,sex=?,country=? where id=?");
            ps.setString(1,u.getName());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getEmail());
            ps.setString(4,u.getSex());
            ps.setString(5,u.getCountry());
            ps.setInt(6,u.getId());
            status=ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        return status;
    }
    
    public static int deleteUser(User u){
        int status=0;
        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement("delete from user where id=?");
            ps.setInt(1,u.getId());
            status=ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}

        return status;
    }
	

}
