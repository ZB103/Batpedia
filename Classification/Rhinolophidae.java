package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the suborder Pteropodidae.

*/

public class Rhinolophidae extends Yinpterochiroptera{
	private static final String FAMILY = "Rhinolophidae";
	
	public Rhinolophidae(){
		super();
		//System.out.println("Rhinolophidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}