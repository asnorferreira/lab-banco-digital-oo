import java.util.Objects;

public class Client implements IClient {
	private String name;
	private String cpf;
	private String address;
	private String email;
	private String phone;

	public Client(String name, String email, String cpf, String address, String phone) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.address = address;
		this.phone = phone;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getCPF() {
		return cpf;
	}

	@Override
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Client client = (Client) o;
		return cpf.equals(client.cpf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
}
