public record BasicDate(int year, int month, int day, int hour, int minutes, int seconds) implements ComparableDate<BasicDate> {

    @Override
    public boolean comesBefore(BasicDate other) {
        if (other.year() < year())
            return true;
        if (other.month() < month())
            return true;
        if (other.day() < day())
            return true;
        if (other.hour() < hour())
            return true;
        if (other.minutes() < minutes())
            return true;
        if (other.seconds() < seconds())
            return true;
        return false;
    }

}
