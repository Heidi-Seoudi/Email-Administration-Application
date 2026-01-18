package emailapp;

public class EmailApp {
    public static void main(String[] args) {
        Email johnEmail = new Email("John", "Smith");
        johnEmail.setMailboxCapacity(200);
        johnEmail.setAlternateEmail("jSmith@myAppCompany.com");
        System.out.println(johnEmail);
    }
}