/*

This is the highest class (order Chiroptera), holding the rest of the variables
since all bats have the same classification from "ORDER" up.
Holds the following subclasses:
Yangochiroptera
Yingpterochiroptera

*/

package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Chiroptera{
	private static final String DOMAIN = "Eukaryota";
	private static final String KINGDOM = "Animalia";
	private static final String PHYLUM = "Chordata";
	private static final String ANIMALCLASS = "Mammalia";
	private static final String ORDER = "Chiroptera";
	

	
	public Chiroptera(){
		System.out.println("Chiroptera order established");
	}
	
	//Getters
	public String getDomain(){return DOMAIN;}
	public String getKingdom(){return KINGDOM;}
	public String getPhylum(){return PHYLUM;}
	public String getAnimalClass(){return ANIMALCLASS;}
	public String getOrder(){return ORDER;}
	
	//Retrieve data from text file
	//Mediator function
	public void getData(String requestedData) throws IOException{
		//Initialize classes
		File file = new File("C:\\Users\\zbake\\Desktop\\Programming\\GitHub\\Batpedia\\Classification\\Data\\Chiroptera.txt");	//Remove hard-code later
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		//Get contents of file
		String fullString = "";	//String of full file transcription
		String line;
		while((line = br.readLine()) != null){fullString += line;}
		
		//Call requested data based on
		if(requestedData.equals("order")){displayOrderData(fullString);}
		else if(requestedData.equals("frequency")){displayFrequencyData(fullString);}
		else if(requestedData.equals("diversity")){displayDiversityData(fullString);}
		
		//Close resources
		br.close();
		fr.close();
	}
	
	//Displays data on the order
	private void displayOrderData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Order") + 6,
			fullString.indexOf("*Frequency"));
		//Use data - temporary print statement
		System.out.println(finalString);
	}
	
	//Displays data on the frequency of bats
	private void displayFrequencyData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Frequency") + 10,
			fullString.indexOf("*Diversity"));
		//Use data - temporary print statement
		System.out.println(finalString);
	}
	
	//Displays data on overview of diversity of bats
	private void displayDiversityData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Diversity") + 10,
			fullString.indexOf("*ENDDOC"));
		//Use data - temporary print statement
		System.out.println(finalString);
	}
}