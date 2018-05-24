import controller.AllJobViewerController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.AllJobViewer;

public class App extends Application {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        logger.debug("Starting application");

        primaryStage = new AllJobViewer();

        new AllJobViewerController((AllJobViewer) primaryStage);

        primaryStage.show();
    }
}
