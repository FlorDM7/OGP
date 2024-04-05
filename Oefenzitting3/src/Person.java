import be.kuleuven.cs.som.annotate.*;

/**
 * A class representing persons.
 * @author Flor De Meulemeester
 * @version 1.0
 */
public class Person {

    /**
     * The name of the person.
     */
    public String name = null;

    /**
     * The partner of the person.
     */
    public Person partner = null;

    /**
     * Variable to check if the person is terminated.
     */
    public boolean isTerminated = false;

    /**
     * Extended constructor requiring a name and a partner
     * @param   name
     *          The name of the person
     * @param   partner
     *          The partner of the person
     */
    public Person(String name, Person partner){
        setName(name);
        if (partner != null) {
            marry(partner);
        } else {
            setPartner(null);
        }
    }

    /**
     * Small constructor only requiring a name
     * @param   name
     *          The name of the person
     */
    public Person(String name) {
        this(name, null);
    }

    /**
     * Checks whether the persons can have each other as partners.
     */
    private static boolean canMarry(Person person, Person partner){
        return person != null && partner != null && person != partner && person.getPartner() == null && partner.getPartner() == null;
    }

    /**
     * Checks whether the persons can divorce.
     */
    private static boolean canDivorce(Person person, Person partner){
        return (person == null) || (partner == null) || (person.getPartner() == partner) || (partner.getPartner() == person);
    }

    @Basic
    public String getName() {
        return name;
    }

    @Basic
    private void setName(String name) {
        this.name = name;
    }

    @Basic
    public Person getPartner() {
        return partner;
    }

    @Basic
    private void setPartner(Person partner) {
        this.partner = partner;
    }

    @Basic
    private boolean isTerminated(){
        return isTerminated;
    }

    @Basic
    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }

    /**
     * A method to marry a person to a partner.
     * @post    The partner of the person is changed if and only if he doesn't have a partner already and
     *          the partner doesn't have another partner and if the person doesn't marry himself.
     *          | canMarry(person, partner)
     * @throws  IllegalPartnerException
     *          If it is not possible to marry then an exception will be thrown.
     */
    public void marry(Person newPartner) throws IllegalPartnerException {
        if (!(canMarry(this, newPartner))){
            throw new IllegalPartnerException(this);
        } else {
            setPartner(newPartner);
        }
    }

    /**
     * A method to divorce a person from his partner (and vice versa).
     * @post    The partner of the person is set to null.
     * @post    The partner of the partner is set to null.
     * @throws  IllegalPartnerException
     *          If it is not possible to divorce.
     */
    public void divorce() throws IllegalPartnerException {
        if (!(canDivorce(this, getPartner()))) {
            throw new IllegalPartnerException(this);
        } else {
            if (getPartner() != null) {
                getPartner().setPartner(null);
            }
            setPartner(null);
        }
    }

    /**
     * A method to switch partners (not recommended).
     * @param   other
     *          The person you want to switch partners with.
     */
    public void switchPartners(Person other){
        Person partnerOfThis = getPartner();
        Person partnerOfOther = other.getPartner();
        divorce();
        other.divorce();
        other.marry(partnerOfThis);
        marry(partnerOfOther);
    }

    /**
     * A method to terminate a person, euh an object.
     */
    public void terminate(){
        if (!isTerminated()){
            divorce();
            setName(null);
        }
    }

}
