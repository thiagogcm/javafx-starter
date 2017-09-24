package io.github.thiagogcm.javafxstarter.view.components;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface BaseView<T> extends Initializable {
    Logger logger = LoggerFactory.getLogger(BaseView.class);

    void setPresenter(T presenter);

    @Override
    default void initialize(URL location, ResourceBundle resources) {
        logger.info("Initializing " + location.getPath());
    }
}
