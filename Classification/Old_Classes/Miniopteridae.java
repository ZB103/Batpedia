package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Miniopteridae extends Yangochiroptera{
	private static final String FAMILY = "Miniopteridae";
	
	public Miniopteridae(){
		super();
		//System.out.println("Miniopteridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}