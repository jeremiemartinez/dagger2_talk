package fr.jmartinez.droidcon.api.event;

import fr.jmartinez.droidcon.model.SpeakerDetails;

public class SpeakerDetailsEvent {

  private final SpeakerDetails details;

  public SpeakerDetailsEvent(SpeakerDetails details) {
    this.details = details;
  }

  public SpeakerDetails getDetails() {
    return details;
  }
}
