package unrn.mongo.servicio;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class MongoServicio {

    private static final String DATABASE_NAME = "blogDB";

    public void ejecutarMongo(String collectionName, MongoOperacion operation) {

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(collectionName);
            operation.ejecutar(collection);
        }
    }

}
