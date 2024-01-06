package sourcecode.src.screen.controller.operation;

import sourcecode.src.exception.NodeExistedException;
import sourcecode.src.exception.NodeFullChildrenException;
import sourcecode.src.exception.NodeNotExistsException;
import sourcecode.src.exception.TreeException;

public interface UserAction {
    public void run();
    public void undo();
}
