package swengs.therapiedb.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class UserImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String filename;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;

    private String contentType;

    @OneToOne
    private User user;

    @Version
    @JsonIgnore
    private long version;

    public UserImage() {
    }

    public UserImage(String name, String filename, byte[] content, String contentType, User user) {
        this.name = name;
        this.filename = filename;
        this.content = content;
        this.contentType = contentType;
        this.user = user;
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserImage userImage = (UserImage) o;
        return id == userImage.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UserImage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", filename='" + filename + '\'' +
                ", content=" + Arrays.toString(content) +
                ", contentType='" + contentType + '\'' +
                ", user=" + user +
                ", version=" + version +
                '}';
    }
}
