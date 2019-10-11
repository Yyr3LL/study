package main.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.model.Point;


/**
 * Dialog to edit details of a person.
 *
 * @author Marco Jakob
 */
public class PointEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField adressField;
    @FXML
    private TextField specField;
    @FXML
    private TextField worktimeField;
    @FXML
    private TextField telephoneField;

    private Stage dialogStage;
    private Point point;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param point
     */
    public void setPoint(Point point) {
        this.point = point;

        nameField.setText(point.getName());
        specField.setText(point.getAdress());
        adressField.setText(point.getSpec());
        worktimeField.setText(point.getWorktime());
        telephoneField.setText(point.getTelephones());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            point.setName(nameField.getText());
            point.setAdress(adressField.getText());
            point.setSpec(specField.getText());
            point.setWorktime(worktimeField.getText());
            point.setTelephones(telephoneField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (nameField.getText() == null || nameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
        }
        if (adressField.getText() == null || adressField.getText().length() == 0) {
            errorMessage += "No valid adress!\n";
        }
        if (specField.getText() == null || specField.getText().length() == 0) {
            errorMessage += "No valid spec!\n";
        }

        if (worktimeField.getText() == null || worktimeField.getText().length() == 0) {
            errorMessage += "No valid worktime!\n";
        }

        if (telephoneField.getText() == null || telephoneField.getText().length() == 0) {
            errorMessage += "No valid telephone!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
