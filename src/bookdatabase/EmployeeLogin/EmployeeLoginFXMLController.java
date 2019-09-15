package bookdatabase.EmployeeLogin;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vinayak
 * @modifier Pramod, Kiranjit
 */
public class EmployeeLoginFXMLController implements Initializable {

    @FXML
    private Button btnEmployeeLogin, btnEmployeeLoginExit;
    @FXML
    private TextField txtEmpID;
    @FXML
    private TextField txtEmpPass;
    @FXML
    private ImageView imgBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img1 = new Image(("images/back.png"));
        imgBack.setImage(img1);
        btnEmployeeLogin.setOnAction((ActionEvent event) -> {

            Stage stage = (Stage) btnEmployeeLogin.getScene().getWindow();
            try {
                if (txtEmpID.getText().equals("admin") && txtEmpPass.getText().equals("admin")) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmployeePageFXML.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    stage.setTitle("2ndpage");
                    stage.setScene(new Scene(root1));
                    stage.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setX(500);
                    alert.setY(350);
                    alert.setTitle("Wrong Combination");
                    alert.setHeaderText("Password or Username is Wrong ");
                    alert.setContentText("Please correct and try again");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                System.out.println("not working");
                System.out.println(e.getMessage());
            }

        });
        btnEmployeeLoginExit.setOnAction((ActionEvent event) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setX(500);
            alert.setY(350);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Exit Application");
            alert.setContentText("Are you sure you want to quit?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.exit(0);
            }
        });
        // TODO
    }

    @FXML
    private void clickBack(MouseEvent event) {
        Stage stage = (Stage) btnEmployeeLogin.getScene().getWindow();

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPageFXMLDocument.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setTitle("2ndpage");
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (Exception e) {
            System.out.println("not working");
        }

    }

}
