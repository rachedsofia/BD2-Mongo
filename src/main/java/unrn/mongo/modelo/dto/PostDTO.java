package unrn.mongo.modelo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import org.bson.Document;

import java.util.List;

@Builder
@Getter
public class PostDTO {
    private Document _id;
    @NotBlank
    private String title;
    @NotBlank
    private String text;
    private List<String> tags;
    @NotBlank
    private String resume;
    private List<String> relatedlinks;
    @NotBlank
    private String author;
    private Document date;

    public static PostDTO fromDocument(Document docPost){

        Document id = new Document("$oid", docPost.getObjectId("_id").toHexString());
        Document date = new Document("$date", docPost.getDate("date"));

        return PostDTO.builder()
                ._id(id)
                .title(docPost.getString("title"))
                .resume(docPost.getString("resume"))
                .text(docPost.getString("text"))
                .tags(docPost.getList("tags", String.class))
                .relatedlinks(docPost.getList("relatedlinks", String.class))
                .author(docPost.getString("author"))
                .date(date)
                .build();
    }


}
