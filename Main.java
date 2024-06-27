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
		System.out.println(chiroptera.getData("order"));
		System.out.println(yangochiroptera.getData("suborder"));
		System.out.println(yinpterochiroptera.getData("suborder"));
		System.out.println(craseonycteridae.getData("location"));
	}
}