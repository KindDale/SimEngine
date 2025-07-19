package com.engine.view;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Loginpage extends Application {

    Scene loginScene, signupScene, landingPageScene;
    Stage primaryStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        // Load background image
        Image bgImage = new Image(getClass().getResource("/background/bgImage.jpeg").toExternalForm());
        BackgroundImage backgroundImage = new BackgroundImage(
            bgImage,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(100, 100, true, true, true, false)
        );

        //User Icon
        ImageView userImage = new ImageView(getClass().getResource("/email/email.png").toExternalForm());
        userImage.setFitWidth(16);
        userImage.setFitHeight(16);

        //Lock Icon
        ImageView lockImage = new ImageView(getClass().getResource("/password/lock.png").toExternalForm());
        lockImage.setFitWidth(16);
        lockImage.setFitHeight(16);

        //Background
        StackPane bg = new StackPane();
        bg.setBackground(new Background(backgroundImage));

        //Font
        Font leagueSpartan = Font.loadFont(
            getClass().getResourceAsStream("/fonts/LeagueSpartan-Regular.ttf"), 20
        );

        //Text
        Text login = new Text("Welcome to Newton's playground");
        login.setFont(leagueSpartan);
        login.setFont(new Font(35));

        // VBox with background
        VBox detailsVBox = new VBox(20);
        detailsVBox.setAlignment(Pos.CENTER);
        detailsVBox.setMinSize(800,600);

        // Email field
        TextField emailField = new TextField();
        emailField.setPromptText("Enter Email");
        emailField.setStyle("-fx-background-radius: 20; -fx-border-radius: 20;");
        emailField.setMaxWidth(500);

        HBox userHBox = new HBox(10,userImage, emailField);
        userHBox.setAlignment(Pos.CENTER);

        // Password field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");
        passwordField.setStyle("-fx-background-radius: 20; -fx-border-radius: 20;");
        passwordField.setMaxWidth(500);

        HBox passwordHBox = new HBox(10, lockImage, passwordField);
        passwordHBox.setAlignment(Pos.CENTER);

        //Login Button
        Button loginButton = new Button("Login");
        loginButton.setStyle(
            "-fx-background-color: linear-gradient(to right, #3a7bd5, #9f37ff);" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-font-size: 14px;" +
            "-fx-padding: 10 20 10 20;" +
            "-fx-background-radius: 30;" +
            "-fx-cursor: hand;"
        );
        UIEffects.applyButtonHoverEffect(loginButton);
        loginButton.setOnAction(event -> {
            if(emailField.getText().isEmpty() || passwordField.getText().isEmpty()){
                emailField.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-radius: 20; -fx-border-radius: 20px");
                passwordField.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-radius: 20; -fx-border-radius: 20px");
            } else{
                initializeLandingPage();
                primaryStage.setScene(landingPageScene);
                applyFadeTransition(landingPageScene);
            }
        });


        Text tx = new Text("New Here ?");
        Hyperlink signUp = new Hyperlink("Sign Up");
        signUp.setOnAction(event -> {
            initializeSignUp();
            primaryStage.setScene(signupScene);
            applyFadeTransition(signupScene);
        });

        HBox signupHBox = new HBox(tx,signUp);
        signupHBox.setAlignment(Pos.CENTER);

        Text spaceText = new Text(" ");
        HBox spaceHBox = new HBox(spaceText);
        spaceHBox.setAlignment(Pos.CENTER);

        //HBox for login and Signup
        HBox loginAndSignUp = new HBox(30,loginButton,signupHBox);
        loginAndSignUp.setAlignment(Pos.CENTER);

        // Add fields to VBox
        detailsVBox.setPadding(new Insets(10));
        detailsVBox.setMaxWidth(10);
        detailsVBox.setMaxHeight(10);
        detailsVBox.setBackground(new Background(new BackgroundFill(
            Color.rgb(255, 255, 255, 0.2),
            new CornerRadii(15),
            Insets.EMPTY
        )));

        detailsVBox.getChildren().addAll(login,spaceText,userHBox,passwordHBox,spaceHBox,loginAndSignUp);   
        bg.getChildren().add(detailsVBox);

        // Show scene
        Scene page1Scene = new Scene(bg,999,665);
        primaryStage.setScene(page1Scene);
        loginScene = page1Scene;
        primaryStage.setTitle("Login Page");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void initializeSignUp(){
        Signuppage signUpPageObj = new Signuppage();
        signUpPageObj.setSignUpStage(primaryStage);
        signupScene = signUpPageObj.createScene(this::backToLogin);
        signUpPageObj.setsignUpScene(signupScene);
    }

    private void backToLogin(){
        primaryStage.setScene(loginScene);
        applyFadeTransition(loginScene);
    }

    private void initializeLandingPage(){
        LandingPage landingPageObj = new LandingPage();
        landingPageObj.setLandingPageStage(primaryStage);
        landingPageScene = landingPageObj.createLandingPage(this::handleBackButton);
        landingPageObj.setLandingPageScene(landingPageScene);
    }

    private void handleBackButton(){
        primaryStage.setScene(loginScene);
    }

    static public void applyFadeTransition(Scene scene) {
    FadeTransition fadeIn = new FadeTransition(Duration.millis(500), scene.getRoot());
    fadeIn.setFromValue(0.0);
    fadeIn.setToValue(1.0);
    fadeIn.play();  
    }

}