import Classification.*;
import GUI.*;
import java.io.IOException;

class Main{
	//Entry point main
	public static void main(String[] args) throws IOException{
		//Initialization			//Make all of these static
		//Order
		Chiroptera chiroptera = new Chiroptera();
		Yangochiroptera yangochiroptera = new Yangochiroptera();
		Yinpterochiroptera yinpterochiroptera = new Yinpterochiroptera();
		//Yango
		Emballonuridae emballonuridae = new Emballonuridae();
		Noctilionidae noctilionidae = new Noctilionidae();
		Thyropteridae thyropteridae = new Thyropteridae();
		Furipteridae furipteridae = new Furipteridae();
		Mormoopidae mormoopidae = new Mormoopidae();
		Molossidae molossidae = new Molossidae();
		Phyllostomidae phyllostomidae = new Phyllostomidae();
		Myzopodidae myzopodidae = new Myzopodidae();
		Mystacinidae mystacinidae = new Mystacinidae();
		Miniopteridae miniopteridae = new Miniopteridae();
		Natalidae natalidae = new Natalidae();
		Vespertillionidae vespertillionidae = new Vespertillionidae();
		//Yin
		Pteropodidae pteropodidae = new Pteropodidae();
		Rhinopomatidae rhinopomatidae = new Rhinopomatidae();
		Megadermatidae megadermatidae = new Megadermatidae();
		Craseonycteridae craseonycteridae = new Craseonycteridae();
		Hipposideridae hipposideridae = new Hipposideridae();
		Rhinolophidae rhinolophidae = new Rhinolophidae();
		
		
		//testing
		System.out.println(craseonycteridae.getData("location"));
		System.out.println(craseonycteridae.getData("habitat"));
		System.out.println(craseonycteridae.getData("diet"));
		System.out.println(craseonycteridae.getData("social"));
		System.out.println(craseonycteridae.getData("reproduction"));
		System.out.println(craseonycteridae.getData("seasonal"));
		System.out.println(craseonycteridae.getData("lifespan"));
		System.out.println(craseonycteridae.getData("predators"));
		System.out.println(craseonycteridae.getData("threats"));
		System.out.println(craseonycteridae.getData("status"));
		System.out.println(craseonycteridae.getData("genera"));
		System.out.println(craseonycteridae.getData("appearance"));
		System.out.println(craseonycteridae.getData("size"));
		System.out.println(craseonycteridae.getData("echo"));
	}
}