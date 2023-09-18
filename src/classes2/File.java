package classes2;

import java.util.Date;

public class File {

    private String absPath;
    private double size;
    private Date dateOfCreation;
    private String content;

    public File(String absolutePath) {
        this.absPath = absolutePath;
        this.size = 8;
        this.dateOfCreation = new Date();
        this.content = "";
    }

    public String getAbsPath() {
        return this.absPath;
    }

    public double getSize() {
        return this.size;
    }

    public Date getDateOfCreation() {
        return this.dateOfCreation;
    }

    public String getContent() {
        return this.content;
    }

    public void rename(String renamed) {
        // todo: implement it
    }

    public void delete() {
        // todo: implement
    }

    public void copy(String name) {
        if(this.size > 10) {
            System.out.println("too big to copy");
        } else {
            System.out.println("copy successful");
        }
    }

    public void addContent(String content) {
        this.content += content;
        this.size += content.length();
    }
}
