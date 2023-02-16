package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.List;
import java.util.*;
import java.util.Map.Entry;
/**
 * Reads in a sales file and calculates the total amount for each service
 * category when requested
 */
public class SalesTally {

	// ADD YOUR INSTANCE VARIABLES HERE
	private ArrayList<Sale> sales;
	/**
	 * Constructor
	 * 
	 * @param salesFileName sales file name
	 */
	public SalesTally(String salesFileName) {
		this.sales = new ArrayList<Sale>();
		try(Scanner in = new Scanner(new File(salesFileName))){
			while (in.hasNextLine()) {
				String temp = in.nextLine();
				String[] line = temp.split(";");
				sales.add(new Sale(line[0], line[1], Double.parseDouble(line[2]), line[3]));
			}
		} catch(FileNotFoundException e) {
			System.out.print("File: " + salesFileName + " not found");
		}
	}


	/**
	 * Returns the total amount of sales for the given category
	 * 
	 * @param category
	 * 
	 * @return total amount of sales for the given category
	 */
	public double getCategoryTotal(String category) {
		double total = 0.0;
		for (int i = 0; i < sales.size(); i++) {
			if (sales.get(i).getServiceCategory().equals(category)) {
				total += sales.get(i).getAmount();
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		SalesTally s = new SalesTally("res/sales.txt");
		System.out.println(s.getCategoryTotal("Dinner"));
	}

}
