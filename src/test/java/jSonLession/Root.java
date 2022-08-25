package jSonLession;

import java.util.List;

public class Root {
    String name;
    List<People>people;
    String getName() {return name; }
    List<People> getListPeople() {return people; };

    public void setName(String name) {
        this.name = name;
    }
    public void setPeople(List<People> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "root{" +
                "name='" + people +
                '}';
    }

}
