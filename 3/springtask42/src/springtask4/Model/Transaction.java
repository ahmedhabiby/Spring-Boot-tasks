package springtask4.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id
    private Long id;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}

