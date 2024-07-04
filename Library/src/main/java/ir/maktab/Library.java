package ir.maktab;

import java.util.Scanner;


import java.util.Scanner;

public class Library {
    Scanner input;
    private int maxBooks;
    private String borrowDate;
    private String returnDate;
    private int numBooks;
    private Book[] books;

    public Library(int maxBooks) {
        this.input = new Scanner(System.in);
        this.books = new Book[maxBooks];
        this.numBooks = 0;
        this.maxBooks = maxBooks;
    }

    public void addBook(Book book) {
        if (this.numBooks < this.books.length) {
            this.books[this.numBooks] = book;
            ++this.numBooks;
        } else {
            System.out.println("Library is Full");
        }

    }

    public void searchWriterByLastName(String lastName) {
        String[] output = new String[this.maxBooks];
        int count = 0;

        for(int i = 0; i < this.numBooks; ++i) {
            if (this.books[i].getWriter().getLastName().equals(lastName)) {
                String var10000 = this.books[i].getWriter().getFirstName();
                String fullname = var10000 + " " + this.books[i].getWriter().getLastName();
                if (!check(output, fullname)) {
                    output[count] = fullname;
                    ++count;
                }
            }
        }

        printArray(output);
    }

    private static boolean check(String[] array, String output) {
        boolean answer = false;
        String[] var3 = array;
        int var4 = array.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String element = var3[var5];
            if (element != null && element.equals(output)) {
                answer = true;
                break;
            }
        }

        return answer;
    }

    private static void printArray(String[] array) {
        String[] var1 = array;
        int var2 = array.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String string = var1[var3];
            if (string != null) {
                System.out.println(string);
            }
        }

    }

    public void searchBookByFirstAndLastName(String firstName, String lastName) {
        String[] output = new String[this.maxBooks];
        int count = 0;

        for(int i = 0; i < this.numBooks; ++i) {
            if (this.books[i].getWriter().getLastName().equals(lastName) && this.books[i].getWriter().getFirstName().equals(firstName) && !check(output, this.books[i].getBookName())) {
                output[count] = this.books[i].getBookName();
                ++count;
            }
        }

        printArray(output);
    }

    public void searchWriterByBookName(String bookName) {
        for(int i = 0; i < this.numBooks; ++i) {
            if (this.books[i].getBookName().equals(bookName)) {
                System.out.println(this.books[i].toString());
            }
        }

    }

    public void borrowBook(Book book, Member member) {
        if (member.getCountOfBorrowed() <= 2) {
            System.out.println("Borrow Date");
            System.out.print("Please Enter Borrow Date In this format year-month-day ");
            this.borrowDate = this.input.next();
            book.setDateOfBorrowed(this.borrowDate);
            book.setBorrowStatus(true);
            ++member.countOfBorrowed;
        } else {
            System.out.println("You borrow More Than two book");
        }

    }

    public void returnBook(Book book) {
        System.out.println("Return Date");
        System.out.print("Please Enter Return Date In this format year-month-day ");
        this.returnDate = this.input.next();
        book.setDateOfReturned(this.returnDate);
        book.setBorrowStatus(false);
    }

    public void calculateFee(Book book) {
        String[] dateOfBorrowed = book.getDateOfBorrowed().split("-", 3);
        String[] dateOfreturn = book.getDateOfReturned().split("-", 3);
        int delay = (Integer.parseInt(dateOfreturn[0]) - Integer.parseInt(dateOfBorrowed[0])) * 365 + (Integer.parseInt(dateOfreturn[1]) - Integer.parseInt(dateOfBorrowed[1])) * 31 + (Integer.parseInt(dateOfreturn[2]) - Integer.parseInt(dateOfBorrowed[2]));
        if (delay > 7) {
            System.out.println("He/She must pay: " + (delay - 7) * 1000);
        }

        book.setDateOfBorrowed("");
        book.setDateOfBorrowed("");
    }

    public void canBorrow(Member member) {
        if (member.getCountOfBorrowed() < 2) {
            System.out.println("You Can Borrow Book");
        } else {
            System.out.println("You Can not Borrow Book");
        }

    }
}
