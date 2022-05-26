import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Цетральное хранилище данных
        HashMap<Customer, Account> bank = new HashMap<>();

        //Первый клиент банка и его счета
        Customer customer = new Customer("Ivan", 32);
        Account account = new Account(30);
        // Добавляем еще один счет
        account.createNewBill(50);

        // Помещаем данные по клиенту в хранилище
        bank.put(customer, account);

        // Второй клиент имеет один счет
        Customer customer1 = new Customer("Piter", 45);
        Account account1 = new Account(99);
        bank.put(customer1, account1);

        // Поиск по имени
        String findByName = "Piter";

        boolean customFound = bank.containsKey(customer);
        bank.forEach((key, value) -> {
            if (key.getName().equals(findByName)) {
                System.out.println(key.getName() + " " +
                        value.getCustomerBillAmount().toString());
            }
        });


        // Поиск по номеру счета
        int findBill = 101;

        for (Map.Entry<Customer, Account> entry : bank.entrySet()) {
            HashMap<Integer, Integer> temp = entry.getValue().getCustomerBillAmount();
            if (temp.containsKey(findBill)) {
                System.out.println(entry.getKey().getName());
            }
        }

        // Второй вариант обхода поиска по имени в цикле for each
        String findByName2 = "Ivan";
        bank.forEach((key, value) -> {
            if (key.getName().equals(findByName2)) {
                System.out.println(key.getName() + " " + value.getCustomerBillAmount().toString());

            }
        });

    }

}


