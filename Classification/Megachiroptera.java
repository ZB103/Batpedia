/*

A family of the suborder Yinpterochiroptera.
Holds the following genuses:
Pteropodidae

This class is a stub. More information may be added later.

*/

package Classification;

class Megachiroptera extends Yinpterochiroptera{
	private static final String FAMILY = "Megachiroptera";
	
	public Megachiroptera(){
		super();
		System.out.println("Megachiroptera family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
	
}

/*

A genus of the family Megachiroptera.

This class is a stub. More information may be added later.

*/

class Pteropodidae extends Megachiroptera{
	private static final String GENUS = "Pteropodidae";
	
	public Pteropodidae(){
		super();
		System.out.println("Pteropodidae genus established");
	}
	
	//Getters
	public String getGenus(){return GENUS;}
}