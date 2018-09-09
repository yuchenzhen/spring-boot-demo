package com.example.demo;

// import com.mongodb.WriteResult;
// import com.mongodb.client.result.UpdateResult;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.bson.types.ObjectId;

//Impl postfix of the name on it compared to the core repository interface
@Component
public class AccountDaoImpl implements AccountDao {

  @Resource
  private MongoTemplate mongoTemplate;

  @Override
  public void saveAccount(Account account) {
    mongoTemplate.save(account);
  }

  @Override
  public void removeAccount(ObjectId id) {
    mongoTemplate.remove(id);
  }

  @Override
  public void updateAccount(Account account) {
    Query query = new Query(Criteria.where("_id").is(account.getId()));

    Update update = new Update();
    update.set("realName", account.getName());

    mongoTemplate.updateFirst(query, update, Account.class);
  }

  @Override
  public Account findAccountById(ObjectId id) {
    Query query = new Query(Criteria.where("id").is(id));
    Account account = mongoTemplate.findOne(query, Account.class);
    return account;
  }

  @Override
  public Account findAccountByName(String realName) {
    Query query = new Query(Criteria.where("realName").is(realName));
    Account account = mongoTemplate.findOne(query, Account.class);
    return account;
  }
}
