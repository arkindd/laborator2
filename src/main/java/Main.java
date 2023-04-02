import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        DataController dataController = new DataController();
        System.out.println(dataController.importFromXml());
        System.out.println(dataController.importFromJSON());
        System.out.println(dataController.importFromYAML());
    }
}