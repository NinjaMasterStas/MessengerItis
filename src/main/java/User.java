public class User {
    private String username;
    private int age;
    private String gender;

    public User(String username, int age, String gender){
        this.username = username;
        this.age = age;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
}
