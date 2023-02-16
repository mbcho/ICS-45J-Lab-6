package labs.lab6;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * A set of baby name data ranking the most popular baby names in the U.S. in a
 * particular year
 */
public class BabyNameData {

	// ADD YOUR INSTANCE VARIABLES HERE
	private ArrayList<BabyName> babies;
	private ArrayList<BabyName> boys;
	private ArrayList<BabyName> girls;
	/**
	 * Constructor that creates this object with data from a file
	 * 
	 * @param babyNamesFileName name of input file
	 */
	public BabyNameData(String babyNamesFileName) {
		this.babies = new ArrayList<BabyName>();
		this.boys = new ArrayList<BabyName>();
		this.girls = new ArrayList<BabyName>();
		try (Scanner in = new Scanner(new File(babyNamesFileName))){
			while (in.hasNextLine()) {
				String temp = in.nextLine();
				String[] line = temp.split("  ");
			
				if (getAllGirlNames().contains(line[1])) {
					babies.add(new BabyName(line[1], Integer.parseInt(line[0]), Integer.parseInt(line[2]), Double.parseDouble(line[3])));
				}
				else if (getAllBoyNames().contains(line[4])) {
					babies.add(new BabyName(line[4], Integer.parseInt(line[0]), Integer.parseInt(line[5]), Double.parseDouble(line[6])));
				}
				// babies.add(new BabyName(line[1], Integer.parseInt(line[0]), Integer.parseInt(line[2]), Double.parseDouble(line[3])));
				// babies.add(new BabyName(line[4], Integer.parseInt(line[0]), Integer.parseInt(line[5]), Double.parseDouble(line[6])));
				boys.add(new BabyName(line[1], Integer.parseInt(line[0]), Integer.parseInt(line[2]), Double.parseDouble(line[3])));
				girls.add(new BabyName(line[4], Integer.parseInt(line[0]), Integer.parseInt(line[5]), Double.parseDouble(line[6])));
			}
		} catch (FileNotFoundException e) {
			System.out.print("File: " + babyNamesFileName + " not found");
		}
	}


	/**
	 * 
	 * @return all girl names (in a non-specific order)
	 */
	public List<String> getAllGirlNames() {
		List<String> names  = new ArrayList<String>();
		for (int i = 0; i < girls.size(); i++) {
			names.add(girls.get(i).getName());
		}
		
		
		return names; // FIX ME
	}


	/**
	 * 
	 * @return all boy names (in a non-specific order)
	 */
	public List<String> getAllBoyNames() {
		List<String> names  = new ArrayList<String>();
		for (int i = 0; i < boys.size(); i++) {
			names.add(boys.get(i).getName());
		}
		
		
		return names; // FIX ME
	}


	/**
	 * 
	 * @return all names that appear in the data for both boys and girls (in a
	 *         non-specific order)
	 */
	public List<String> getAllNonGenderSpecificNames() {
		List<String> names  = new ArrayList<String>();
		for (int i = 0; i < babies.size(); i++) {
			names.add(babies.get(i).getName());
		}
		
		
		return names; // FIX ME
	}


	/**
	 * 
	 * @param rank
	 * @return the girl name at the rank specified
	 * 
	 *         If rank is out of the range of data, throw an
	 *         IllegalArgumentException with the message "Rank [rank] out of range
	 *         of data"
	 */
	public String getGirlNameAtRank(int rank) throws IllegalArgumentException {
		if (rank > getAllGirlNames().size() || rank < 1) {
			throw new IllegalArgumentException("Rank " + rank + " out of range of data");
		}
		return girls.get(rank-1).getName();
	}



	/**
	 * 
	 * @param rank
	 * @return the boy name at the rank specified
	 * 
	 *         If rank is out of the range of data, throw an
	 *         IllegalArgumentException with the message "Rank [rank] out of range
	 *         of data"
	 */
	public String getBoyNameAtRank(int rank) throws IllegalArgumentException{
		if (rank > getAllGirlNames().size() || rank < 1) {
			throw new IllegalArgumentException("Rank " + rank + " out of range of data");
		}
		return boys.get(rank-1).getName(); // FIX ME
	}
	
	public static void main(String[] args) {

	}
}
