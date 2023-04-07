import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
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

    public MutableTreeNode getFirstNode(ReactorType reactorType){
        return new DefaultMutableTreeNode(reactorType.getImportMethod());
    }
    public MutableTreeNode getNode(Reactor reactor) {
        DefaultMutableTreeNode reactorNode = new DefaultMutableTreeNode(reactor.getType());
        reactorNode.add(new DefaultMutableTreeNode("����� ��������: "+reactor.getBurnup()));
        reactorNode.add(new DefaultMutableTreeNode("���: "+reactor.getKpd()));
        reactorNode.add(new DefaultMutableTreeNode("����������: "+reactor.getEnrichment()));
        reactorNode.add(new DefaultMutableTreeNode("�������� ��������: "+reactor.getTermal_capacity()));
        reactorNode.add(new DefaultMutableTreeNode("�������������� ��������: "+reactor.getElectrical_capacity()));
        reactorNode.add(new DefaultMutableTreeNode("����� �����: "+reactor.getLife_time()));
        reactorNode.add(new DefaultMutableTreeNode("��������� ��������: "+reactor.getFirst_load()));
        return reactorNode;
    }
}
