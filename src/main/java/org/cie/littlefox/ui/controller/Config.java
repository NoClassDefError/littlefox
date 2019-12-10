package org.cie.littlefox.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.cie.littlefox.LittlefoxApplication;
import org.cie.littlefox.util.ApplicationContextProvider;
import org.cie.littlefox.util.MyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class Config {
    @FXML
    public Button startButton;
    @FXML
    public TextArea output;

    public SpringApplication server;

    @FXML
    public Label serverStatus;
    public int sStatus = 0;

    @FXML
    public Label currentPort;

    @FXML
    public Label currentIP;

    @FXML
    public TextField portSet;

    @FXML
    public Label message;
    private MyProperties myProperties;

    public Config() {
        server = new SpringApplication(LittlefoxApplication.class);
        myProperties = new MyProperties();
        currentPort.setText((String) myProperties.get("server.port"));
        server.addListeners((ApplicationListener<ApplicationStartingEvent>) applicationStartingEvent -> {
            serverStatus.setText("正在启动");
            sStatus = 2;
        }, (ApplicationListener<ApplicationStartedEvent>) applicationStartedEvent -> {
            labelSet();
        }, (ApplicationListener<ApplicationFailedEvent>) applicationFailedEvent -> {
            serverStatus.setText("启动失败");
            startButton.setText("启动");
            sStatus = 0;
        }, (ApplicationListener<ContextClosedEvent>) event -> {
            labelClear();
        });
    }

    public void startServer() {
        if (sStatus == 0) {
            server.run();
        } else {
            ApplicationContext context = ApplicationContextProvider.getApplicationContext();
            if (context != null) {
                SpringApplication.exit(context);
                labelClear();
            } else {
                labelClear();
            }
        }
    }

    private void labelSet() {
        serverStatus.setText("正在运行");
        startButton.setText("停止");
        sStatus = 1;

    }

    private void labelClear() {
        sStatus = 0;
        serverStatus.setText("已停止");
        startButton.setText("启动");

    }

    private void portSet() {

    }

    public void change() {
        try {
            int port = Integer.parseInt(portSet.getText());
            myProperties.setProperty("server.port", port + "");
            currentPort.setText(port + "");
        } catch (NumberFormatException e) {
            message.setText("端口填写格式错误");
        }
    }
}
