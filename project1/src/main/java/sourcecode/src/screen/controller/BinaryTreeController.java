package sourcecode.src.screen.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import sourcecode.src.exception.NodeExistedException;
import sourcecode.src.exception.NodeFullChildrenException;
import sourcecode.src.exception.NodeNotExistsException;
import sourcecode.src.exception.TreeException;
import sourcecode.src.screen.controller.operation.CreatePressed;
import sourcecode.src.screen.controller.operation.DeletePressed;
import sourcecode.src.screen.controller.operation.InsertPressed;
import sourcecode.src.screen.controller.operation.UserAction;
import sourcecode.src.treedatastructure.BinaryTree;
import sourcecode.src.treedatastructure.GenericTree;

public class BinaryTreeController extends GenericTreeController{
    public BinaryTreeController(Stage stage, String treeType) {
        super(stage, treeType);
        this.setTreeDataStructure(new BinaryTree());
        this.setTreeType(treeType);
    }


    @FXML
    @Override
    protected void btnInsertPressed(ActionEvent event) throws TreeException {

        try {

            String node_val = this.getTfNodeInsert().getText();
            String parent_val = this.getTfParentInsert().getText();
            int intNodeVal = Integer.parseInt(node_val);
            int intParentVal = Integer.parseInt(parent_val);

            this.getTreeDataStructure().checkInsertNode(intParentVal, intNodeVal);

            InsertPressed insertPressed = new InsertPressed(this.getTreeDataStructure(), this, this.getScenePane(), intNodeVal, intParentVal);

            insertPressed.run();

            this.getHistory().add(insertPressed);
        }

        catch (NodeExistedException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Exception");
            alert.setHeaderText(null);
            alert.setContentText("Look likes the parent node does not exist.");

            alert.showAndWait();
        }

        catch (NodeNotExistsException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Exception");
            alert.setHeaderText(null);
            alert.setContentText("Looks like the child node has existed.");

            alert.showAndWait();
        }

        catch (NodeFullChildrenException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Exception");
            alert.setHeaderText(null);
            alert.setContentText("Looks like the inserted node invades the binary property of tree.");
            alert.showAndWait();
        }
        this.getTfNodeInsert().clear();
        this.getTfParentInsert().clear();
    }

}

