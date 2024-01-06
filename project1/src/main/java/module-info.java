module sourcecode.src{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


//    requires org.controlsfx.controls;
//    requires org.kordamp.bootstrapfx.core;


//    exports com.example.treedatastructure;
//    opens com.example.treedatastructure to javafx.fxml;
//    exports src.screen;
//    opens src.screen to javafx.fxml;
    exports sourcecode.src.test;
    opens sourcecode.src.test to javafx.fxml;
//    exports com.example.treedatastructure.treedatastructure;
//    opens com.example.treedatastructure.treedatastructure to javafx.fxml;
    exports sourcecode.src.screen.controller;
    opens sourcecode.src.screen.controller to javafx.fxml;
    exports sourcecode.src.screen.controller.operation;
    opens sourcecode.src.screen.controller.operation to javafx.fxml;
    exports sourcecode.src.exception;
    opens sourcecode.src.treedatastructure to javafx.fxml;
    exports sourcecode.src.treedatastructure;
}