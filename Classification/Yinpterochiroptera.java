package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A suborder of the order Chiroptera.

*/

public class Yinpterochiroptera extends Chiroptera{
	private static final String SUBORDER = "Yinpterochiroptera";
	
	public Yinpterochiroptera(){
		super();
		//System.out.println("Yinpterochiroptera order established");
	}
	
	//Subclass creator functions
	public static Yinpterochiroptera createPteropodidae(){return new Pteropodidae();}
	public static Yinpterochiroptera createRhinopomatidae(){return new Rhinopomatidae();}
	public static Yinpterochiroptera createMegadermatidae(){return new Megadermatidae();}
	public static Yinpterochiroptera createCraseonycteridae(){return new Craseonycteridae();}
	public static Yinpterochiroptera createHipposideridae(){return new Hipposideridae();}
	public static Yinpterochiroptera createRhinolophidae(){return new Rhinolophidae();}
	
	//Getters
	public String getSuborder(){return SUBORDER;}
	
	//Retrieve data from text file
	//Mediator function
	public void getData(String requestedData) throws IOException{
		//Initialize classes
		File file = new File("C:\\Users\\zbake\\Desktop\\Programming\\GitHub\\Batpedia\\Classification\\Data\\Yinpterochiroptera.txt");	//Remove hard-code later
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		//Get contents of file
		String fullString = "";	//String of full file transcription
		String line;
		while((line = br.readLine()) != null){fullString += line + "\n";}
		
		//Call requested data based on
		if(requestedData.equals("suborder")){displayOrderData(fullString);}
		
		//Close resources
		br.close();
		fr.close();
	}
	
	//Displays data on the suborder
	private void displayOrderData(String fullString){
		//Extract substring of needed data
		String finalString = fullString.substring(fullString.indexOf("*Suborder") + 10,
			fullString.indexOf("*ENDDOC"));
		//Use data - temporary print statement
		System.out.println(finalString);
	}
}

/*

A family of the suborder Pteropodidae.

*/

class Pteropodidae extends Yinpterochiroptera{
	private static final String FAMILY = "Pteropodidae";
	
	public Pteropodidae(){
		super();
		//System.out.println("Pteropodidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
	
}

/*

A family of the suborder Yinpterochiroptera.

*/

class Rhinopomatidae extends Yinpterochiroptera{
	private static final String FAMILY = "Rhinopomatidae";
	
	public Rhinopomatidae(){
		super();
		//System.out.println("Rhinopomatidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the suborder Yinpterochiroptera.

*/

class Megadermatidae extends Yinpterochiroptera{
	private static final String FAMILY = "Megadermatidae";
	
	public Megadermatidae(){
		super();
		//System.out.println("Megadermatidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the suborder Yinpterochiroptera.

*/

class Craseonycteridae extends Yinpterochiroptera{
	private static final String FAMILY = "Craseonycteridae";
	
	public Craseonycteridae(){
		super();
		//System.out.println("Craseonycteridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the suborder Yinpterochiroptera.

*/

class Hipposideridae extends Yinpterochiroptera{
	private static final String FAMILY = "Hipposideridae";
	
	public Hipposideridae(){
		super();
		//System.out.println("Hipposideridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the suborder Yinpterochiroptera.

*/

class Rhinolophidae extends Yinpterochiroptera{
	private static final String FAMILY = "Rhinolophidae";
	
	public Rhinolophidae(){
		super();
		//System.out.println("Rhinolophidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}