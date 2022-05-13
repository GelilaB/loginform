import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
// import javafx.event.Event;
// import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class loggedincontroller implements Initializable {

    @FXML
    private Button button_logout;

    @FXML
    private Label lable_member;

    @FXML
    private Label lable_welcome;
    @FXML
    void logoutAction(ActionEvent event) {
        try {
            Parent  root = FXMLLoader.load(getClass().getResource("login.fxml"));
                    
                    Scene scene= new Scene(root);
                    Stage primaryStage=(Stage)button_logout.getScene().getWindow(); 
                    primaryStage.setScene(scene);
                    primaryStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       

            
            
                 
    }
  
}
