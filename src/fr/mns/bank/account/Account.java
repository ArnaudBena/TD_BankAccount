/**
 * JavaDoc
 */
package fr.mns.bank.account;

import fr.mns.bank.personne.Client;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Account {

    protected UUID id;
    protected String iban;
    protected double balance;
    protected double overdraftLimit;
    protected Client owner;
    protected boolean closed;
    protected LocalDate openedAt;
    protected LocalDate closedAt;

    protected Account(double balance, double overdraftLimit, Client owner) {
        this.id = UUID.randomUUID();
        this.iban = generateIban();
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
        this.owner = owner;
        this.closed = false;
        this.openedAt = LocalDate.now();
    }

    private String generateIban() {
        return "IBAN-" + UUID.randomUUID();
    }

    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public Client getOwner() {
        return owner;
    }

    public LocalDate getOpenedAt() {
        return openedAt;
    }

    public LocalDate getClosedAt() {
        return closedAt;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void transferTo(Account target, double amount) {
        this.withdraw(amount);
        target.deposit(amount);
    }

    public void closed() {
        this.closed = true;
        this.closedAt = LocalDate.now();
    }
}
