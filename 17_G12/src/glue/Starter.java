/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glue;

import acquaintance.IData;
import acquaintance.IGameEngine;
import acquaintance.IUI;
import core_engine.GameEngine;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Stephanie
 */
public class Starter  extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/GUI.fxml"));
	Pane pane = loader.load();
	
	IGameEngine business = new GameEngine();
	IUI controller = (IUI)loader.getController();
	controller.injectGameEngine(business);
	
	Scene scene = new Scene(pane);
	
	stage.setScene(scene);
	stage.show();
    }
    
    public static void main(String[] args) {
	launch(args);
    }


}
