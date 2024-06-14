package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Emballonuridae extends Yangochiroptera{
	private static final String FAMILY = "Emballonuridae";
	
	public Emballonuridae(){
		super();
		//System.out.println("Emballonuridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}