import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IClient c1 = new Client("John Doe", "123.456.789-00", "123 Main St", "john@example.com", "(555) 123-4567");
        IClient c2 = new Client("Jane Smith", "987.654.321-00", "456 Elm St", "jane@example.com", "(555) 987-6543");

        List<IAccount> accounts = new ArrayList<>();
        accounts.add(new Account("123456", 19500.0, c1));
        accounts.add(new Account("789012", 25000.0, c2));

        accounts.get(0).deposit(590.0);
        accounts.get(1).deposit(350.0);

        System.out.println("Total balance for " + c1.getName() + ": " + Account.getTotalBalanceClient(c1, accounts));

        List<ITransaction> t = new ArrayList<>();
        t.add(new Transaction(100.0, TransactionType.DEPOSIT, "Deposit to account 123456"));
        t.add(new Transaction(50.0, TransactionType.WITHDRAWAL, "Withdrawal from account 789012"));

        List<ITransaction> recentTransactions = Transaction.getRecentTransactions(t);
        System.out.println("Recent transactions:");
        for (ITransaction transaction : recentTransactions) {
            System.out.println(transaction.getDescription() + ": $" + transaction.getAmount());
        }
    }
}
