package fr.jmartinez.droidcon;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Slot {

    public final String title;
    public final String speaker;

    @JsonCreator
    public Slot(@JsonProperty("title") String title,
                @JsonProperty("speaker") String speaker) {
        this.title = title;
        this.speaker = speaker;
    }
}
