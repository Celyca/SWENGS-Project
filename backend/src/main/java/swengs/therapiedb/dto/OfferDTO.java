package swengs.therapiedb.dto;

public class OfferDTO {
    private long id;
    private String description;
    private int duration;
    private Long location;
    private Long species;
    private Long user;

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

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public Long getSpecies() {
        return species;
    }

    public void setSpecies(Long species) {
        this.species = species;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
