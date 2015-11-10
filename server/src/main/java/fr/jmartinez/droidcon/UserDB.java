package fr.jmartinez.droidcon;

import java.util.*;
import javax.inject.Singleton;

@Singleton
public class UserDB {

    private static final Map<String, DroidconUser> users = new HashMap<>();

    static {
        users.put("afogel", new DroidconUser("afogel", "Alexis", "Fogel"));
        users.put("apenel", new DroidconUser("apenel", "Alizée", "Penel"));
        users.put("arosovosky", new DroidconUser("arosovosky", "Alexis", "Rosovosky"));
        users.put("bphillips", new DroidconUser("bphillips", "Bill", "Phillips"));
        users.put("clatislaw", new DroidconUser("clatislaw", "Corey", "Latislaw"));
        users.put("dcavailles", new DroidconUser("dcavailles", "Damien", "Cavailles"));
        users.put("cmottier", new DroidconUser("cmottier", "Cyril", "Mottier"));
        users.put("emargraff", new DroidconUser("emargraff", "Etienne", "Margraff"));
        users.put("ecaron", new DroidconUser("ecaron", "Etienne", "Caron"));
        users.put("elezmy", new DroidconUser("elezmy", "Eyal", "Lezmy"));
        users.put("fmierzejewski", new DroidconUser("fmierzejewski", "Florian", "Mierzejewski"));
        users.put("fblavoet", new DroidconUser("fblavoet", "François", "Blavoet"));
        users.put("gbernard", new DroidconUser("gbernard", "Guillaume", "Bernard"));
        users.put("jmartinez", new DroidconUser("jmartinez", "Jeremie", "Martinez"));
        users.put("mpink", new DroidconUser("mpink", "Madis", "Pink"));
        users.put("mdecourville", new DroidconUser("mdecourville", "Marc", "De Courville"));
        users.put("mscheel", new DroidconUser("mscheel", "Mark", "Scheel"));
        users.put("mcalba", new DroidconUser("mcalba", "Mathieu", "Calba"));
        users.put("mboudraa", new DroidconUser("mboudraa", "Mounir", "Boudraa"));
        users.put("nhachicha", new DroidconUser("nhachicha", "Nabil", "Hachicha"));
        users.put("pbenayoun", new DroidconUser("pbenayoun", "Pierre", "Benayoun"));
        users.put("pcrepieux", new DroidconUser("pcrepieux", "Pierre", "Crepieux"));
        users.put("podybman", new DroidconUser("podybman", "Pierre-Olivier", "Dybman"));
        users.put("qsallat", new DroidconUser("qsallat", "Quentin", "Sallat"));
        users.put("rnachmany", new DroidconUser("rnachmany", "Ran", "Nachmany"));
        users.put("baugustin", new DroidconUser("baugustin", "Benjamin", "Augustin"));
        users.put("rpiel", new DroidconUser("rpiel", "Romain", "Piel"));
        users.put("skocken", new DroidconUser("skocken", "Stan", "Kocken"));
        users.put("sisakova", new DroidconUser("sisakova", "Svetlana", "Isakova"));
        users.put("toz", new DroidconUser("toz", "Turhan", "Oz"));
        users.put("vleck", new DroidconUser("vleck", "Volker", "Leck"));
        users.put("xhallade", new DroidconUser("xhallade", "Xavier", "Hallade"));
        users.put("blacroix", new DroidconUser("blacroix", "Benjamin", "Lacroix"));
        users.put("tguerin", new DroidconUser("tguerin", "Thomas", "Guerin"));
        users.put("jsdupuy", new DroidconUser("jsdupuy", "Jean-Sébastien", "Dupuy"));
    }

    public DroidconUser findById(String id) {
        return users.get(id);
    }

    public List<DroidconUser> findAll() {
        ArrayList<DroidconUser> droidconUsers = new ArrayList<>(users.values());
        Collections.sort(droidconUsers);
        return droidconUsers;
    }
}
