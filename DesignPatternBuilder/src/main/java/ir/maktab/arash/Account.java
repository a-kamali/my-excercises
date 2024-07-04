package ir.maktab.arash;

public class Account {

    String accountNumber;
    String accountName;
    String dateOfJoin;
    String accountStatus;

    public Account(String accountNumber, String accountName, String dateOfJoin, String accountStatus) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.dateOfJoin = dateOfJoin;
        this.accountStatus = accountStatus;
    }
    static AccountBuilder builder(){
        return new AccountBuilder();
    }

    static class AccountBuilder {
        String accountNumber;
        String accountName;
        String dateOfJoin;
        String accountStatus;

        public AccountBuilder accountName (String accountName){
            this.accountName = accountName;
            return this;
        }
        public AccountBuilder accountNumber (String accountNumber){
            this.accountNumber = accountNumber;
            return this;
        }
        public AccountBuilder dateOfJoin (String dateOfJoin){
            this.dateOfJoin = dateOfJoin;
            return this;
        }
        public AccountBuilder accountStatus (String accountStatus){
            this.accountStatus = accountStatus;
            return this;
        }
        public Account build(){
            return new Account(accountNumber, accountName, dateOfJoin, accountStatus);
        }


    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", dateOfJoin='" + dateOfJoin + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}
