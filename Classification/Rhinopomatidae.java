package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the suborder Pteropodidae.

*/

public class Rhinopomatidae extends Yinpterochiroptera{
	private static final String FAMILY = "Rhinopomatidae";
	
	public Rhinopomatidae(){
		super();
		//System.out.println("Rhinopomatidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}