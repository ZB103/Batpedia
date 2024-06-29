package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the subclass Yangochiroptera.

*/

public class Vespertillionidae extends Yangochiroptera{
	private static final String FAMILY = "Vespertillionidae";
	
	public Vespertillionidae(){
		super();
		//System.out.println("Vespertillionidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}