import java.util.HashMap;
import java.util.Map;


public class DataClass {

	public static final Map<String,String> DbAlphabets;
	public static final Map<String,String> DbNumbers;
	public static final Map<String,String> DbSpecialChars;
	static{
		DbAlphabets=new HashMap<String,String>();
		//bell ,lINE, fEED AND OTHER IRRELEVANT COMMANDS ARE NOT IMPLEMENTED
		DbAlphabets.put("null","00000");
		DbAlphabets.put(" ","00100");
		DbAlphabets.put("A","00011");DbAlphabets.put("B","11001");DbAlphabets.put("C","01110");
		DbAlphabets.put("D","01001");DbAlphabets.put("E","00001");DbAlphabets.put("F","01101");
		DbAlphabets.put("G","11010");DbAlphabets.put("H","10100");DbAlphabets.put("I","00110");
		DbAlphabets.put("J","01011");DbAlphabets.put("K","01111");DbAlphabets.put("L","10010");
		DbAlphabets.put("M","11100");DbAlphabets.put("N","01100");DbAlphabets.put("O","11000");
		DbAlphabets.put("P","10110");DbAlphabets.put("Q","10111");DbAlphabets.put("R","01010");
		DbAlphabets.put("S","00101");DbAlphabets.put("T","10000");DbAlphabets.put("U","00111");
		DbAlphabets.put("V","11110");DbAlphabets.put("W","10011");DbAlphabets.put("X","11101");
		DbAlphabets.put("Y","10101");DbAlphabets.put("Z","10001");
	}
		
	static{
		DbNumbers=new HashMap<String,String>();
		DbNumbers.put("0","10110");
		DbNumbers.put("1","10111");DbNumbers.put("2","10011");DbNumbers.put("3","00001");
		DbNumbers.put("4","01010");DbNumbers.put("5","10000");DbNumbers.put("6","10101");
		DbNumbers.put("7","00111");DbNumbers.put("8","00110");DbNumbers.put("9","11000");
	}
	static{
		DbSpecialChars=new HashMap<String,String>();
		DbSpecialChars.put(",","01100");DbSpecialChars.put(".","11100");
		DbSpecialChars.put("?","11001");DbSpecialChars.put(":","01110");
		DbSpecialChars.put(";","11110");DbSpecialChars.put("$","01001");
		DbSpecialChars.put("!","01101");DbSpecialChars.put("&","11010");
		DbSpecialChars.put("#","10100");DbSpecialChars.put("'","01011");
		DbSpecialChars.put("(","01111");DbSpecialChars.put(")","10010");
		DbSpecialChars.put("\"","10001");DbSpecialChars.put("/","11101");	
		DbSpecialChars.put("SwitchToDigits","11011");
		DbSpecialChars.put("SwitchToLetters","11111");
	}	
	
	private DataClass(){
		
	}
	
	private static DataClass DataClassInstance;
	
	public synchronized static DataClass getDataClassInstance(){
		if(DataClassInstance==null){
			DataClassInstance=new DataClass();
		}
		return DataClassInstance; 
	}

	public static Map<String, String> getDbalphabets() {
		return DbAlphabets;
	}

	public static Map<String, String> getDbnumbers() {
		return DbNumbers;
	}

	public static Map<String, String> getDbspecialchars() {
		return DbSpecialChars;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		throw new CloneNotSupportedException();
	}
	
	
	
}
