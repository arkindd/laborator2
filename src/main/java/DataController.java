import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.stream.Collectors;

public class DataController {
    public ReactorType importFromXml() throws FileNotFoundException, JAXBException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/ReactorsXML.xml"));
        String body = br.lines().collect(Collectors.joining());
        StringReader reader = new StringReader(body);
        JAXBContext context = JAXBContext.newInstance(ReactorType.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ReactorType reactorType = (ReactorType) unmarshaller.unmarshal(reader);
        reactorType.setImportMethod("Imported from XML");
        return reactorType;
    }

    public ReactorType importFromJSON() throws IOException {
        File file = new File("src/main/resources/ReactorsJSON.json");
        ObjectMapper objectMapper = new ObjectMapper();
        ReactorType reactorType = objectMapper.readValue(file, new TypeReference<>(){});
        reactorType.setImportMethod("Imported from JSON");
        return reactorType;
    }

    public ReactorType importFromYAML() throws IOException {
        File file = new File("src/main/resources/ReactorsYAML.yaml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ReactorType reactorType = objectMapper.readValue(file, new TypeReference<>(){});
        reactorType.setImportMethod("Imported from YAML");
        return reactorType;
    }
}
