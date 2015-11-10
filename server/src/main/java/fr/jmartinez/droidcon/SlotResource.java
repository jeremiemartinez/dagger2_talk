package fr.jmartinez.droidcon;

import java.util.List;
import javax.inject.Inject;
import net.codestory.http.annotations.Get;
import net.codestory.http.annotations.Prefix;

@Prefix("/slots")
public class SlotResource {

    private final SlotService slotService;

    @Inject
    public SlotResource(SlotService slotService) {
        this.slotService = slotService;
    }

    @Get("/:login")
    public List<Slot> findByUser(String login) {
        return slotService.findByUser(login);
    }

}
