/*

This class gives easy testing access to the classes.
These functions have been moved to an external class in order to reduce
the amount of code in Main.java while preserving these testing methods
for later debugging purposes, should they be useful.

*/

package Classification;

public class classTest{
	public classTest(){
		return;
	}
	//Initializes and tests all available classes
	public static void initAll(){
		initOrder();
		System.out.println();
		initYang();
		System.out.println();
		initYin();
	}
	
	//Initializes and tests all order classes
	public static void initOrder(){
		//Chiroptera
		System.out.println("---Testing Chiroptera---");
		Chiroptera chiroptera = new Chiroptera();
		System.out.println(chiroptera.getDomain());
		System.out.println(chiroptera.getKingdom());
		System.out.println(chiroptera.getPhylum());
		System.out.println(chiroptera.getAnimalClass());
		System.out.println(chiroptera.getOrder());
		
		System.out.println();
		
		//Yangochiroptera
		System.out.println("---Testing Yangochiroptera---");
		Yangochiroptera yangochiroptera = new Yangochiroptera();
		System.out.println(yangochiroptera.getDomain());
		System.out.println(yangochiroptera.getKingdom());
		System.out.println(yangochiroptera.getPhylum());
		System.out.println(yangochiroptera.getAnimalClass());
		System.out.println(yangochiroptera.getOrder());
		System.out.println(yangochiroptera.getSuborder());
		
		System.out.println();
		
		//Yinpterochiroptera
		System.out.println("---Testing Yinpterochiroptera---");
		Yinpterochiroptera yinpterochiroptera = new Yinpterochiroptera();
		System.out.println(yinpterochiroptera.getDomain());
		System.out.println(yinpterochiroptera.getKingdom());
		System.out.println(yinpterochiroptera.getPhylum());
		System.out.println(yinpterochiroptera.getAnimalClass());
		System.out.println(yinpterochiroptera.getOrder());
		System.out.println(yinpterochiroptera.getSuborder());
	}

	//Initializes and tests all family classes
	public static void initYang(){
		//Emballonuridae
		System.out.println("---Testing Emballonuridae---");
		Emballonuridae emballonuridae = new Emballonuridae();
		System.out.println(emballonuridae.getDomain());
		System.out.println(emballonuridae.getKingdom());
		System.out.println(emballonuridae.getPhylum());
		System.out.println(emballonuridae.getAnimalClass());
		System.out.println(emballonuridae.getOrder());
		System.out.println(emballonuridae.getSuborder());
		
		System.out.println();
		
		//Noctilionidae
		System.out.println("---Testing Noctilionidae---");
		Noctilionidae noctilionidae = new Noctilionidae();
		System.out.println(noctilionidae.getDomain());
		System.out.println(noctilionidae.getKingdom());
		System.out.println(noctilionidae.getPhylum());
		System.out.println(noctilionidae.getAnimalClass());
		System.out.println(noctilionidae.getOrder());
		System.out.println(noctilionidae.getSuborder());
		
		System.out.println();
		
		//Thyropteridae
		System.out.println("---Testing Thyropteridae---");
		Thyropteridae thyropteridae = new Thyropteridae();
		System.out.println(thyropteridae.getDomain());
		System.out.println(thyropteridae.getKingdom());
		System.out.println(thyropteridae.getPhylum());
		System.out.println(thyropteridae.getAnimalClass());
		System.out.println(thyropteridae.getOrder());
		System.out.println(thyropteridae.getSuborder());
		
		System.out.println();
		
		//Furipteridae
		System.out.println("---Testing Furipteridae---");
		Furipteridae furipteridae = new Furipteridae();
		System.out.println(furipteridae.getDomain());
		System.out.println(furipteridae.getKingdom());
		System.out.println(furipteridae.getPhylum());
		System.out.println(furipteridae.getAnimalClass());
		System.out.println(furipteridae.getOrder());
		System.out.println(furipteridae.getSuborder());
		
		System.out.println();
		
		//Mormoopidae
		System.out.println("---Testing Mormoopidae---");
		Mormoopidae mormoopidae = new Mormoopidae();
		System.out.println(mormoopidae.getDomain());
		System.out.println(mormoopidae.getKingdom());
		System.out.println(mormoopidae.getPhylum());
		System.out.println(mormoopidae.getAnimalClass());
		System.out.println(mormoopidae.getOrder());
		System.out.println(mormoopidae.getSuborder());
		
		System.out.println();
		
		//Molossidae
		System.out.println("---Testing Molossidae---");
		Molossidae molossidae = new Molossidae();
		System.out.println(molossidae.getDomain());
		System.out.println(molossidae.getKingdom());
		System.out.println(molossidae.getPhylum());
		System.out.println(molossidae.getAnimalClass());
		System.out.println(molossidae.getOrder());
		System.out.println(molossidae.getSuborder());
		
		System.out.println();
		
		//Phyllostomidae
		System.out.println("---Testing Phyllostomidae---");
		Phyllostomidae phyllostomidae = new Phyllostomidae();
		System.out.println(phyllostomidae.getDomain());
		System.out.println(phyllostomidae.getKingdom());
		System.out.println(phyllostomidae.getPhylum());
		System.out.println(phyllostomidae.getAnimalClass());
		System.out.println(phyllostomidae.getOrder());
		System.out.println(phyllostomidae.getSuborder());
		
		System.out.println();
		
		//Myzopodidae
		System.out.println("---Testing Myzopodidae---");
		Myzopodidae myzopodidae = new Myzopodidae();
		System.out.println(myzopodidae.getDomain());
		System.out.println(myzopodidae.getKingdom());
		System.out.println(myzopodidae.getPhylum());
		System.out.println(myzopodidae.getAnimalClass());
		System.out.println(myzopodidae.getOrder());
		System.out.println(myzopodidae.getSuborder());
		
		System.out.println();
		
		//Mystacinidae
		System.out.println("---Testing Mystacinidae---");
		Mystacinidae mystacinidae = new Mystacinidae();
		System.out.println(mystacinidae.getDomain());
		System.out.println(mystacinidae.getKingdom());
		System.out.println(mystacinidae.getPhylum());
		System.out.println(mystacinidae.getAnimalClass());
		System.out.println(mystacinidae.getOrder());
		System.out.println(mystacinidae.getSuborder());
		
		System.out.println();
		
		//Miniopteridae
		System.out.println("---Testing Miniopteridae---");
		Miniopteridae miniopteridae = new Miniopteridae();
		System.out.println(miniopteridae.getDomain());
		System.out.println(miniopteridae.getKingdom());
		System.out.println(miniopteridae.getPhylum());
		System.out.println(miniopteridae.getAnimalClass());
		System.out.println(miniopteridae.getOrder());
		System.out.println(miniopteridae.getSuborder());
		
		System.out.println();
		
		//Natalidae
		System.out.println("---Testing Natalidae---");
		Natalidae natalidae = new Natalidae();
		System.out.println(natalidae.getDomain());
		System.out.println(natalidae.getKingdom());
		System.out.println(natalidae.getPhylum());
		System.out.println(natalidae.getAnimalClass());
		System.out.println(natalidae.getOrder());
		System.out.println(natalidae.getSuborder());
		
		System.out.println();
		
		//Vespertillionidae
		System.out.println("---Testing Vespertillionidae---");
		Vespertillionidae vespertillionidae = new Vespertillionidae();
		System.out.println(vespertillionidae.getDomain());
		System.out.println(vespertillionidae.getKingdom());
		System.out.println(vespertillionidae.getPhylum());
		System.out.println(vespertillionidae.getAnimalClass());
		System.out.println(vespertillionidae.getOrder());
		System.out.println(vespertillionidae.getSuborder());
	}
	
	public static void initYin(){
		//Pteropodidae
		System.out.println("---Testing Pteropodidae---");
		Pteropodidae pteropodidae = new Pteropodidae();
		System.out.println(pteropodidae.getDomain());
		System.out.println(pteropodidae.getKingdom());
		System.out.println(pteropodidae.getPhylum());
		System.out.println(pteropodidae.getAnimalClass());
		System.out.println(pteropodidae.getOrder());
		System.out.println(pteropodidae.getSuborder());
		
		System.out.println();
		
		//Rhinopomatidae
		System.out.println("---Testing Rhinopomatidae---");
		Rhinopomatidae rhinopomatidae = new Rhinopomatidae();
		System.out.println(rhinopomatidae.getDomain());
		System.out.println(rhinopomatidae.getKingdom());
		System.out.println(rhinopomatidae.getPhylum());
		System.out.println(rhinopomatidae.getAnimalClass());
		System.out.println(rhinopomatidae.getOrder());
		System.out.println(rhinopomatidae.getSuborder());
		
		System.out.println();
		
		//Megadermatidae
		System.out.println("---Testing Megadermatidae---");
		Megadermatidae megadermatidae = new Megadermatidae();
		System.out.println(megadermatidae.getDomain());
		System.out.println(megadermatidae.getKingdom());
		System.out.println(megadermatidae.getPhylum());
		System.out.println(megadermatidae.getAnimalClass());
		System.out.println(megadermatidae.getOrder());
		System.out.println(megadermatidae.getSuborder());
		
		System.out.println();
		
		//Craseonycteridae
		System.out.println("---Testing Craseonycteridae---");
		Craseonycteridae craseonycteridae = new Craseonycteridae();
		System.out.println(craseonycteridae.getDomain());
		System.out.println(craseonycteridae.getKingdom());
		System.out.println(craseonycteridae.getPhylum());
		System.out.println(craseonycteridae.getAnimalClass());
		System.out.println(craseonycteridae.getOrder());
		System.out.println(craseonycteridae.getSuborder());
		
		System.out.println();
		
		//Hipposideridae
		System.out.println("---Testing Hipposideridae---");
		Hipposideridae hipposideridae = new Hipposideridae();
		System.out.println(hipposideridae.getDomain());
		System.out.println(hipposideridae.getKingdom());
		System.out.println(hipposideridae.getPhylum());
		System.out.println(hipposideridae.getAnimalClass());
		System.out.println(hipposideridae.getOrder());
		System.out.println(hipposideridae.getSuborder());
		
		System.out.println();
		
		//Rhinolophidae
		System.out.println("---Testing Rhinolophidae---");
		Rhinolophidae rhinolophidae = new Rhinolophidae();
		System.out.println(rhinolophidae.getDomain());
		System.out.println(rhinolophidae.getKingdom());
		System.out.println(rhinolophidae.getPhylum());
		System.out.println(rhinolophidae.getAnimalClass());
		System.out.println(rhinolophidae.getOrder());
		System.out.println(rhinolophidae.getSuborder());
		
		System.out.println();
	}
}