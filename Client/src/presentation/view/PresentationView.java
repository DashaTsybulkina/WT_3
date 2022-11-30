package presentation.view;

import entity.User;

public abstract class PresentationView {
    protected User currentUser;
    protected PresentationView(User user) {
        this.currentUser = user;
    }
    public abstract PresentationView show();
}
