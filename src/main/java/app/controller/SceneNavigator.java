//package app.controller;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Controller;
//
//import java.net.URL;
//
//@Controller
//class SceneNavigator {
//
//    @Autowired
//    ApplicationContext context;
//
//    SceneNavigator() {
//    }
//
//    public void openScene(Stage window, String resourcePath, int width, int height) throws Exception {
//        URL url = getClass().getClassLoader().getResource(resourcePath);
//        FXMLLoader loader = new FXMLLoader(url);
//        loader.setControllerFactory(context::getBean);
//        Parent root = loader.load();
//
//        Scene scene =  new Scene(root, width ,height);
//        window.setScene(scene);
//        window.show();
//    }
//}