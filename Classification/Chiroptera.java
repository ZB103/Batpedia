/*

This is the highest class (order Chiroptera), holding the rest of the variables
since all bats have the same classification from "ORDER" up.
Holds the following subclasses:
Yangochiroptera
Yingpterochiroptera

*/

package Classification;

class Chiroptera{
	private static final String DOMAIN = "Eukaryota";
	private static final String KINGDOM = "Animalia";
	private static final String PHYLUM = "Chordata";
	private static final String ANIMALCLASS = "Mammalia";
	private static final String ORDER = "Chiroptera";
	
	public Chiroptera(){
		System.out.println("Chiroptera order established");
	}
	
	//Getters
	public String getDomain(){return DOMAIN;}
	public String getKingdom(){return KINGDOM;}
	public String getPhylum(){return PHYLUM;}
	public String getAnimalClass(){return ANIMALCLASS;}
	public String getOrder(){return ORDER;}
}

/*

A suborder of the order Chiroptera.
Holds the following families:
Emballonuroidea
Vespertilionoidea
Noctilionoidea

This class is a stub. More information may be added later.

*/

class Yangochiroptera extends Chiroptera{
	private static final String SUBORDER = "Yangochiroptera";
	
	public Yangochiroptera(){
		super();
		System.out.println("Yangochiroptera order established");
	}
	
	//Getters
	public String getSuborder(){return SUBORDER;}
}

/*
A suborder of the order Chiroptera.
Holds the following families:
Megachiroptera
Rhinolophoidea

This class is a stub. More information may be added later.

*/

class Yinpterochiroptera extends Chiroptera{
	private static final String SUBORDER = "Yinpterochiroptera";
	
	public Yinpterochiroptera(){
		super();
		System.out.println("Yinpterochiroptera order established");
	}
	
	//Getters
	public String getSuborder(){return SUBORDER;}
}