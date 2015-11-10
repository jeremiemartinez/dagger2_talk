package fr.jmartinez.droidcon.api;

import fr.jmartinez.droidcon.model.Slot;
import fr.jmartinez.droidcon.model.Speaker;
import fr.jmartinez.droidcon.model.SpeakerDetails;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface Api {

  @GET("/users")
  void users(Callback<List<Speaker>> callback);

  @GET("/users/{id}")
  void userDetails(@Path("id") String id, Callback<SpeakerDetails> callback);

  @GET("/slots/{id}")
  void slots(@Path("id") String id, Callback<List<Slot>> callback);
}
