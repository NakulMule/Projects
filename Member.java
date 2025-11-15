package Internship.Library;

public class Member {
    private int memberId;
    private String name;
    private String password;

    public Member(int memberId, String name, String password) { // Added public modifier
        this.memberId = memberId;
        this.name = name;
        this.password = password;
    }

    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name;
    }
}
