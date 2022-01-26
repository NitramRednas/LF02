package schritt3;

public abstract class  Person {

    private String name;
    private int alter;

    public Person(String name, int alter){
        this.name = name;
        this.alter = alter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public int getAlter() {
        return alter;
    }

}
