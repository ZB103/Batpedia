package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Thyropteridae extends Yangochiroptera{
	private static final String FAMILY = "Thyropteridae";
	
	public Thyropteridae(){
		super();
		//System.out.println("Thyropteridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}
