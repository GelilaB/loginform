import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

// import javax.lang.model.util.ElementScanner14;

import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController implements Initializable {

    @FXML
    private Button button_signup;

    @FXML
    private Button button_back;

    @FXML
    private Label emailLabel;

    @FXML
    private Label passLabel;

    @FXML
    private TextField tx_email;

    @FXML
    private TextField tx_password;

    @FXML
    private TextField tx_username;

    @FXML
    private Label userLabel;

    @FXML
    private Label notS;

    @FXML
    void backAction(ActionEvent event) {
        try {
            Parent  root = FXMLLoader.load(getClass().getResource("login.fxml"));
            
            Scene scene= new Scene(root);
            Stage primaryStage=(Stage)button_back.getScene().getWindow(); 
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void handle(ActionEvent event) {
       
        if ( (tx_username.getText().isBlank()==false && tx_password.getText().isBlank()==false && tx_email.getText().isBlank()==false)
        ) {
            Fine();
            notS.setText("accoount created successfully");
        } else {
            notS.setText("please write all instructions");
        }
    }
      

    public void Fine(){
        DBcon c = new  DBcon();
        Connection con = c.getconnection();

    String sql = ("insert into users(username,password,email) values(?,?,?)");
    try {
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, tx_username.getText());
        st.setString(2, tx_password.getText());
        st.setString(3, tx_email.getText());
       
   
    
        st.executeUpdate();
 
     
   
        } catch (Exception e) {
     System.out.println(e);
    }

    
}

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}
