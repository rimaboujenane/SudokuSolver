import java.util.ArrayList;
import java.util.List;

public class LinkedGeneralTree<E> extends AbstractTree<E> {
    private List<Position<E>> positions = new ArrayList<>();

    // Add root method for initializing the tree
    public Position<E> addRoot(E initialElement) {
        Position<E> root = new TreeNode<>(initialElement, null);
        positions.add(root);
        return root;
    }

    // Add child method for building the tree structure
    public Position<E> addChild(Position<E> parent, E element) {
        TreeNode<E> parentNode = (TreeNode<E>) parent;
        TreeNode<E> childNode = new TreeNode<>(element, parentNode);
        parentNode.getChildren().add(childNode);
        positions.add(childNode);
        return childNode;
    }

    @Override
    public Position<E> root() {
        return positions.isEmpty() ? null : positions.get(0);
    }

    @Override
    public Position<E> parent(Position<E> p) {
        return ((TreeNode<E>) p).getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        return ((TreeNode<E>) p).getChildren();
    }

    @Override
    public int numChildren(Position<E> p) {
        return ((TreeNode<E>) p).getChildren().size();
    }

    @Override
    public int size() {
        return positions.size();
    }
}
