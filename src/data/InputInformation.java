package data;
public class InputInformation {

	private int    id;
	private String responsibleName;
	
	public InputInformation(int id, String responsibleName) {
		this.id 			 = id;
		this.responsibleName = responsibleName;
	}

	public int getId() {
		return id;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

}