package utility;

class Location {
    private String state;
    private String city;

    public Location(String state, String city) {
        this.state = state;
        this.city = city;
    }
}

public class Employee {
    private String userName;
    private String employer;
    private Location location;

    public Employee (String userName, String employer){
        this.userName = userName;
        this.employer = employer;
    }

    public Employee (String userName, String employer, String state, String city){
        location = new Location(state,city);
        this.userName = userName;
        this.employer = employer;
        this.location = location;
    }
}
