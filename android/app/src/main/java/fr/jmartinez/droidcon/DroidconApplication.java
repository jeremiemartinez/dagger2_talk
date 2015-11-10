package fr.jmartinez.droidcon;

import android.app.Application;

public class DroidconApplication extends Application {

  private static DroidconApplication app;

  @Override
  public void onCreate() {
    super.onCreate();
    app = this;
  }

  public static DroidconApplication app() {
    return app;
  }
}
