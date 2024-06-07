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
		Yangochiroptera emballonuridae = yangochiroptera.createEmballonuridae();
		Yangochiroptera noctilionidae = yangochiroptera.createNoctilionidae();
		Yangochiroptera thyropteridae = yangochiroptera.createThyropteridae();
		Yangochiroptera furipteridae = yangochiroptera.createFuripteridae();
		Yangochiroptera mormoopidae = yangochiroptera.createMormoopidae();
		Yangochiroptera phyllostomidae = yangochiroptera.createPhyllostomidae();
		Yangochiroptera myzopodidae = yangochiroptera.createMyzopodidae();
		Yangochiroptera mystacinidae = yangochiroptera.createMystacinidae();
		Yangochiroptera miniopteridae = yangochiroptera.createMiniopteridae();
		Yangochiroptera natalidae = yangochiroptera.createNatalidae();
		Yangochiroptera vespertillionidae = yangochiroptera.createVespertillionidae();
		//Yin
		Yinpterochiroptera pteropodidae = yinpterochiroptera.createPteropodidae();
		Yinpterochiroptera rhinopomatidae = yinpterochiroptera.createRhinopomatidae();
		Yinpterochiroptera megadermatidae = yinpterochiroptera.createMegadermatidae();
		Yinpterochiroptera craseonycteridae = yinpterochiroptera.createCraseonycteridae();
		Yinpterochiroptera hipposideridae = yinpterochiroptera.createHipposideridae();
		Yinpterochiroptera rhinolophidae = yinpterochiroptera.createRhinolophidae();
		
		//System.out.println(hipposideridae.getFamily());
	}

}