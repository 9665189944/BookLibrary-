package DAO;

import DTO.BookDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookDAO {


    static Connection con=null;


    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8","root","Akhil@01999");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertBook(BookDTO d1)
    {
         PreparedStatement pstmt=null;
        int count=0;
        String query="insert into book_info values(?,?,?)";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,d1.getBookId());
            pstmt.setString(2,d1.getBookName());
            pstmt.setDouble(3,d1.getBookPrice());
            count=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int deleteBook(BookDTO d1)
    {
        PreparedStatement pstmt=null;
        int count=0;
        String query="delete from book_info where Book_ID=?";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,d1.getBookId());
            count=pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }


    public ArrayList<BookDTO> viewBook() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "select * from book_info";
        ArrayList <BookDTO> data;
        try {
          data=new ArrayList<>();
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            System.out.println("Book Details");
            while (rs.next()) {
                BookDTO Book=new BookDTO();
                Book.setBookId( rs.getInt("Book_ID"));
                Book.setBookName(rs.getString("Book_Name"));
                Book.setBookPrice(rs.getDouble("Book_Price"));
                data.add(Book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  data;
    }




}
