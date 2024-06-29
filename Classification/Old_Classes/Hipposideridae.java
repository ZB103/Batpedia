package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the suborder Pteropodidae.

*/

public class Hipposideridae extends Yinpterochiroptera{
	private static final String FAMILY = "Hipposideridae";
	
	public Hipposideridae(){
		super();
		//System.out.println("Hipposideridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}