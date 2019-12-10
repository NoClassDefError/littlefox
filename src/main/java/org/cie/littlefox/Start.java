package org.cie.littlefox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("小狐狸网盘后台服务器管理工具");
        try {
            FXMLLoader loader = new FXMLLoader();
            //加载窗口
            BorderPane rootLayout = new BorderPane();
            Scene scene = new Scene(rootLayout,997,654);
            primaryStage.setScene(scene);
            primaryStage.show();

            //加载登录页面
            loader.setLocation(Start.class.getResource("/org/cie/littlefox/ui/config.fxml"));
            AnchorPane anchorPane = loader.load();
            rootLayout.setCenter(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
