package com.engine.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LandingPage {
    
    Scene landingPageScene;
    Stage landingPageStage;

    public void setLandingPageScene(Scene landingPageScene) {
        this.landingPageScene = landingPageScene;
    }
    
    public void setLandingPageStage(Stage landingPageStage) {
        this.landingPageStage = landingPageStage;
    }

    public Scene createLandingPage(Runnable back) {

    // Background Image
    Image bgImage = new Image(getClass().getResource("/background/bgImage.jpeg").toExternalForm());
    BackgroundImage backgroundImage = new BackgroundImage(
        bgImage,
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.DEFAULT,
        new BackgroundSize(100, 100, true, true, true, false)
    );

    Text landingText = new Text("Newton's Playground");
    landingText.setFont(new Font(35));
    landingText.setStyle("-fx-font-weight: bold;");

    Text descriptionText = new Text("Interactive Physics Engine and Simulation Platform");
    descriptionText.setFont(new Font(20));
    descriptionText.setFill(Color.WHITE);

    StackPane root = new StackPane();
    root.setBackground(new Background(backgroundImage));

    // Just one card
    VBox card1 = createCard(
        "⚡",                     
        "Real-time Physics",
        "Experience accurate physics \n  calculations with smooth \n\t60fps animations",
        "#3a7bd5", bgImage
    );
    UIEffects.applyFrostedStyle(card1);
    card1.setStyle("-fx-border-color: white; -fx-border-width: 2; -fx-background-radius: 20; -fx-border-radius: 20");
    UIEffects.applyElevationEffect(card1);

    VBox card2 = createCard(
            "🎯",
            "Interactive Controls",
            "Adjust parameters in real-time and\n\tsee immediate effects",
            "#00c96b", bgImage
    );
    UIEffects.applyFrostedStyle(card2);
    card2.setStyle("-fx-border-color: white; -fx-border-width: 2; -fx-background-radius: 20; -fx-border-radius: 20");
    UIEffects.applyElevationEffect(card2);

    VBox card3 = createCard(
            "▶",
            "Multiple Simulations",
            "Explore pendulums, projectiles,\n\tcollisions, and more",
            "#5e60ce", bgImage
    );
    card3.setStyle("-fx-border-color: white; -fx-border-width: 2; -fx-background-radius: 20; -fx-border-radius: 20");
    UIEffects.applyFrostedStyle(card3);
    UIEffects.applyElevationEffect(card3);

    HBox cardHBox = new HBox(20,card1,card2,card3);
    cardHBox.setAlignment(Pos.CENTER);

    Button startExploring = new Button("Start Exploring ▶");
    UIEffects.applyButtonHoverEffect(startExploring);
    startExploring.setStyle(
            "-fx-background-color: linear-gradient(to right, #3a7bd5, #9f37ff);" +
            "-fx-text-fill: white;" +
            "-fx-font-weight: bold;" +
            "-fx-font-size: 14px;" +
            "-fx-padding: 10 20 10 20;" +
            "-fx-background-radius: 30;" +
            "-fx-cursor: hand;"
    );

    VBox landingVBox = new VBox(30,landingText,descriptionText,cardHBox,startExploring);
    landingVBox.setAlignment(Pos.CENTER);

    // Optional: center align in VBox or StackPane
    root.getChildren().addAll(landingVBox);

    Scene sc = new Scene(root, 999, 665);
    return sc;
    }

public VBox createCard(String icon, String title, String description, String color, Image bgImage) {
    // Create cropped background behind card
    ImageView bgCrop = new ImageView(bgImage);
    bgCrop.setFitWidth(250); // same as card width
    bgCrop.setFitHeight(200); // same as card height
    bgCrop.setEffect(new GaussianBlur(20));
    //bgCrop.setOpacity(0.5); // optional for glass look

    Label iconLabel = new Label(icon);
    iconLabel.setStyle("-fx-font-size: 30px; -fx-text-fill: white;");

    Label titleLabel = new Label(title);
    titleLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: white;");

    Label descLabel = new Label(description);
    descLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

    VBox content = new VBox(10, iconLabel, titleLabel, descLabel);
    content.setAlignment(Pos.CENTER);
    content.setPadding(new Insets(20));
    content.setBackground(new Background(new BackgroundFill(
        Color.rgb(255, 255, 255, 0.3), new CornerRadii(20), Insets.EMPTY
    )));
    content.setBorder(new Border(new BorderStroke(Color.WHITE,
        BorderStrokeStyle.NONE, new CornerRadii(20), new BorderWidths(2))));

    StackPane cardStack = new StackPane(bgCrop, content);
    cardStack.setPrefSize(250, 200);
    cardStack.setStyle("-fx-background-radius: 20; -fx-border-radius: 20;");
    return new VBox(cardStack); // you can return cardStack directly too
}

}
