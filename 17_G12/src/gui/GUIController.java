/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
public class GUIController
{
    
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
        
    public void initialize() {
        // TODO
    }    

    //------------------------------------------------------
    //-----------------------Main Menu----------------------
    //------------------------------------------------------
    
    @FXML
    private void newGameButtonClicked(ActionEvent event)
    {
        changeScene(mainMenuScene, newGameScene);
    }

    @FXML
    private void highscoreButtonClicked(ActionEvent event)
    {
        changeScene(mainMenuScene, highscoreScene);
    }

    @FXML
    private void creditsButtonClicked(ActionEvent event)
    {
        changeScene(mainMenuScene, creditsScene);
    }

    @FXML
    private void quitButtonClicked(ActionEvent event)
    {
        //Quits the game
    }
    
    //------------------------------------------------------
    //---------------------New Game Menu--------------------
    //------------------------------------------------------
    
    @FXML
    private void newGameBackButtonClicked(ActionEvent event)
    {
        changeScene(newGameScene, mainMenuScene);
    }
    
    //------------------------------------------------------
    //--------------------Highscore Menu--------------------
    //------------------------------------------------------
    
    @FXML
    private void highscoreBackButtonClicked(ActionEvent event)
    {
        changeScene(highscoreScene, mainMenuScene);
    }
    
    //------------------------------------------------------
    //----------------------Credits Menu--------------------
    //------------------------------------------------------
    
    @FXML
    private void creditsBackButtonClicked(ActionEvent event)
    {
        changeScene(creditsScene, mainMenuScene);
    }
    
    //------------------------------------------------------
    //--------------------General Methods-------------------
    //------------------------------------------------------
    
    public void changeScene(AnchorPane from, AnchorPane to)
    {
        from.setVisible(false);
        from.setDisable(true);
        to.setVisible(true);
        to.setDisable(false);
    }

}
