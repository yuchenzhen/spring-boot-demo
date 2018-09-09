package com.example.demo;
import org.bson.types.ObjectId;

public interface AccountDao {

  void saveAccount(Account account);

  void removeAccount(ObjectId id);

  void updateAccount(Account account);

  Account findAccountById(ObjectId id);

  Account findAccountByName(String realName);
}
