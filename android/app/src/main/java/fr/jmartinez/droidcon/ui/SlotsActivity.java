package fr.jmartinez.droidcon.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import fr.jmartinez.droidcon.R;
import fr.jmartinez.droidcon.api.event.CreateSlotEvent;
import fr.jmartinez.droidcon.api.event.SlotsEvent;
import fr.jmartinez.droidcon.api.event.SpeakerDetailsEvent;
import fr.jmartinez.droidcon.model.Slot;
import fr.jmartinez.droidcon.slot.SlotManager;
import fr.jmartinez.droidcon.speaker.SpeakerManager;

public class SlotsActivity extends AppCompatActivity {

  public static final String SPEAKER_EXTRA = "SPEAKER_EXTRA";

  @Bind(R.id.slot_list_view) ListView listView;
  @Bind(R.id.user) TextView userView;
  @Bind(R.id.image) ImageView imageView;

  private SpeakerManager speakerManager;
  private SlotManager slotManager;
  private EventBus bus;

  private ArrayAdapter<Slot> adapter;
  private String speaker;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.slots_activity);
    ButterKnife.bind(this);
    speaker = getIntent().getStringExtra(SPEAKER_EXTRA);
    adapter = new ArrayAdapter<>(this, R.layout.slot_item_view);
    listView.setAdapter(adapter);
    userView.setText(speaker);
    speakerManager = new SpeakerManager();
    slotManager = new SlotManager();
    bus = EventBus.getDefault();
  }

  @Override
  protected void onResume() {
    super.onResume();
    speakerManager.userDetails(speaker);
    slotManager.list(speaker);
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

  public void onEventMainThread(SlotsEvent event) {
    adapter.clear();
    adapter.addAll(event.getResult());
    adapter.notifyDataSetChanged();
  }

  public void onEventMainThread(SpeakerDetailsEvent speakerDetailsEvent) {
    userView.setText(speakerDetailsEvent.getDetails().toString());
    imageView.setImageResource(speakerDetailsEvent.getDetails().image);
  }

  public void onEventMainThread(CreateSlotEvent event) {
    slotManager.list(speaker);
  }
}
