package vn.edu.iuh.fit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entity.Account;
import vn.edu.iuh.fit.repository.AccountRepository;
import vn.edu.iuh.fit.service.TransactionService;

import java.util.Optional;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    @GetMapping("/withdraw")
    public String showWithdraw(){
        return "withdraw";
    }
    @PostMapping("/withdraw/new")
    public ResponseEntity<?> withDrawMoney (@RequestParam Long accountId, @RequestParam double amount){
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if(optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            transactionService.withDrawMoney(account,amount);
            return ResponseEntity.ok("Money withdraw successfully");
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
