package factory;

public class ConcreteFormatFactory extends FormatFactory {
    @Override
    public FormatInput createFormat(String type) {
        return switch (type.toLowerCase()) {
            case "docx" -> new DOCXFormat();
            case "xlsx" -> new XLSXFormat();
            case "xml" -> new XMLFormat();
            default -> throw new IllegalArgumentException("Unsupported format: " + type);
        };
    }
}
