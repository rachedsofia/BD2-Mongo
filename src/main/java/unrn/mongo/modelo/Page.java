package unrn.mongo.modelo;
import lombok.*;
import org.bson.types.ObjectId;
import java.util.Date;
@Getter
@Setter

public class Page {
    private ObjectId id;
    private String title;
    private String author;
    private String text;
    private Date date;

    public Page(ObjectId id, String title, String author, String text, Date date) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.title = title;
        this.text = text;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}