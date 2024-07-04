package ir.maktab.service.accountService;

import ir.maktab.entity.Account;

public interface AccountService {

    Account findByShebaNumber(Integer shebaNumber);
    Double findBalance(Integer accountID)
    boolean updateBalance(Integer accountID,Double balance);
}
