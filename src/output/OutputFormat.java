package output;
public class OutputFormat {

	private int    customersQuantity;
	private int    salesmanQuantity;
	private int	   bestSaleId;
	private String needsImprovementSalesmanName;
	
	public OutputFormat() {
		
	}
	
	public OutputFormat(int customersQuantity, int salesmanQuantity, int bestSaleId, String needsImprovementSalesmanName) {
		this.customersQuantity            = customersQuantity;
		this.salesmanQuantity             = salesmanQuantity;
		this.bestSaleId 	              = bestSaleId;
		this.needsImprovementSalesmanName = needsImprovementSalesmanName;
	}

	public int getCustomersQuantity() {
		return customersQuantity;
	}

	public int getSalesmanQuantity() {
		return salesmanQuantity;
	}

	public int getBestSaleId() {
		return bestSaleId;
	}
	
	public String getNeedsImprovementSalesmanName() {
		return needsImprovementSalesmanName;
	}
	
	public void setCustomersQuantity(int customersQuantity) {
		this.customersQuantity = customersQuantity;
	}
	
	public void setSalesmanQuantity(int salesmanQuantity) {
		this.salesmanQuantity = salesmanQuantity;
	}

	public void setBestSaleId(int bestSaleId) {
		this.bestSaleId = bestSaleId;
	}

	public void setNeedsImprovementSalesmanName(String needsImprovementSalesmanName) {
		this.needsImprovementSalesmanName = needsImprovementSalesmanName;
	}

}