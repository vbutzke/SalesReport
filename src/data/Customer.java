package data;
public class Customer extends InputInformation {

	private String cnpj;
	private String activity;
	
	public Customer(int id, String responsibleName, String cnpj, String activity) {
		super(id, responsibleName);
		this.cnpj     = cnpj;
		this.activity = activity;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getActivity() {
		return activity;
	}
	
}