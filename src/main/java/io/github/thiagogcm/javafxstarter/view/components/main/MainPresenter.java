package io.github.thiagogcm.javafxstarter.view.components.main;

import io.github.thiagogcm.javafxstarter.service.PersonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MainPresenter implements MainContract.Presenter {
    private static final Logger logger = LoggerFactory.getLogger(MainPresenter.class);

    private MainViewCtrl mainViewCtrl;
    private PersonService personService;

    public MainPresenter(MainViewCtrl mainViewCtrl, PersonService personService) {
        this.mainViewCtrl = mainViewCtrl;
        this.personService = personService;
    }

    @Override
    public void showPerson() {
        logger.debug("in showPerson");

        mainViewCtrl.display(personService.getPerson());
    }
}
