public class Athlete extends Person {

    private String sportName;

    // Constructor
    public Athlete(String firstName, String lastName, String phoneNumber, String sportName) {
        super(firstName, lastName, phoneNumber);
        this.sportName = sportName;
    }

    // Getter
    public String getSportName() {
        return sportName;
    }

    // toString Method
    @Override
    public String toString() {
        return super.toString() + " Sport: " + sportName;
    }
}
