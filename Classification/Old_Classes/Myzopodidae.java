package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Myzopodidae extends Yangochiroptera{
	private static final String FAMILY = "Myzopodidae";
	
	public Myzopodidae(){
		super();
		//System.out.println("Myzopodidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}