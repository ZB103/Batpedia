package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A suborder of the order Chiroptera.
Genera:
Emballonuridae
Noctilionidae
Thyropteridae
Furipteridae
Mormoopidae
Molossidae
Phyllostomidae
Myzopodidae
Mystacinidae
Miniopteridae
Natalidae
Vespertillionidae

*/

public class Yangochiroptera extends Chiroptera{
	private static final String SUBORDER = "Yangochiroptera";
	
	public Yangochiroptera(){
		super();
		//System.out.println("Yangochiroptera order established");
	}
	
	//Getters
	public String getSuborder(){return SUBORDER;}
	
	//Retrieve data from text file
	//Mediator function
	public String getData(String requestedData) throws IOException{
		String finalString = "";
		//Initialize classes
		File file = new File("C:\\Users\\zbake\\Desktop\\Programming\\GitHub\\Batpedia\\Classification\\Data\\Yangochiroptera.txt");	//Remove hard-code later
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		//Get contents of file
		String fullString = "";	//String of full file transcription
		String line;
		while((line = br.readLine()) != null){finalString = fullString += line + "\n";}
		
		//Call requested data based on
		if(requestedData.equals("suborder")){finalString = displayOrderData(fullString);}
		
		//Close resources
		br.close();
		fr.close();
		
		//Return data
		return finalString;
	}
	
	//Displays data on the suborder
	private String displayOrderData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Suborder") + 10,
			fullString.indexOf("*ENDDOC"));
		//Return data
		return finalString;
	}
}