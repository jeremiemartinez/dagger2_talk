package fr.jmartinez.droidcon;

import static java.time.LocalDate.now;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class SlotService {

    private final SlotDB slotDB;

    @Inject
    public SlotService(SlotDB slotDB) {
        this.slotDB = slotDB;
    }

    public List<Slot> findByUser(String login) {
        return slotDB.all().stream().filter(s -> s.speaker.equalsIgnoreCase(login)).collect(Collectors.toList());
    }
}
