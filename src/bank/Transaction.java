package bank;

public class Transaction extends Thread{
    private Card card;
    private double money;//сумма, которую мы либо кладем, либо снимаем с карты

    /**
     *
     * @param card
     * @param money - если < 0, то снимаем, а иначе пополняем
     */
    Transaction(Card card,double money){
        this.card = card;
        this.money = money;
    }

//    В этом методе либо пополняем баланс, либо снимаем с карты средства
    @Override
    public void run() {
        synchronized (card){//заблокировали карту тем объектом, который вызывает run через start
            double currentBalance = card.getBalance();//получили текущий баланс
            System.out.println("Баланс карты до транзакции составляет " + currentBalance);
            currentBalance += money;
            card.setBalance(currentBalance);//сохранили на карте изменение баланса
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var clientCard = new Card(1000);//создали карту с балансом 1000р
        var client = new Transaction(clientCard,-500);//клиент снимает средства
        var bank = new Transaction(clientCard,700);//банк пополнил баланс карты
        client.start();//клиент вызывает run и снимает 500р
        bank.start();//банк вызывает run и пополняет баланс на 700р
        client.join();//заставляем владельца карты ожидать, когда карта освободится
        bank.join();//заставляем банк ожидать, когда карта освободится
        System.out.println("Баланс карты составляет " + clientCard.getBalance());
    }
}
