package fr.jmartinez.droidcon.speaker;

import fr.jmartinez.droidcon.api.ApiManager;

public class SpeakerManager {

  private final ApiManager apiManager = new ApiManager();

  public void userDetails(String user) {
    apiManager.userDetails(user);
  }

  public void list() {
    apiManager.users();
  }
}
