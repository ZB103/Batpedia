import Classification.*;
import GUI.*;
import java.io.IOException;

class Main{
	//Entry point main
	public static void main(String[] args) throws IOException{
		initAll();
	}
	
	//Initialization
	//Calls all initialization functions
	private static void initAll(){
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
	}

}