package ir.maktab.service.transactionService;

import java.sql.SQLException;

public interface TransactionService {
    void createTransaction(Integer originAccount_id, Integer destinationAccount_id, Double amount);
    void transferAndCreateTransaction(int OrgingBankCard,int DestinationBankCard,Double money) throws SQLException;

}
