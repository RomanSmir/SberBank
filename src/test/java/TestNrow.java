import com.sun.tools.hat.internal.util.Comparer;
import org.testng.annotations.AfterTest;
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
        roman.setAge(120);
        roman.setName("roman");
        andrey.setAge(200);
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
        Comparator<Person> comparator = Comparator.comparing(Person::getAge);
        Person maxObject = output.stream().max(comparator).get();
        String nameOldPerson = maxObject.getName();
        System.out.println(nameOldPerson);
    }
}





