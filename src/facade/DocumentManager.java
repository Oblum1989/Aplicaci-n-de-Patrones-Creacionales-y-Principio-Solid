package facade;

import builder.Document;

public class DocumentManager {
    private static DocumentManager instance;

    private DocumentManager() {}

    public static DocumentManager getInstance() {
        if (instance == null) {
            instance = new DocumentManager();
        }
        return instance;
    }

    public Document constructDocument(String format, String data) {
        System.out.println("Constructing document from " + format + " data...");
        return new Document();
    }
}