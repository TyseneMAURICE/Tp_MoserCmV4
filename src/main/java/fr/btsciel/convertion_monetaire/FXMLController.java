package fr.btsciel.convertion_monetaire;

import javafx.animation.RotateTransition;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    public Label Euro;
    public TextField textField;
    public Button Bouton;
    public Label Dollards;
    public TextField textfield2;
    public double tauxConvertion = 1.17960000;
    public RadioButton RadioButton1;
    public RadioButton RadioButton2;
    public ToggleGroup ToogleGroup;
    public RotateTransition rotate;


    public void initialize(URL location, ResourceBundle resources) {
        textField.setDisable(false);
        textfield2.setDisable(true);
        RadioButton1.setOnAction(e-> {rotation();
            textField.setDisable(true);
            textfield2.setDisable(false);
        });

        RadioButton2.setOnAction(e-> {rotation();
            textfield2.setDisable(false);
            textField.setDisable(true);
        });

        Bouton.setOnAction(event -> convertisseur());

    }

    private void rotation() {
        rotate = new RotateTransition(Duration.seconds(2),Bouton);
        rotate.setByAngle(180);
        rotate.play();
    }

    public void convertisseur() {
        try{
            if(ToogleGroup.getSelectedToggle() == RadioButton1){
                String s = textField.getText().replaceAll(",", ".");
                double nombre1 = Double.parseDouble(s);
                double nombreConverti = nombre1 * tauxConvertion;
                textfield2.setText(String.valueOf(nombreConverti));
            }
            else if(ToogleGroup.getSelectedToggle() == RadioButton2){
                String s = textfield2.getText().replaceAll(",", ".");
                double nombre2 = Double.parseDouble(s);
                double nombreConverti = nombre2/tauxConvertion;
                textField.setText(String.valueOf(nombreConverti));
            }
        }
        catch(NumberFormatException e){
            Alert dialogW = new Alert(Alert.AlertType.WARNING);
            dialogW.setTitle("Erreur");
            dialogW.setHeaderText(null);
            dialogW.setContentText("Attention !! Veuillez entrer un nombre et pas un caractère");
            dialogW.showAndWait();
        }
    }


}