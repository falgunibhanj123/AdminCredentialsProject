package employeeManagement.model;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CredentialService {

void showCredentials(Employee employee) {
	System.out.println("Dear "+employee.getFirstName()+" your generated credentials are as follows");
	System.out.println("Email    ---> "+employee.getEmailID());
	System.out.println("Password ---> "+employee.getPassword());
}
	
void generateEmailID(Employee employee) {
		
		String emailID = employee.getFirstName().toLowerCase()+employee.getLastName().toLowerCase()+"@"+
						employee.getDepartment().toLowerCase()+"."+employee.getCompany().toLowerCase()+".com";
		employee.setEmailID(emailID);
		
	}
	String generateCredentials() {
		Stream<Character> demoPassword = Stream.concat(getRandomNumbers(2),   
                Stream.concat(getRandomSpecialChars(2),   
                        Stream.concat(getRandomAlphabets(2, true), getRandomAlphabets(2, false))));  
         
       List<Character> listOfChar = demoPassword.collect(Collectors.toList());  
         
       Collections.shuffle(listOfChar);  
         
       String password = listOfChar.stream()  
               .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)  
               .toString(); 
       return password;
	}
	
	
	
	
	    public static Stream<Character> getRandomSpecialChars(int length) {  
	          
	        Stream<Character> specialCharsStream;  
	          
	        Random random = new SecureRandom();  
	          
	        IntStream specialChars = random.ints(length, 33, 45);  
	        specialCharsStream =  specialChars.mapToObj(data -> (char) data);  
	          
	        return specialCharsStream;  
	    }  
	      
	    public static Stream<Character> getRandomNumbers(int length) {  
	          
	        Stream<Character> numberStream;  
	          
	        Random random = new SecureRandom();  
	          
	        IntStream numberIntStream = random.ints(length, 48, 57);  
	        numberStream = numberIntStream.mapToObj(data -> (char) data);  
	          
	        return numberStream;  
	    }  
	      
	    public static Stream<Character> getRandomAlphabets(int length, boolean check) {  
	          
	        Stream<Character> lowerUpperStream;  
	          
	        if(check == true) {  
	            Random random = new SecureRandom();  
	              
	            IntStream lCaseStream = random.ints(length, 'a', 'z');  
	            lowerUpperStream =  lCaseStream.mapToObj(data -> (char) data);  
	        }  
	        else {  
	            Random random = new SecureRandom();  
	              
	            IntStream uCaseStream = random.ints(length, 'A', 'Z');  
	            lowerUpperStream =  uCaseStream.mapToObj(data -> (char) data);  
	        }  
	          
	        return lowerUpperStream;  
	          
	    }  
}
