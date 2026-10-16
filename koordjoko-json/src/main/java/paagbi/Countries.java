package paagbi;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Herrialdea")
@XmlAccessorType(XmlAccessType.FIELD)
public class Countries {

    @XmlElement(name = "Izena")
    private String izena;

    @XmlElement(name = "Latitudea")
    private Koordenatuak latitudea;

    @XmlElement(name = "Longitudea")
    private Koordenatuak longitudea;

    // Constructor vacío necesario para JAXB
    public Countries() {
    }

    public Countries(
            String izena,
            double latitudeMin,
            double latitudeMax,
            double longitudeMin,
            double longitudeMax
    ) {
        this.izena = izena;
        this.latitudea = new Koordenatuak(latitudeMin, latitudeMax);
        this.longitudea = new Koordenatuak(longitudeMin, longitudeMax);
    }

    public String getIzena() {
        return izena;
    }

    public boolean contains(double latitude, double longitude) {
        return latitude >= getLatitudeMin() && latitude <= getLatitudeMax() && longitude >= getLongitudeMin() && longitude <= getLongitudeMax();
    }

    public double getLatitudeMin() {
        return latitudea.getMin();
    }

    public double getLatitudeMax() {
        return latitudea.getMax();
    }

    public double getLongitudeMin() {
        return longitudea.getMin();
    }

    public double getLongitudeMax() {
        return longitudea.getMax();
    }
}