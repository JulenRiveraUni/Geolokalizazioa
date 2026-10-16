package paagbi;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Herrialdeak")
@XmlAccessorType(XmlAccessType.FIELD)
public class Herrialdeak {

    @XmlElement(name = "Herrialdea")
    private List<Countries> herrialdeak;

    // Constructor vacío necesario para JAXB
    public Herrialdeak() {
    }

    public List<Countries> getHerrialdeak() {
        return herrialdeak;
    }
}