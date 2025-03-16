package prototype;

public class PDFDocument extends DocumentPrototype {
    @Override
    public DocumentPrototype cloneDocument() {
        System.out.println("Cloning PDF document...");
        return new PDFDocument();
    }

    public void generatePDF() {
        System.out.println("Generating PDF...");
    }
}