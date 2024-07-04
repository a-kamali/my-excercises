package ir.maktab.Repository.Implement;

import ir.maktab.Repository.BaseDomainRepository;
import ir.maktab.domain.BaseDomain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


//public abstract class BaseDomainRepositoryImpl implements BaseDomainRepositoryImpl {
//
//    protected final Connection connection;
//    public static final String INSERT_IN_TABLE_QUERY_TEMPLATE
//            = "INSERT INTO %s (%s, %s, %s) values (%s,%s,%s)";
//
//    protected BaseDomainRepositoryImpl(Connection connection) {
//        this.connection = connection;
//    }
//
//
//    // CRUD
//    // Create / Insert in Tabale
//    void insert(BaseDomain baseDomain) throws SQLException {
//        Scanner input = new Scanner(System.in);
//        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_IN_TABLE_QUERY_TEMPLATE);
//        preparedStatement.setString(1,getTableName());
//        preparedStatement.setString(2,getfirtTableColumnName());
//        preparedStatement.setString(3,getSecondTableColumnName());
//        preparedStatement.setString(4,getThirdTableColumnName());
//        preparedStatement.setString(5,getStringData());
//        preparedStatement.setString(6,getStringData());
//        preparedStatement.setString(7,getStringData());
//
//    };

    public abstract class BaseDomainRepositoryImpl implements BaseDomainRepository {

        protected final Connection connection;
        public static final String INSERT_IN_TABLE_QUERY_TEMPLATE = "INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)";

        protected BaseDomainRepositoryImpl(Connection connection) {
            this.connection = connection;
        }

        // CRUD
        // Create / Insert in Table
        @Override
        public void insert(BaseDomain baseDomain) throws SQLException {
            String tableName = getTableName();
            String firstColumnName = getFirstTableColumnName();
            String secondColumnName = getSecondTableColumnName();
            String thirdColumnName = getThirdTableColumnName();

            String query = String.format(INSERT_IN_TABLE_QUERY_TEMPLATE, tableName, firstColumnName, secondColumnName, thirdColumnName);

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, baseDomain.getFirstData());
                preparedStatement.setString(2, baseDomain.getSecondData());
                preparedStatement.setString(3, baseDomain.getThirdData());
                preparedStatement.executeUpdate();
            }
        }

        protected abstract String getTableName();
        protected abstract String getFirstTableColumnName();
        protected abstract String getSecondTableColumnName();
        protected abstract String getThirdTableColumnName();






    // Read
    BaseDomain read(int id);

    // Update
    BaseDomain update(BaseDomain baseDomain);

    // Delete
    boolean delete(int id);

    // Find
    BaseDomain findById(int id);
    List<BaseDomain> findAll();

}

