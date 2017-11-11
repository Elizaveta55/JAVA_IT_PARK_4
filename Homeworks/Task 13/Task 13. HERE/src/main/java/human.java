import com.google.common.base.MoreObjects;

public class human {
    private int age;
    private int height;
    private String name;

    public human(int age, int height, String name){
        this.age = age;
        this.height = height;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("age", age)
                .add("height", height)
                .add("name", name)
                .toString();
    }

}
