package com.nighthawk.spring_portfolio.mvc.nutritionstorage;


/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NutDisplayTable extends Application {
    private Database database;
    private Retrieve retrieve;

    public NutDisplayTable(Database database, Retrieve retrieve) {
        this.database = database;
        this.retrieve = retrieve;
    }

    @Override
    public void start(Stage stage) {
        TableView<DataObject> table = new TableView<>();
        TableColumn<DataObject, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<DataObject, String> nameColumn = new TableColumn<>("Name");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.getColumns().addAll(idColumn, nameColumn);
        table.getItems().addAll(retrieve.select());

        VBox root = new VBox(table);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
*/