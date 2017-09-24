package io.github.thiagogcm.javafxstarter;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.github.thiagogcm.javafxstarter.view.ViewFactory;
import io.github.thiagogcm.javafxstarter.view.ViewLocation;

@SpringBootApplication
public class App extends Application {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private ConfigurableApplicationContext springContext;

    @Autowired
    private ViewFactory viewFactory;

    public static void main(String[] args) {
        logger.info("Starting App");

        launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(getClass());
        springContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("App Title");

        Scene scene = new Scene(viewFactory.getView(ViewLocation.MAIN_VIEW));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        springContext.close();
    }
}
