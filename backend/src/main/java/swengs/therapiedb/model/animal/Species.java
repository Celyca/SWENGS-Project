package swengs.therapiedb.model.animal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import swengs.therapiedb.model.therapie.Offer;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "species")
    private List<Animal> animals;

    @OneToMany(mappedBy = "species")
    private List<Offer> offers;

    @Version
    @JsonIgnore
    private long version;

    public Species() {
    }

    public Species(String name) {
        this.name = name;
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

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Species species = (Species) o;
        return id == species.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animals=" + animals +
                ", offers=" + offers +
                ", version=" + version +
                '}';
    }
}
