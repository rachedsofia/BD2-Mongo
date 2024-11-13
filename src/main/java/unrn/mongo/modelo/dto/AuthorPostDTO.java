package unrn.mongo.modelo.dto;

import lombok.Builder;
import lombok.Getter;
import org.bson.Document;

@Builder
@Getter
public class AuthorPostDTO {
    private String _id;
    private int count;

    public static AuthorPostDTO fromDocument(Document doc){
        return AuthorPostDTO.builder()
                ._id(doc.getString("_id"))
                .count(doc.getInteger("count"))
                .build();
    }
}
