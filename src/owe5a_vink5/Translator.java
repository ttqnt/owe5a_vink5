package owe5a_vink5;

/**
 *
 * @author karin
 */

public class Translator {
	private String aaSeq;
	static final char[] ONE = {'A', 'R', 'N', 'D', 'C', 'Q', 'E', 'G', 'H', 'I', 'L', 'K', 'M', 'F', 'P', 'S', 'T', 'W', 'Y', 'V'};
	static final String[] THREE = {"Ala", "Arg", "Asn", "Asp", "Cys", "Gln", "Glu", "Gly", "His", "Ile", "Leu", "Lys", "Met", "Phe", "Pro", "Ser", "Thr", "Trp", "Tyr", "Val" };
	static final String[] AA = {"Alanine", "Arginine", "Asparagine", "Aspartic Acid", "Cysteine", "Glutamic Acid", "Glutamine", "Glysine", "Histidine", "Isoleucine", "Leucine", "Lysine", "Methionine", "Phenylalanine", "Proline", "Serine", "Threonine", "Tryptophan", "Tyrosine", "Valine" };
	  
	//constructor
	Translator(String input){
			setSequentie(input);
		}
		//controleert of de ingevoerde sequentie geldige 1 lettercode of codons zijn
	public void setSequentie(String input){
		String seq = input.toUpperCase();

		if (seq.matches("[ACDEFGHIKLMNPQRSTVWY]+")){
			aaSeq = seq;
		} else if (seq.matches("[ACDEFGHIKLMNOPQRSTUVWY]+")){
			if(isAminozuur(input)){
				aaSeq = input;
			}else{
				aaSeq =("Ongeldige tekens ingevoerd");
			}
		} else{
			aaSeq =("Ongeldige tekens ingevoerd");
		}
	}
	
	//omzeten van 1-lettercode in 3-lettercode
	public String threeLetter(){
		String threeCode = "";
		if (!aaSeq.equals("Ongeldige tekens ingevoerd")){
			for(int a = 0; a < aaSeq.length(); a++){
				for(int i = 0; i < ONE.length; i++){
					if (ONE[i] == (aaSeq.charAt(a) )) {
				        threeCode += (THREE[i]);
				        }
					}
				}
			aaSeq = threeCode;
		}
		return aaSeq;
	}
	
	//omzeten van 3- in 1-lettercode
	public String oneLetter(){
		String oneCode = "";
		String[] s = aaSeq.split("(?<=.)(?=\\p{Lu})");
		
		if (!aaSeq.equals("Ongeldige tekens ingevoerd")){
			for (int i = 0; i < s.length; i++)
				for(int x = 0; x < THREE.length; x++)
					if(s[i].equals(THREE[x])){
						oneCode += (ONE[x]);
						}
			aaSeq = oneCode;
		}
		return aaSeq;
	}

	//omzeten van 1-lettercode in volledige naam aminozuur	
	public String fullName(){
		String fullName = "";
		if (!aaSeq.equals("Ongeldige tekens ingevoerd")){
			for(int a = 0; a < aaSeq.length(); a++){
				for(int i = 0; i < ONE.length; i++){
					if (ONE[i] == (aaSeq.charAt(a) )) {
						fullName += (AA[i]+ " ");
				        }
					}
				}
			aaSeq = fullName;
		}
		return aaSeq;
	}
	
	//controleert of alle 3 lettercodes wel voor aminozuren vertalen
	private boolean isAminozuur(String seq){
		boolean b = false;
		String checkAA = "";
		String[] s = seq.split("(?<=.)(?=\\p{Lu})");
		
		for (int i = 0; i < s.length; i++)
			for(int x = 0; x < THREE.length; x++)
				if(s[i].equals(THREE[x]) ){
					checkAA += (s[i].toString() + "");
					}
		if (checkAA.length()/3 == s.length){
			b = true;
		}
		return b;
	}
}
