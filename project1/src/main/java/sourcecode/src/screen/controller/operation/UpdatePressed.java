package sourcecode.src.screen.controller.operation;

import javafx.animation.SequentialTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import sourcecode.src.exception.NodeExistedException;
import sourcecode.src.exception.NodeFullChildrenException;
import sourcecode.src.exception.NodeNotExistsException;
import sourcecode.src.exception.TreeException;
import sourcecode.src.screen.controller.GenericTreeController;
import sourcecode.src.treedatastructure.GenericTree;
import sourcecode.src.treedatastructure.Node;

import java.util.ArrayList;
import java.util.Collections;

public class UpdatePressed implements UserAction {
    private int intOldVal;
    private int intNewVal;
    private GenericTreeController genericTreeController;
    private GenericTree genericTree;
    private Pane scenePane;

    public UpdatePressed(GenericTree genericTree, GenericTreeController genericTreeController, Pane scenePane, int intOldVal, int intNewVal) {
        this.genericTree = genericTree;
        this.genericTreeController = genericTreeController;
        this.scenePane = scenePane;
        this.intNewVal = intNewVal;
        this.intOldVal = intOldVal;
    }

    @Override
    public void run() {
        Node nodeObject = genericTree.searchNode(intOldVal);
        ArrayList<Node> search_direction = genericTree.getPathToRoot(nodeObject);
        search_direction.add(genericTree.getRootNode());
        Collections.reverse(search_direction);
        drawAnimationsUpdate(search_direction, nodeObject, intNewVal);
        System.out.println("Update operation.");
    }

    @Override
    public void undo() {
        Node nodeObject = genericTree.searchNode(intNewVal);
        nodeObject.getTfId().setText(String.valueOf(intOldVal));
        nodeObject.updateId(intOldVal);
        System.out.println("Update operation undo.");
    }

    public void drawAnimationsUpdate(ArrayList<Node> search_direction, Node oldNode, int newNodeVal) {
        ArrayList<Line> listLines = new ArrayList<Line>();
        ArrayList<StackPane> listStackPane = new ArrayList<StackPane>();
        SequentialTransition seq = this.genericTreeController.drawAnimations(search_direction, listLines, listStackPane);
        seq.setOnFinished(event -> turnOffAnimationsUpdate(listLines, listStackPane, oldNode, newNodeVal));
        seq.play();
    }


    private void turnOffAnimationsUpdate(ArrayList<Line> listLines, ArrayList<StackPane> listPanes, Node childNode, int newNodeVal) {
        try {
            int secondsToSleep = 1;
            long millisecondsToSleep = secondsToSleep * 1000;

            childNode.getTfId().setText(String.valueOf(newNodeVal));
            childNode.updateId(newNodeVal);
            Thread.sleep(millisecondsToSleep);
            scenePane.getChildren().removeAll(listLines);
            scenePane.getChildren().removeAll(listPanes);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
