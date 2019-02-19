package ru.hh.nab.example;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Objects;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.glassfish.jersey.message.filtering.EntityFiltering;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.Document;

//@EntityFiltering
//@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
@XmlRootElement
public class Todo {
//    @Id
    private String id;

//    @NotBlank
//    @Size(max=100)
//    @Indexed(unique=true)
    private String title;

    private Boolean completed = false;

    private Date createdAt = new Date();

    public Todo() {
        super();
    }

    public Todo(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo[id=%s, title='%s', completed='%s']",
                id, title, completed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) &&
                Objects.equals(title, todo.title) &&
                Objects.equals(completed, todo.completed) &&
                Objects.equals(createdAt, todo.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, completed, createdAt);
    }
}
