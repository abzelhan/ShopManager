package com.abzal.project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "final_transactions", schema = "public", catalog = "postgres")
public class Transaction {
    private int id;
    private Item item;
    private Cashier cashier;
    private Integer amount;
    private Date transactionTime;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id")
    public Item getItem() {
        return item;
    }

    public void setItem(Item itemId) {
        this.item = itemId;
    }

    @ManyToOne
    @JoinColumn(name = "cashier_id",referencedColumnName = "id")
    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashierId) {
        this.cashier = cashierId;
    }

    @Basic
    @Column(name = "amount", nullable = true)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "transaction_time")
    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Transient
    public int getTotalPrice(){
        return getItem().getPrice()*getAmount();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", item=" + item +
                ", cashier=" + cashier +
                ", amount=" + amount +
                ", transactionTime=" + transactionTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        if (id != that.id) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (cashier != null ? !cashier.equals(that.cashier) : that.cashier != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        return transactionTime != null ? transactionTime.equals(that.transactionTime) : that.transactionTime == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (cashier != null ? cashier.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (transactionTime != null ? transactionTime.hashCode() : 0);
        return result;
    }
}
