package utility;

public class Employee {
    private String userName;
    private String employer;
    private Location location;

    public Employee (String userName, String employer){
        this.userName = userName;
        this.employer = employer;
    }

    public Employee (String userName, String employer, Location location){
        this.userName = userName;
        this.employer = employer;
        this.location = location;
    }
}