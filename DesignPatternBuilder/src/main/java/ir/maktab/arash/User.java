package ir.maktab.arash;
import lombok.*;


@Builder
@ToString

public class User {
    public String name;
    public int age;
    public String gender;
    public String dateOfBirth;
}
