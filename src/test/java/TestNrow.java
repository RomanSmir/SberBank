import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

public class TestNrow {


    @Test
    public void testTest() {
        PersonDbManager personDbManager = new PersonDbManager();
        personDbManager.dropTable();
        personDbManager.createTable();
        Person roman = new Person();
        roman.setAge(1);
        roman.setName("roman");
        Person andrey = new Person();
        andrey.setAge(2);
        andrey.setName("andrey");
        Person vasia = new Person();
        vasia.setAge(3);
        vasia.setName("vasia");
        personDbManager.insertPerson(roman);
        personDbManager.insertPerson(andrey);
        personDbManager.insertPerson(vasia);
        List<Person> personss = personDbManager.selectPersons();
        Assert.assertEquals(personss,roman);
        Assert.assertEquals(personss,vasia);
        Assert.assertEquals(personss,andrey);

    }


}
