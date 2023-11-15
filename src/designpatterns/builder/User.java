package designpatterns.builder;

public class User {
    private final int id;
    private final String name;

/*
    private final String phoneNumber; // optional - clients will be forced to send default values say, null
    private final int age;

    public User(int id, String name, String phoneNumber, int age) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    // Function Overloading / Constructor Overloading - function with same names, but list of arguments can differ
    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.phoneNumber = "";
        this.age = 0;
    }

    public User(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = 0;
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.phoneNumber = "";
        this.age = age;
    }
 */
/*
    private String phoneNumber;
    private int age;
    // adding one more data member, requires us to modify all the constructors - combinatorial explosion
    // Solution: we can use setters
    private String schoolName; // this is optional, we will set it using setters

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.phoneNumber = "";
        this.age = 0;
        this.schoolName = "";
    }

    // setters require you to remove final keyword from data members
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
 */
    private final String phoneNumber;
    private final int age;

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.age = builder.age;
    }

    // static ensures, we can create object of this inner class without creating object of User e.g. User.Builder
    // intermediate class is used to hold contents of actual User class
    // sacrificing immutability of unimportant internal static Builder class
    public static class Builder {
        private final int id;
        private final String name;
        private String phoneNumber;
        private int age;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
            this.phoneNumber = "";
            this.age = 0;
        }
        /*

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public void setAge(int age) {
            this.age = age;
        }
        */

        // to support chaining
        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAge(int age) {
            if(age < 0)
                throw new IllegalArgumentException("age cannot be negative");
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
