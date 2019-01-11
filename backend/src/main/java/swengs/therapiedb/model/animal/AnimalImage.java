package swengs.therapiedb.model.animal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class AnimalImage {

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
    private Animal animal;

    @Version
    @JsonIgnore
    private long version;

    public AnimalImage() {
    }

    public AnimalImage(@NotNull String originalFileName, @NotNull String contentType, @NotNull Long size, Animal animal) {
        this.originalFileName = originalFileName;
        this.contentType = contentType;
        this.size = size;
        this.animal = animal;
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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalImage that = (AnimalImage) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AnimalImage{" +
                "id=" + id +
                ", originalFileName='" + originalFileName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", size=" + size +
                ", animal=" + animal +
                ", version=" + version +
                '}';
    }
}
