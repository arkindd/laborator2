import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataController {

    public ReactorType importData(String filePath) throws IOException, JAXBException {
        ReactorType reactorType;
        if (Objects.equals(getExtension(filePath), "xml")) {
            reactorType = importFromXml(filePath);
        } else if (Objects.equals(getExtension(filePath), "json")) {
            reactorType = importFromJSON(filePath);
        } else if (Objects.equals(getExtension(filePath), "yaml")) {
            reactorType = importFromYAML(filePath);
        } else return null;
        return reactorType;
    }

    public String getExtension(String filePath) {
        String extension = "";
        File file = new File(filePath);
        int dotIndex = file.getName().lastIndexOf(".");
        if (dotIndex > 0) {
            extension = file.getName().substring(dotIndex + 1);
        }
        return extension;
    }

    public ReactorType importFromXml(String fileName) throws FileNotFoundException, JAXBException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String body = br.lines().collect(Collectors.joining());
        StringReader reader = new StringReader(body);
        JAXBContext context = JAXBContext.newInstance(ReactorType.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ReactorType reactorType = (ReactorType) unmarshaller.unmarshal(reader);
        reactorType.setImportMethod("Imported from XML");
        return reactorType;
    }

    public ReactorType importFromJSON(String fileName) throws IOException {
        File file = new File(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        ReactorType reactorType = objectMapper.readValue(file, new TypeReference<>() {});
        reactorType.setImportMethod("Imported from JSON");
        return reactorType;
    }

    public ReactorType importFromYAML(String fileName) throws IOException {
        File file = new File(fileName);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ReactorType reactorType = objectMapper.readValue(file, new TypeReference<>() {});
        reactorType.setImportMethod("Imported from YAML");
        return reactorType;
    }
}
