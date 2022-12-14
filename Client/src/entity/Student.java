package entity;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private String lastname;
    private int age;
    private String spec;

    public Student(String name, String lastname, int age, String spec) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.spec = spec;
    }
    public Student(String[] args) {
        this.name = args[0];
        this.lastname = args[1];
        this.age = Integer.parseInt(args[3]);
        this.spec = args[2];
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", spec='" + spec + '\'' +
                '}';
    }
}
