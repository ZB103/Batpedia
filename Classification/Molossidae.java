package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Molossidae extends Yangochiroptera{
	private static final String FAMILY = "Molossidae";
	
	public Molossidae(){
		super();
		//System.out.println("Molossidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}