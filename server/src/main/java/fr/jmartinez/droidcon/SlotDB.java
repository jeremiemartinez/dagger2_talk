package fr.jmartinez.droidcon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class SlotDB {

    private static final Map<Long, Slot> slots = new HashMap<>();
    private static final AtomicLong idsGenerator = new AtomicLong(1L);

    static {
        slots.put(idsGenerator.getAndIncrement(), new Slot("Improve your app metrics in weeks with Play Store Experiments", "afogel"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Striptease of The Android Permissions System", "apenel"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Striptease of The Android Permissions System", "arosovosky"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("What To Do About Fragments?", "bphillips"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Android Katas", "clatislaw"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Advanced Scrolling Techniques on Android", "cmottier"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Android Auto : Rolling Droid gather no moss", "dcavailles"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Microsoft, c'est aussi des services pour vos Apps Android (si, si!)", "emargraff"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Let's Play! Build your first Cardboard App", "ecaron"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Gradle plugins: take it to the next level", "elezmy"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Level up your Android Build", "fmierzejewski"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Let's sprinkle some #PerfMatters on our ViewGroups", "fblavoet"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Le Data Binding sur Android", "gbernard"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Dagger 2 - Back to basics", "jmartinez"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Squeezing the last drop of performance out of your Gradle builds", "mpink"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Archos Fusion Storage: a flexible and innovative mean to extend your Android products storage", "mdecourville"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("The Sharing Economy made Amazing by Android", "mscheel"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Task & Document API", "mcalba"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Comment développer une app en moins d'1h et en moins de 200 lignes avec Kotlin", "mboudraa"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Advanced techniques for concurrency & memory management", "nhachicha"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Comment j'ai retrouvé un code d'athlète avec Google Fit API", "pbenayoun"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Pourquoi la batterie de mon smartphone se vide en une journée ? voir moins :-/", "pcrepieux"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Mettre à jour un device Android, ok mais comment ça marche ? Les secrets de l'OTA", "podybman"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("From Nice To Astonishing", "qsallat"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Performance Matter", "rnachmany"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Let's get Functional", "baugustin"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("rpiel", "Ingredients for a healthy codebase"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Testez unitairement votre code, même votre UI !", "skocken"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Eddystone™, the open beacon format from Google", "toz"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Level up your Android Build", "vleck"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("The Android NDK and its new support in Android Studio/gradle-experimental plugin", "xhallade"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Comment tester (vraiment) une application Android", "blacroix"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Comment tester (vraiment) une application Android", "tguerin"));
        slots.put(idsGenerator.getAndIncrement(), new Slot("Microsoft, c'est aussi des services pour vos Apps Android (si, si!)", "jsdupuy"));
    }

    public List<Slot> all() {
        return new ArrayList<>(slots.values());
    }

    public void create(Slot slot) {
        slots.put(idsGenerator.getAndIncrement(), slot);
    }
}
