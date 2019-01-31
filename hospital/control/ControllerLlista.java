package hospital.control;

import hospital.model.Hospital;
import hospital.model.Pacient;
import hospital.model.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerLlista implements Initializable {

    public String csvFile = "src/hospital/data/Hospital.csv";
    List<Pacient> p = new ArrayList<>();

    @FXML
    TableView<Pacient> tablePacients;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn DNI = new TableColumn("DNI");
        TableColumn Nom = new TableColumn("Nom");
        TableColumn Cognoms = new TableColumn("Cognoms");
        TableColumn DataNaix = new TableColumn("Data de Naixament");
        TableColumn Genre = new TableColumn("Gènere");
        TableColumn Telefon = new TableColumn("Telèfon");
        TableColumn pes = new TableColumn("Pes");
        TableColumn Alçada = new TableColumn("Alçada");

        // COMPTE!!!! les propietats han de tenir getters i setters
        DNI.setCellValueFactory(new PropertyValueFactory<Pacient,String>("DNI"));
        Nom.setCellValueFactory(new PropertyValueFactory<Pacient,String>("Nom"));
        Cognoms.setCellValueFactory(new PropertyValueFactory<Pacient,String>("Cognoms"));
        DataNaix.setCellValueFactory(new PropertyValueFactory<Pacient,String>("DataNaixament"));
        Genre.setCellValueFactory(new PropertyValueFactory<Pacient, String>("genere"));
        Telefon.setCellValueFactory(new PropertyValueFactory<Pacient,String>("Telefon"));
        pes.setCellValueFactory(new PropertyValueFactory<Pacient,Float>("Pes"));
        Alçada.setCellValueFactory(new PropertyValueFactory<Pacient,Integer>("Alçada"));

        tablePacients.getColumns().addAll(DNI,Nom,Cognoms,DataNaix,Genre,Telefon,pes,Alçada);

        ObservableList<Pacient> data = FXCollections.observableArrayList();
        data.add(new Pacient("111","n","co", LocalDate.of(2000,12,12), Persona.Genere.HOME,"55555",5.4f,100));
        loadData();
        data.addAll(p);
        tablePacients.setItems(data);

    }

    private void loadData() {
        Hospital hospital = new Hospital();
        p.addAll(hospital.loadPacients(csvFile));
    }
}
