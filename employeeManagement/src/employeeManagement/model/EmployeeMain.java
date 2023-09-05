package employeeManagement.model;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmployeeMain {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the first name: -");
		
		String firstName = sc.next();
		
		System.out.println("Please enter the last name: -");
		
		String lastName = sc.next();
		
		Employee employee = new Employee(firstName, lastName);
		
		System.out.println("Please enter the department from the following: -");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		
		switch (sc.nextInt()) {
		case 1: {
			employee.setDepartment("tech");
			break;
		}
		case 2: {
			employee.setDepartment("admin");
			break;
		}
		case 3: {
			employee.setDepartment("hr");
			break;
		}
		case 4: {
			employee.setDepartment("legal");
			break;
		}
		default:
		{
			System.out.println("Invalid value. Please enter between 1-4.");
		}
		}
		CredentialService credentialService = new CredentialService(); 
		credentialService.generateEmailID(employee);
		employee.setPassword(credentialService.generateCredentials());
		credentialService.showCredentials(employee);
		
	}
	
	
	      

	
	
	 
}
