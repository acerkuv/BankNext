import java.util.HashMap;
import java.util.Objects;

public class Account {
    private int bill = 100;
    private int amount;
    private HashMap<Integer, Integer> customerBillAmount = new HashMap<>();
    protected Account(int amount){
        this.amount = amount;
        bill++;
        customerBillAmount.put(bill, amount);

    }

    protected void createNewBill(int amount){
        bill++;
        customerBillAmount.put(bill, amount);

    }

    public HashMap getCustomerBillAmount() {
        return customerBillAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return bill == account.bill && amount == account.amount && Objects.equals(customerBillAmount, account.customerBillAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bill, amount, customerBillAmount);
    }
}
