package vn.edu.iuh.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
