package fr.jmartinez.droidcon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import de.greenrobot.event.EventBus;
import fr.jmartinez.droidcon.DroidconApplication;
import fr.jmartinez.droidcon.R;
import fr.jmartinez.droidcon.api.event.SpeakersEvent;
import fr.jmartinez.droidcon.model.Speaker;
import fr.jmartinez.droidcon.speaker.SpeakerManager;
import javax.inject.Inject;

public class SpeakersActivity extends AppCompatActivity {

  @Bind(R.id.user_list_view) ListView listView;

  @Inject SpeakerManager speakerManager;
  @Inject EventBus bus;

  private ArrayAdapter<Speaker> adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.users_activity);
    ButterKnife.bind(this);
    DroidconApplication.app().getComponent().inject(this);
    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
    listView.setAdapter(adapter);
  }

  @Override
  protected void onStart() {
    super.onStart();
    bus.register(this);
  }

  @Override
  protected void onStop() {
    super.onStop();
    bus.unregister(this);
  }

  @Override
  protected void onResume() {
    super.onResume();
    speakerManager.list();
  }

  @OnItemClick(R.id.user_list_view)
  public void onUserItemClicked(int position) {
    Speaker item = adapter.getItem(position);
    Intent intent = new Intent(this, SlotsActivity.class);
    intent.putExtra(SlotsActivity.SPEAKER_EXTRA, item.login);
    startActivity(intent);
  }

  public void onEventMainThread(SpeakersEvent event) {
    adapter.clear();
    adapter.addAll(event.getResult());
    adapter.notifyDataSetChanged();
  }
}
