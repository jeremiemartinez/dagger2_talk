package fr.jmartinez.droidcon.api.event;

import fr.jmartinez.droidcon.model.Slot;
import java.util.List;

public class SlotsEvent {
  private final List<Slot> result;

  public SlotsEvent(List<Slot> slots) {
    result = slots;
  }

  public List<Slot> getResult() {
    return result;
  }
}
