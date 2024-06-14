package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the suborder Pteropodidae.

*/

public class Megadermatidae extends Yinpterochiroptera{
	private static final String FAMILY = "Megadermatidae";
	
	public Megadermatidae(){
		super();
		//System.out.println("Megadermatidae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}