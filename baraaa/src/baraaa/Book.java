/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baraaa;

import java.io.Serializable;


public class Book implements Serializable{
   private String bookName;
   private int bookID;
   private String bookGategory;
    
    private String bookAuthor;
    private String bookPublisher;
    private String bookeditition;
    private double bookprice;
    private int bookQu;

    public Book() {
        
        
        
        
    }

    public Book(String bookName, int bookID, String bookGategory, String bookAuthor, String bookPublisher, String bookeditition, double bookprice, int bookQu) {
        this.bookName = bookName;
        this.bookID = bookID;
        this.bookGategory = bookGategory;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookeditition = bookeditition;
        this.bookprice = bookprice;
        this.bookQu = bookQu;
      
        
    }

    Book(String bookID, String bookName, String bookCategory, Auther author, String bookPublisher, int bookEditionYear, double bookPrice, int bookQuantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookGategory() {
        return bookGategory;
    }

    public void setBookGategory(String bookGategory) {
        this.bookGategory = bookGategory;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookeditition() {
        return bookeditition;
    }

    public void setBookeditition(String bookeditition) {
        this.bookeditition = bookeditition;
    }

    public double getBookprice() {
        return bookprice;
    }

    public void setBookprice(double bookprice) {
        this.bookprice = bookprice;
    }

    public int getBookQu() {
        return bookQu;
    }

    public void setBookQu(int bookQu) {
        this.bookQu = bookQu;
    }


    @Override
    public String toString() {
        return "Book{" + "bookName: " + bookName + ", bookID: " + bookID + ", bookGategory: " + bookGategory + ", bookAuthor: " + bookAuthor + ", bookPublisher: " + bookPublisher + ", bookeditition: " + bookeditition + ", bookprice: " + bookprice + ", bookQu: " + bookQu + '}';
    }

}
