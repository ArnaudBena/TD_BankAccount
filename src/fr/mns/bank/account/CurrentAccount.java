package fr.mns.bank.account;

import fr.mns.bank.personne.Client;

public class CurrentAccount extends Account {
    public CurrentAccount(double balance, Client owner) {
        super(balance, -1000, owner);
    }

    @Override
    public void withdraw(double amount) {
        double gap = balance - amount;
        if (gap < overdraftLimit) {
            this.balance -= amount;
        } else {
            System.out.println("Découvert autorisé dépassé. Solde insufisant.");
        }
    }
}
