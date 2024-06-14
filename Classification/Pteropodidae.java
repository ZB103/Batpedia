package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the suborder Pteropodidae.

*/

public class Pteropodidae extends Yinpterochiroptera{
	private static final String FAMILY = "Pteropodidae";
	
	public Pteropodidae(){
		super();
		//System.out.println("Pteropodidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
	
}
