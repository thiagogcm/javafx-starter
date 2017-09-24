package io.github.thiagogcm.javafxstarter.view;

import java.io.IOException;

import io.github.thiagogcm.javafxstarter.App;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FxmlLoader {
    private static final Logger logger = LoggerFactory.getLogger(FxmlLoader.class);

    private ConfigurableApplicationContext context;

    @Autowired
    public FxmlLoader(ConfigurableApplicationContext context) {
        this.context = context;
    }

    Parent load(String location) {
        logger.debug("Loading FXML from " + location);

        FXMLLoader loader = new FXMLLoader(App.class.getResource(location));
        loader.setControllerFactory(context::getBean);

        Parent parent = null;

        try {
            parent = loader.load();
        } catch (IOException e) {
            logger.error("Error on load fxml:" + e.getMessage());
        }

        return parent;
    }
}
