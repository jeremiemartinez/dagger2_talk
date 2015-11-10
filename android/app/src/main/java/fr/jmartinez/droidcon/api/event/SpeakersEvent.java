package fr.jmartinez.droidcon.api.event;

import fr.jmartinez.droidcon.model.Speaker;
import java.util.List;

public class SpeakersEvent {
  private final List<Speaker> result;

  public SpeakersEvent(List<Speaker> speakers) {
    result = speakers;
  }

  public List<Speaker> getResult() {
    return result;
  }
}
