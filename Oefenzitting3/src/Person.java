import be.kuleuven.cs.som.annotate.Basic;


/**
 * A class representing persons.
 * @version 1.0
 */
public class Person {

    /**
     * The name of the person.
     */
    public String name;

    /**
     * The partner of the person.
     */
    public Person partner;

    /**
     * Variable to check if the person is terminated.
     */
    public boolean isTerminated;

    /**
     * Extended constructor requiring a name and a partner
     * @extend marry()
     */
    public Person(String name, Person partner){
        setName(name);
        marry(partner);
    }

    /**
     * Small constructor only requiring a name
     */
    public Person(String name) {
        this(name, null);
    }

    /**
     * Checks whether the persons can have each other as partners.
     * @return boolean
     */
    private static boolean canMarry(Person person, Person partner){
        return person != null && partner != null && person != partner && person.getPartner() == null && partner.getPartner() == null;
    }

    /**
     * Checks whether the persons can divorce.
     * @param person
     * @param partner
     * @return boolean
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

    private boolean isTerminated(){
        return isTerminated;
    }

    /**
     * A method to marry a person to a partner.
     * @post The partner of the person is changed if and only if he doesn't have a partner already and
     *       the partner doesn't have another partner and if the person doesn't marry himself.
     *       | canMarry(person, partner)
     * @throws IllegalPartnerException If it is not possible to marry then an exception will be thrown.
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
     * @post The partner of person is set to null
     * @post The partner of the partner is set to null.
     * @throws IllegalPartnerException If it is not possible to divorce.
     */
    public void divorce() throws IllegalPartnerException {
        if (!(canDivorce(this, this.getPartner()))) {
            throw new IllegalPartnerException(this);
        } else {
            getPartner().setPartner(null);
            setPartner(null);
        }
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
