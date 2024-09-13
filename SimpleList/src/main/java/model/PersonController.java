package model;

import java.util.Comparator;

import structures.NodePerson;
import structures.SimpleLinkedListPerson;

public class PersonController {

    private SimpleLinkedListPerson people;

    public PersonController(){
        people = new SimpleLinkedListPerson();
    }

    public void addPerson(String name, int age){
        Person person = new Person(name, age);
        people.add(name, person);
    }

    public void selectionSort(Comparator<Person> comparator){
        int n = people.getSize();
        for (int i = 0; i < n - 1; i++){
            for (int j = i+1; j < n; j++){
                if (comparator.compare(people.get(i).getValue(), people.get(j).getValue()) > 0){

                    //Person prev = toSort.get(i);
                    //Person current = toSort.get(j);

                    //toSort.set(i, current);
                    //toSort.set(j, prev);
                }
            }
        }
    }

    public void addPetToPerson(String personName, String petName, int petAge) {
        // Busca a la persona por su nombre
        NodePerson personNode = people.search(personName);
        if (personNode != null) {
            // Si la persona se encuentra, agrega la mascota
            personNode.getValue().addPet(petName, petAge);
            System.out.println("Mascota agregada a " + personName);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }


    public SimpleLinkedListPerson getPeople() {
        return people;
    }
}
