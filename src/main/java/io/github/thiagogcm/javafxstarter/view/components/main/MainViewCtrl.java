package io.github.thiagogcm.javafxstarter.view.components.main;

import java.net.URL;
import java.util.ResourceBundle;

import io.github.thiagogcm.javafxstarter.model.Person;
import io.github.thiagogcm.javafxstarter.view.ViewFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainViewCtrl implements MainContract.View {
    private static final Logger logger = LoggerFactory.getLogger(MainViewCtrl.class);

    private MainContract.Presenter presenter;
    private ViewFactory viewFactory;

    @FXML
    private BorderPane mainPane;

    @FXML
    private Button btnShow;

    @FXML
    private Label lblResult;

    public MainViewCtrl(ViewFactory viewFactory) {
        this.viewFactory = viewFactory;
    }

    @Override
    public void display(Person person) {
        logger.debug("Displaying person");

        lblResult.setText(person.getName() + " " + person.getAge());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //presenter.start();

        btnShow.setOnAction(e -> presenter.showPerson());
    }

    @Override
    @Autowired
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
