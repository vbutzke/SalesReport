package main;
import controllers.ReportController;

/*Author: Vitória Butzke Piccoli*/

public class SalesReport {

	public static void main(String[] args) {
		ReportController reportBuilder = new ReportController();
		reportBuilder.readMultipleFiles();
	}

}
