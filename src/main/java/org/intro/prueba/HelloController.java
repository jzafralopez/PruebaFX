package org.intro.prueba;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SpinnerValueFactory;

public class HelloController {

    @FXML
    private TableView<Usuario> tableView;
    @FXML
    private TableColumn<Usuario, String> correoColumn;
    @FXML
    private TableColumn<Usuario, String> plataformaColumn;
    @FXML
    private TableColumn<Usuario, String> adminColumn;

    @FXML
    private TableColumn<Usuario, String> softColumn;

    @FXML
    private TextField correoField;
    @FXML
    private Spinner<String> plataformaSpinner;
    @FXML
    private CheckBox adminCheckBox;
    @FXML
    private Button addButton;;

    private final ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
    @FXML
    private Button limpiarBtn;
    @FXML
    private Spinner <String>sotfSpinner;

    @FXML
    public void initialize() {
        plataformaSpinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(
                FXCollections.observableArrayList("Windows", "Linux", "macOS")
        ));

        sotfSpinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(
                FXCollections.observableArrayList("1", "2", "3","4","5")
        ));


        correoColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCorreo()));
        plataformaColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getPlataforma()));
        softColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getSoft()));
        adminColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleBooleanProperty().asString());
        tableView.setItems(usuarios);

        addButton.setOnAction(event -> agregarUsuario());
        limpiarBtn.setOnAction(event -> limpiar());

        tableView.setRowFactory(e -> {
            TableRow<Usuario> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 1) {
                    Usuario usuario = row.getItem();
                    mostrarDetallesUsuario(usuario);
                }
            });
            return row;
        });
    }

    private void agregarUsuario() {
        String correo = correoField.getText();
        String plataforma = plataformaSpinner.getValue();
        String sotf = sotfSpinner.getValue();
        boolean isAdmin = adminCheckBox.isSelected();

        Usuario nuevoUsuario = new Usuario(correo, plataforma, sotf, isAdmin);
        usuarios.add(nuevoUsuario);
    }

    private void limpiar() {
        Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmar borrado");
        confirmAlert.setHeaderText("¿Estás seguro de que deseas borrar?");
        ButtonType result = confirmAlert.showAndWait().orElse(ButtonType.CANCEL);
        if (result == ButtonType.OK) {
            limpiar();
        }
    }

    private void mostrarDetallesUsuario(Usuario usuario) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Detalles");
        alert.setHeaderText("Correo" + usuario.getCorreo());
        alert.setContentText("Correo: " + usuario.getCorreo() +
                "\nSoft: " + usuario.getSoft() +
                "\nPlataforma: " + usuario.getPlataforma() +
                "\nAdmin: " + (usuario.getAdmin()));
        alert.showAndWait();
    }
}
