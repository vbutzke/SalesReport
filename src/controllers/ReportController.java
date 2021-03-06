package controllers;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import data.*;
import output.*;

public class ReportController {
	
	private static String parser = ";";
	private static String inputDirectory = "dados/in/";
	private static String inputExtension = ".dat";
	private static String outputDirectory = "dados/out/";
	private static String outputExtension = ".proc";
	
	public void readMultipleFiles() {
		File file = new File(inputDirectory);
		String [] fileList = file.list();

		for(String fileName : fileList){
		    if(fileName.endsWith(inputExtension)){
		    	processFile(fileName);
		    }
		}
	}
	
	public void processFile(String fileName) {
		OutputFile output = new OutputFile();
		output.setFormat(readFile(inputDirectory+fileName));
		output.setContent(output.createContent());
		writeFile(output, fileName+outputExtension);
	}
	
	public OutputFormat readFile(String fileName) {
		OutputFormat output	  = new OutputFormat();
		int customersQuantity = 0;
		int salesmanQuantity  = 0;
		int bestSaleId		  = 0;
		int id 				  = 0;
		double price 		  = 0.0;
		double worstSale	  = 99999999999999999999999999999999999999999999999.99;
		String line 		  = "";
		String salesmanName   = "";
		String needsImprovementSalesmanName = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while((line = reader.readLine()) != null) {
				String[] contents = line.split(parser);
				switch(Integer.parseInt(contents[0])) {
					case 1:
						salesmanQuantity++;
						break;
					case 2:
						customersQuantity++;
						break;
					case 3:
						Sales sales  = new Sales(Integer.parseInt(contents[0]), 
												 contents[5], 
												 Integer.parseInt(contents[1]), 
												 Integer.parseInt(contents[2]), 
												 Integer.parseInt(contents[3]), 
												 Double.parseDouble(contents[4]));
						price        = greatest(price, sales.getItemPrice());
						id           = greatestSaleId(price, sales.getItemPrice(), id, sales.getItemId());
						worstSale    = lowest(worstSale, sales.getItemPrice());
						salesmanName = needsImprovementSalesmanName(worstSale, sales.getItemPrice(), salesmanName, sales.getResponsibleName());
						break;
				}
				
				bestSaleId = id;
				needsImprovementSalesmanName = salesmanName;
			}
			
			reader.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("Not possible to read file, file not found. \n"+e);
		} catch(IOException i) {
			System.out.println("Trouble closing file. \n"+i);
		}
		
		output.setCustomersQuantity(customersQuantity);
		output.setSalesmanQuantity(salesmanQuantity);
		output.setBestSaleId(bestSaleId);
		output.setNeedsImprovementSalesmanName(needsImprovementSalesmanName);
		
		return output;
	}
	
	public void writeFile(OutputFile file, String fileName) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputDirectory+fileName));
			writer.write(file.getContent());
			writer.close();
		} catch(IOException e) {
			System.out.println("It was not possible to save the file. \n"+e);
		}
	}
	
/*----- Auxiliary methods -----*/
	
	private double greatest(double v1, double v2) {
		if(v1 > v2) {
			return v1;
		}
		return v2;
	}
	
	private int greatestSaleId(double price1, double price2, int id1, int id2) {
		if(price1>price2) {
			return id1;
		}
		return id2;
	}
	
	private double lowest(double v1, double v2) {
		if(v1<v2) {
			return v1;
		}
		return v2;
	}
	
	private String needsImprovementSalesmanName(double price1, double price2, String name1, String name2) {
		if(price1<price2) {
			return name1;
		}
		return name2;
	}
	
}