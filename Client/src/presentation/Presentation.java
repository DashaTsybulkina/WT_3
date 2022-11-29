package presentation;

import entity.User;
import presentation.view.GuestView;
import presentation.view.PresentationView;

public class Presentation {
    private PresentationView view;
    User currentUser;
    public Presentation() {
        this.currentUser = new User();
        this.currentUser.setPermission("");
        this.view = new GuestView();
    }

    public void show() {
        while (view != null) {
            view = view.show(currentUser);
        }
    }
}
