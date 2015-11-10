package fr.jmartinez.droidcon.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Speaker {

  public final String login;

  @JsonCreator
  public Speaker(@JsonProperty("login") String login) {
    this.login = login;
  }

  @Override
  public String toString() {
    return login;
  }
}
