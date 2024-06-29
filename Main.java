import Classification.*;
import GUI.*;
import java.io.IOException;

class Main{
	//Entry point main
	public static void main(String[] args) throws IOException{
		//Order
		Chiroptera chiroptera = new Chiroptera();
		Suborder yinpterochiroptera = new Suborder("Yinpterochiroptera");
		Suborder yangochiroptera = new Suborder("Yangochiroptera");
		//Yango
		String ya = "Yangochiroptera";
		Family emballonuridae = new Family("Emballonuridae", ya);
		Family noctilionidae = new Family("Noctilionidae", ya);
		Family thyropteridae = new Family("Thyropteridae", ya);
		Family furipteridae = new Family("Furipteridae", ya);
		Family mormoopidae = new Family("Mormoopidae", ya);
		Family molossidae = new Family("Molossidae", ya);
		Family phyllostomidae = new Family("Phyllostomidae", ya);
		Family myzopodidae = new Family("Myzopodidae", ya);
		Family mystacinidae = new Family("Mystacinidae", ya);
		Family miniopteridae = new Family("Miniopteridae", ya);
		Family natalidae = new Family("Natalidae", ya);
		Family vespertillionidae = new Family("Vespertillionidae", ya);
		//Yin
		String yi = "Yinpterochiroptera";
		Family pteropodidae = new Family("Pteropodidae", yi);
		Family rhinopomatidae = new Family("Rhinopomatidae", yi);
		Family megadermatidae = new Family("Megadermatidae", yi);
		Family craseonycteridae = new Family("Craseonycteridae", yi);
		Family hipposideridae = new Family("Hipposideridae", yi);
		Family rhinolophidae = new Family("Rhinolophidae", yi);
		
		
		//testing
		
	}
}