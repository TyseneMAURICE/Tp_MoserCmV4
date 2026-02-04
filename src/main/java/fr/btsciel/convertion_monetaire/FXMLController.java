package fr.btsciel.convertion_monetaire;

import javafx.animation.RotateTransition;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    public Label label1;
    public TextField textField;
    public Button Bouton;
    public Label label2;
    public TextField textfield2;
    public DecimalFormat df = new DecimalFormat("#.##");
    public ArrayList<String> info;
    public double resultat = 0;
    public double tauxConvertionEuroDollard = 1.18;
    public double tauxConvertionEuroLivre = 0.86;
    public double tauxConvertionEuroYen = 184.97;
    public RotateTransition rotate;
    public ComboBox comboSelection;
    int choix;


    public void initialize(URL location, ResourceBundle resources) {
        info  = new ArrayList<>();
        initDataComboSelection();
        textfield2.setDisable(true);
        textField.setDisable(false);
        Bouton.setOnAction(event -> {
            switch (choix){
                case 0:
                    convertionEuroDollard();
                    break;
                case 1:
                    convertionDollardEuro();
                    break;
                case 2:
                    convertionEuroLivre();
                    break;
                case 3:
                    convertionLivreEuro();
                    break;
                case 4:
                    convertionEuroYen();
                    break;
                case 5:
                    convertionYenEuro();
                    break;
            }
        });

        comboSelection.setOnAction(event -> {
            combo_Selection(event);

            switch (choix){
                case 0:
                    label1.setText("    Euro");
                    label2.setText("  Dollard US");
                    textField.clear();
                    textfield2.clear();
                    break;
                case 1:
                    label1.setText("  Dollard US");
                    label2.setText("    Euro");
                    textField.clear();
                    textfield2.clear();
                    break;
                case 2:
                    label1.setText("    Euro");
                    label2.setText("    Livre");
                    textField.clear();
                    textfield2.clear();
                    break;
                case 3:
                    label1.setText("    Livre");
                    label2.setText("    Euro");
                    textField.clear();
                    textfield2.clear();
                    break;
                case 4:
                    label1.setText("    Euro");
                    label2.setText("    Yen");
                    textField.clear();
                    textfield2.clear();
                    break;
                case 5:
                    label1.setText("    Yen");
                    label2.setText("    Euro");
                    textField.clear();
                    textfield2.clear();
                    break;
            }
        });
    }

    private void combo_Selection(Event e) {
        int selectedIndex = comboSelection.getSelectionModel().getSelectedIndex();
        if (selectedIndex > 5){
            return;
        }
        choix = selectedIndex;
        System.out.println(info.get(selectedIndex));
    }

    private void initDataComboSelection(){
        info.add("Euro - Dollard US");
        info.add("Dollard US - Euro");
        info.add("Euro - Livre");
        info.add("Livre - Euro");
        info.add("Euro - Yen");
        info.add("Yen - Euro");
        info.forEach(info -> comboSelection.getItems().add(info));
        comboSelection.getSelectionModel().selectFirst();
    }

    public void convertionEuroDollard(){

        try {
            double euro = Double.parseDouble(textField.getText().replace(",","."));
            resultat = euro * tauxConvertionEuroDollard;
            textfield2.setText(String.valueOf(df.format(resultat)));
        }catch (NumberFormatException e){
            problèmeDeSaisi();
        }

    }

    public void convertionDollardEuro(){

        try {
            double dollar = Double.parseDouble(textField.getText().replace(",", "."));
            resultat = dollar / tauxConvertionEuroDollard;
            textfield2.setText(String.valueOf(df.format(resultat)));
        }catch (NumberFormatException e){
            problèmeDeSaisi();
        }
    }

    public void convertionEuroLivre(){
        try {
            double euro = Double.parseDouble(textField.getText().replace(",", "."));
            resultat = euro * tauxConvertionEuroLivre;
            textfield2.setText(String.valueOf(df.format(resultat)));
        }catch (NumberFormatException e){
            problèmeDeSaisi();
        }
    }

    public void convertionLivreEuro(){
        try {
            double livre = Double.parseDouble(textField.getText().replace(",", "."));
            resultat = livre / tauxConvertionEuroLivre;
            textfield2.setText(String.valueOf(df.format(resultat)));
        }catch (NumberFormatException e){
            problèmeDeSaisi();
        }
    }

    public void convertionEuroYen(){
        try {
            double euro = Double.parseDouble(textField.getText().replace(",", "."));
            resultat = euro * tauxConvertionEuroYen;
            textfield2.setText(String.valueOf(df.format(resultat)));
        }catch (NumberFormatException e){
            problèmeDeSaisi();
        }
    }

    public void convertionYenEuro(){
        try {
            double yen = Double.parseDouble(textField.getText().replace(",", "."));
            resultat = yen / tauxConvertionEuroYen;
            textfield2.setText(String.valueOf(df.format(resultat)));
        }catch (NumberFormatException e){
            problèmeDeSaisi();
        }
    }

    public void problèmeDeSaisi(){

        Alert dialogW = new Alert(Alert.AlertType.WARNING);
        dialogW.setTitle("Erreur");
        dialogW.setHeaderText(null); //Pas de text dans le header
        dialogW.setContentText("Attention !! Veuillez taper un nombre pas un caractère");
        dialogW.showAndWait();
    }

}