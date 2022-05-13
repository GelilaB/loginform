import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loginController implements Initializable{

    @FXML
    
    private Label Lable_Em;

    @FXML
    private Label displayLabel;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button button_log;

    @FXML
    private Button button_sign;

    @FXML
    private Label lable_PASS;

    @FXML
    private Label lable_UR;

    @FXML
    private TextField txt_emai;

    @FXML
    private TextField txt_passw;

    @FXML
    private TextField txt_uname;

    @FXML
    void loginAction(ActionEvent event) {
        if (txt_uname.getText().isBlank()==false && txt_passw.getText().isBlank()==false) {
            Errorhandle();
     } else {
       displayLabel.setText("Enter username and password!");
      }
    }

 public void Errorhandle(){
        DBcon c = new  DBcon();
        Connection con = c.getconnection();

        String verify = ("select count(1) From users where userName ='"+txt_uname.getText()+"' and password = '"+txt_passw.getText() +"'");
           
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(verify);
            while (rs.next())
            if(rs.getInt(1)==1){
        
            Parent root = FXMLLoader.load(getClass().getResource("logged.fxml"));
            
            Scene scene= new Scene(root);
            Stage primaryStage=(Stage)button_sign.getScene().getWindow(); 
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else{
            displayLabel.setText("Invalid Username and Paswword! please try again!!");
        }}
        catch (Exception e) {
            e.printStackTrace();
        }
    
       
    } 
        
    
 @FXML
    void signUpAction(ActionEvent event) {

        
            try {
                Parent  root = FXMLLoader.load(getClass().getResource("signup.fxml"));
                
                Scene scene= new Scene(root);
                Stage primaryStage=(Stage)button_sign.getScene().getWindow(); 
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }}
    
        
     @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }

}

