package main.view;



import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.model.Point;
import main.MainApp;


public class PointOverviewController {
    @FXML
    private TableView<Point> pointTable;
    @FXML
    private TableColumn<Point, String> NameColumn;
    @FXML
    private TableColumn<Point, String> SpecColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label adressLabel;
    @FXML
    private Label specLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private Label worktimeLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PointOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        NameColumn.setCellValueFactory(
                cellData -> cellData.getValue().nameProperty());
        SpecColumn.setCellValueFactory(
                cellData -> cellData.getValue().specProperty());

        // Clear person details.
        showPointDetails(null);

        // Listen for selection changes and show the person details when changed.
        pointTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPointDetails(newValue));
    }



    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        pointTable.setItems(mainApp.getPointsData());
    }

    private void showPointDetails(Point p) {
        if (p != null) {
            // Fill the labels with info from the person object.
            nameLabel.setText(p.getName());
            adressLabel.setText(p.getAdress());
            specLabel.setText(p.getSpec());
            worktimeLabel.setText(p.getWorktime());
            telephoneLabel.setText(p.getTelephones());

            // TODO: We need a way to convert the birthday into a String!
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
            nameLabel.setText("");
            adressLabel.setText("");
            specLabel.setText("");
            worktimeLabel.setText("");
            telephoneLabel.setText("");
        }
    }

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = pointTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            pointTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewPerson() {
        Point tempPerson = new Point();
        boolean okClicked = mainApp.showPointEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPointsData().add(tempPerson);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        Point selectedPoint = pointTable.getSelectionModel().getSelectedItem();
        if (selectedPoint != null) {
            boolean okClicked = mainApp.showPointEditDialog(selectedPoint);
            if (okClicked) {
                showPointDetails(selectedPoint);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
}
