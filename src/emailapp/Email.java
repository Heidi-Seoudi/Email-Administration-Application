package emailapp;

import java.util.Random;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity;
    private String alternateEmail;
    private static int defaultPasswordLength = 8;
    private static Random random = new Random();
    private static final String companySuffix = "myAppCompany.com";

    public Email(String firstName, String lastName){
        this(firstName, lastName, defaultPasswordLength);
    }
    public Email(String firstName, String lastName, int passwordLength) {
        this.firstName = firstName;
        this.lastName = lastName;
        setDepartment();
        generateAndSetPassword(passwordLength);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment() {
        System.out.println("Department Selection: ");
        System.out.println("1. Accounting\n2. Sales\n3. Development\n0. None\n");
        System.out.println("Please enter a code to select your department: ");
        Scanner scanner = new Scanner(System.in);
        int dept = scanner.nextInt();
        switch (dept){
            case 1 -> department = "accounting";
            case 2 -> department = "sales";
            case 3 -> department = "dev";
            default -> department = null;
        }
    }

    public void generateAndSetPassword(int length) {
        String lowerCase = "abcdefghijklmnopqrstuvwxyz1234567890";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String chars = "!@#$&_";
        int upperRand = random.nextInt(0,upperCase.length());
        int charsRand = random.nextInt(0,chars.length());
        char[] password = new char[length];
        password[0] = upperCase.charAt(upperRand);
        for(int i = 1; i< password.length; i++){
            if(i==(password.length/2)){
                password[i] = chars.charAt(charsRand);
                continue;
            }
            int lowerRand = random.nextInt(0,lowerCase.length());
            password[i] = lowerCase.charAt(lowerRand);
        }
        this.password = new String(password);
    }

    public void changePassword(String password) {
        //password validation code
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String toString(){
        String email =  firstName+"."+lastName+"@";
        if(department != null)
            email += department+".";
        email+=companySuffix;
        String info = """ 
                Employee Information
                Name: """ + firstName + " " + lastName + """
                \nEmail: """+email+ """
                \nMailBox Capacity: """+mailboxCapacity;
        if(alternateEmail != null){
            info+= """
                    \nAlternative Email: """+alternateEmail;
        }
        info+="%nYour randomly generated password is: %s%n".formatted(password);
        return info;
    }

}
