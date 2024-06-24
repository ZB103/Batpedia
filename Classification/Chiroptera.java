package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

This is the highest class (order Chiroptera), holding the rest of the variables
since all bats have the same classification from "ORDER" up.
Holds the following subclasses:
Yangochiroptera
Yingpterochiroptera

*/

public class Chiroptera{
	private static final String DOMAIN = "Eukaryota";
	private static final String KINGDOM = "Animalia";
	private static final String PHYLUM = "Chordata";
	private static final String ANIMALCLASS = "Mammalia";
	private static final String ORDER = "Chiroptera";
	

	
	public Chiroptera(){
		//System.out.println("Chiroptera order established");
	}
	
	//Getters
	public String getDomain(){return DOMAIN;}
	public String getKingdom(){return KINGDOM;}
	public String getPhylum(){return PHYLUM;}
	public String getAnimalClass(){return ANIMALCLASS;}
	public String getOrder(){return ORDER;}
	
	//Retrieve data from text file
	//Mediator function
	public String getData(String requestedData) throws IOException{
		String finalString = "";
		//Initialize classes
		File file = new File("C:\\Users\\zbake\\Desktop\\Programming\\GitHub\\Batpedia\\Classification\\Data\\Chiroptera.txt");	//Remove hard-code later
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		//Get contents of file
		String fullString = "";	//String of full file transcription
		String line;
		while((line = br.readLine()) != null){fullString += line + "\n";}
		
		//Call requested data based on
		if(requestedData.equals("order")){finalString = displayOrderData(fullString);}
		else if(requestedData.equals("frequency")){finalString = displayFrequencyData(fullString);}
		else if(requestedData.equals("diversity")){finalString = displayDiversityData(fullString);}
		
		//Close resources
		br.close();
		fr.close();
		
		//Return data
		return finalString;
	}
	
	//Displays data on the order
	private String displayOrderData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Order") + 6,
			fullString.indexOf("*Frequency"));
		//Return data
		return finalString;
	}
	
	//Displays data on the frequency of bats
	private String displayFrequencyData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Frequency") + 10,
			fullString.indexOf("*Diversity"));
		//Return data
		return finalString;
	}
	
	//Displays data on overview of diversity of bats
	private String displayDiversityData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Diversity") + 10,
			fullString.indexOf("*ENDDOC"));
		//Return data
		return finalString;
	}
}