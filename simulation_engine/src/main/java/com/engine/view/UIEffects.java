package com.engine.view;

import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class UIEffects {

    public static void applyElevationEffect(Region card) {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(0);
        shadow.setOffsetY(0);
        //shadow.setColor(Color.web("#00000033")); // soft black

        card.setEffect(shadow);

        card.setOnMouseEntered((MouseEvent e) -> {
            Timeline enterAnimation = new Timeline(
                new KeyFrame(Duration.millis(200),
                    new KeyValue(shadow.radiusProperty(), 20),
                    new KeyValue(shadow.offsetYProperty(), 15)
                )
            );
            enterAnimation.play();
        });

        card.setOnMouseExited((MouseEvent e) -> {
            Timeline exitAnimation = new Timeline(
                new KeyFrame(Duration.millis(200),
                    new KeyValue(shadow.radiusProperty(), 0),
                    new KeyValue(shadow.offsetYProperty(), 0)
                )
            );
            exitAnimation.play();
        });
    }
    
    public static void applyButtonHoverEffect(Button button) {
    DropShadow shadow = new DropShadow();
    shadow.setRadius(0);
    shadow.setOffsetY(0);
    shadow.setColor(Color.web("#ffffff44")); 

    button.setEffect(shadow);

    button.setOnMouseEntered(e -> {
        Timeline hoverIn = new Timeline(
            new KeyFrame(Duration.millis(200),
                new KeyValue(shadow.radiusProperty(), 15),
                new KeyValue(shadow.offsetYProperty(), 5),
                new KeyValue(shadow.colorProperty(), Color.web("#ffffff99")) 
            )
        );
        hoverIn.play();
    });

    button.setOnMouseExited(e -> {
        Timeline hoverOut = new Timeline(
            new KeyFrame(Duration.millis(200),
                new KeyValue(shadow.radiusProperty(), 0),
                new KeyValue(shadow.offsetYProperty(), 0),
                new KeyValue(shadow.colorProperty(), Color.web("#ffffff44")) // revert to soft glow
            )
        );
        hoverOut.play();
    });
}


    public static void applyFrostedStyle(Region node) {
        node.setBackground(new Background(new BackgroundFill(
            Color.rgb(255, 255, 255, 0.2), new CornerRadii(20), Insets.EMPTY
        )));
        node.setEffect(new BoxBlur(10, 10, 3));
        node.setStyle("-fx-border-color: white; -fx-border-width: 2; " +
                    "-fx-background-radius: 20; -fx-border-radius: 20;");
    }

}

