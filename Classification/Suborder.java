package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

class Suborder provides information on the two subclasses:

Yangochiroptera; A suborder of the order Chiroptera.
Families:
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

Yinpterochiroptera; A suborder of the order Chiroptera.
Families:
Craseonycteridae
Hipposideridae
Megadermatidae
Pteropodidae
Rhinolophidae
Rhinopomatidae

*/


public class Suborder extends Chiroptera{
	private final String suborder;
	private final String filepath;
	
	public Suborder(String in){
		super();
		suborder = in;
		filepath = "Classification\\Data\\" + getSuborder() + ".txt";
	}
	
	//Getters
	public String getSuborder(){return suborder;}
	
	//Retrieve data from text file
	//Mediator function
	public String getData(String requestedData) throws IOException{
		String finalString = "";
		//Initialize classes
		File file = new File(filepath);
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