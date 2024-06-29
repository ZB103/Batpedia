package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A suborder of the order Chiroptera.
Genera:
Craseonycteridae
Hipposideridae
Megadermatidae
Pteropodidae
Rhinopophidae
Rhinopomatidae

*/

public class Yinpterochiroptera extends Chiroptera{
	private static final String SUBORDER = "Yinpterochiroptera";
	
	public Yinpterochiroptera(){
		super();
		//System.out.println("Yinpterochiroptera order established");
	}
	
	//Getters
	public String getSuborder(){return SUBORDER;}
	
	//Retrieve data from text file
	//Mediator function
	public String getData(String requestedData) throws IOException{
		String finalString = "";
		//Initialize classes
		File file = new File("Classification\\Data\\Yinpterochiroptera.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		//Get contents of file
		String fullString = "";	//String of full file transcription
		String line;
		while((line = br.readLine()) != null){fullString += line + "\n";}
		
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