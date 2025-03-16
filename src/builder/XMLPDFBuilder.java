package builder;

public class XMLPDFBuilder extends DocumentPDFBuilder {
    private final Document document = new Document();

    @Override
    public DocumentPDFBuilder addTable(String table) {
        System.out.println("Adding table to XML PDF...");
        return this;
    }

    @Override
    public DocumentPDFBuilder addTitle(String title) {
        System.out.println("Adding title to XML PDF...");
        return this;
    }

    @Override
    public DocumentPDFBuilder addColumn(String column) {
        System.out.println("Adding column to XML PDF...");
        return this;
    }

    @Override
    public DocumentPDFBuilder applyStyle(String style) {
        System.out.println("Applying style to XML PDF...");
        return this;
    }

    @Override
    public Document getResult() {
        return document;
    }
}
