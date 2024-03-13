import be.kuleuven.cs.som.annotate.Basic;

public class Oiltank {

    private int capacity;
    private int content;

    public Oiltank(int capacity, int content){
        setCapacity(capacity);
        setContent(content);
    }

    public Oiltank(int capacity) {
        this(capacity, 0);
    }

    public Oiltank(){
        this(5000,0);
    }

    /**
    * @post If the added amount is positive and the new amount doesn't exceed the capacity
     * then the content will change.
     */
    public void addAmount(int amount){
        int newAmount = this.content + amount;
        if ((newAmount <= capacity) && (amount > 0)){
            setContent(newAmount);
        }
    }

    /**
    * @post If the added amount is positive and the new amount doesn't become negative
     * then the content will change.
     */
    public void deleteAmount(int amount){
        int newAmount = this.content - amount;
        if ((newAmount > 0) && (amount > 0)){
            setContent(newAmount);
        }
    }

    public void fullTank(){
        setContent(this.capacity);
    }

    public void emptyTank(){
        setContent(0);
    }

    @Basic
    public int getCapacity() {
        return capacity;
    }

    @Basic
    public int getContent() {
        return content;
    }

    @Basic
    private void setCapacity(int capacity) {
        if (capacity > 0)
            this.capacity = capacity;
        else
            this.capacity = 0;
    }

    @Basic
    private void setContent(int content) {
        if (content > 0)
            this.content = content;
        else
            this.content = 0;
    }

    /**
     * Method transfers the content from one tank to another
     */
    public void transferTank(Oiltank oiltank){
        int content = oiltank.getContent();
        if ((this.getContent() + content < this.capacity) && (0 < oiltank.getContent() - content)) {
            oiltank.deleteAmount(content);
            this.addAmount(content);
        }
    }

    public boolean isMoreFillThen(Oiltank oiltank){
        float percentage1 = (float) this.getContent() / (float) this.getCapacity();
        float percentage2 = (float) oiltank.getContent() / (float) oiltank.getCapacity();
        return percentage1 > percentage2;
    }

    public boolean hasSameCapacity(Oiltank oiltank){
        return this.getCapacity() == oiltank.getCapacity();
    }

    public Oiltank makeCopy(){
        Oiltank oiltank = new Oiltank(this.getCapacity(), this.getContent());
        return oiltank;
    }

    public void printTank(){
        System.out.println("The capacity of the tank is " + this.capacity);
        System.out.println("The content of the tank is " + this.content);
    }


    /**
     * Method gives the tank with biggest capacity that is not full
     * @param oiltank2
     * @param oiltank3
     * @return Oiltank
     */
    public Oiltank biggestCapacityButNotFull(Oiltank oiltank2, Oiltank oiltank3){
        Oiltank oiltank1 = this;
        int capacity1 = 0;
        int capacity2 = 0;
        int capacity3 = 0;

        if (oiltank1.getContent() < oiltank1.getCapacity())
            capacity1 = oiltank1.getCapacity();

        if (oiltank2.getContent() < oiltank2.getCapacity())
            capacity2 = oiltank2.getCapacity();

        if (oiltank3.getContent() < oiltank3.getCapacity())
            capacity3 = oiltank3.getCapacity();

        int maximum = Math.max(capacity3 ,Math.max(capacity1,capacity2));
        if (maximum == capacity1)
            return oiltank1;
        if (maximum == capacity2)
            return oiltank2;
        return oiltank3;
    }
}
