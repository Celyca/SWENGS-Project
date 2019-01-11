package swengs.therapiedb.model.therapie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import swengs.therapiedb.model.animal.Species;
import swengs.therapiedb.model.user.User;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private int duration;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Species species;

    @OneToMany(mappedBy = "offer")
    private List<Event> events;

    @ManyToOne
    private User employee;

    @Version
    @JsonIgnore
    private long version;

    public Offer() {
    }

    public Offer(String description, int duration) {
        this.description = description;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return id == offer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", location=" + location +
                ", species=" + species +
                ", events=" + events +
                ", employee=" + employee +
                ", version=" + version +
                '}';
    }
}
