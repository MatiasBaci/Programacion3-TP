package orgFiuba.Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import orgFiuba.Model.Pokemones.Habilidad;
import orgFiuba.Model.Pokemones.Pokemon;
import orgFiuba.Model.SerializacionDeserealizacion.HabilidadDeserializer;
import orgFiuba.Model.SerializacionDeserealizacion.HabilidadIdsCustom;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServicioDeLecturasJson {

    static public Map<Integer, Habilidad> lecturaHabilidadesJson(String habilidadesPath){
        try {
            File habilidadesFile = new File(habilidadesPath);
            ObjectMapper objectMapper2 = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(List.class, new HabilidadDeserializer());
            objectMapper2.registerModule(module);

            List<HabilidadIdsCustom> habilidades = objectMapper2.readValue(habilidadesFile, new TypeReference<List<HabilidadIdsCustom>>() {});
            System.out.println(habilidades);
            Map<Integer, Habilidad> habilidadesID = habilidades.stream()
                    .collect(Collectors.toMap(HabilidadIdsCustom::getId, HabilidadIdsCustom::getUnaHabilida)); // ---> Lo tranformo en Hash para no usar Fors
            return habilidadesID;

        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción adecuadamente
            return null;
        }
    }

    public static Map<Integer, Pokemon> lecturaPokemonJson(String pokemonsPath){
        return null;
    }
}
