package ir.maktab;

public class Book {
    private String bookName;
    private String subject;
    private String publisher;
    private String yearPublication;
    private String dateOfBorrowed;
    private String dateOfReturned;
    private boolean borrowStatus;
    private Writer writer;

    public Book() {
    }

    public Writer getWriter() {
        return this.writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYearPublication() {
        return this.yearPublication;
    }

    public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }

    public boolean isBorrowStatus() {
        return this.borrowStatus;
    }

    public void setBorrowStatus(boolean borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public String getDateOfReturned() {
        return this.dateOfReturned;
    }

    public void setDateOfReturned(String dateOfReturned) {
        this.dateOfReturned = dateOfReturned;
    }

    public String getDateOfBorrowed() {
        return this.dateOfBorrowed;
    }

    public void setDateOfBorrowed(String dateOfBorrowed) {
        this.dateOfBorrowed = dateOfBorrowed;
    }

    public String toString() {
        return "Name of Book is:" + this.bookName + "\nBook Subject is:" + this.subject + "\n Book published by " + this.publisher + "\nIt is Published At " + this.yearPublication;
    }
}
