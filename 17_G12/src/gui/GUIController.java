/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author BenPaxIndustries
 */
public class GUIController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane defaultScene;
    @FXML
    private AnchorPane mainMenuScene;
    @FXML
    private Button newGameButton;
    @FXML
    private Button highScoreButton;
    @FXML
    private Button creditsButton;
    @FXML
    private Button quitButton;
    @FXML
    private ImageView mainMenuBackgroundImage;
    @FXML
    private AnchorPane creditsScene;
    @FXML
    private Button creditsBackButton;
    @FXML
    private ImageView creditsBackgroundImage;
    @FXML
    private AnchorPane highscoreScene;
    @FXML
    private ListView<?> highscoreList;
    @FXML
    private Button highscoreBackButton;
    @FXML
    private ImageView highscoreBackgroundImage;
    @FXML
    private AnchorPane newGameScene;
    @FXML
    private ImageView newGameBackgroundImage;
    @FXML
    private RadioButton veryEasyButton;
    @FXML
    private ToggleGroup difficultyRadioButtons;
    @FXML
    private RadioButton easyButton;
    @FXML
    private RadioButton normalButton;
    @FXML
    private RadioButton hardButton;
    @FXML
    private RadioButton veryHardButton;
    @FXML
    private Button newGameBackButton;
    @FXML
    private Button newGamePlayButton;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void newGameButtonClicked(ActionEvent event) {
    }

    @FXML
    private void highscoreButtonClicked(ActionEvent event) {
    }

    @FXML
    private void creditsButtonClicked(ActionEvent event) {
    }

    @FXML
    private void quitButtonClicked(ActionEvent event) {
    }
    
}
