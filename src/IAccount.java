import java.util.List;

public interface IAccount {
	String getAccountNumber();

	void setAccountNumber(String accountNumber);

	double getBalance();

	void setBalance(double balance);

	IClient getOwner();

	void setOwner(IClient owner);

	void deposit(double amount);

	void withdraw(double amount);

	void transfer(double amount, IAccount destinationAccount);

	List<ITransaction> getTransactions();

	void addTransaction(ITransaction transaction);
}
