package paagbi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class XMLReader {

    public static List<Countries> irakurriHerrialdeak() {

        List<Countries> herrialdeak = new ArrayList<>();

        try {

            InputStream fitxategia = XMLReader.class.getClassLoader().getResourceAsStream("Countries.xml");

            if (fitxategia == null) {
                System.out.println("Ez da Countries.xml aurkitu");
                return herrialdeak;
            }

            // JAXBContext sortu
            JAXBContext testuingurua = JAXBContext.newInstance(Herrialdeak.class);

            // Unmarshaller sortu
            Unmarshaller deserializatzailea = testuingurua.createUnmarshaller();

            // XML irakurri eta objektua sortu
            Herrialdeak herrialdeakObjektua = (Herrialdeak) deserializatzailea.unmarshal(fitxategia);
            herrialdeak = herrialdeakObjektua.getHerrialdeak();

        } catch (JAXBException e) {
            System.out.println("Errorea XML irakurtzean.");
            e.printStackTrace();
        }
        
        return herrialdeak;
    }
}