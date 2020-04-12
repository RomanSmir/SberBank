public class Person {


    private long uid;
    private String name;
    private int age;

    public Person() {

    }

    public Person(Long uid, String name, int age) {
        this.uid = uid;
        this.name = name;
        this.age = age;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getUid() {

        return uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age ;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
