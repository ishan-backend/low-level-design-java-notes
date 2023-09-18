package classes2;

public class FileTester {
    public static void main(String []args) {
        File myFile = new File("usr/desktop/test");
        System.out.println(myFile.getDateOfCreation() + " " + myFile.getSize());
        myFile.copy("user/desktop/test2");
        myFile.addContent("letter7");
        System.out.println(myFile.getDateOfCreation() + " " + myFile.getSize());

        File myFile2 = new File("usr/desktop/test");
        System.out.println(myFile2.getDateOfCreation() + " " + myFile2.getSize());
        myFile2.copy("user/desktop/test2");
        myFile2.addContent("letter89");
        System.out.println(myFile2.getDateOfCreation() + " " + myFile2.getSize());
    }
}
