package ir.maktab.Repository;

import ir.maktab.domain.BaseDomain;

import java.sql.SQLException;
import java.util.List;

public interface BaseDomainRepository {
    // CRUD
    // Create
        BaseDomain create(BaseDomain baseDomain);

    // Read
        BaseDomain read(int id);

    // Update
    BaseDomain update(BaseDomain baseDomain);

    // Delete
    boolean delete(int id);

    // Find
    BaseDomain findById(int id);
    List<BaseDomain> findAll();

    // CRUD
    // Create / Insert in Table
    void insert(BaseDomain baseDomain) throws SQLException;
}
