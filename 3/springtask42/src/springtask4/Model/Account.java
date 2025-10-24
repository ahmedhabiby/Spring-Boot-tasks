package springtask4.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
    @Id
    private Long id;
    private String accountNumber;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}

