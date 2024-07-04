package ir.maktab;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Library library = new Library(10);
        Writer writer1 = new Writer();

        Book book1_1 = new Book();


        writer1.setFirstName("Ali");
        writer1.setLastName("Karimi");
        writer1.setBirthDate("Farvardin");
        writer1.setEmail("ali@gmail.com");

        book1_1.setBookName("book1_1");
        book1_1.setPublisher("Publisher1-1");
        book1_1.setSubject("Subject1-1");
        book1_1.setYearPublication("Year1-1");
        book1_1.setWriter(writer1);

        Member member1 = new Member();


        member1.setFullName("Member1");

        library.addBook(book1_1);
        System.out.println("Answer first question");
        library.searchWriterByLastName("LastName1");
        System.out.println("Answer second question");
        library.searchBookByFirstAndLastName("FirstName1", "LastName1");
        System.out.println("Answer third question");
        library.searchWriterByBookName(book1_1.getBookName());
        System.out.println("Answer forth question");
        library.borrowBook(book1_1, member1);
        library.returnBook(book1_1);
        library.calculateFee(book1_1);
        System.out.println("Answer fifth question");

    }
}
