package com.ikut.surucufx;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public BorderPane mainView;
    public Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("SürücüFX");
        showMain();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    private void showMain() throws IOException {
        mainView = FXMLLoader.load(getClass().getResource("/fxml/MainView.fxml"));
        stage.setScene(new Scene(mainView));
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.show();
    }
    
}
