package ir.maktab.service.transactionService;

import ir.maktab.config.DataSource;
import ir.maktab.entity.Account;
import ir.maktab.repository.transactionRepository.transactionRepository;
import ir.maktab.service.accountService.AccountService;
import ir.maktab.service.cardService.CardService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionServiceImpl implements TransactionService {
    private final transactionRepository transactionRepository;
    private final AccountService accountService;
    private final CardService cardService;
    private final DataSource dataSource;


    public TransactionServiceImpl(transactionRepository transactionRepository,
                                  AccountService accountService,
                                  CardService cardService,
                                  DataSource dataSource) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.cardService = cardService;
        this.dataSource = dataSource;
    }

    @Override
    public void createTransaction(Integer originAccount_id, Integer destinationAccount_id, Double amount) {
        if(originAccount_id==null || destinationAccount_id==null || amount==null){
            try {
                transactionRepository.create(originAccount_id, destinationAccount_id, amount);

            } catch (SQLException e) {
                System.out.println("You entered the wrong parameters");
            } {
                System.out.println("You entered the Null parameters");
            }
        }
    }
    @Override
    public void transferAndCreateTransaction(int OrgingBankCard,int DestinationBankCard,Double money) throws SQLException {
        Connection connection = null;
        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            int orginAccountID =cardService.findCardByCardNumber(OrgingBankCard).getId();
            int destinationAccountID = cardService.findCardByCardNumber(DestinationBankCard).getId();
            if(accountService.findBalance(orginAccountID) < money ){
                throw new RuntimeException("Money is more than Origin Balance");
            }
            accountService.updateBalance(orginAccountID,-money);
            accountService.updateBalance(destinationAccountID,money);
            createTransaction(orginAccountID,destinationAccountID,money);
            connection.commit();
        }catch (SQLException e){
            if(connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            if(connection!= null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }


        }
    }

