package paagbi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jakarta.xmlbind.JakartaXmlBindAnnotationModule;

public class JSONReader {

    public static List<Countries> irakurriHerrialdeak() {

        List<Countries> herrialdeak = new ArrayList<>();

        try {
            InputStream fitxategia = JSONReader.class.getClassLoader().getResourceAsStream("Countries.json");

            if (fitxategia == null) {
                System.out.println("Ez da Countries.json aurkitu");
                return herrialdeak;
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JakartaXmlBindAnnotationModule());

            Herrialdeak objektua = mapper.readValue(fitxategia, Herrialdeak.class);
            herrialdeak = objektua.getHerrialdeak();

        } catch (Exception e) {
            System.out.println("Errorea JSON irakurtzean.");
            e.printStackTrace();
        }

        return herrialdeak;
    }
}