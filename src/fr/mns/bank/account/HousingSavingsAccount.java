package fr.mns.bank.account;

import fr.mns.bank.personne.Client;

public class HousingSavingsAccount extends Account {

    protected HousingSavingsAccount(double balance, double overdraftLimit, Client owner) {
        super(balance, overdraftLimit, owner);
    }
}
