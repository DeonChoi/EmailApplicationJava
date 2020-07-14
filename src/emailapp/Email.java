package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 12;
    private String alternateEmail;
    private String companySuffix = "company.com";

    //Constructor to receive first and last name
    public Email(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        //Call method that asks for department, which should return the department
        this.department = setDepartment();

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        //System.out.print(this.password);

        //Combine elements to generate an email
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase() + "." + this.companySuffix;
        System.out.println(this.email);

    }

    //Ask for the department
    private String setDepartment() {

        System.out.print("Enter the department code: \n1) for sales \n2) for Development \n3) for Accounting \n0) for None \n");
        Scanner scnr = new Scanner(System.in);
        int deptChoice = scnr.nextInt();
        switch (deptChoice) {
            case 1:
                return "Sales";
            case 2:
                return "Development";
            case 3:
                return "Accounting";
            default:
                return "";
        }

    }

    //Generate a random String for password
    private String randomPassword(int passwordLength) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
        String newPassword = "";
        for (int i=0; i<passwordLength; i++) {
            int randomCharIndex = (int) Math.floor(Math.random() * passwordSet.length());
            char passwordCharacter = passwordSet.charAt(randomCharIndex);
            newPassword += passwordCharacter;
        }
        return newPassword;
    }

    //Set mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    //Get name
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    //Get email
    public String getEmail() {
        return this.email;
    }

    //Get mailbox capacity
    public int getMailboxCapacity() {
        return this.mailboxCapacity;
    }

    //Get alternate email
    public String getAlternateEmail() {
        return this.alternateEmail;
    }

}