module com.example.aso_exersare {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aso_exersare to javafx.fxml;
    exports com.example.aso_exersare;
}