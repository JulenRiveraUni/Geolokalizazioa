package paagbi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLReader {

    public static List<Countries> irakurriHerrialdeak() {

        List<Countries> herrialdeak = new ArrayList<>();

        try {
            InputStream fitxategia = XMLReader.class.getClassLoader().getResourceAsStream("Countries.xml");

            if (fitxategia == null) {
                System.out.println("Ez da Countries.xml aurkitu");
                return herrialdeak;
            }

            DocumentBuilderFactory fabrika = DocumentBuilderFactory.newInstance();
            DocumentBuilder eraikitzailea = fabrika.newDocumentBuilder();
            Document dokumentua = eraikitzailea.parse(fitxategia);
            dokumentua.getDocumentElement().normalize();
            NodeList herrialdeenZerrenda = dokumentua.getElementsByTagName("Herrialdea");

            for (int i = 0; i < herrialdeenZerrenda.getLength(); i++) {
                Element herrialdea = (Element) herrialdeenZerrenda.item(i);
                String izena = herrialdea.getElementsByTagName("Izena").item(0).getTextContent();
                Element latitudea = (Element) herrialdea.getElementsByTagName("Latitudea").item(0);
                Element longitudea = (Element) herrialdea.getElementsByTagName("Longitudea").item(0);
                double latitudeMin = Double.parseDouble(latitudea.getElementsByTagName("Min").item(0).getTextContent());
                double latitudeMax = Double.parseDouble(latitudea.getElementsByTagName("Max").item(0).getTextContent());
                double longitudeMin = Double.parseDouble(longitudea.getElementsByTagName("Min").item(0).getTextContent());
                double longitudeMax = Double.parseDouble(longitudea.getElementsByTagName("Max").item(0).getTextContent());

                Countries herrialdeBerria = new Countries(izena,latitudeMin,latitudeMax,longitudeMin,longitudeMax);
                herrialdeak.add(herrialdeBerria);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return herrialdeak;
    }
}