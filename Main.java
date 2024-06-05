import Classification.*;
import GUI.*;
import java.io.IOException;

class Main{
	//Entry point main
	public static void main(String[] args) throws IOException{
		Chiroptera c = new Chiroptera();
		c.getData("order");
		System.out.println("\n\n");
		c.getData("frequency");
		System.out.println("\n\n");
		c.getData("diversity");
		System.out.println("\n\n");
	}
	
	//Initialization
	//Calls all initialization functions
	//private static void initAll(){
	//	return;
	//}

}