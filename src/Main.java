import builder.DOCXPDFBuilder;
import builder.Document;
import builder.DocumentPDFBuilder;
import prototype.PDFDocument;
import factory.ConcreteFormatFactory;
import factory.FormatFactory;
import factory.FormatInput;

public class Main {
    public static void main(String[] args) {
        // Using Factory Method
        FormatFactory factory = new ConcreteFormatFactory();
        FormatInput format = factory.createFormat("docx");
        format.readData();

        // Using Builder
        DocumentPDFBuilder builder = new DOCXPDFBuilder();
        Document doc = builder.addTitle("Title").addTable("Table").getResult();
        doc.generate();

        // Using Prototype
        PDFDocument original = new PDFDocument();
        PDFDocument clone = (PDFDocument) original.cloneDocument();
        clone.generatePDF();
    }
}