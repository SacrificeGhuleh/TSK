package tsk2020.CV02;

public class Person {
    private int id;
    private String name;
    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person(int id, String name, String role) {
        super();
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Person() {
        super();
    }
}
