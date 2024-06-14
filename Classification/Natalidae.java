package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Natalidae extends Yangochiroptera{
	private static final String FAMILY = "Natalidae";
	
	public Natalidae(){
		super();
		//System.out.println("Natalidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}