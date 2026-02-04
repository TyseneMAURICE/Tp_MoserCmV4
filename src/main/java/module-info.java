module fr.btsciel.convertion_monetaire {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.btsciel.convertion_monetaire to javafx.fxml;
    exports fr.btsciel.convertion_monetaire;
}