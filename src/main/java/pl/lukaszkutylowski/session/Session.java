package pl.lukaszkutylowski.session;

import org.springframework.stereotype.Component;
import pl.lukaszkutylowski.model.User;

@Component
public class Session {

    private User sessionUser;

    public User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User user) {
        this.sessionUser = user;
    }

    public void deleteSession() {
        this.sessionUser = null;
    }
}
