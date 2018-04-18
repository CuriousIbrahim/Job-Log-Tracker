import controller.StatusController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.InsertJobWindow;
import controller.AddJobController;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new InsertJobWindow();

        new AddJobController((InsertJobWindow)primaryStage);
        new StatusController((InsertJobWindow)primaryStage);

        primaryStage.show();
    }
}
