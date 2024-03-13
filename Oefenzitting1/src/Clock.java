import be.kuleuven.cs.som.annotate.Basic;

public class Clock {

    private int hours;
    private int minutes;
    private int seconds;
    public boolean indicatorFor12Hours; // true = AM, false = PM
    public boolean notationWith12Hours;

    public Clock(int hours, int minutes, int seconds, boolean indicator){
        this.setIndicatorFor12Hours(indicator);
        this.setNotationWith12Hours(true);
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public Clock(int hours, int minutes, int seconds){
        this.setIndicatorFor12Hours(true);
        this.setNotationWith12Hours(false);
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public Clock(){
        this.setIndicatorFor12Hours(true);
        this.setNotationWith12Hours(false);
        this.setHours(0);
        this.setMinutes(0);
        this.setSeconds(0);
    }

    @Basic
    public int getHours() {
        if (this.isNotationWith12Hours()){
            if (this.isIndicatorFor12Hours()){
                if (hours == 0)
                    return 12;
                else
                    return hours;
            } else {
                if (hours == 12)
                    return hours;
                else
                    return hours % 12;
            }
        } else {
            return hours % 24;
        }
    }


    /**
     * Sets hours to the given value.
     * If the given value is negative, hours will be set to 0.
     * If the given value is bigger than 24, the value will be hours % 24.
     */
    @Basic
    private void setHours(int hours) {
        if (hours < 0){
            this.hours = 0;
        } else if ((hours / 12) % 2 == 0) {
            this.setIndicatorFor12Hours(true);
            this.hours = hours % 24;
        } else {
            this.setIndicatorFor12Hours(false);
            this.hours = hours % 24;
        }
    }

    @Basic
    public int getMinutes() {
        return minutes;
    }

    /**
     * Sets minutes to the given value.
     * If the given value is negative, minutes will be set to 0.
     * If the given value is above 59, minutes will be set to the value % 60.
     * After this hours will be incremented with minutes/60 using setHours().
     */
    @Basic
    private void setMinutes(int minutes) {
        if (minutes < 0) {
            this.minutes = 0;
        } else {
            if ((minutes / 60) >= 1) {
                this.minutes = minutes % 60;
                setHours(this.hours + (minutes / 60));
            } else {
                this.minutes = minutes;
            }
        }
    }

    @Basic
    public int getSeconds() {
        return seconds;
    }

    /**
     * Sets seconds to the given value.
     * If the given value is negative, seconds will be set to 0.
     * If the given value is above 59, seconds will be set to the value % 60.
     * After this minutes will be incremented with seconds/60 using setMinutes().
     */
    @Basic
    private void setSeconds(int seconds) {
        if (seconds < 0) {
            this.seconds = 0;
        } else {
            if ((seconds / 60) >= 1) {
                this.seconds = seconds % 60;
                setMinutes(this.minutes + (seconds / 60));
            } else {
                this.seconds = seconds;
            }
        }
    }

    /**
     * Returns true if the clock is before noon (AM) and false if the clock is after noon (PM).
     */
    @Basic
    public boolean isIndicatorFor12Hours() {
        return indicatorFor12Hours;
    }

    /**
     * A mutator that can change the AM/PM indication of the clock.
     * @param indicatorFor12Hours
     */
    @Basic
    public void setIndicatorFor12Hours(boolean indicatorFor12Hours) {
        this.indicatorFor12Hours = indicatorFor12Hours;
    }

    /**
     * @return Returns true if the clock uses 12-hour notation, false if the clock uses 24-hour notation.
     */
    @Basic
    public boolean isNotationWith12Hours() {
        return notationWith12Hours;
    }

    /**
     * Changes the notation of the clock from 12-hour to 24-hour or vice versa.
     * @param notationWith12Hours
     */
    @Basic
    public void setNotationWith12Hours(boolean notationWith12Hours) {
        this.notationWith12Hours = notationWith12Hours;
    }

    /**
     * This mutator moves the clock one second forward.
     * The setter makes sure nothing illegal happens.
     */
    public void addOneSecond(){
        setSeconds(this.seconds + 1);
    }

    /**
     * Prints out a visual representation of a digital clock.
     */
    public void printClock(){
        if (this.isNotationWith12Hours()){
            if (this.isIndicatorFor12Hours()) {
                System.out.println(this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds() + " AM");
            } else {
                System.out.println(this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds() + " PM");
            }
        } else {
            System.out.println(this.getHours() + ":" + this.getMinutes() + ":" + this.getSeconds());
        }
    }
}
