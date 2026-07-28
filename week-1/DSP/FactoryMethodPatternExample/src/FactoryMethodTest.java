public class FactoryMethodTest {
    public static void main(String[] args) {
        // Initialize our factories
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        System.out.println("--- Testing Streamlined Factory Method ---");
        
        // Manufacture and use a PDF
        Document pdf = pdfFactory.createDocument();
        pdf.open();
        pdf.close();

        System.out.println(); // Just a blank line for clean spacing

        // Manufacture and use an Excel file
        Document excel = excelFactory.createDocument();
        excel.open();
        excel.close();
    }
}