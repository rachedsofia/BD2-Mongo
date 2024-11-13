package unrn.mongo.modelo;

import jdk.jshell.Snippet;
import lombok.*;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Post {
    private ObjectId id;
    private String title;
    private String author;
    private String text;
    private List<String> tags;
    private String resume;
    private List<String> relatedLinks;
    private Date date;


    public Post(ObjectId id, String title, String author, String text, List<String> tags, String resume, List<String> relatedLinks, Date date)
    {
        this.date = date;
        this.relatedLinks = relatedLinks;
        this.resume = (String) resume;
        this.tags =  tags;
        this.text = (String) text;
        this.author = author;
        this.title = title;
        this.id = id;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public List<String> getRelatedLinks() {
        return relatedLinks;
    }

    public void setRelatedLinks(List<String> relatedLinks) {
        this.relatedLinks = relatedLinks;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}