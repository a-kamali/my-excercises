package ir.maktab.Repository;

public interface UserRepository extends BaseDomainRepository {
    boolean findByUsername(String username) throws Exception;
}
