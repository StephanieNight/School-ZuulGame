/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import acquaintance.IGameEngine;
import acquaintance.IUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author BenPaxIndustries
 */
public class GUIController implements IUI {

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
    private Button loadGameButton;
    @FXML
    private AnchorPane gameScene;
    @FXML
    private Button forwardButton;
    @FXML
    private Button leftButton;
    @FXML
    private Button rightButton;
    @FXML
    private Button backButton;
    @FXML
    private Button inventoryButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button pickUpButton;
    @FXML
    private Button gameSceneOptionsButton;
    @FXML
    private AnchorPane optionsScene;
    @FXML
    private Button saveGameButton;
    @FXML
    private Button optionsBackToMenuButton;
    @FXML
    private Button optionsQuitGameButton;
    @FXML
    private Button resumeGameButton;
    @FXML
    private Button optionsHelpButton;
    @FXML
    private AnchorPane helpScene;
    @FXML
    private Button backToOptionsButton;
    @FXML
    private Button yesDeleteProgressButton;
    @FXML
    private Button noBackToOptionsButton;
    @FXML
    private AnchorPane wantToQuitPopUpLayer;
    @FXML
    private Button newGameNextButton;
    @FXML
    private AnchorPane EnterNamePopUpLayer;
    @FXML
    private Button PlayButton;
    @FXML
    private Button BackToDifficlyButton;
    @FXML
    private ImageView labyrinthImage;

    private boolean isMapView = false;
    private int difficulty = 3;
    private int itemNumber = 0;

    private IGameEngine gameEngine;
    @FXML
    private TextField enterPlayerName;
    @FXML
    private AnchorPane combatScene;
    @FXML
    private ImageView combatImage;
    @FXML
    private Button attackButton;
    @FXML
    private Button combatInventoryButton;
    @FXML
    private Button fleeButton;
    @FXML
    private TextField currentHealthField;
    @FXML
    private Button combatSceneOptionsButton;
    @FXML
    private Button mapButton;
    @FXML
    private AnchorPane inventoryScene;
    @FXML
    private RadioButton itemOneRadioButton;
    @FXML
    private ToggleGroup inventoryButtons;
    @FXML
    private RadioButton itemTwoRadioButton;
    @FXML
    private RadioButton itemFiveRadioButton;
    @FXML
    private RadioButton itemFourRadioButton;
    @FXML
    private RadioButton itemThreeRadioButton;
    @FXML
    private RadioButton itemSixRadioButton;
    @FXML
    private RadioButton itemSevenRadioButton;
    @FXML
    private Button useInventoryButton;
    @FXML
    private Button dropInventoryButton;
    @FXML
    private Button inspectInventoryButton;
    @FXML
    private Button closeInventoryButton;
    
    private RadioButton[] inventoryRadioButtons;
    private RadioButton[] searchRadioButtons;
    @FXML
    private TextArea logTextArea;
    @FXML
    private TextArea logCombatTextArea;
    @FXML
    private AnchorPane searchScene;
    @FXML
    private RadioButton roomItem1RadioButton;
    @FXML
    private RadioButton roomItem2RadioButton;
    @FXML
    private RadioButton roomItem3RadioButton;
    @FXML
    private RadioButton roomItem4RadioButton;
    @FXML
    private RadioButton roomItem5RadioButton;
    @FXML
    private RadioButton roomItem6RadioButton;
    @FXML
    private RadioButton roomItem7RadioButton;
    @FXML
    private ToggleGroup roomRadioButtons;
    @FXML
    private RadioButton roomItem8RadioButton;
    @FXML
    private RadioButton roomItem9RadioButton;
    @FXML
    private RadioButton roomItem10RadioButton;
    @FXML
    private RadioButton roomItem11RadioButton;
    @FXML
    private RadioButton roomItem12RadioButton;

    public void initialize() {
        // TODO
    }

    //------------------------------------------------------
    //-----------------------Main Menu----------------------
    //------------------------------------------------------
    @FXML
    private void newGameButtonClicked(ActionEvent event) {
        changeScene(mainMenuScene, newGameScene);
    }

    @FXML
    private void highscoreButtonClicked(ActionEvent event) {
        changeScene(mainMenuScene, highscoreScene);
        gameEngine.loadHighScore();
    }

    @FXML
    private void creditsButtonClicked(ActionEvent event) {
        changeScene(mainMenuScene, creditsScene);
    }

    @FXML
    private void quitButtonClicked(ActionEvent event) {
        //Quits the game
        Platform.exit();
    }

    //------------------------------------------------------
    //---------------------New Game Menu--------------------
    //------------------------------------------------------
    @FXML
    private void newGameBackButtonClicked(ActionEvent event) {
        changeScene(newGameScene, mainMenuScene);
    }

    //------------------------------------------------------
    //--------------------Highscore Menu--------------------
    //------------------------------------------------------
    @FXML
    private void highscoreBackButtonClicked(ActionEvent event) {
        changeScene(highscoreScene, mainMenuScene);
    }

    //------------------------------------------------------
    //----------------------Credits Menu--------------------
    //------------------------------------------------------
    @FXML
    private void creditsBackButtonClicked(ActionEvent event) {
        changeScene(creditsScene, mainMenuScene);
    }

    //------------------------------------------------------
    //--------------------General Methods-------------------
    //------------------------------------------------------
    private void changeScene(AnchorPane from, AnchorPane to) {
        from.setVisible(false);
        from.setDisable(true);
        to.setVisible(true);
        to.setDisable(false);
    }

    private void makeVisible(AnchorPane popUp) {
        popUp.setVisible(true);
        popUp.setDisable(false);
    }

    private void makeInvisible(AnchorPane popUp) {
        popUp.setVisible(false);
        popUp.setDisable(true);
    }
    
    private void makeVisible(ImageView popUp) {
        popUp.setVisible(true);
        popUp.setDisable(false);
    }

    private void makeInvisible(ImageView popUp) {
        popUp.setVisible(false);
        popUp.setDisable(true);
    }

    @FXML
    private void loadGameButtonClicked(ActionEvent event) {
        gameEngine.loadGame();
    }

    @FXML
    private void forwardButtonClicked(ActionEvent event) {
        if(gameEngine.move())
        {
            changeScene(gameScene, combatScene);
        }
        
        
            if(isMapView)
            {
                labyrinthImage.setImage(gameEngine.renderMiniMapView());
            }
            else
            {
                labyrinthImage.setImage(gameEngine.renderMazeView());
            }
        
        
        
    }

    @FXML
    private void leftButtonClicked(ActionEvent event) {
        gameEngine.turnLeft();
        labyrinthImage.setImage(gameEngine.renderMazeView());
    }

    @FXML
    private void rightButtonClicked(ActionEvent event) {
        gameEngine.turnRight();
        labyrinthImage.setImage(gameEngine.renderMazeView());
    }

    @FXML
    private void backButtonClicked(ActionEvent event) {
        gameEngine.turnBack();
        labyrinthImage.setImage(gameEngine.renderMazeView());
    }

    @FXML
    private void inventoryButtonClicked(ActionEvent event) {
 
        makeVisible(inventoryScene);
        String[] inventoryList = gameEngine.getInventory();
        for(int i = 0; i < inventoryList.length; i++)
        {
            System.out.println(inventoryList[i]);
            inventoryRadioButtons[i].setVisible(true);
            if(inventoryList[i] != null)
            {
            inventoryRadioButtons[i].setText(inventoryList[i]);
            }
            else
            {
                inventoryRadioButtons[i].setText("Empty inventory slot");
            }
        }
        makeInvisible(labyrinthImage);
       

    }

    @FXML
    private void searchButtonClicked(ActionEvent event)
    {
        makeVisible(searchScene);
        String[] roomItemList = gameEngine.getLoot();
        for (int i = 0; i < roomItemList.length && i < searchRadioButtons.length; i++)
        {
            searchRadioButtons[i].setVisible(true);
            if (roomItemList[i] != null)
            {
                searchRadioButtons[i].setText(roomItemList[i]);
            }
        }
        makeInvisible(labyrinthImage);
    }

    @FXML
    private void pickUpButtonClicked(ActionEvent event)
    {
        
    }

    @FXML
    private void gameSceneOptionsButtonClicked(ActionEvent event)
    {
        changeScene(gameScene, optionsScene);
    }

    @FXML
    private void saveGameButtonClicked(ActionEvent event) {
        gameEngine.saveGame();
    }

    @FXML
    private void optionsBackToMenuButtonClicked(ActionEvent event) {
        makeVisible(wantToQuitPopUpLayer);
    }

    @FXML
    private void optionsQuitGameButtonClicked(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void resumeGameButtonClicked(ActionEvent event) {
        changeScene(optionsScene, gameScene);
    }

    @FXML
    private void optionsHelpButtonClicked(ActionEvent event) {
        changeScene(optionsScene, helpScene);
    }

    @FXML
    private void backtoOptionsButtonClicked(ActionEvent event) {
        changeScene(helpScene, optionsScene);
    }

//    private void newGamePlayButtonClicked(ActionEvent event) {
//        changeScene(newGameScene, gameScene);
//    }
    @FXML
    private void yesDeleteProgressButtonClicked(ActionEvent event) {
        makeInvisible(wantToQuitPopUpLayer);
        changeScene(optionsScene, mainMenuScene);
    }

    @FXML
    private void noBackToOptionsButtonClicked(ActionEvent event) {
        makeInvisible(wantToQuitPopUpLayer);
    }

    @FXML
    private void newGameNextButtonClicked(ActionEvent event) {
        makeVisible(EnterNamePopUpLayer);
    }

    @FXML
    private void playButtonClicked(ActionEvent event) {
        changeScene(newGameScene, gameScene);
        gameEngine.startNewGame(difficulty, enterPlayerName.getText());
        labyrinthImage.setImage(gameEngine.renderMazeView());
        createRadioArrays();
        
        
    }
        private void createRadioArrays()
        {
            inventoryRadioButtons = new RadioButton[7];
        inventoryRadioButtons[0] = itemOneRadioButton;
        inventoryRadioButtons[1] = itemTwoRadioButton;
        inventoryRadioButtons[2] = itemThreeRadioButton;
        inventoryRadioButtons[3] = itemFourRadioButton;
        inventoryRadioButtons[4] = itemFiveRadioButton;
        inventoryRadioButtons[5] = itemSixRadioButton;
        inventoryRadioButtons[6] = itemSevenRadioButton;
        currentHealthField.setText(gameEngine.getCurrentHealthToString());
        for (int i = 0; i < inventoryRadioButtons.length; i++) {
            inventoryRadioButtons[i].setVisible(false);  
        }
        
        searchRadioButtons = new RadioButton[12];
        
        searchRadioButtons[0] = roomItem1RadioButton;
        searchRadioButtons[1] = roomItem2RadioButton;
        searchRadioButtons[2] = roomItem3RadioButton;
        searchRadioButtons[3] = roomItem4RadioButton;
        searchRadioButtons[4] = roomItem5RadioButton;
        searchRadioButtons[5] = roomItem6RadioButton;
        searchRadioButtons[6] = roomItem7RadioButton;
        searchRadioButtons[7] = roomItem8RadioButton;
        searchRadioButtons[8] = roomItem9RadioButton;
        searchRadioButtons[9] = roomItem10RadioButton;
        searchRadioButtons[10] = roomItem11RadioButton;
        searchRadioButtons[11] = roomItem12RadioButton;
            for (int i = 0; i < searchRadioButtons.length; i++) {
                searchRadioButtons[i].setVisible(false);
            }
        }
    

    @FXML
    private void BackToDifficltyButtonClicked(ActionEvent event) {
        makeInvisible(EnterNamePopUpLayer);
    }

    @FXML
    private void veryEasyButtonClicked(ActionEvent event) {
        difficulty = 1;
    }

    @FXML
    private void easyButtonClicked(ActionEvent event) {
        difficulty = 2;
    }

    @FXML
    private void normalButtonClicked(ActionEvent event) {
        difficulty = 3;
    }

    @FXML
    private void hardButtonClicked(ActionEvent event) {
        difficulty = 4;
    }

    @FXML
    private void veryHardButtonClicked(ActionEvent event) {
        difficulty = 5;
    }

    @Override
    public void injectGameEngine(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @FXML
    private void attackButtonClicked(ActionEvent event) {
        if(gameEngine.attack())
        {
            if (gameEngine.checkForGameOver())
            {
                //chanceScene(combatScene, defeatedScene);
            }
            changeScene(combatScene, gameScene);
            labyrinthImage.setImage(gameEngine.renderMazeView());
        }
        
        currentHealthField.setText(gameEngine.getCurrentHealthToString());
    }

    @FXML
    private void combatInventoryButtonClicked(ActionEvent event)
    {
        makeVisible(inventoryScene);
        String[] inventoryList = gameEngine.getInventory();
        for(int i = 0; i < inventoryList.length; i++)
        {
            System.out.println(inventoryList[i]);
            inventoryRadioButtons[i].setVisible(true);
            if(inventoryList[i] != null)
            {
            inventoryRadioButtons[i].setText(inventoryList[i]);
            }
            else
            {
                inventoryRadioButtons[i].setText("Empty inventory slot");
            }
        }
        makeInvisible(labyrinthImage);
    }

    @FXML
    private void fleeButtonClicked(ActionEvent event)
    {
        gameEngine.flee();
        changeScene(combatScene, gameScene);
    }

    @FXML
    private void currentHealthFieldUpdate(ActionEvent event)
    {
        
    }

    @FXML
    private void combatSceneOptionsButtonClicked(ActionEvent event) {
        changeScene(combatScene, optionsScene);
    }

    @FXML
    private void mapButtonClicked(ActionEvent event) {
        if (!isMapView) {
            labyrinthImage.setImage(gameEngine.renderMiniMapView());
            isMapView = true;
        } else {
            labyrinthImage.setImage(gameEngine.renderMazeView());
            isMapView = false;
        }
    }

    @FXML
    private void itemOneRadioButtonClicked(ActionEvent event) {
        itemNumber = 0;
    }

    @FXML
    private void itemTwoRadioButtonClicked(ActionEvent event) {
        itemNumber = 1;
    }

    @FXML
    private void itemFiveRadioButtonClicked(ActionEvent event) {
        itemNumber = 4;
    }

    @FXML
    private void itemFourRadioButtonClicked(ActionEvent event) {
        itemNumber = 3;
    }

    @FXML
    private void itemThreeRadioButtonClicked(ActionEvent event) {
        itemNumber = 2;
    }

    @FXML
    private void itemSixRadioButtonClicked(ActionEvent event) {
        itemNumber = 5;
    }

    @FXML
    private void itemSevenRadioButtonClicked(ActionEvent event) {
        itemNumber = 6;
    }

    @FXML
    private void useInventoryButtonClicked(ActionEvent event) {
        gameEngine.useItem(itemNumber);

    }

    @FXML
    private void dropInventoryButtonClicked(ActionEvent event) {
        gameEngine.dropItem(itemNumber);
    }

    @FXML
    private void inspectInventoryButtonClicked(ActionEvent event) {
        gameEngine.itemDescription(itemNumber);
        //write it in text box
    }

    @FXML
    private void closeInventoryButtonClicked(ActionEvent event) {
        makeInvisible(inventoryScene);
        makeVisible(labyrinthImage);
       
    }

    @FXML
    private void useRoomItemButtonClicked(ActionEvent event)
    {
        
    }

    @FXML
    private void inspectRoomItemButtonClicked(ActionEvent event)
    {
        
    }

    @FXML
    private void closeSearchSceneButtonClicked(ActionEvent event)
    {
        makeInvisible(searchScene);
        makeVisible(labyrinthImage);
    }

    
    
}
