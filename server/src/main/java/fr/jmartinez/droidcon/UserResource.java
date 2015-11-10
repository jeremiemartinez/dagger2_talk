package fr.jmartinez.droidcon;

import javax.inject.Inject;
import net.codestory.http.annotations.Get;
import net.codestory.http.annotations.Prefix;

import java.util.List;

@Prefix("/users")
public class UserResource {

    private final UserDB userDB;

    @Inject
    public UserResource(UserDB userDB) {
        this.userDB = userDB;
    }

    @Get("/:id")
    public DroidconUser findById(String id) {
        return userDB.findById(id);
    }

    @Get
    public List<DroidconUser> findAll() {
        return userDB.findAll();
    }

}
