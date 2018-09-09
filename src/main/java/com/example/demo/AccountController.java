package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @RequestMapping("/account")
    public List<Account> account() {
        return accountRepository.findAll();
    }

    @RequestMapping("/addAccount")
    public Account addAccount(@RequestParam String name) {
        System.out.println(name);
        Account account = new Account();
        account.setName(name);
        Account result = accountRepository.insert(account);
        System.out.println(result);

        return result;
    }
}


