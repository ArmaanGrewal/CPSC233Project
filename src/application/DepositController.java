package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DepositController {
	
	Stage depositStage;

    @FXML
    void backToBalance(ActionEvent event) throws IOException {
    	Parent root1 = FXMLLoader.load(getClass().getResource("BankAccountScene.fxml"));
    	depositStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene createAccountScene = new Scene(root1, 450, 225);
    	depositStage.setScene(createAccountScene);
    	depositStage.show();
    }

}
