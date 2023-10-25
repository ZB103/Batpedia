/*

A family of the suborder Yangochiroptera.
Holds the following genuses:
Emballonuridae
Nycteridae

This class is a stub. More information may be added later.

*/

package Classification;

class Emballonuroidea extends Yangochiroptera{
	private static final String FAMILY = "Emballonuroidea";
	
	public Emballonuroidea(){
		super();
		System.out.println("Emballonuroidea family established");
	}
	
	//Getters
	public String getFamily(){return FAMILY;}
	
}

/*

A genus of the family Emballonuroidea.

This class is a stub. More information may be added later.

*/

class Emballonuridae extends Emballonuroidea{
	private static final String GENUS = "Emballonuridae";
	
	public Emballonuridae(){
		super();
		System.out.println("Emballonuridae genus established");
	}
	
	//Getters
	public String getGenus(){return GENUS;}
}

/*

A genus of the family Emballonuroidea.

This class is a stub. More information may be added later.

*/

class Nycteridae extends Emballonuroidea{
	private static final String GENUS = "Nycteridae";
	
	public Nycteridae(){
		super();
		System.out.println("Nycteridae genus established");
	}
	
	//Getters
	public String getGenus(){return GENUS;}
}