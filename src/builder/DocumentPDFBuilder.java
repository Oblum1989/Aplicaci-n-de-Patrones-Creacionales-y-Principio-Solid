package builder;

public abstract class DocumentPDFBuilder {
    public abstract DocumentPDFBuilder addTable(String table);
    public abstract DocumentPDFBuilder addTitle(String title);
    public abstract DocumentPDFBuilder addColumn(String column);
    public abstract DocumentPDFBuilder applyStyle(String style);
    public  abstract Document getResult();
}
