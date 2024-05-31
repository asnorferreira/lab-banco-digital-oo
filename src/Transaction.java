import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class Transaction implements ITransaction {
	private double amount;
	private LocalDateTime timestamp;
	private TransactionType type;
	private String description;

	public Transaction(double amount, TransactionType type, String description) {
		this.amount = amount;
		this.timestamp = LocalDateTime.now();
		this.type = type;
		this.description = description;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	@Override
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public TransactionType getType() {
		return type;
	}

	@Override
	public void setType(TransactionType type) {
		this.type = type;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	public static List<ITransaction> getRecentTransactions(List<ITransaction> transactions) {
		LocalDateTime thirtyDaysAgo = LocalDateTime.now().minus(30, ChronoUnit.DAYS);
		return transactions.stream()
				.filter(transaction -> transaction.getTimestamp()
						.isAfter(thirtyDaysAgo))
				.collect(Collectors.toList());
	}
}
