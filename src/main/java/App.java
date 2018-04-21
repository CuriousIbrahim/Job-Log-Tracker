import controller.AllJobViewerController;
import controller.StatusController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.AllJobViewer;
import view.InsertJobWindow;
import controller.AddJobController;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new AllJobViewer();

        new AllJobViewerController((AllJobViewer) primaryStage);

        primaryStage.show();
    }
}
