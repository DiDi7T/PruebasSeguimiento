// import com.google.gson.Gson;

// import model.PersonController;

// public class Main {
//     public static void main(String[] args) {
//         PersonController controller = new PersonController();

//         controller.addPerson("name10", 10);
//         controller.addPerson("name20", 20);
//         controller.addPerson("name30", 30);

//         Gson gson = new Gson();

//         // Serializando a JSON
//         String json = gson.toJson(controller.getPeople());
//         System.out.println("JSON Serializado: " + json);

//         // // Un ejemplo de JSON
//         // String json = "{ 'people': [ { 'name': 'name10', 'age': 10 }, { 'name': 'name20', 'age': 20 } ] }";

//         // // Deserializando desde JSON
//         // SimpleLinkedListPerson people = gson.fromJson(json, SimpleLinkedListPerson.class);

//         // System.out.println("Persona deserializada: " + people.getFirst().getValue().getName());
//     }

// }
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.PersonController;
import structures.SimpleLinkedListPerson;
import structures.SimpleLinkedListPersonAdapter;

public class Main {
    public static void main(String[] args) {
        // Crear el Gson con el adaptador personalizado
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(SimpleLinkedListPerson.class, new SimpleLinkedListPersonAdapter())
            .create();

        // Crear tu controlador y agregar personas
        PersonController controller = new PersonController();
        controller.addPerson("name10", 10);
        controller.addPerson("name20", 20);

        // Serializar el objeto a JSON
        String json = gson.toJson(controller.getPeople());
        System.out.println("JSON: " + json);

        // Deserializar el JSON de nuevo a un objeto
        SimpleLinkedListPerson people = gson.fromJson(json, SimpleLinkedListPerson.class);
        System.out.println("Deserializado: " + people.getFirst().getValue().getName());

        //agregar pet a person
        // PersonController controller = new PersonController();

        // // Agregar personas
        // controller.addPerson("John", 30);
        // controller.addPerson("Jane", 25);

        // // Agregar mascotas a las personas
        // controller.addPetToPerson("John", "Max", 5);  // Agrega mascota "Max" a "John"
        // controller.addPetToPerson("Jane", "Bella", 3);  // Agrega mascota "Bella" a "Jane"

        // // Verificar si las mascotas fueron agregadas correctamente
        // System.out.println(controller.getPeople().search("John").getValue().getPets().search("Max").getValue());
        // System.out.println(controller.getPeople().search("Jane").getValue().getPets().search("Bella").getValue());


        //BUSQUEDA
        // Buscar a "Bob" usando búsqueda secuencial
        if (controller.getPeople().search("Bob") != null) {
            System.out.println("Bob fue encontrado.");
        } else {
            System.out.println("Bob no está en la lista.");
        }

        // Intentar buscar una persona que no está en la lista
        if (controller.getPeople().search("David") != null) {
            System.out.println("David fue encontrado.");
        } else {
            System.out.println("David no está en la lista.");
        }
    }
}
