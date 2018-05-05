package data;
public class Salesman extends InputInformation {

	private String cpf;
	private double remuneration;
	
	public Salesman(int id, String responsibleName, String cpf, double remuneration) {
		super(id, responsibleName);
		this.cpf          = cpf;
		this.remuneration = remuneration;
	}

	public String getCpf() {
		return cpf;
	}

	public double getRemuneration() {
		return remuneration;
	}
	
}
