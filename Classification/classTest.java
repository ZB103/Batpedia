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
		initFamily();
		System.out.println();
		initEmbaFamily();
		System.out.println();
		initVesperFamily();
		System.out.println();
		initNoctFamily();
		System.out.println();
		initMegaFamily();
		System.out.println();
		initRhinoFamily();
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
	public static void initFamily(){
		//Emballonuroidea
		System.out.println("---Testing Emballonuroidea---");
		Emballonuroidea emballonuroidea = new Emballonuroidea();
		System.out.println(emballonuroidea.getDomain());
		System.out.println(emballonuroidea.getKingdom());
		System.out.println(emballonuroidea.getPhylum());
		System.out.println(emballonuroidea.getAnimalClass());
		System.out.println(emballonuroidea.getOrder());
		System.out.println(emballonuroidea.getSuborder());
		System.out.println(emballonuroidea.getFamily());
		
		System.out.println();
		
		//Vespertilionoidea
		System.out.println("---Testing Vespertilionoidea---");
		Vespertilionoidea vespertilionoidea = new Vespertilionoidea();
		System.out.println(vespertilionoidea.getDomain());
		System.out.println(vespertilionoidea.getKingdom());
		System.out.println(vespertilionoidea.getPhylum());
		System.out.println(vespertilionoidea.getAnimalClass());
		System.out.println(vespertilionoidea.getOrder());
		System.out.println(vespertilionoidea.getSuborder());
		System.out.println(vespertilionoidea.getFamily());
		
		System.out.println();
		
		//Noctilionoidea
		System.out.println("---Testing Noctilionoidea---");
		Noctilionoidea noctilionoidea = new Noctilionoidea();
		System.out.println(noctilionoidea.getDomain());
		System.out.println(noctilionoidea.getKingdom());
		System.out.println(noctilionoidea.getPhylum());
		System.out.println(noctilionoidea.getAnimalClass());
		System.out.println(noctilionoidea.getOrder());
		System.out.println(noctilionoidea.getSuborder());
		System.out.println(noctilionoidea.getFamily());
		
		System.out.println();
		
		//Megachiroptera
		System.out.println("---Testing Megachiroptera---");
		Megachiroptera megachiroptera = new Megachiroptera();
		System.out.println(megachiroptera.getDomain());
		System.out.println(megachiroptera.getKingdom());
		System.out.println(megachiroptera.getPhylum());
		System.out.println(megachiroptera.getAnimalClass());
		System.out.println(megachiroptera.getOrder());
		System.out.println(megachiroptera.getSuborder());
		System.out.println(megachiroptera.getFamily());
		
		System.out.println();
		
		//Rhinophoidea
		System.out.println("---Testing Rhinophoidea---");
		Rhinophoidea rhinophoidea = new Rhinophoidea();
		System.out.println(rhinophoidea.getDomain());
		System.out.println(rhinophoidea.getKingdom());
		System.out.println(rhinophoidea.getPhylum());
		System.out.println(rhinophoidea.getAnimalClass());
		System.out.println(rhinophoidea.getOrder());
		System.out.println(rhinophoidea.getSuborder());
		System.out.println(rhinophoidea.getFamily());
	}

	//Initializes and tests all Emballonuroidea genus classes
	public static void initEmbaFamily(){
		//Emballonuridae
		System.out.println("---Testing Emballonuridae---");
		Emballonuridae emballonuridae = new Emballonuridae();
		System.out.println(emballonuridae.getDomain());
		System.out.println(emballonuridae.getKingdom());
		System.out.println(emballonuridae.getPhylum());
		System.out.println(emballonuridae.getAnimalClass());
		System.out.println(emballonuridae.getOrder());
		System.out.println(emballonuridae.getSuborder());
		System.out.println(emballonuridae.getFamily());
		System.out.println(emballonuridae.getGenus());
		
		System.out.println();
		
		//Nycteridae
		System.out.println("---Testing Nycteridae---");
		Nycteridae nycteridae = new Nycteridae();
		System.out.println(nycteridae.getDomain());
		System.out.println(nycteridae.getKingdom());
		System.out.println(nycteridae.getPhylum());
		System.out.println(nycteridae.getAnimalClass());
		System.out.println(nycteridae.getOrder());
		System.out.println(nycteridae.getSuborder());
		System.out.println(nycteridae.getFamily());
		System.out.println(nycteridae.getGenus());
	}

	//Initializes and tests all Vespertilionoidea genus classes
	public static void initVesperFamily(){
		//Miniopteridae
		System.out.println("---Testing Miniopteridae---");
		Miniopteridae miniopteridae = new Miniopteridae();
		System.out.println(miniopteridae.getDomain());
		System.out.println(miniopteridae.getKingdom());
		System.out.println(miniopteridae.getPhylum());
		System.out.println(miniopteridae.getAnimalClass());
		System.out.println(miniopteridae.getOrder());
		System.out.println(miniopteridae.getSuborder());
		System.out.println(miniopteridae.getFamily());
		System.out.println(miniopteridae.getGenus());
		
		System.out.println();
		
		//Cistugidae
		System.out.println("---Testing Cistugidae---");
		Cistugidae cistugidae = new Cistugidae();
		System.out.println(cistugidae.getDomain());
		System.out.println(cistugidae.getKingdom());
		System.out.println(cistugidae.getPhylum());
		System.out.println(cistugidae.getAnimalClass());
		System.out.println(cistugidae.getOrder());
		System.out.println(cistugidae.getSuborder());
		System.out.println(cistugidae.getFamily());
		System.out.println(cistugidae.getGenus());
		
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
		System.out.println(molossidae.getFamily());
		System.out.println(molossidae.getGenus());
		
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
		System.out.println(natalidae.getFamily());
		System.out.println(natalidae.getGenus());
		
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
		System.out.println(vespertillionidae.getFamily());
		System.out.println(vespertillionidae.getGenus());
	}

	//Initializes and tests all Noctilionoidea genus classes
	public static void initNoctFamily(){
		//Noctilionidae
		System.out.println("---Testing Noctilionidae---");
		Noctilionidae noctilionidae = new Noctilionidae();
		System.out.println(noctilionidae.getDomain());
		System.out.println(noctilionidae.getKingdom());
		System.out.println(noctilionidae.getPhylum());
		System.out.println(noctilionidae.getAnimalClass());
		System.out.println(noctilionidae.getOrder());
		System.out.println(noctilionidae.getSuborder());
		System.out.println(noctilionidae.getFamily());
		System.out.println(noctilionidae.getGenus());
		
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
		System.out.println(thyropteridae.getFamily());
		System.out.println(thyropteridae.getGenus());
		
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
		System.out.println(furipteridae.getFamily());
		System.out.println(furipteridae.getGenus());
		
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
		System.out.println(mormoopidae.getFamily());
		System.out.println(mormoopidae.getGenus());
		
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
		System.out.println(phyllostomidae.getFamily());
		System.out.println(phyllostomidae.getGenus());
		
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
		System.out.println(myzopodidae.getFamily());
		System.out.println(myzopodidae.getGenus());
		
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
		System.out.println(mystacinidae.getFamily());
		System.out.println(mystacinidae.getGenus());
	}

	//Initializes and tests all Megachiroptera genus classes
	public static void initMegaFamily(){
		//Pteropodidae
		System.out.println("---Testing Pteropodidae---");
		Pteropodidae pteropodidae = new Pteropodidae();
		System.out.println(pteropodidae.getDomain());
		System.out.println(pteropodidae.getKingdom());
		System.out.println(pteropodidae.getPhylum());
		System.out.println(pteropodidae.getAnimalClass());
		System.out.println(pteropodidae.getOrder());
		System.out.println(pteropodidae.getSuborder());
		System.out.println(pteropodidae.getFamily());
		System.out.println(pteropodidae.getGenus());
	}

	//Initializes and tests all Rhinolophoidea genus classes
	public static void initRhinoFamily(){
		//Rhinopomatidae
		System.out.println("---Testing Rhinopomatidae---");
		Rhinopomatidae rhinopomatidae = new Rhinopomatidae();
		System.out.println(rhinopomatidae.getDomain());
		System.out.println(rhinopomatidae.getKingdom());
		System.out.println(rhinopomatidae.getPhylum());
		System.out.println(rhinopomatidae.getAnimalClass());
		System.out.println(rhinopomatidae.getOrder());
		System.out.println(rhinopomatidae.getSuborder());
		System.out.println(rhinopomatidae.getFamily());
		System.out.println(rhinopomatidae.getGenus());
		
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
		System.out.println(megadermatidae.getFamily());
		System.out.println(megadermatidae.getGenus());
		
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
		System.out.println(craseonycteridae.getFamily());
		System.out.println(craseonycteridae.getGenus());
		
		System.out.println();
		
		//Rhinonycteridae
		System.out.println("---Testing Rhinonycteridae---");
		Rhinonycteridae rhinonycteridae = new Rhinonycteridae();
		System.out.println(rhinonycteridae.getDomain());
		System.out.println(rhinonycteridae.getKingdom());
		System.out.println(rhinonycteridae.getPhylum());
		System.out.println(rhinonycteridae.getAnimalClass());
		System.out.println(rhinonycteridae.getOrder());
		System.out.println(rhinonycteridae.getSuborder());
		System.out.println(rhinonycteridae.getFamily());
		System.out.println(rhinonycteridae.getGenus());
		
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
		System.out.println(hipposideridae.getFamily());
		System.out.println(hipposideridae.getGenus());
		
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
		System.out.println(rhinolophidae.getFamily());
		System.out.println(rhinolophidae.getGenus());
	}
}