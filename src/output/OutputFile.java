package output;
public class OutputFile {

	private OutputFormat format;
	private String       content;
	
	public OutputFile() {
		format = new OutputFormat();
	}
	
	public OutputFile(int customersQuantity, int salesmanQuantity, int bestSaleId, String needsImprovementSalesmanName) {
		format  = new OutputFormat(customersQuantity, salesmanQuantity, bestSaleId, needsImprovementSalesmanName);
		content = createContent();
	}

	public OutputFormat getFormat() {
		return format;
	}

	public String getContent() {
		return content;
	}

	public String createContent() {
		
		String information = System.lineSeparator()+"1. Quantidade de Clientes: "+format.getCustomersQuantity()+
							 System.lineSeparator()+"2. Quantidade de Vendedores: "+format.getSalesmanQuantity()+
							 System.lineSeparator()+"3. ID da Venda de valor mais alto: "+format.getBestSaleId()+
							 System.lineSeparator()+"4. Nome do Vendedor que menos vendeu: "+format.getNeedsImprovementSalesmanName();
		return information;
	}

	public void setFormat(OutputFormat format) {
		this.format = format;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
