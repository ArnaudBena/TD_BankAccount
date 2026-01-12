package fr.mns.bank.account;

import fr.mns.bank.personne.Client;

public class SavingsAccount extends Account implements InterestBearing {

    private static final double INTERESTRATE = 1.02; // taux d'intêret de 2%

    protected SavingsAccount(double balance, Client owner) {
        super(balance, 0, owner);
    }
    @Override
    public void withdraw(double amount) {
        double gap = balance - amount;
        if (gap >= overdraftLimit) {
            this.balance -= amount;
        } else {
            System.out.println("Vous n'avez pas le droit au découvert sur ce compte");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * INTERESTRATE;
    }

    private void addInterest() {
        balance += calculateInterest();
    }
}
