package Classification;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*

A family of the suborder Pteropodidae.

*/

public class Craseonycteridae extends Yinpterochiroptera{
	private static final String FAMILY = "Craseonycteridae";
	
	public Craseonycteridae(){
		super();
		//System.out.println("Craseonycteridae family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
}