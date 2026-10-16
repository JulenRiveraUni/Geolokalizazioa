package paagbi;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Koordenatuak {

    @XmlElement(name = "Min")
    private double min;

    @XmlElement(name = "Max")
    private double max;

    // Constructor vacío necesario para JAXB
    public Koordenatuak() {
    }

    public Koordenatuak(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}