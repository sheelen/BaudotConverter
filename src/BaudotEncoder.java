
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class BaudotEncoder {

	public String Text;
	public String out="";
	public  List<String> input;
	public  List<String> output=new ArrayList<String>();
	
	
	public static boolean count=true;
	public List<String> getOutput() {
		return output;
	}

	/*
	 * constructor takes the input as string and stores it into a List
	 */
	
	public BaudotEncoder(String s){
		Text=s.toUpperCase();
		String[] array=Text.split("");
		input= Arrays.asList(array);	
	
		Execute();
		//Converting list "output" back to string 
		for(String q: output){
			out +=q+ "\t";
		}

	}
	
	/*
	 * Method which takes each string from the list and call 
	 * corresponding method to fetch its corresponding Baudot code
	 */
	public void Execute(){
		
		for(Iterator<String> it=input.iterator();it.hasNext();){
			String key=it.next();
			
			if(key.equals("")){
				out="Please Enter a Message in the box below";
				break;
			}
			
			if(key.equals(" ")){	
				isAlphabet(key);
			}
			
			else if(key.matches("[a-zA-z]{1}")){
				isAlphabet(key);		
			}
			
			else if(key.matches("\\d{1}")){
				isNumber(key);
			}
			
			else{isSpecialChar(key);}
			
		}
		
	}
	
	public void isAlphabet(String a){
		if(count==false){
			count=true;
			output.add(DataClass.getDbspecialchars().get("SwitchToLetters"));
		}
		output.add(DataClass.getDbalphabets().get(a));
		count=true;
	}	
	public void isNumber(String n){
		//DataClass dc=DataClass.getDataClassInstance();
		if(count==true){
			output.add(DataClass.getDbspecialchars().get("SwitchToDigits"));
		}
		output.add(DataClass.getDbnumbers().get(n));
		count=false;
		
	}
	
	public void isSpecialChar(String sp){
		String eol = "\n";
		if(count==true&&!sp.equals(eol)){
			output.add(DataClass.getDbspecialchars().get("SwitchToDigits"));
		}
		if(!sp.equals(eol)){
		output.add(DataClass.getDbspecialchars().get(sp));
		count=false;}
	}

	public String getOut() {
		return out;
	}
		
}
