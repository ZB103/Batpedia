package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Mystacinidae extends Yangochiroptera{
	private static final String FAMILY = "Mystacinidae";
	
	public Mystacinidae(){
		super();
		//System.out.println("Mystacinidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}