package ir.maktab.repository;

    import ir.maktab.entity.BankAccount;

    import java.sql.SQLException;

public interface BankAccountRepository {

    void save(BankAccount bankAccount) throws SQLException;
    BankAccount findByAccountNumber(String accountNumber) throws SQLException;


}
