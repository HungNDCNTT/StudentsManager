package vn.poly.ass.model;

public class Student {
    private int id;
    private String name,birthday,idClass;

    public Student(int id, String name, String birthday, String idClass) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idClass = idClass;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }
}
