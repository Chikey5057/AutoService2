package h8.chikey.control;

import h8.chikey.daoimpl.ClientIMPL;
import h8.chikey.model.Client;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.Date;

public class FirstWindowController {
//    private final SessionFactory factory;
//
//    public FirstWindowController(){
//        factory = new Configuration().configure().buildSessionFactory();
//
//    }

    @FXML
    private TableView<Client> table;

    @FXML
    private TableColumn<Client, Integer> columnID;

    @FXML
    private TableColumn<Client, String> columnFirstName;

    @FXML
    private TableColumn<Client, String> columnLastName;

    @FXML
    private TableColumn<Client, String> columnPatronymic;

    @FXML
    private TableColumn<Client, String> columnGender;

    @FXML
    private TableColumn<Client, Date> columnDirthday;

    @FXML
    private TableColumn<Client, String> columnPhone;

    @FXML
    private TableColumn<Client, String> columnEmail;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonClose;

    private final ObservableList<Client> clientList = FXCollections.observableArrayList();

    @FXML
    void initialize(){
            try (SessionFactory factory = new Configuration().configure().buildSessionFactory()){
                ClientIMPL clientIMPL = new ClientIMPL(factory);
                clientList.addAll(clientIMPL.readMyAll());
            }

            columnID.setCellValueFactory(clientIntegerCellDataFeatures -> new SimpleObjectProperty<>(clientIntegerCellDataFeatures.getValue().getClientID()));
            columnFirstName.setCellValueFactory(clientStringCellDataFeatures -> new SimpleObjectProperty<>(clientStringCellDataFeatures.getValue().getFirstName()));
            table.setItems(clientList);
    }
}
