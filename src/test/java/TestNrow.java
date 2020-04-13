import com.sun.tools.hat.internal.util.Comparer;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Stream;

public class TestNrow {

    public Person roman = new Person();
    public Person andrey = new Person();
    public Person vasia = new Person();


    @BeforeTest
    public void newTableForTest() {
        PersonDbManager personDbManager = new PersonDbManager();
        personDbManager.dropTable();
        personDbManager.createTable();
        roman.setAge(1);
        roman.setName("roman");
        andrey.setAge(2);
        andrey.setName("andrey");
        vasia.setAge(99);
        vasia.setName("vasia");
    }


    @Test
    public void testInRow() {
        PersonDbManager personDbManager = new PersonDbManager();
        List<Person> input = new ArrayList<>();
        input.add(roman);
        input.add(andrey);
        input.add(vasia);
        for (int i = 0; i < input.size(); i++) {
            personDbManager.insertPerson(input.get(i));
        }
        List<Person> output = personDbManager.selectPersons();
        Assert.assertEquals(input.size(), output.size());
        for (int i = 0; i < output.size(); i++) {
            Person curentInpunt = input.get(i);
            Person curentOutput = output.get(i);
            Assert.assertEquals(curentOutput.getName(), curentInpunt.getName());
            Assert.assertEquals(curentOutput.getAge(), curentInpunt.getAge());
        }

    }
    @Test
    public void testMaxAge() {
        PersonDbManager personDbManager = new PersonDbManager();
        List<Person> output = personDbManager.selectPersons();
        for (int i = 0; i < output.size(); i++) {
            Person curentOutput = output.get(i);
            System.out.println(curentOutput);

            List<Integer> ageList = new ArrayList<Integer>();
            ageList.add(curentOutput.getAge());
            ageList.add(curentOutput.getAge());
            ageList.add(curentOutput.getAge());
            Stream<Integer> stream = ageList.stream();
            Optional<Integer> max = stream.max((val1, val2) -> {
                return val1.compareTo(val2);
            });
            Integer maxAge = max.get();
            System.out.println(maxAge + " лет самому старому из списка");
        }
    }

    @Test
    public void testAge() {
        PersonDbManager personDbManager = new PersonDbManager();
        Comparator<Person> pcomp = new Person().thenComparing(new Person());
        TreeSet<Person> people = new TreeSet(pcomp);
        people.add(roman);
        people.add(andrey);
        people.add(vasia);

        for (Person p : people) {

            //System.out.println(p.getName() + " " + p.getAge());
        }

    }
}




