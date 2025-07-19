package com.engine.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Signuppage {
    public Scene signUpScene;
    public Stage signUpStage;

    public void setsignUpScene(Scene signUpScene) {
        this.signUpScene = signUpScene;
    }
    public void setSignUpStage(Stage signUpStage) {
        this.signUpStage = signUpStage;
    }
    
    public Scene createScene(Runnable back){

        Font leagueSpartan = Font.loadFont(getClass().getResourceAsStream("/fonts/LeagueSpartan-Regular.ttf"), 20);
        Text signUpText = new Text("Sign Up");
        Text space = new Text(" ");
        signUpText.setFont(leagueSpartan);
        signUpText.setFont(new Font(35));

        Image bgImage = new Image(getClass().getResource("/background/bgImage.jpeg").toExternalForm());
        
        BackgroundImage backgroundImage = new BackgroundImage(
            bgImage,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(100,100, true, true, true, false)
        ); 

        StackPane bg = new StackPane();
        bg.setBackground(new Background(backgroundImage));

        //Name 
        ImageView nameImage = new ImageView(getClass().getResource("/name/name.png").toExternalForm());
        nameImage.setFitWidth(16);
        nameImage.setFitHeight(16);

        TextField nameTextField = new TextField();
        nameTextField.setPromptText("Enter Name");
        nameTextField.setStyle("-fx-background-radius: 20 ; -fx-border-radius: 20");
        nameTextField.setMaxWidth(500);

        HBox nameHBox = new HBox(10,nameImage,nameTextField);
        nameHBox.setAlignment(Pos.CENTER);

        //Email Address
        ImageView emailImage = new ImageView(getClass().getResource("/email/email.png").toExternalForm());
        emailImage.setFitWidth(16);
        emailImage.setFitHeight(16);

        TextField emailField = new TextField();
        emailField.setPromptText("Enter Email");
        emailField.setStyle("-fx-background-radius: 20; -fx-border-radius: 20");
        emailField.setMaxWidth(500);

        HBox emailHBox = new HBox(10,emailImage,emailField);
        emailHBox.setAlignment(Pos.CENTER);

        //Enter Password
        ImageView enterPassImageView = new ImageView(getClass().getResource("/enterpass/enterpass.png").toExternalForm());
        enterPassImageView.setFitWidth(16);
        enterPassImageView.setFitHeight(16);

        PasswordField enterPasswordField = new PasswordField();
        enterPasswordField.setPromptText("Enter Password");
        enterPasswordField.setStyle("-fx-background-radius: 20; -fx-border-radius: 20");
        enterPasswordField.setMaxWidth(500);

        HBox enterPasswordHBox = new HBox(10,enterPassImageView,enterPasswordField);
        enterPasswordHBox.setAlignment(Pos.CENTER);

        //Confirm Password
        ImageView confirmPassImageView = new ImageView(getClass().getResource("/confirmpass/confirmpass.png").toExternalForm());
        confirmPassImageView.setFitWidth(16);
        confirmPassImageView.setFitHeight(16);

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");
        confirmPasswordField.setStyle("-fx-background-radius: 20; -fx-border-radius: 20");
        confirmPasswordField.setMaxWidth(500);

        HBox confirmPasswordHBox = new HBox(10,confirmPassImageView,confirmPasswordField);
        confirmPasswordHBox.setAlignment(Pos.CENTER);

        HBox passwordHBox = new HBox(20,enterPasswordHBox,confirmPasswordHBox);
        passwordHBox.setAlignment(Pos.CENTER);

        Button signUpButton = new Button("Sign up");
        signUpButton.setStyle("-fx-background-radius: 5;" + 
        "-fx-background-color: linear-gradient(to right, #3a7bd5, #9f37ff);" +
        "-fx-text-fill: white;" + 
        "-fx-font-weight: bold;"+
        "-fx-font-size: 14px;"+
        "-fx-padding: 10 20 10 20;"+
        "-fx-background-radius: 30;" + "-fx-cursor: hand;");
        UIEffects.applyButtonHoverEffect(signUpButton);
        
        Text tx = new Text("Already a user !");
        Hyperlink login = new Hyperlink("Login");
        login.setOnAction(event -> {
            back.run();
        });

        HBox hyperlinkHBox = new HBox(tx,login);
        hyperlinkHBox.setAlignment(Pos.CENTER);

        HBox loginHBox = new HBox(20,signUpButton,hyperlinkHBox);
        loginHBox.setAlignment(Pos.CENTER);

        VBox detailsVBox = new VBox(20);
        detailsVBox.setAlignment(Pos.CENTER);
        detailsVBox.setMinSize(800,600);

        detailsVBox.setPadding(new Insets(10));
        detailsVBox.setMaxWidth(10);
        detailsVBox.setMaxHeight(10);
        detailsVBox.setBackground(new Background(new BackgroundFill(
            Color.rgb(255, 255, 255, 0.2),
            new CornerRadii(15),
            Insets.EMPTY
        )));

        detailsVBox.getChildren().addAll(signUpText,space,nameHBox,emailHBox,passwordHBox,loginHBox);
        bg.getChildren().add(detailsVBox);
        Scene sc = new Scene(bg,999,665);
        return sc;
    }
}