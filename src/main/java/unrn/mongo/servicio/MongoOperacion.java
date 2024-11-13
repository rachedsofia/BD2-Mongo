package unrn.mongo.servicio;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

    @FunctionalInterface
    public interface MongoOperacion {
        void ejecutar(MongoCollection<Document> collection);
    }
