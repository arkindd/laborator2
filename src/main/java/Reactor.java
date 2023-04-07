import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Reactor {
    @XmlElement(name = "type")
    String type;
    @XmlElement(name = "burnup")
    float burnup;
    @XmlElement(name = "kpd")
    float kpd;
    @XmlElement(name = "enrichment")
    float enrichment;
    @XmlElement(name = "termal_capacity")
    int termal_capacity;
    @XmlElement(name = "electrical_capacity")
    int electrical_capacity;
    @XmlElement(name = "life_time")
    int life_time;
    @XmlElement(name = "first_load")
    float first_load;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getBurnup() {
        return burnup;
    }

    public void setBurnup(float burnup) {
        this.burnup = burnup;
    }

    public float getKpd() {
        return kpd;
    }

    public void setKpd(float kpd) {
        this.kpd = kpd;
    }

    public float getEnrichment() {
        return enrichment;
    }

    public void setEnrichment(float enrichment) {
        this.enrichment = enrichment;
    }

    public int getTermal_capacity() {
        return termal_capacity;
    }

    public void setTermal_capacity(int termal_capacity) {
        this.termal_capacity = termal_capacity;
    }

    public int getElectrical_capacity() {
        return electrical_capacity;
    }

    public void setElectrical_capacity(int electrical_capacity) {
        this.electrical_capacity = electrical_capacity;
    }

    public int getLife_time() {
        return life_time;
    }

    public void setLife_time(int life_time) {
        this.life_time = life_time;
    }

    public float getFirst_load() {
        return first_load;
    }

    public void setFirst_load(float first_load) {
        this.first_load = first_load;
    }

    @Override
    public String toString() {
        return "Reactor{" +
                "type='" + type + '\'' +
                ", burnup=" + burnup +
                ", kpd=" + kpd +
                ", enrichment=" + enrichment +
                ", termal_capacity=" + termal_capacity +
                ", electrical_capacity=" + electrical_capacity +
                ", life_time=" + life_time +
                ", first_load=" + first_load +
                '}';
    }
}