package fr.jmartinez.droidcon.speaker;

import fr.jmartinez.droidcon.api.ApiManager;
import javax.inject.Inject;

public class SpeakerManager {

  private final ApiManager apiManager;

  @Inject
  public SpeakerManager(ApiManager apiManager) {
    this.apiManager = apiManager;
  }

  public void userDetails(String user) {
    apiManager.userDetails(user);
  }

  public void list() {
    apiManager.users();
  }
}
