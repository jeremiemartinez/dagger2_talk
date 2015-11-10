package fr.jmartinez.droidcon.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.jmartinez.droidcon.DroidconApplication;

public class SpeakerDetails {

  public final String login;
  public final String firstname;
  public final String lastname;
  public final int image;

  @JsonCreator
  public SpeakerDetails(@JsonProperty("login") String login, @JsonProperty("firstname") String firstname, @JsonProperty("lastname") String lastname) {
    this.login = login;
    this.firstname = firstname;
    this.lastname = lastname;
    this.image = DroidconApplication.app()
        .getResources()
        .getIdentifier(login, "drawable", DroidconApplication.app().getPackageName());
  }

  @Override
  public String toString() {
    return firstname + " " + lastname;
  }
}
