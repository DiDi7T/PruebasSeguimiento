import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import model.Person;
import structures.SimpleLinkedListPerson;

public class SimpleLinkedListPersonAdapter extends TypeAdapter<SimpleLinkedListPerson> {

    @Override
    public void write(JsonWriter out, SimpleLinkedListPerson list) throws IOException {
        out.beginArray();
        for (int i = 0; i < list.getSize(); i++) {
            Person person = list.get(i).getValue();
            out.beginObject();
            out.name("name").value(person.getName());
            out.name("age").value(person.getAge());
            out.endObject();
        }
        out.endArray();
    }

    @Override
    public SimpleLinkedListPerson read(JsonReader in) throws IOException {
        SimpleLinkedListPerson list = new SimpleLinkedListPerson();
        in.beginArray();
        while (in.hasNext()) {
            in.beginObject();
            String name = "";
            int age = 0;
            while (in.hasNext()) {
                String fieldName = in.nextName();
                if (fieldName.equals("name")) {
                    name = in.nextString();
                } else if (fieldName.equals("age")) {
                    age = in.nextInt();
                }
            }
            list.add(name, new Person(name, age));
            in.endObject();
        }
        in.endArray();
        return list;
    }
}
