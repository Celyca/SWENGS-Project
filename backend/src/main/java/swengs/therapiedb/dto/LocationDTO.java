package swengs.therapiedb.dto;

import java.util.List;
import java.util.Set;

public class LocationDTO {
    private long id;
    private String name;
    private String email;
    private int zip;
    private String city;
    private String address;
    private String phone;
    private Set<Long> animals;
    private Set<Long> users;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Long> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Long> animals) {
        this.animals = animals;
    }

    public Set<Long> getUsers() {
        return users;
    }

    public void setUsers(Set<Long> users) {
        this.users = users;
    }
}
