package io.github.thiagogcm.javafxstarter.view.components.main;

import io.github.thiagogcm.javafxstarter.model.Person;
import io.github.thiagogcm.javafxstarter.view.components.BaseView;

public interface MainContract {

    interface View extends BaseView<Presenter> {

        void display(Person person);
    }

    interface Presenter {

        void showPerson();
    }
}
