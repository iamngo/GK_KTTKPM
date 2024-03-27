package vn.edu.iuh.fit.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Table(name = "transaction")
@Entity
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionType;
    private double amount;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
