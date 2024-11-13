package unrn.mongo.modelo.dto;

import lombok.Builder;
import lombok.Getter;
import org.bson.Document;

@Builder
@Getter
public class OtherPostDTO {

    private Document _id;
    private String title;
    private String resume;

    public static OtherPostDTO fromDocument(Document docPost){

        Document id = new Document("$oid", docPost.getObjectId("_id").toHexString());

        return OtherPostDTO.builder()
                ._id(id)
                .title(docPost.getString("title"))
                .resume(docPost.getString("resume"))
                .build();
    }
}
