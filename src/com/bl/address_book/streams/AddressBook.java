package com.bl.address_book.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class AddressBook {
	static List<Contact> addressBook;

	public static void main(String[] args) {
		
		addressBook = new ArrayList<Contact>();

		boolean isExit = false;
		System.out.println("Welcome to the AddressBook ");
		Scanner sc = new Scanner(System.in);
		
		while(!isExit) {
			System.out.println("select the options");

			if(addressBook.isEmpty()) {
				System.out.println("\n1.Add Contact \n5.Exit");
			}else {
				System.out.println("1.Add Contact \n2.Display Contact \n3.Edit Contact \n4.Delete Contact \n5.Exit");
			}
			String option = sc.nextLine();
			switch(option) {
			case "1":
				addContact(sc);
				break;
			case "2":
				showContact();
				break;
			case "3":
				editContact(sc);
				break;
			case "4":
				deleteContact(sc);
				break;
			case "5":
				isExit = true;
				showContact();
				break;
			default :
				System.out.println("Invalid input");
				break;
			}
		}
		sc.close();
	}

	private static void deleteContact(Scanner sc) {
		System.out.println("Enter the Contact details which you want to delete?(Enter the First Name)");
		String firstName = sc.nextLine();
		Contact deleteContact = null;
		for (int i = 0; i < addressBook.size(); i++) {
			if (firstName.equals(addressBook.get(i).getFirstName())) {
				deleteContact = addressBook.remove(i);
			}
		}
		if (deleteContact == null) {
			System.err.println("no contact found with the First Name"+firstName);
		}else {
			System.out.println(deleteContact.getFirstName() +"has removed from the AddressBook");
		}

	}

	private static void editContact(Scanner sc) {
		System.out.println("enter the first name to edit contact");
		String firstName = sc.nextLine();
		Contact editContact = null;
		for (int i = 0; i < addressBook.size(); i++) {
			if(firstName.equals(addressBook.get(i).getFirstName())) {
				editContact = addressBook.get(i);
			}

		}
		if(editContact == null) {
			System.out.println("enter details not exist in contact"+firstName);

		}else {
			editContactDetail(editContact, sc);
		}
	}

	private static void editContactDetail(Contact editContact, Scanner sc) {


		System.out.println("Enter the First name");
		String firstName = sc.nextLine();
		editContact.setFirstName(validateFirstName(firstName, sc));;
		
		System.out.println("Enter the Last Name");
		String lastName = sc.nextLine();
		editContact.setLastName(validateLastName(lastName, sc));

		System.out.println("Enter the Email ID");
		String email = sc.nextLine();
		editContact.setEmailID(validateEmailID(email, sc));

		System.out.println("Enter the PhoneNumber");
		String phoneNumber = sc.nextLine();
		editContact.setPhoneNumber(validatePhoneNumber(phoneNumber, sc));;
		
		System.out.println("Enter zip Code ");
		String zipCode = sc.nextLine();
		editContact.setZipCode(validateZipCode(zipCode, sc));
		
		System.out.println("Contact has been edited");

	}

	private static void showContact() {
		if(addressBook.isEmpty()) {
			System.out.println("AddressBook is Empty");
		}else {
			for (Contact cont : addressBook) {
				System.out.println(cont);

			}
		}

	}

	private static void addContact(Scanner sc) {
		Contact contact = new Contact();

		System.out.println("Enter the First name");
		String firstName = sc.nextLine();
		contact.setFirstName(validateFirstName(firstName, sc));;
		
		System.out.println("Enter Last Name");
		String lastName = sc.nextLine();
		contact.setLastName(validateLastName(lastName, sc));

		System.out.println("Enter the Email ID");
		String email = sc.nextLine();
		contact.setEmailID(validateEmailID(email, sc));

		System.out.println("Enter the PhoneNumber");
		String phoneNumber = sc.nextLine();
		contact.setPhoneNumber(phoneNumber);
		
		System.out.println("Enter Zip Code");
		String zipCode = sc.nextLine();
		contact.setZipCode(validateZipCode(zipCode, sc));
		
		System.out.println(contact);

		addressBook.add(contact);
		System.out.println("Contact as saved");

	}

	public static String validateFirstName(String firstName, Scanner sc  ) {
		String nameValid = "^[A-Z]{1}[a-z]{2,9}$";
		Pattern regex = Pattern.compile(nameValid);
		Matcher inputMatcher = regex.matcher(firstName);

		while(!inputMatcher.matches()) {
			System.out.println("Invalid input");
			System.out.println("Lenght must not Exceeds 10 (EX: Rajshekar)");
			firstName = sc.nextLine();
			inputMatcher = regex.matcher(firstName);
		}
		return firstName;
	}
	
	public static String validateLastName(String lastName, Scanner sc ) {
		String namevalid = "^[A-Z]{1}[a-z]{3,7}$";
		Pattern regex = Pattern.compile(namevalid);
		Matcher inputMatcher = regex.matcher(lastName);
		
		
		while(!inputMatcher.matches()) {
			System.out.println("Invalid input");
			System.out.println("Lenth must not Exceeds 8 ");
			lastName = sc.nextLine();
			inputMatcher = regex.matcher(lastName);
		}
		return lastName;
	}

	public static String validateEmailID(String email, Scanner sc) {
		String resultPattern = "^[a-z.]{2,30}@{1}[a-z]{3,10}.[a-z]{3}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(email);

		while(!inputMatcher.matches()) {
			System.out.println("Invalid input");
			System.out.println("Lenght must be follow the expression (EX: Raj@gmail.com)");
			email = sc.nextLine();
			inputMatcher = regex.matcher(email);
		}
		return email;
	}

	public static String validatePhoneNumber(String phoneNumber, Scanner sc) {
		String resultPattern = "^[+]{0,1}[0-9]{0,2}[0-9]{10}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(phoneNumber);

		while(!inputMatcher.matches()) {
			System.out.println("Invalid input");
			System.out.println("Lenght must no (EX: +919999988888)");
			phoneNumber = sc.nextLine();
			inputMatcher = regex.matcher(phoneNumber);
		}
		return phoneNumber; 
	}
	
	
	public static String validateZipCode(String zipCode, Scanner sc) {
		String resultPattern = "^[0-9]{6}$";
		Pattern regex = Pattern.compile(resultPattern);
		Matcher inputMatcher = regex.matcher(zipCode);
		
		while(!inputMatcher.matches()) {
			System.out.println("Invalid input");
			System.out.println("Lenght no exceed with the pattern ");
			zipCode = sc.nextLine();
			inputMatcher = regex.matcher(zipCode);
		}
		return zipCode;
	}
}
