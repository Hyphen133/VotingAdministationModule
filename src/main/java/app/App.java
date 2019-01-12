//package app;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import java.net.URL;
//
////https://wimdeblauwe.wordpress.com/2017/09/18/using-spring-boot-with-javafx/
//
//@SpringBootApplication
//public class App extends Application {
//    private ConfigurableApplicationContext context;
//    private Parent rootNode;
//
//    @Override
//    public void init() throws Exception {
//        SpringApplicationBuilder builder = new SpringApplicationBuilder(App.class);
//        context = builder.run(getParameters().getRaw().toArray(new String[0]));
//
//        URL url = getClass().getClassLoader().getResource("views/mainWindow.fxml");
//        FXMLLoader loader = new FXMLLoader(url);
//        loader.setControllerFactory(context::getBean);
//
//        rootNode = loader.load();
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//        primaryStage.setScene(new Scene(rootNode, 600, 400));
//        primaryStage.centerOnScreen();
//        primaryStage.show();
//    }
//
//    @Override
//    public void stop() throws Exception {
//        context.close();
//    }
//
//
//}