package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Noctilionidae extends Yangochiroptera{
	private static final String FAMILY = "Noctilionidae";
	
	public Noctilionidae(){
		super();
		//System.out.println("Noctilionidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}