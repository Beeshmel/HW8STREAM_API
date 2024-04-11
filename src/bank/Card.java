package bank;

public class Card {
    private double balance;

    public Card(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance > 0){
            this.balance = balance;
            System.out.println("После транзакции баланс карты составляет: " + balance);
        }else
            System.out.println("Баланс не может быть отрицательным!");
    }
}
