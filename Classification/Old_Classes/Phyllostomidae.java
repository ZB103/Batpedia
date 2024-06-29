package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Phyllostomidae extends Yangochiroptera{
	private static final String FAMILY = "Phyllostomidae";
	
	public Phyllostomidae(){
		super();
		//System.out.println("Phyllostomidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}