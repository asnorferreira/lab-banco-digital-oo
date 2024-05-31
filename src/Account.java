import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account implements IAccount {
	private String accountNumber;
	private double balance;
	private IClient owner;
	private List<ITransaction> transactions;

	public Account(String accountNumber, double balance, IClient owner) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.owner = owner;
		this.transactions = new ArrayList<>();
	}

	@Override
	public String getAccountNumber() {
		return accountNumber;
	}

	@Override
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public IClient getOwner() {
		return owner;
	}

	@Override
	public void setOwner(IClient owner) {
		this.owner = owner;
	}

	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		if (balance >= 0) {
			this.balance -= amount;
		} else {
			System.out.println("Insufficiente funds!");
		}
	}

	@Override
	public void transfer(double amount, IAccount destinationAccount) {
		if (balance >= amount) {
			this.withdraw(amount);
			destinationAccount.deposit(amount);
		} else {
			System.out.println("Insufficiente funds!");
		}
	}

	@Override
	public List<ITransaction> getTransactions() {
		return transactions;
	}

	@Override
	public void addTransaction(ITransaction transaction) {
		this.transactions.add(transaction);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Account account = (Account) o;
		return accountNumber.equals(account.accountNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber);
	}

	public static double getTotalBalanceClient(IClient client, List<? extends IAccount> accounts) {
		return accounts.stream()
				.filter(account -> account.getOwner().equals(client))
				.mapToDouble(IAccount::getBalance)
				.sum();
	}
}
