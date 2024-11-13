package unrn.mongo.repositorio;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import unrn.mongo.servicio.MongoServicio;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

@Repository

public class PageRepository {

    private static final String COLLECTION_NAME = "pages";

    @Autowired
    private MongoServicio mongoServicio;

    public Document getPageById(String id) {
        AtomicReference<Document> documentPage = new AtomicReference<>();

        this.mongoServicio.ejecutarMongo(COLLECTION_NAME, collection -> {

            Document document = collection.find(Filters.eq("_id", new ObjectId(id))).first();

            documentPage.set(document);

        });

        return documentPage.get();
    }

}
