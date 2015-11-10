package fr.jmartinez.droidcon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.codestory.http.security.User;

public class DroidconUser implements User, Comparable<DroidconUser>{

    private final String login;
    private final String firstname;
    private final String lastname;

    @JsonCreator
    public DroidconUser(@JsonProperty("login") String login, @JsonProperty("firstname") String firstname, @JsonProperty("lastname") String lastname) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String login() {
        return login;
    }

    @Override
    public String[] roles() {
        return new String[0];
    }

    @Override
    public int compareTo(DroidconUser o) {
        return login.compareTo(o.login);
    }

    @Override
    public boolean equals(Object obj) {
        return login.equals(((DroidconUser)obj).login);
    }
}
