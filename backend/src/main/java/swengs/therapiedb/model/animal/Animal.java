package swengs.therapiedb.model.animal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import swengs.therapiedb.model.therapie.Event;
import swengs.therapiedb.model.therapie.Location;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String breed;
    private String color;
    private int age;
    private String gender;
    private String description;

    @ManyToOne
    private Species species;

    @OneToOne
    private AnimalImage image;

    @OneToMany(mappedBy = "animal")
    private List<Event> events;

    @ManyToOne
    private Location location;

    @Version
    @JsonIgnore
    private long version;

    public Animal() {
    }

    public Animal(String name, String breed, String color, int age, String gender, String description, Species species) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.species = species;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public AnimalImage getImage() {
        return image;
    }

    public void setImage(AnimalImage image) {
        this.image = image;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", species=" + species +
                ", image=" + image +
                ", events=" + events +
                ", location=" + location +
                ", version=" + version +
                '}';
    }
}
