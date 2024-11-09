import java.util.ArrayList;
import java.util.List;

public class TreeNode<E> implements Position<E> {
    private E element;
    private TreeNode<E> parent;
    private List<Position<E>> children = new ArrayList<>();

    public TreeNode(E element, TreeNode<E> parent) {
        this.element = element;
        this.parent = parent;
    }

    @Override
    public E getElement() {
        return element;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public List<Position<E>> getChildren() {
        return children;
    }
}
