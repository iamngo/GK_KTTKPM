package vn.edu.iuh.fit.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.Account;
import vn.edu.iuh.fit.entity.Transaction;
import vn.edu.iuh.fit.repository.AccountRepository;
import vn.edu.iuh.fit.repository.TransactionRepository;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void withDrawMoney(Account account, double amount){
        if(account.getBalance()-50000>=amount){
            account.setBalance(account.getBalance()-amount);
            accountRepository.save(account);

            Transaction transaction = new Transaction();
            transaction.setAccount(account);
            transaction.setAmount(amount);
            transaction.setTransactionType("Withdraw");
            transaction.setDate(Date.valueOf(LocalDate.now()));
            transactionRepository.save(transaction);
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }
}
