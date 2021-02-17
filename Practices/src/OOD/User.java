package OOD;

public class User {
    private final String firstName;
    private final String lastName;
    private String phone;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPhone(){
        return phone;
    }
    public static class UserBuilder{
        private String firstName;
        private String lastName;
        private String phone = "";

        public UserBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public UserBuilder phone(int age){
            this.phone = phone;
            return this;
        }
        public User build(){
            if (firstName == null || lastName == null) {
                throw new IllegalArgumentException("required fields are not set");
            }
            return new User(this);
        }
    }
    public static void main(String[] args) {
        User user = new UserBuilder().firstName("xiaoxue").lastName("zeng").phone(123).build();
    }
}
