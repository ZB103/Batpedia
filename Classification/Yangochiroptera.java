package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A suborder of the order Chiroptera.

*/

public class Yangochiroptera extends Chiroptera{
	private static final String SUBORDER = "Yangochiroptera";
	
	public Yangochiroptera(){
		super();
		//System.out.println("Yangochiroptera order established");
	}
	
	//Getters
	public String getSuborder(){return SUBORDER;}
	
	
	//Subclass creator functions
	public static Yangochiroptera createEmballonuridae(){return new Emballonuridae();}
	public static Yangochiroptera createNoctilionidae(){return new Noctilionidae();}
	public static Yangochiroptera createThyropteridae(){return new Thyropteridae();}
	public static Yangochiroptera createFuripteridae(){return new Furipteridae();}
	public static Yangochiroptera createMormoopidae(){return new Mormoopidae();}
	public static Yangochiroptera createPhyllostomidae(){return new Phyllostomidae();}
	public static Yangochiroptera createMyzopodidae(){return new Myzopodidae();}
	public static Yangochiroptera createMystacinidae(){return new Mystacinidae();}
	public static Yangochiroptera createMiniopteridae(){return new Miniopteridae();}
	public static Yangochiroptera createNatalidae(){return new Natalidae();}
	public static Yangochiroptera createVespertillionidae(){return new Vespertillionidae();}	
	
	//Retrieve data from text file
	//Mediator function
	public void getData(String requestedData) throws IOException{
		//Initialize classes
		File file = new File("C:\\Users\\zbake\\Desktop\\Programming\\GitHub\\Batpedia\\Classification\\Data\\Yangochiroptera.txt");	//Remove hard-code later
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

A family of the subclass Yangochiroptera.

*/

class Emballonuridae extends Yangochiroptera{
	private static final String FAMILY = "Emballonuridae";
	
	public Emballonuridae(){
		super();
		//System.out.println("Emballonuridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the subclass Yangochiroptera.

*/

class Noctilionidae extends Yangochiroptera{
	private static final String FAMILY = "Noctilionidae";
	
	public Noctilionidae(){
		super();
		//System.out.println("Noctilionidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the subclass Yangochiroptera.

*/

class Thyropteridae extends Yangochiroptera{
	private static final String FAMILY = "Thyropteridae";
	
	public Thyropteridae(){
		super();
		//System.out.println("Thyropteridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the subclass Yangochiroptera.

*/

class Furipteridae extends Yangochiroptera{
	private static final String FAMILY = "Furipteridae";
	
	public Furipteridae(){
		super();
		//System.out.println("Furipteridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the subclass Yangochiroptera.


*/

class Mormoopidae extends Yangochiroptera{
	private static final String FAMILY = "Mormoopidae";
	
	public Mormoopidae(){
		super();
		//System.out.println("Mormoopidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the subclass Yangochiroptera.


*/

class Phyllostomidae extends Yangochiroptera{
	private static final String FAMILY = "Phyllostomidae";
	
	public Phyllostomidae(){
		super();
		//System.out.println("Phyllostomidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the subclass Yangochiroptera.

*/

class Myzopodidae extends Yangochiroptera{
	private static final String FAMILY = "Myzopodidae";
	
	public Myzopodidae(){
		super();
		//System.out.println("Myzopodidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the subclass Yangochiroptera.


*/

class Mystacinidae extends Yangochiroptera{
	private static final String FAMILY = "Mystacinidae";
	
	public Mystacinidae(){
		super();
		//System.out.println("Mystacinidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the subclass Yangochiroptera.


*/

class Miniopteridae extends Yangochiroptera{
	private static final String FAMILY = "Miniopteridae";
	
	public Miniopteridae(){
		super();
		//System.out.println("Miniopteridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the subclass Yangochiroptera.


*/

class Natalidae extends Yangochiroptera{
	private static final String FAMILY = "Natalidae";
	
	public Natalidae(){
		super();
		//System.out.println("Natalidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}

/*

A family of the subclass Yangochiroptera.


*/

class Vespertillionidae extends Yangochiroptera{
	private static final String FAMILY = "Vespertillionidae";
	
	public Vespertillionidae(){
		super();
		//System.out.println("Vespertillionidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}