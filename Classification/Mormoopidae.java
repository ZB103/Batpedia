package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Mormoopidae extends Yangochiroptera{
	private static final String FAMILY = "Mormoopidae";
	
	public Mormoopidae(){
		super();
		//System.out.println("Mormoopidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}