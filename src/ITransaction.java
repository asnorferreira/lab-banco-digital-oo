import java.time.LocalDateTime;

public interface ITransaction {
    double getAmount();

    void setAmount(double amout);

    LocalDateTime getTimestamp();

    void setTimestamp(LocalDateTime timestamp);

    TransactionType getType();

    void setType(TransactionType type);

    String getDescription();

    void setDescription(String description);
}
