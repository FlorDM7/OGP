package oefening1;

public class Main {

    public static void main(String[] args){
        outer();
    }

    public static void inner(Person myWife) {
        Person patrick = new Person("Patrick");
        try {
            myWife.marry(patrick);
        } catch (IllegalPartnerException exc) {
        // myWife is already married
            myWife.divorce();
            patrick.marry(myWife);
        }
        Person child = new Person("Jake");
    }
    public static void outer() {
        Person john = new Person("John");
        Person peter = new Person("Peter");
        Person mary = new Person("Mary");
        Person ann = new Person("Ann", john);
        Person myFriend = new Person("David");

        peter = null;
        myFriend = ann;
        inner(myFriend);
        john = ann.getPartner();
    }
}
