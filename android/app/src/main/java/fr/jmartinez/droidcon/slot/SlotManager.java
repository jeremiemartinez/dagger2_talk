package fr.jmartinez.droidcon.slot;

import fr.jmartinez.droidcon.api.ApiManager;
import javax.inject.Inject;

public class SlotManager {

  private final ApiManager apiManager;

  @Inject
  public SlotManager(ApiManager apiManager) {
    this.apiManager = apiManager;
  }

  public void list(String speaker) {
    apiManager.slots(speaker);
  }
}
