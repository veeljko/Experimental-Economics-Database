package rs.raf.m_stojanovic.bp.contactbook.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;
import rs.raf.m_stojanovic.bp.contactbook.Config;

public class MongoEksperimentRezultatDto {

    public static MongoEksperimentRezultatDto loadByEksperimentId(int eksperimentId) {
        MongoDatabase database = Config.getMongoDatabaseConnection();

        MongoCollection<Document> collection =
                database.getCollection("eksperiment_detaljni_rezultati");

        Document document = collection.find(
                new Document("eksperiment_id", eksperimentId)
        ).first();

        if (document == null) {
            return null;
        }

        JsonWriterSettings settings = JsonWriterSettings
                .builder()
                .indent(true)
                .build();

        return new MongoEksperimentRezultatDto(
                document.getInteger("eksperiment_id"),
                document.toJson(settings)
        );
    }

    private final int eksperimentId;
    private final String json;

    public MongoEksperimentRezultatDto(int eksperimentId, String json) {
        this.eksperimentId = eksperimentId;
        this.json = json;
    }

    public int getEksperimentId() {
        return eksperimentId;
    }

    public String getJson() {
        return json;
    }
}