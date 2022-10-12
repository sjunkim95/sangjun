package edu.java.contact.ver06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static edu.java.contact.ver06.OracleConnection.*;
import static edu.java.contact.ver06.ContactSql.*;
import static edu.java.contact.ver06.Contact.Entity.*;

import oracle.jdbc.driver.OracleDriver;


public class ContactDaoImpl implements ContactDao {

    // Singleton 적용
    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {}
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        return instance;
    }
    
    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    private void closeResources(Connection conn, Statement stmt) throws SQLException {
        stmt.close();
        conn.close();
    }
    
    private void closeResources(Connection conn, Statement stmt, ResultSet rs) 
            throws SQLException {
        rs.close();
        closeResources(conn, stmt);
    }
    
    @Override
    public List<Contact> read() {
        List<Contact> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            
            System.out.println(SQL_SELECT_ALL);
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery(); // SQL 문장 실행

            while (rs.next()) {
                Integer CID = rs.getInt(COL_CID);
                String NAME = rs.getString(COL_NAME);
                String PHONE = rs.getString(COL_PHONE);
                String EMAIL = rs.getString(COL_EMAIL);
               
                Contact contact = new Contact(CID, NAME, PHONE, EMAIL);
                list.add(contact);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }

    @Override
    public Contact read(Integer cid) {
        Contact contact = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = getConnection();
            
            System.out.println(SQL_SELECT_BY_CID);
            stmt = conn.prepareStatement(SQL_SELECT_BY_CID);
            rs = stmt.executeQuery(); // SQL 문장 실행

            if (rs.next()) {
                Integer CID = rs.getInt(COL_CID);
                String NAME = rs.getString(COL_NAME);
                String PHONE = rs.getString(COL_PHONE);
                String EMAIL = rs.getString(COL_EMAIL);
               
                contact = new Contact(CID, NAME, PHONE, EMAIL);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return contact;
    }

    @Override
    public int create(Contact contact) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            System.out.println(SQL_CREATE);
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int update(Contact contact) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = getConnection();
            System.out.println(SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }

    @Override
    public int delete(Integer cid) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            
            conn = getConnection();
            System.out.println(SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cid);
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                closeResources(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }

}
