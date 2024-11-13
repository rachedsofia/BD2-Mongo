package unrn.mongo.repositorio;
import com.mongodb.client.model.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import unrn.mongo.servicio.MongoServicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class PostRepository {

    private static final String COLLECTION_NAME = "posts";

    @Autowired
    private MongoServicio mongoServicio;

    public Document findPostById(String id){
        AtomicReference<Document> documentPost  = new AtomicReference<>();

        this.mongoServicio.ejecutarMongo(COLLECTION_NAME, collection -> {

            Document document = collection.find(Filters.eq("_id", new ObjectId(id))).first();

            documentPost.set(document);
        });

        return documentPost.get();
    }
    public List<Document> findLatestPosts(){

        List<Document> result = new ArrayList<>();

        this.mongoServicio.ejecutarMongo(COLLECTION_NAME, collection -> {

            Bson projectionFields = Projections.fields(
                    Projections.include("id", "title", "resume"));

            collection.find()
                    .projection(projectionFields)
                    .sort(Sorts.descending("date"))
                    .limit(4)
                    .into(result);
        });

        return result;
    }

    public List<Document> findPostsByAuthorName(String name){

        List<Document> result = new ArrayList<>();

        this.mongoServicio.ejecutarMongo(COLLECTION_NAME, collection -> {

            collection.find(Filters.eq("author", name)).into(result);

        });

        return result;
    }

    public List<Document> findPostByText(String text){

        List<Document> result = new ArrayList<>();

        this.mongoServicio.ejecutarMongo(COLLECTION_NAME, collection -> {
            collection.createIndex(Indexes.text("text"));

            collection.find(Filters.text(text)).into(result);
        });

        return result;

    }

    public List<Document> findAuthors(){

        List<Document> documentAuthorsCount = new ArrayList<>();

        this.mongoServicio.ejecutarMongo(COLLECTION_NAME, collection -> {

            collection.aggregate(List.of(Aggregates.group("$author",
                    Accumulators.sum("count",
                            1))))
                    .into(documentAuthorsCount);

        });

        return documentAuthorsCount;
    }

}
