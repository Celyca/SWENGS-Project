package swengs.therapiedb.dto;

import java.util.Date;

public class EventDTO {
    private long id;
    private String description;
    private Date event;
    private Long animal;
    private Long user;
    private Long offer;

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

    public Date getEvent() {
        return event;
    }

    public void setEvent(Date event) {
        this.event = event;
    }

    public Long getAnimal() {
        return animal;
    }

    public void setAnimal(Long animal) {
        this.animal = animal;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getOffer() {
        return offer;
    }

    public void setOffer(Long offer) {
        this.offer = offer;
    }
}
