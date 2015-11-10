package fr.jmartinez.droidcon.api;

import android.widget.Toast;
import de.greenrobot.event.EventBus;
import fr.jmartinez.droidcon.BuildConfig;
import fr.jmartinez.droidcon.DroidconApplication;
import fr.jmartinez.droidcon.R;
import fr.jmartinez.droidcon.api.event.SlotsEvent;
import fr.jmartinez.droidcon.api.event.SpeakerDetailsEvent;
import fr.jmartinez.droidcon.api.event.SpeakersEvent;
import fr.jmartinez.droidcon.model.Slot;
import fr.jmartinez.droidcon.model.Speaker;
import fr.jmartinez.droidcon.model.SpeakerDetails;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Client;
import retrofit.client.Response;
import retrofit.converter.Converter;
import timber.log.Timber;

@Singleton
public class ApiManager {

  private final Client client;
  private final Converter converter;
  private final EventBus bus;
  private final Api api;

  @Inject
  public ApiManager(Client client, Converter converter, EventBus bus) {
    this.client = client;
    this.converter = converter;
    this.bus = bus;
    RestAdapter restAdapter = new RestAdapter.Builder() //
        .setEndpoint(BuildConfig.URL_SERVER) //
        .setConverter(this.converter) //
        .setClient(this.client) //
        .build();

    api = restAdapter.create(Api.class);
  }

  public void slots(String speaker) {
    api.slots(speaker, new Callback<List<Slot>>() {
      @Override
      public void success(List<Slot> slots, Response response) {
        bus.post(new SlotsEvent(slots));
      }

      @Override
      public void failure(RetrofitError error) {
        fail(error);
      }
    });
  }

  public void userDetails(String user) {
    api.userDetails(user, new Callback<SpeakerDetails>() {
      @Override
      public void success(SpeakerDetails speakerDetails, Response response) {
        bus.post(new SpeakerDetailsEvent(speakerDetails));
      }

      @Override
      public void failure(RetrofitError error) {
        fail(error);
      }
    });
  }

  public void users() {
    api.users(new Callback<List<Speaker>>() {
      @Override
      public void success(List<Speaker> speakers, Response response) {
        bus.post(new SpeakersEvent(speakers));
      }

      @Override
      public void failure(RetrofitError error) {
        fail(error);
      }
    });
  }

  private void fail(Exception e) {
    Toast.makeText(DroidconApplication.app(), R.string.error_http, Toast.LENGTH_LONG).show();
    Timber.e(e, "Error while calling server");
  }
}
