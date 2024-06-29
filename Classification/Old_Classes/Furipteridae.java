package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Furipteridae extends Yangochiroptera{
	private static final String FAMILY = "Furipteridae";
	
	public Furipteridae(){
		super();
		//System.out.println("Furipteridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}