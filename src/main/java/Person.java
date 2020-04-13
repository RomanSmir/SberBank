import java.util.Comparator;

public class Person implements Comparator<Person> {


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
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



        public int compare(Person a, Person b) {

            if (a.getAge() > b.getAge())
                return 1;
            else if (a.getAge() < b.getAge())
                return -1;
            else
                return 0;
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
