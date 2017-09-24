package io.github.thiagogcm.javafxstarter.view;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Parent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component
public class ViewFactory {
    private static final Logger logger = LoggerFactory.getLogger(ViewFactory.class);

    private FxmlLoader loader;
    private Map<String, Parent> viewInstances;

    public ViewFactory(FxmlLoader loader) {
        this.loader = loader;
        this.viewInstances = new HashMap<>();
    }

    /**
     * Lazily instantiate a JavaFX Parent Node
     */
    public Parent getView(String view) {
        Parent node = viewInstances.get(view);

        if (node == null) {
            logger.debug("Loading view");
            node = loader.load(view);
            viewInstances.put(view, node);

            return node;
        } else {
            logger.debug("View already loaded");
        }

        return node;
    }
}
