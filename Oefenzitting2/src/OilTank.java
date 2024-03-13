import be.kuleuven.cs.som.annotate.Basic;

/**
 * A class of tanks for storing oil, involving a capacity and a contents.
 * The capacity expresses the maximum amount of oil that can be stored
 * in a tank; the contents expresses the actual amount of oil stored.
 * Implemented with nominal programming.
 */
class OilTank {
	

	// The capacity of this oil tank expressed.
	private int capacity;

	// The amount of oil currently stored in this oil tank.
	private int content;

	/**
	 * Initialize a new oil tank with given capacity and contents.
	 * @pre	The capacity must be a positive integer.
	 * 		| capacity > 0
	 * @pre	The content must be a positive integer and not exceed the capacity.
	 * 		| (0 < content) && (content < capacity)
	 */
	public OilTank(int capacity, int contents) {
		setCapacity(capacity);
		fill(contents);
	}
	
	/**
	 * Initialize a new oil tank with given capacity and no contents
	 * @pre	The capacity must be a positive integer.
	 *  	| capacity > 0
	 */
	public OilTank(int capacity) {
		this(capacity, 0);
	}
	
	/**
	 * Initialize a new oil tank with a capacity of 5000 and no contents
	 */
	public OilTank() {
		this(5000);
	}
	
	
	/**
	 * Add the given amount of oil to this tank.
	 * @pre The amount must be a positive integer.
	 * 		| amount > 0
	 * @post If the amount given is greater than the capacity, then the content will be set to the capacity.
	 * 		| this.setContent(this.getCapacity)
	 * @param amount
	 */
	public void fill(int amount) {
		setContents(Math.min(amount+getContents(),getCapacity()));
	}

	/**
	 * Fill this tank to its full capacity with oil.
	 */
	public void fill() {
		setContents(getCapacity());
	}

	/**
	 * Extract the given amount of oil from this tank.
	 * @pre The amount must be a positive integer.
	 * 		| amount > 0
	 * @post The content of the tank will get subtracted by amount
	 * and if amount is greater than the content it will be zero.
	 * 		| this.getContents(max(getContents() - amount, 0))
	 */
	public void extract(int amount) {
		assert (amount > 0) : "Precondition: Acceptable amount";
		if (amount > getContents()) {
			extract();
		} else {
			setContents(getContents() - amount);
		}
	}
	
	/**
	* Extract the full contents from this tank.
	*/
	public void extract() {
		setContents(0);
	}
	
	/**
	 * Transfer the entire contents of the other tank to this tank.
	 * @pre The other tank must be defined.
	 * 		| other != null
	 * @pre Both tanks must not be the same.
	 * 		| this != other
	 * @post The content of the tank is transferred to the other one.
	 */
	public void transferFrom(OilTank other) {
		if (other.getContents() <= this.getFree()) {
			this.fill(other.getContents());
			other.extract();
		} else {
			other.extract(this.getFree());
			this.fill();
		}
	}
	
	/**
	* Return the capacity of this oil tank.
	*/
	@Basic
	public int getCapacity() {
		return this.capacity;
	}
	
	/**
	* Return the contents of this oil tank.
	*/
	@Basic
	public int getContents() {
		return this.content;
	}
	
	/**
	* Return the free amount of space in this oil tank.
	* The difference between the capacity of this oil tank
	* and its contents.
	*/
	public int getFree() {
		return getCapacity() - getContents();
	}
	
	/**
	 * Check whether this tank is relatively more filled than the other tank.
	 * @pre The other tank must be defined.
	 * 		| other != null
	 * @pre Both tanks must not be the same.
	 * 		| this != other
	 */
	public boolean isFullerThan(OilTank other) {
		return this.getPercentageFilled() > other.getPercentageFilled();
	}
	
	/**
	* Return the relative amount (the percentage) of the capacity of this tank
	* filled with oil.
	* For a tank with a capacity of 0, 100% is returned.
	*/
	public double getPercentageFilled() {
		if (getCapacity() == 0) {
			return 100.0;
		} else {
			return (100.0 * getContents()) / getCapacity();
		}
	}
	
	/**
	 * Return the tank with the largest unused capacity out of this tank and
	 * the two other tanks.
	 * @pre The other tanks must be defined.
	 * 		| other1 != null && other2 != null
	 */
	public OilTank getMostFree(OilTank other1, OilTank other2) {
		OilTank result = this;
		if (other1.getFree() > result.getFree()) {
			result = other1;
		}
		if (other2.getFree() > result.getFree()) {
			result = other2;			
		}
		return result;
	}
	
	/**
	* Return a textual representation of this oil tank.
	* The resulting string has the form "Oil Tank with Capacity xxx and
	* Contents yyy".
	*/
	public String toString() {
		return "Oil Tank with Capacity " + getCapacity() +
				" and Contents " + getContents();
	}
	
	/**
	* Check whether this tank is identical to the other tank.
	* True if the capacity and the contents of this tank are equal to
	* the capacity, respectively the contents of the other tank.
	*/
	public boolean isSame(OilTank other) {
		return (other != null) &&
			(this.getCapacity() == other.getCapacity()) &&
			(this.getContents() == other.getContents());
	}
	
	/**
	* Return a new tank as an exact copy of this oil tank.
	*/
	public OilTank getCopy() {
		return new OilTank(getCapacity(), getContents());
	}
	
	/*
	* Set the capacity of this oil tank to the given amount.
	*/
	@Basic
	private void setCapacity(int amount) {
		this.capacity = amount;
	}
	
	/*
	* Set the contents of this oil tank to the given amount.
	*/
	@Basic
	private void setContents(int amount) {
		this.content = amount;
	}
}
