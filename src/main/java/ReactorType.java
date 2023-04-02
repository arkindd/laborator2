import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ReactorType")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReactorType {
    @XmlElementWrapper(name="Reactors")
    @XmlElement(name="Reactor")
    private List<Reactor> reactorList = new ArrayList<>();

    private String importMethod;

    public void setImportMethod(String importMethod) {
        this.importMethod = importMethod;
    }

    public List<Reactor> getReactorList() {
        return reactorList;
    }

    public void setReactorList(List<Reactor> reactorList) {
        this.reactorList = reactorList;
    }

    public String getImportMethod() {
        return importMethod;
    }

    @Override
    public String toString() {
        return "ReactorType{" +
                "reactorList=" + reactorList +
                ", importMethod='" + importMethod + '\'' +
                '}';
    }
}
