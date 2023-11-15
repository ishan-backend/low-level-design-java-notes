package designpatterns.builder;

public class Tester {
    public static void main(String []args) {
        /*
            new User(1, "Sita Ram", null, 22);
            new User(1, "Hanuman Ji");
        */
        /*
            User user = new User(1, "Sita ram");
            user.setAge(22);
            user.setPhoneNumber("999999999");
            user.setSchoolName("Karma");
        */

        /*
        * Builder Pattern ensures:
        * 1. Single constructor (No constructor explosion)
        * 2. Constructor doesn't have lots of arguments
        * 3. Immutability is ensured - don't need to worry about race condition, multithreaded system
        * 4. Easier for any client to populate any optional arguments
        * 5. We just sacrificed inner immutability of Builder class which is fine
        * */
        // we can call constructor of private property static Builder class of class User, by using
        User.Builder builder = new User.Builder(1, "Sita ram");
        builder.setAge(22);
        builder.setPhoneNumber("999998888");
        User user = new User(builder);

        // We can make the job bit easier by a concept called chaining - appears intuitive
        // User.Builder builder = new User.Builder(1, "Sita ram"); -> gives object of Builder
        // We can use it to invoke any non-static method but chaining can happen if all non-static methods return instance of Builder class
        // you can escape some setters also, since they are optional
        // if you want to return instance of User, write one more method
        User user1 = new User.Builder(1, "Sita ram").setAge(1000030445).setPhoneNumber("999998888").build();
        User user2 = new User.Builder(1, "hanuman ji").setAge(100000000).build();
        // You can rename your setters to your data members like setAge -> age
    }
}
