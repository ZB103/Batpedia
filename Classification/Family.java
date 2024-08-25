package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

class Family provides information on the families of Yinptero/Yangochiroptera:

Yangochiroptera
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

Yinpterochiroptera
A suborder of the order Chiroptera.
Families:
Craseonycteridae
Hipposideridae
Megadermatidae
Pteropodidae
Rhinolophidae
Rhinopomatidae

*/


public class Family extends Suborder{
	private final String family;
	private final String commonName;
	private final String filepath;
	
	public Family(String fam, String name, String subord){
		super(subord);
		family = fam;
		commonName = name;
		filepath = "Classification\\Data\\" + getFamily() + ".txt";
	}
	
	//Getters
	public String getFamily(){return family;}
	public String getCommonName(){return commonName;}
	
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
		while((line = br.readLine()) != null){fullString += line + "\n";}
		
		//Call requested data based on
		if(requestedData.equals("location")){finalString = displayLocationData(fullString);}
		else if(requestedData.equals("habitat")){finalString = displayHabitatData(fullString);}
		else if(requestedData.equals("diet")){finalString = displayDietData(fullString);}
		else if(requestedData.equals("social")){finalString = displaySocialData(fullString);}
		else if(requestedData.equals("reproduction")){finalString = displayReproduceData(fullString);}
		else if(requestedData.equals("seasonal")){finalString = displaySeasonalData(fullString);}
		else if(requestedData.equals("lifespan")){finalString = displayLifespanData(fullString);}
		else if(requestedData.equals("predators")){finalString = displayPredatorData(fullString);}
		else if(requestedData.equals("threats")){finalString = displayThreatData(fullString);}
		else if(requestedData.equals("status")){finalString = displayStatusData(fullString);}
		else if(requestedData.equals("genera")){finalString = displayGeneraData(fullString);}
		else if(requestedData.equals("appearance")){finalString = displayAppearanceData(fullString);}
		else if(requestedData.equals("size")){finalString = displaySizeData(fullString);}
		else if(requestedData.equals("echo")){finalString = displayEchoData(fullString);}
		
		//Close resources
		br.close();
		fr.close();
		
		//Return data
		return finalString;
	}
	
	//Displays data on the family's location
	private String displayLocationData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Location") + 10,
			fullString.indexOf("*Habitat"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's habitat
	private String displayHabitatData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Habitat") + 9,
			fullString.indexOf("*Diet"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's diet
	private String displayDietData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Diet") + 6,
			fullString.indexOf("*Social Structure"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's social structure
	private String displaySocialData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Social Structure") + 18,
			fullString.indexOf("*Reproduction"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's reproduction
	private String displayReproduceData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Reproduction") + 14,
			fullString.indexOf("*Seasonal Behavior"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's seasonal behavior
	private String displaySeasonalData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Seasonal Behavior") + 19,
			fullString.indexOf("*Lifespan"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's lifespan
	private String displayLifespanData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Lifespan") + 10,
			fullString.indexOf("*Predators"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's predators
	private String displayPredatorData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Predators") + 11,
			fullString.indexOf("*Threats"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's threats
	private String displayThreatData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Threats") + 9,
			fullString.indexOf("*Status"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's status
	private String displayStatusData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Status") + 8,
			fullString.indexOf("*Genera"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's genera
	private String displayGeneraData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Genera") + 8,
			fullString.indexOf("*Appearance"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's appearance
	private String displayAppearanceData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Appearance") + 12,
			fullString.indexOf("*Size"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's size
	private String displaySizeData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Size") + 6,
			fullString.indexOf("*Echolocation"));
		//Return data
		return finalString;
	}
	
	//Displays data on the family's echolocation
	private String displayEchoData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Echolocation?") + 15,
			fullString.indexOf("*ENDDOC"));
		//Return data
		return finalString;
	}
}