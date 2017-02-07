package seedu.addressbook.data.tag;

import java.util.ArrayList;
import java.util.List;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

public class Tagging {
    private Person person;
    private ReadOnlyPerson readPerson;
    private Tag tag;
    private String type;
    private static final List<Tagging> TAGGINGS = new ArrayList<Tagging>();

    public Tagging(Person person, String type) {
        this.person = person;
        this.readPerson = null;
        this.type = type;
        TAGGINGS.add(this);
    }

    public Tagging(ReadOnlyPerson readPerson, String type) {
        this.person = null;
        this.readPerson = readPerson;
        this.type = type;
        TAGGINGS.add(this);
    }

    public Person getPerson() {
        return person;
    }

    public ReadOnlyPerson getReadPerson() {
        return readPerson;
    }

    public Tag getTag() {
        return tag;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return type + person.toString() + tag.toString();
    }

    public static void PrintAllChanges() {
        for (Tagging t : TAGGINGS) {
            if (null == t.getPerson()) {
                System.out.println(t.getType() + " "
                        + t.getReadPerson().getName() + " "
                                + t.getReadPerson().getTags().toString());
            } else {
                System.out.println(t.getType() + " "
                        + t.getPerson().getName() + " "
                                + t.getPerson().getTags().toString());
            }
        }
    }
}
