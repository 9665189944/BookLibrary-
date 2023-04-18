package Demo;

import DAO.BookDAO;
import DTO.BookDTO;

import java.util.List;
import java.util.Scanner;

public class BookPresentation {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Select mode of Operation");
        System.out.println("1:Add New Book");
        System.out.println("2:Delete Book");
        System.out.println("3:View Books");

        int choice=sc.nextInt();

        switch (choice)
        {
            case 1: addBooks();
                  break;
            case 2: deleteBooks();
                break;
            case 3 : viewBooks();
                break;
            default:
                System.out.println("Invalid Choice");
        }

    }

    private static void viewBooks() {
        BookDAO b1=new BookDAO();
        b1.viewBook();

    }

    private static void deleteBooks() {

        System.out.println("Enter Book Id");
        int id=sc.nextInt();
        BookDTO d1=new BookDTO();
        d1.setBookId(id);
        BookDAO b2=new BookDAO();
         int count= b2.deleteBook(d1);
        System.out.println(count+"delete Record Successfully");
    }

    private  static void  addBooks()
    {
        System.out.println("Enter Book Id");
        int id=sc.nextInt();
        System.out.println("Enter Book Name");
        String name=sc.next();
        System.out.println("Enter Book Price");
        double price=sc.nextDouble();

        //Add data into dto object
        BookDTO d1=new BookDTO();
        d1.setBookId(id);
        d1.setBookName(name);
        d1.setBookPrice(price);
        //call Method from DAO class

        BookDAO b1=new BookDAO();
        int count=b1.insertBook(d1);
        System.out.println(count+"Insert Record Successfully");


    }


}
