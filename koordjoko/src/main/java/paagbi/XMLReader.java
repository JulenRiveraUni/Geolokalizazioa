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

    public static List<Countries> leerPaises() {

        List<Countries> paises = new ArrayList<>();

        try {

            InputStream archivo = XMLReader.class
                    .getClassLoader()
                    .getResourceAsStream("Countries.xml");

            if (archivo == null) {
                System.out.println("No se ha encontrado Countries.xml");
                return paises;
            }

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(archivo);

            document.getDocumentElement().normalize();

            NodeList listaPaises =
                    document.getElementsByTagName("Country");

            for (int i = 0; i < listaPaises.getLength(); i++) {

                Element pais = (Element) listaPaises.item(i);

                String name = pais
                        .getElementsByTagName("Name")
                        .item(0)
                        .getTextContent();

                Element latitude = (Element) pais
                        .getElementsByTagName("latitude")
                        .item(0);

                Element longitude = (Element) pais
                        .getElementsByTagName("longitude")
                        .item(0);

                double latitudeMin = Double.parseDouble(
                        latitude.getElementsByTagName("min")
                                .item(0)
                                .getTextContent()
                );

                double latitudeMax = Double.parseDouble(
                        latitude.getElementsByTagName("max")
                                .item(0)
                                .getTextContent()
                );

                double longitudeMin = Double.parseDouble(
                        longitude.getElementsByTagName("min")
                                .item(0)
                                .getTextContent()
                );

                double longitudeMax = Double.parseDouble(
                        longitude.getElementsByTagName("max")
                                .item(0)
                                .getTextContent()
                );

                Countries nuevoPais = new Countries(
                        name,
                        latitudeMin,
                        latitudeMax,
                        longitudeMin,
                        longitudeMax
                );

                paises.add(nuevoPais);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return paises;
    }
}