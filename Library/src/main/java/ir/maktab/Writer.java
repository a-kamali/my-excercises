package ir.maktab;

public class Writer {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;
    StringBuilder books;

    public void setBooks(String book) {
        this.books.append(book);
    }

    public Writer() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "writer Name is :" + this.firstName + " " + this.lastName + "\nHe/She Birthed At:" + this.birthDate + "\n Her/His Email is " + this.email + "\n";
    }
}

