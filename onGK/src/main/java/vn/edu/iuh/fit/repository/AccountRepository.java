package vn.edu.iuh.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {
}
