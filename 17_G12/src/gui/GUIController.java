/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static acquaintance.IGameConstants.isDebug;
import acquaintance.IGameEngine;
import acquaintance.IScore;
import acquaintance.IUI;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class GUIController implements IUI
{
    /**-------------------
     * SCENES AND POP-UPS.
     */
    @FXML private AnchorPane defaultScene;
    
    //Main scenes
    @FXML private AnchorPane mainMenuScene;
    @FXML private AnchorPane creditsScene;
    @FXML private AnchorPane highscoreScene;
    @FXML private AnchorPane newGameScene;
    @FXML private AnchorPane optionsScene;
    @FXML private AnchorPane gameScene;
    @FXML private AnchorPane helpScene;
    @FXML private AnchorPane combatScene;
    @FXML private AnchorPane gameOverScene;
    @FXML private AnchorPane gameWonScene;
    
    //Scenes within gameScene
    @FXML private AnchorPane inventoryScene;
    @FXML private AnchorPane searchScene;
    @FXML private AnchorPane combatInventoryScene;
    
    //Pop-ups
    @FXML private AnchorPane wantToQuitPopUpLayer;
    @FXML private AnchorPane enterNamePopUpLayer;
    
    /**-----------------------
     * mainMenuScene elements.
     */
    @FXML private ImageView mainMenuBackgroundImage;
    @FXML private Button newGameButton;
    @FXML private Button loadGameButton;
    @FXML private Button highScoreButton;
    @FXML private Button creditsButton;
    @FXML private Button quitButton;
    
    /**----------------------
     * newGameScene elements.
     */
    @FXML private ImageView newGameBackgroundImage;
    @FXML private ToggleGroup difficultyRadioButtons;
    @FXML private RadioButton veryEasyButton;
    @FXML private RadioButton easyButton;
    @FXML private RadioButton normalButton;
    @FXML private RadioButton hardButton;
    @FXML private RadioButton veryHardButton;
    @FXML private Button newGameBackButton;
    @FXML private Button newGameNextButton;
    
    /**-----------------------------
     * enterNamePopUpLayer elements.
     */
    @FXML private TextField enterPlayerName;
    @FXML private Button PlayButton;
    @FXML private Button BackToDifficlyButton;
    
    /**------------------------
     * highscoreScene elements.
     */
    @FXML private ImageView highscoreBackgroundImage;
    @FXML private Button highscoreBackButton;
    @FXML private ListView<String> highScoreName;
    @FXML private ListView<String> highScoreNumber;
    @FXML private ListView<String> highScoreDifficulity;
    
    /**----------------------
     * creditsScene elements.
     */
    @FXML private ImageView creditsBackgroundImage;
    @FXML private Button creditsBackButton;
    
    /**-------------------
     * gameScene elements.
     */
    //This ImageView displays the labyrinth
    @FXML private ImageView labyrinthImage;
    @FXML private ImageView gameSceneBackgroundImage;
    
    //This TextArea writes the game activities
    @FXML private TextArea logTextArea;
    
    //These buttons are used to navigate
    @FXML private Button forwardButton;
    @FXML private Button leftButton;
    @FXML private Button rightButton;
    @FXML private Button backButton;
    
    //These buttons are used to change to different scenes within gameScene.
    @FXML private Button inventoryButton;
    @FXML private Button searchButton;
    @FXML private Button mapButton;
    
    //This buttons changes the main scene to optionsScene
    @FXML private Button gameSceneOptionsButton;
    
    //This is used to pick up an item
    @FXML private Button pickUpButton;
    
    /**----------------------
     * optionsScene elements.
     */
    @FXML private ImageView optionsSceneBackground;
    @FXML private Button resumeGameButton;
    @FXML private Button saveGameButton;
    @FXML private Button optionsHelpButton;
    @FXML private Button optionsBackToMenuButton;
    @FXML private Button optionsQuitGameButton;
    
    //Pop-ups
    @FXML private Button backToOptionsButton;
    @FXML private Button yesDeleteProgressButton;
    @FXML private Button noBackToOptionsButton;
    
    /**-------------------
     * helpScene elements.
     */
    @FXML private ImageView helpSceneBackgroundImage;
    
    /**---------------------
     * combatScene elements.
     */
    @FXML private ImageView combatSceneImage;
    
    //Container for combat graphics
    @FXML private ImageView combatImage;
    
    //Container for written game activities
    @FXML private TextArea 
            logCombatTextArea;
    
    //Container for players current health
    @FXML private TextField currentHealthField;
    
    //Action buttons
    @FXML private Button attackButton;    
    @FXML private Button fleeButton;
    
    //Change scene buttons
    @FXML private Button combatInventoryButton;
    @FXML private Button combatSceneOptionsButton;
    
    /**------------------------------
     * combatInventoryScene elements.
     */
    @FXML private ToggleGroup inventoryButtons1; //Refactoring
    @FXML private RadioButton itemOneRadioButton1;
    @FXML private RadioButton itemTwoRadioButton1;
    @FXML private RadioButton itemFiveRadioButton1;
    @FXML private RadioButton itemFourRadioButton1;
    @FXML private RadioButton itemThreeRadioButton1;
    @FXML private RadioButton itemSixRadioButton1;
    @FXML private RadioButton itemSevenRadioButton1;
    @FXML private Button useInventoryButton1;
    @FXML private Button dropInventoryButton1;
    @FXML private Button inspectInventoryButton1;
    @FXML private Button closeCombatInventoryButton;
    
    /**------------------------
     * inventoryScene elements.
     */
    //Toggle group for all included radio buttons
    @FXML private ToggleGroup inventoryButtons;
    
    //Radio buttons for items
    @FXML private RadioButton itemOneRadioButton;
    @FXML private RadioButton itemTwoRadioButton;
    @FXML private RadioButton itemFiveRadioButton;
    @FXML private RadioButton itemFourRadioButton;
    @FXML private RadioButton itemThreeRadioButton;
    @FXML private RadioButton itemSixRadioButton;
    @FXML private RadioButton itemSevenRadioButton;
    
    //Action buttons
    @FXML private Button useInventoryButton;
    @FXML private Button dropInventoryButton;
    @FXML private Button inspectInventoryButton;
    
    //Change scene button
    @FXML private Button closeInventoryButton;
    
    /**---------------------
     * searchScene elements.
     */
    //Toggle group for all included radio buttons
    @FXML private ToggleGroup roomRadioButtons;
    
    //All included radio buttons
    @FXML private RadioButton roomItem1RadioButton;
    @FXML private RadioButton roomItem2RadioButton;
    @FXML private RadioButton roomItem3RadioButton;
    @FXML private RadioButton roomItem4RadioButton;
    @FXML private RadioButton roomItem5RadioButton;
    @FXML private RadioButton roomItem6RadioButton;
    @FXML private RadioButton roomItem7RadioButton;
    @FXML private RadioButton roomItem8RadioButton;
    @FXML private RadioButton roomItem9RadioButton;
    @FXML private RadioButton roomItem10RadioButton;
    @FXML private RadioButton roomItem11RadioButton;
    @FXML private RadioButton roomItem12RadioButton;
    
    /**-----------------------
     * gameOverScene elements.
     */
    @FXML private ImageView gameOverBackgroundImage;
    
    /**----------------------
     * gameWonScene elements.
     */
    @FXML private ImageView gameWonSceneBackgroundImage;
    @FXML private Label gameWonNameHolder;
    @FXML private Label gameWonScore;
    @FXML private Label gameWonDifficulty;
    
    /**-------------------
     * NON-FXML VARIABLES.
     */
    private boolean isMapView = false;
    private int difficulty = 3;
    private int itemNumber = 0;
    private int lootItemNumber = 0;
    private IGameEngine gameEngine;
    private RadioButton[] inventoryRadioButtons;
    private RadioButton[] searchRadioButtons;
    private RadioButton[] combatInventoryButtons;
    private IScore[] scores;
    ObservableList<String> scoreNames;
    ObservableList<String> scoreNumbers;
    ObservableList<String> scoreDifficulties;

    /**
     * This is run when the GUI.fxml file is loaded.
     */
    public void initialize() {
        logTextArea.setWrapText(true);
        logCombatTextArea.setWrapText(true);
        // TODO
    }

    //------------------------------------------------------
    //------------------------------------------------------
    //-----------------------Main Menu----------------------
    //------------------------------------------------------
    //------------------------------------------------------
    
    /**
     * This method is triggered, when pressing the 'New Game' button in the
     * main menu of the game, and when used, it changes from the main menu 
     * to the new game scene, where you can pick difficulties and 
     * start the game.
     * @param event 
     */
    @FXML
    private void newGameButtonClicked(ActionEvent event)
    {
        changeScene(mainMenuScene, newGameScene);
    }
    
    /**
     * This method is triggered, when pressing the 'Load Game' button in the
     * main menu of the game, and when used, it changes from the main menu to
     * the game scene, with the progress of the last saved game.
     * @param event 
     */
    @FXML
    private void loadGameButtonClicked(ActionEvent event) {
        gameEngine.loadGame();
        changeScene(mainMenuScene, gameScene);
        createRadioArrays();
        redraw();
    }

    /**
     * This method is triggered, when pressing the 'Highscore' button in the
     * main menu of the game, and when used, it changes from the main menu to
     * the highscore scene, where you can see the top 10 best scores achieved.
     * @param event 
     */
    @FXML
    private void highscoreButtonClicked(ActionEvent event) {
        changeScene(mainMenuScene, highscoreScene);
        scoreNames = FXCollections.observableArrayList();
        scoreNumbers = FXCollections.observableArrayList();
        scoreDifficulties = FXCollections.observableArrayList();
        
        
        scores = gameEngine.loadHighScore();
        for (int i = 0; i < scores.length; i++) {
            scoreNames.add(scores[i].getName());
            scoreNumbers.add(scores[i].getScoreString());
            scoreDifficulties.add(scores[i].getDifficulty());
        }
        
        highScoreName.setItems(scoreNames);
        highScoreNumber.setItems(scoreNumbers);
        highScoreDifficulity.setItems(scoreDifficulties);
    }

    /**
     * This method is triggered, when pressing the 'Credits' button in the
     * main menu of the game, and when used, it changes from the main menu to
     * the credits scene, where you can see everyone involved in the making of
     * the game.
     * @param event 
     */
    @FXML
    private void creditsButtonClicked(ActionEvent event) {
        changeScene(mainMenuScene, creditsScene);
    }

    /**
     * This method is triggered, when pressing the 'Quit' button in the main
     * menu of the game, and when used, it terminates the program and quits
     * the game.
     * @param event 
     */
    @FXML
    private void quitButtonClicked(ActionEvent event) {
        //Quits the game
        Platform.exit();
    }

    
    
    //------------------------------------------------------
    //------------------------------------------------------
    //---------------------New Game Menu--------------------
    //------------------------------------------------------
    //------------------------------------------------------
    
    /**
     * This method is triggered when pressing the 'Back to Main Menu' button
     * in the new game menu, and when used, it changes from the new game menu
     * to the main menu.
     * @param event 
     */
    @FXML
    private void newGameBackButtonClicked(ActionEvent event) {
        changeScene(newGameScene, mainMenuScene);
    }
    
    /**
     * This method is triggered when pressing the 'Next' Button in the
     * new game menu, and when used, a popup appears where you can enter your
     * name in the game.
     * @param event 
     */
    @FXML
    private void newGameNextButtonClicked(ActionEvent event) {
        GUIController.this.makeVisible(enterNamePopUpLayer);
    }

    /**
     * This method is triggered when pressing the 'Play' Button in the
     * popup of a new game menu, and when used, the game starts, changing
     * from the new game menu to the actual game scene.
     * @param event 
     */
    @FXML
    private void playButtonClicked(ActionEvent event) {
        changeScene(newGameScene, gameScene);
        gameEngine.startNewGame(difficulty, enterPlayerName.getText());
        labyrinthImage.setImage(gameEngine.renderMazeView());
        createRadioArrays();
        GUIController.this.makeInvisible(enterNamePopUpLayer);
    }
    
    /**
     * This method is triggered when pressing the 'Back to Difficulty'
     * button in a popup of the new game menu, and when used, the popup
     * dissappears from the new game menu.
     * @param event 
     */
    @FXML
    private void BackToDifficltyButtonClicked(ActionEvent event) {
        GUIController.this.makeInvisible(enterNamePopUpLayer);
    }

    /**
     * This method is triggered when pressing the 'Very easy' difficulty
     * radio button in the new game menu, and when used, the diffuculty
     * variable in the code is set to the value for very easy difficulty.
     * @param event 
     */
    @FXML
    private void veryEasyButtonClicked(ActionEvent event) {
        difficulty = 1;
    }

    /**
     * This method is triggered when pressing the 'Easy' difficulty
     * radio button in the new game menu, and when used, the diffuculty
     * variable in the code is set to the value for easy difficulty.
     * @param event 
     */
    @FXML
    private void easyButtonClicked(ActionEvent event) {
        difficulty = 2;
    }

    /**
     * This method is triggered when pressing the 'Normal' difficulty
     * radio button in the new game menu, and when used, the diffuculty
     * variable in the code is set to the value for normal difficulty.
     * @param event 
     */
    @FXML
    private void normalButtonClicked(ActionEvent event) {
        difficulty = 3;
    }

    /**
     * This method is triggered when pressing the 'Hard' difficulty
     * radio button in the new game menu, and when used, the diffuculty
     * variable in the code is set to the value for hard difficulty.
     * @param event 
     */
    @FXML
    private void hardButtonClicked(ActionEvent event) {
        difficulty = 4;
    }

    /**
     * This method is triggered when pressing the 'Very hard' difficulty
     * radio button in the new game menu, and when used, the diffuculty
     * variable in the code is set to the value for very hard difficulty.
     * @param event 
     */
    @FXML
    private void veryHardButtonClicked(ActionEvent event) {
        difficulty = 5;
    }
    
    
    
    //------------------------------------------------------
    //------------------------------------------------------
    //--------------------Highscore Menu--------------------
    //------------------------------------------------------
    //------------------------------------------------------
    
    /**
     * This method is triggered when pressing the 'Back to Main Menu' button
     * in the highscore menu, and when used, it changes the scene from
     * highScoreScene to mainMenuScene and clears the highscores.
     * @param event 
     */
    @FXML
    private void highscoreBackButtonClicked(ActionEvent event) {
        changeScene(highscoreScene, mainMenuScene);
        scoreDifficulties.clear();
        scoreNames.clear();
        scoreNumbers.clear();
    }
    

    
    //------------------------------------------------------
    //------------------------------------------------------
    //----------------------Credits Menu--------------------
    //------------------------------------------------------
    //------------------------------------------------------
    
    /**
     * This method is triggered when pressing the 'Back to Main Menu' button
     * in the credits menu, and when used, it changes the scene from 
     * creditsScene to mainMenuScene.
     * @param event 
     */
    @FXML
    private void creditsBackButtonClicked(ActionEvent event) {
        changeScene(creditsScene, mainMenuScene);
    }
    
    //------------------------------------------------------
    /**------------------------------------------------------
     * ---------------------GameScene------------------------.
     -------------------------------------------------------*/
    //------------------------------------------------------
    
    /**
     * This method is triggered when pressing the 'Forward' button in the
     * game scene, and when used, it does the following:
     * 
     * Engages in combat, changing the scene from gameScene to combatScene
     * and renders the combatImage and currentHealthField, IF gameEngine.move()
     * is true.
     * 
     * Ends the game with game over by changing the scene from gameScene to
     * gameOverScene, IF gameEngine.checkForGameOver() is true.
     * 
     * Ends the game with player win by changing the scene from gameScene to
     * gameWonScene, IF gameEnginge.checkWinCondition() is true.
     * 
     * Redraws the presentation of maze and minimap with 'redraw()' and
     * updates the game log with the most recent gameplay information.
     * 
     * @param event 
     */
    @FXML
    private void forwardButtonClicked(ActionEvent event)
    {
        if(gameEngine.move()) //Er navngivning korrekt her?
        {
            changeScene(gameScene, combatScene);
            combatImage.setImage(gameEngine.renderBattleView());
            currentHealthField.setText(gameEngine.getCurrentHealthToString());
        }
        if(gameEngine.checkForGameOver())
        {
            changeScene(gameScene, gameOverScene);
                    // losing game over image
        }
        if(gameEngine.checkWinCondition())
        {
            setEndGameInformation();
            changeScene(gameScene, gameWonScene);
            
            gameEngine.saveHighScore();
        }
        redraw();
        String tempMSG = gameEngine.getMessage();
        logCombatTextArea.setText(tempMSG);
        logTextArea.setText(tempMSG);
    }
    
    /**
     * This method is triggered when pressing the 'Left' button in the
     * game scene, and when used, it does the following:
     * 
     * Faces the player in the direction to the left.
     * Redraws the presentation of maze and minimap with 'redraw()'.
     * @param event 
     */
    @FXML
    private void leftButtonClicked(ActionEvent event) {
        gameEngine.turnLeft();
        redraw();
    }

    /**
     * This method is triggered when pressing the 'Right' button in the
     * game scene, and when used, it does the following:
     * 
     * Faces the player in the direction to the right.
     * Redraws the presentation of maze and minimap with 'redraw()'.
     * @param event 
     */
    @FXML
    private void rightButtonClicked(ActionEvent event) {
        gameEngine.turnRight();
        redraw();
    }

    /**
     * This method is triggered when pressing the 'Back' button in the
     * game scene, and when used, it does the following:
     * 
     * Faces the player in the opposite direction.
     * Redraws the presentation of maze and minimap with 'redraw()'.
     * @param event 
     */
    @FXML
    private void backButtonClicked(ActionEvent event) {
        gameEngine.turnBack();
        redraw();
    }
    
    /**
     * This method is triggered when pressing the 'Inventory' button in
     * the gameScene, and when used, it does the following:
     * 
     * Opens the inventory by making the inventoryScene visible and
     * gets the current items to display in the inventory.
     * 
     * 
     * @param event 
     */
    @FXML
    private void inventoryButtonClicked(ActionEvent event) {
 
        GUIController.this.makeVisible(inventoryScene);
        String[] inventoryList = gameEngine.getInventory();
        for(int i = 0; i < inventoryList.length; i++)
        {
            if(isDebug)
                System.out.println("GUI inventory received: " + inventoryList[i]);
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
        makeInvisible(searchScene);
    }

    /**
     * This method is triggered when pressing the 'Search' button in
     * the gameScene, and when used, it does the following:
     * 
     * Opens the search menu by making the searchScene visible and
     * gets the items in the current room to display.
     * 
     * @param event 
     */
    @FXML
    private void searchButtonClicked(ActionEvent event)
    {
        GUIController.this.makeVisible(searchScene);
        String[] roomItemList = gameEngine.getLoot();
        for (int i = 0; i < searchRadioButtons.length; i++)
        {
            
            if (i < roomItemList.length)
            {
                searchRadioButtons[i].setText(roomItemList[i]);
                searchRadioButtons[i].setVisible(true);
            }
            else
            {
                searchRadioButtons[i].setVisible(false);
            }
        }
        makeInvisible(labyrinthImage);
        makeInvisible(inventoryScene);
    }


    /**
     * This method is triggered when pressing the 'Options' button in
     * the gameScene, and when used, it does the following:
     * 
     * Opens the options menu by making the optionsScene visible and
     * the gameScene invisible.
     * 
     * @param event 
     */
    @FXML
    private void gameSceneOptionsButtonClicked(ActionEvent event)
    {
        changeScene(gameScene, optionsScene);
    }
    
    /**
     * This method is triggered when pressing the 'Map' button in
     * the gameScene, and when used, it does the following:
     * 
     * If the map is not opened, the map will be rendered and shown
     * in the gameScene.
     * 
     * If the map is opened, the maze will be rendered and shown in
     * the gameScene.
     * 
     * @param event 
     */
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
    
    /**
     * This method is triggered when pressing the 'Talk' button in
     * the gameScene, and when used, it does the following:
     * 
     * Engages in combat if there is a monster in the same room, or
     * Talks to the friendly minion Bob, if he is in the same room.
     * 
     * @param event 
     */
    @FXML
    private void taltToBob(ActionEvent event) {
        if(gameEngine.checkForMonster() != null)
        {
        if(gameEngine.checkForMonster().startsWith("minion") || gameEngine.checkForMonster().equals("Zuul"))
        {
            changeScene(gameScene, combatScene);
        }
        else if(gameEngine.checkForMonster().equals("bob"))
        {
            logTextArea.setText(gameEngine.talkToBob());
        }
        }
        redraw();
    }
    
    /**------------------------------------------------------
     * -------------------optionsScene-----------------------.
     -------------------------------------------------------*/

    /**
     * This method is triggered when pressing the 'Save Game' button in
     * the gameScene, and when used, it saves the game, by calling the
     * method saveGame() on the business facade 'gameEngine'.
     * 
     * @param event 
     */
    @FXML
    private void saveGameButtonClicked(ActionEvent event) {
        gameEngine.saveGame();
    }

    /**
     * This method is triggered when pressing the 'Back to Main Menu'
     * button in the popup asking if you want to quit in the optionsScene.
     * When used it goes back to the options menu making the popup
     * invisible.
     * 
     * @param event 
     */
    @FXML
    private void optionsBackToMenuButtonClicked(ActionEvent event) {
        GUIController.this.makeVisible(wantToQuitPopUpLayer);
    }

    /**
     * This method is triggered when pressing the 'Quit' button in the
     * options menu. When used it terminates the program and quits 
     * the game.
     * 
     * @param event 
     */
    @FXML
    private void optionsQuitGameButtonClicked(ActionEvent event) {

        Platform.exit();
    }

    /**
     * This method is triggered when pressing the 'Resume Game' button
     * in the options menu. When used it quits the menu and resumes the
     * game by changing from the optionsScene to the GameScene.
     * 
     * @param event 
     */
    @FXML
    private void resumeGameButtonClicked(ActionEvent event) {
        changeScene(optionsScene, gameScene);
    }

    /**
     * This method is triggered when pressing the 'Help' button in the
     * options menu. When used it opens the help menu by changing from
     * the optionsScene to the helpScene.
     * 
     * @param event 
     */
    @FXML
    private void optionsHelpButtonClicked(ActionEvent event) {
        changeScene(optionsScene, helpScene);
    }
    
    /** PopUp Layer - wantToQuitPopUpLayer. */
    
    /**
     * This method is triggered when pressing the 'Yes, delete all my
     * progress' button in the popup in the options menu asking if you
     * want to quit. When used it goes back to the main menu, making the
     * popup invisible and switching from the optionsScene to the
     * mainMenuScene.
     * 
     * @param event 
     */
    @FXML
    private void yesDeleteProgressButtonClicked(ActionEvent event) {
        GUIController.this.makeInvisible(wantToQuitPopUpLayer);
        changeScene(optionsScene, mainMenuScene);
    }

    /**
     * This method is triggered when pressing the 'No, take me back to
     * options' button in the popup in the options menu asking if you
     * want to quit. When used it goes back to the options menu by
     * making the popup invisible.
     * 
     * @param event 
     */
    @FXML
    private void noBackToOptionsButtonClicked(ActionEvent event) {
        GUIController.this.makeInvisible(wantToQuitPopUpLayer);
    }
    
    /**------------------------------------------------------
     * -------------------optionsScene-----------------------.
     -----------------------helpScene-----------------------*/
    
    /**
     * This method is triggered when pressing the 'Back to Options'
     * button in the help menu. When used, it goes back to the options
     * menu, by changing from the helpScene to the optionsScene.
     * 
     * @param event 
     */
    @FXML
    private void backtoOptionsButtonClicked(ActionEvent event) {
        changeScene(helpScene, optionsScene);
    }
    
    
    /**------------------------------------------------------
     * --------------------combatScene-----------------------.
     --------------------------------------------------------*/
    
    /**
     * This methods is triggered when pressing the 'attack' button
     * in the combatScene. when used it:
     * 
     * Attacks and damages the minion if the mi
     * 
     * @param event 
     */
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
        String tempMSG = gameEngine.getMessage();
        logCombatTextArea.setText(tempMSG);
        logTextArea.setText(tempMSG);
        
        currentHealthField.setText(gameEngine.getCurrentHealthToString());
        if(gameEngine.checkForGameOver())
        {
            setEndGameInformation();
            changeScene(gameScene, gameOverScene);
        }
    }

    @FXML
    private void combatInventoryButtonClicked(ActionEvent event)
    {
        GUIController.this.makeVisible(combatInventoryScene);
        String[] inventoryList = gameEngine.getInventory();
        for(int i = 0; i < inventoryList.length; i++)
        {
            if (isDebug)
                System.out.println("GUI inventory received: " + inventoryList[i]);
            combatInventoryButtons[i].setVisible(true);
            if(inventoryList[i] != null)
            {
            combatInventoryButtons[i].setText(inventoryList[i]);
            }
            else
            {
                combatInventoryButtons[i].setText("Empty slot");
            }
        }
        makeInvisible(combatImage);
    }

    @FXML
    private void fleeButtonClicked(ActionEvent event)
    {
        gameEngine.flee();
        changeScene(combatScene, gameScene);
        if(gameEngine.checkForGameOver())
        {
            changeScene(gameScene, gameOverScene);
        }
    }
    
    @FXML
    private void combatSceneOptionsButtonClicked(ActionEvent event)
    {
        changeScene(combatScene, optionsScene);
    }
    
    
    /**------------------------------------------------------
     * -------------------gameOverScene----------------------.
     --------------------------------------------------------*/
    @FXML
    private void gameOverSceneMainMenuButtonClicked(ActionEvent event)
    {
        changeScene(gameOverScene, mainMenuScene);
    }
    
    
    /**------------------------------------------------------
     * -------------------gameWonScene-----------------------.
     --------------------------------------------------------*/
    @FXML
    private void gameWonSceneMainMenuButtonClicked(ActionEvent event)
    {
        changeScene(gameWonScene, mainMenuScene);
    }
    
    /**------------------------------------------------------
     * ------------------inventoryScene----------------------.
     --------------------------------------------------------*/
    
    @FXML
    private void itemOneRadioButtonClicked(ActionEvent event)
    {
        itemNumber = 0;
    }

    @FXML
    private void itemTwoRadioButtonClicked(ActionEvent event)
    {
        itemNumber = 1;
    }

    @FXML
    private void itemThreeRadioButtonClicked(ActionEvent event)
    {
        itemNumber = 2;
    }

    @FXML
    private void itemFourRadioButtonClicked(ActionEvent event)
    {
        itemNumber = 3;
    }
    
    @FXML
    private void itemFiveRadioButtonClicked(ActionEvent event)
    {
        itemNumber = 4;
    }

    @FXML
    private void itemSixRadioButtonClicked(ActionEvent event)
    {
        itemNumber = 5;
    }

    @FXML
    private void itemSevenRadioButtonClicked(ActionEvent event)
    {
        itemNumber = 6;
    }
    
    @FXML
    private void useInventoryButtonClicked(ActionEvent event)
    {
        gameEngine.useItem(itemNumber);
        inventoryButtonClicked(event);
        combatInventoryButtonClicked(event);
        String tempMSG = gameEngine.getMessage();
        logCombatTextArea.setText(tempMSG);
        logTextArea.setText(tempMSG);
        currentHealthField.setText(gameEngine.getCurrentHealthToString());
    }

    @FXML
    private void dropInventoryButtonClicked(ActionEvent event)
    {
        gameEngine.dropItem(itemNumber);
        inventoryButtonClicked(event);
        redraw();
        String tempMSG = gameEngine.getMessage();
        logCombatTextArea.setText(tempMSG);
        logTextArea.setText(tempMSG);
    }

    @FXML
    private void inspectInventoryButtonClicked(ActionEvent event)
    {
        logTextArea.setText(gameEngine.itemDescription(itemNumber));
        logCombatTextArea.setText(gameEngine.itemDescription(itemNumber));
        //write it in text box
    
    }

    @FXML
    private void closeInventoryButtonClicked(ActionEvent event)
    {
        GUIController.this.makeInvisible(inventoryScene);
        makeInvisible(combatInventoryScene);
        makeVisible(labyrinthImage);
        makeVisible(combatImage);
        redraw();
    }
    
    /**------------------------------------------------------
     * --------------------searchScene-----------------------.
     --------------------------------------------------------*/
    
    @FXML
    private void roomItem1RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 0;
    }

    @FXML
    private void roomItem2RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 1;
    }

    @FXML
    private void roomItem3RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 2;
    }

    @FXML
    private void roomItem4RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 3;
    }

    @FXML
    private void roomItem5RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 4;
    }

    @FXML
    private void roomItem6RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 5;
    }

    @FXML
    private void roomItem7RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 6;
    }

    @FXML
    private void roomItem8RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 7;
    }

    @FXML
    private void roomItem9RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 8;
    }

    @FXML
    private void roomItem10RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 9;
    }

    @FXML
    private void roomItem11RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 10;
    }

    @FXML
    private void roomItem12RadioButtonClicked(ActionEvent event)
    {
        lootItemNumber = 11;
    }
    
    @FXML
    private void useRoomItemButtonClicked(ActionEvent event)
    {
        gameEngine.useLootItem(lootItemNumber);
        searchButtonClicked(event);
        
        String tempMSG = gameEngine.getMessage();
        logCombatTextArea.setText(tempMSG);
        logTextArea.setText(tempMSG);
        
    }

    @FXML
    private void inspectRoomItemButtonClicked(ActionEvent event)
    {//replace all
        logTextArea.setText(gameEngine.getLootItemDescription(lootItemNumber));
        logCombatTextArea.setText(gameEngine.getLootItemDescription(lootItemNumber));
    }

    @FXML
    private void closeSearchSceneButtonClicked(ActionEvent event)
    {
        GUIController.this.makeInvisible(searchScene);
        makeVisible(labyrinthImage);
        redraw();
    }
    
    @FXML
    private void pickUpButtonClicked(ActionEvent event)
    {
        gameEngine.pickUpItem(lootItemNumber);
        searchButtonClicked(event);
        redraw();
        String tempMSG = gameEngine.getMessage();
        logCombatTextArea.setText(tempMSG);
        logTextArea.setText(tempMSG);
    }
    
    
    //------------------------------------------------------
    //-------------------General Methods--------------------
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

    private class TempString{
        private String in;
        public TempString(String in)
        {
            this.in = in;
        }
        public String toString()
        {
            return in;
        }
    }
    
    private void setEndGameInformation()
    {
        gameWonNameHolder.setText(gameEngine.getName());
        gameWonScore.setText(gameEngine.getScoreString());
        gameWonDifficulty.setText(gameEngine.getDifficultyString());
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
        
        for (int i = 0; i < inventoryRadioButtons.length; i++)
        {
            inventoryRadioButtons[i].setVisible(false);  
        }
        
        combatInventoryButtons = new RadioButton[7];
        combatInventoryButtons[0] = itemOneRadioButton1;
        combatInventoryButtons[1] = itemTwoRadioButton1;
        combatInventoryButtons[2] = itemThreeRadioButton1;
        combatInventoryButtons[3] = itemFourRadioButton1;
        combatInventoryButtons[4] = itemFiveRadioButton1;
        combatInventoryButtons[5] = itemSixRadioButton1;
        combatInventoryButtons[6] = itemSevenRadioButton1;

        for (int i = 0; i < combatInventoryButtons.length; i++) {
            combatInventoryButtons[i].setVisible(false);
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
        for (int i = 0; i < searchRadioButtons.length; i++)
        {
            searchRadioButtons[i].setVisible(false);
        }
    }
    
    @Override
    public void injectGameEngine(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        createBackgrounds();

    }
    
    private void createBackgrounds()
    {
        mainMenuBackgroundImage.setImage(gameEngine.getMainMenuBackground());
        newGameBackgroundImage.setImage(gameEngine.getNewGameBackground());
        gameSceneBackgroundImage.setImage(gameEngine.getGameAndCombatSceneBackground());
        gameOverBackgroundImage.setImage(gameEngine.getGameOverSceneBackground());
        gameWonSceneBackgroundImage.setImage(gameEngine.getGameWonSceneBackground());
        highscoreBackgroundImage.setImage(gameEngine.getHighscoreAndCreditsSceneBackground());
        creditsBackgroundImage.setImage(gameEngine.getHighscoreAndCreditsSceneBackground());
        optionsSceneBackground.setImage(gameEngine.getOptionsAndHelpSceneBackground());
        helpSceneBackgroundImage.setImage(gameEngine.getOptionsAndHelpSceneBackground());
        combatSceneImage.setImage(gameEngine.getGameAndCombatSceneBackground());
    }
    
    private void redraw()
    {
        if(isMapView)
        {
        labyrinthImage.setImage(gameEngine.renderMiniMapView());
        }
        else
        {
        labyrinthImage.setImage(gameEngine.renderMazeView());
        }
        combatImage.setImage(gameEngine.renderBattleView());
    }
    
    /**------------------------------------------------------
     * ----------------Methods without body------------------.
     --------------------------------------------------------*/
    @FXML
    private void currentHealthFieldUpdate(ActionEvent event)
    {
        
    }
}
