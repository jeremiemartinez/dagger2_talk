package fr.jmartinez.droidcon;

import android.app.Application;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import fr.jmartinez.droidcon.ui.SlotsActivity;
import fr.jmartinez.droidcon.ui.SpeakersActivity;
import javax.inject.Singleton;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;
import retrofit.converter.JacksonConverter;

public class DroidconApplication extends Application {

  private static DroidconApplication app;
  private DroidconComponent component;

  @Override
  public void onCreate() {
    super.onCreate();
    app = this;

    component = DaggerDroidconApplication_DroidconComponent.create();
  }

  public DroidconComponent getComponent() {
    return component;
  }

  public static DroidconApplication app() {
    return app;
  }

  @Component(modules = DroidconModule.class)
  @Singleton
  public interface DroidconComponent {
    void inject(SpeakersActivity activity);

    void inject(SlotsActivity activity);
  }

  @Module
  public static class DroidconModule {

    @Provides
    public Converter providesConverter() {
      return new JacksonConverter();
    }

    @Provides
    @Singleton
    public EventBus providesBus() {
      return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Client providesClient() {
      return new OkClient(new OkHttpClient());
    }
  }
}
