package fr.jmartinez.droidcon.slot;

import fr.jmartinez.droidcon.api.ApiManager;

public class SlotManager {

  private final ApiManager apiManager = new ApiManager();

  public void list(String speaker) {
    apiManager.slots(speaker);
  }
}
