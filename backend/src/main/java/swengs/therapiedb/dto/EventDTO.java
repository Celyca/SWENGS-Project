package swengs.therapiedb.dto;

import java.util.Date;

public class EventDTO {
    private long id;
    private Date event;
    private Long aninmal;
    private Long user;
    private Long offer;

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

    public Long getAninmal() {
        return aninmal;
    }

    public void setAninmal(Long aninmal) {
        this.aninmal = aninmal;
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
