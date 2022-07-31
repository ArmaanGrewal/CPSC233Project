package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class bankSceneController {

	Stage bankAccountStage;
	
    @FXML
    void toDepositWindow(ActionEvent event) throws IOException {
    	Parent root1 = FXMLLoader.load(getClass().getResource("DepositScene.fxml"));
    	bankAccountStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene createAccountScene = new Scene(root1, 450, 225);
    	bankAccountStage.setScene(createAccountScene);
    	bankAccountStage.show();
    }

    @FXML
    void toLoginWindow(ActionEvent event) throws IOException {
    	Parent root1 = FXMLLoader.load(getClass().getResource("ApplicationScene.fxml"));
    	bankAccountStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene createAccountScene = new Scene(root1, 450, 250);
    	bankAccountStage.setScene(createAccountScene);
    	bankAccountStage.show();
    }

    @FXML
    void toWithdrawWindow(ActionEvent event) throws IOException {
    	Parent root1 = FXMLLoader.load(getClass().getResource("WithdrawScene.fxml"));
    	bankAccountStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene createAccountScene = new Scene(root1, 450, 225);
    	bankAccountStage.setScene(createAccountScene);
    	bankAccountStage.show();
    }

}

