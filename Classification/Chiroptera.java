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