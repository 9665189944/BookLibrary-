package DAO;

import DTO.BookDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookDAO {

   BookDTO b;
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


    public void viewBook() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "select * from book_info";
        List <BookDTO> data;
        try {
          data=new ArrayList<>();
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            System.out.println("Book Details");
            while (rs.next()) {
                //BookDTO Book = new BookDTO();
                b.setBookId(rs.getInt("Book_ID"));
                b.setBookName(rs.getString("Book_Name"));
                b.setBookPrice(rs.getDouble("Book_Price"));
                data.add(b);
            }
            for (BookDTO data1:data) {
                System.out.println(data1.getBookId()+"\t"+data1.getBookName()+"\t"+ data1.getBookPrice());
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
