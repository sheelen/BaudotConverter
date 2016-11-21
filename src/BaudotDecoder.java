import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;


public class BaudotDecoder {

	public String Text;
	public String out="";
	public  List<String> input;
	public  List<String> output=new ArrayList<String>();
	public static boolean flag=true;
	
	public BaudotDecoder(String s){
		/*
		 * Converts zeros and ones to a's and b's as string does not support binary
		 * data handling with spaces
		 */
		int a=s.length();
		StringBuilder sb=new StringBuilder(s);
		for(int i=0;i<a;i++){
			if(sb.charAt(i)=='1'){
				sb.replace(i, i+1, "b");
			}
			else if(sb.charAt(i)=='0'){
				sb.replace(i, i+1, "a");
			}	
		}
		
		String Text=sb.toString();
		Text=Text.replaceAll("\\s+","");	//Replacing all spaces with null
	/* Here we have a string "Text" of (a,b)s donating zeros and ones, without spaces */
	/*
	 * Breaking the String in 5 character sequence and storing it in an array then list "input"	
	 */
		String[] array=Text.split("(?<=\\G.{5})");
		input= Arrays.asList(array);
		//System.out.println("Input is "+input);	
		
		Execute();
	
		for(String q: output){
			out +=q;
		}
		//System.out.println(out);
	}
	
	public String convertToBinary(String nos){
		nos=nos.replaceAll("a", "0");
		nos=nos.replaceAll("b", "1");
		return nos;
	}
	
	public void Execute(){
		
		for(Iterator<String> it=input.iterator();it.hasNext();){
		String key=it.next();
		key=convertToBinary(key);
		
		 	if(key.length()==5 && key.equals("11111")){
			flag=true;
		 	key=it.next();
		 	key=convertToBinary(key);
		 	}
		 	
		 	if(key.length()==5 && key.equals("11011")){
		 	flag=false;
		 	key=it.next();
		 	key=convertToBinary(key);
		 	}
		
		 	if(key.length()==5 && flag==true){
			isAlphabet(key);
		 	}
		 	
		 	if(key.length()==5 && flag==false){
		 	isNumber(key);
		 	}
		 	
		 	if(key.length()==5 && key=="00100"){
			output.add(" ");
		 	}
		 	if(key.length()<5 ){
		 		output.add("\n \"REJECTED LAST DIGITS\" REASON: Keys should be in sequence or multiple of 5");
		 	}
		
		}
	
	}
	
	public void isAlphabet(String a){
	
		for (Entry<String, String> entry : DataClass.DbAlphabets.entrySet()) {
			if (entry.getValue().equals(a)) {
            output.add(entry.getKey());
            }
        }
	}	
	
	public void isNumber(String n){
		String value="";//extra variable to be checked for both variable and special character method
		for (Entry<String, String> entry : DataClass.DbNumbers.entrySet()) {
			if (entry.getValue().equals(n)) {
				value=entry.getKey();	
			}		
        }
		
		if(value.equals("")){
			for (Entry<String, String> entry : DataClass.DbSpecialChars.entrySet()) {
				if (entry.getValue().equals(n)) {
					value=entry.getKey();
	            }		
	        }
		}
		if(!value.equals("")){
			output.add(value);
		}
		
	}

	public String getOut() {
		return out;
	}
	
	//public static void main(String[] args){
		//new BaudotDecoder("11011100101111110110 00100 110111 10101");
		
//	}
}
