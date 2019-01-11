package swengs.therapiedb.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class UserImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "original_file_name", nullable = false)
    private String originalFileName;

    @NotNull
    @Column(name = "content_type", nullable = false)
    private String contentType;

    @NotNull
    @Column(name = "jhi_size", nullable = false)
    private Long size;

    @OneToOne(mappedBy = "image")
    private User user;

    @Version
    @JsonIgnore
    private long version;

    public UserImage() {
    }

    public UserImage(@NotNull String originalFileName, @NotNull String contentType, @NotNull Long size, User user) {
        this.originalFileName = originalFileName;
        this.contentType = contentType;
        this.size = size;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
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
                ", originalFileName='" + originalFileName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", size=" + size +
                ", user=" + user +
                ", version=" + version +
                '}';
    }
}
