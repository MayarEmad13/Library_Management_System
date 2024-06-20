package library_management_system;

public class Person {
    String name;
    private int id;

    
    public Person()
    {
        System.out.println("Hello User");
    }
    public Person(String name , int id)
    {
        this.name=name;
        this.id=id;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
