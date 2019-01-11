package swengs.therapiedb.model.therapie;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import swengs.therapiedb.model.animal.Animal;
import swengs.therapiedb.model.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date event;

    @ManyToOne
    private Animal animal;

    @ManyToOne
    private User user;

    @ManyToOne
    private Offer offer;

    @Version
    @JsonIgnore
    private long version;

    public Event() {
    }

    public Event(Date event) {
        this.event = event;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEvent() {
        return event;
    }

    public void setEvent(Date event) {
        this.event = event;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", event=" + event +
                ", animal=" + animal +
                ", user=" + user +
                ", offer=" + offer +
                ", version=" + version +
                '}';
    }
}
