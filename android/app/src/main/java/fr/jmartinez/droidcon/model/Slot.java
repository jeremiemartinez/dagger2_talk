package fr.jmartinez.droidcon.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Slot {

  public final String title;
  public final String speaker;

  @JsonCreator
  public Slot(@JsonProperty("title") String title, @JsonProperty("speaker") String speaker) {
    this.title = title;
    this.speaker = speaker;
  }

  @Override
  public String toString() {
    return title;
  }
}
