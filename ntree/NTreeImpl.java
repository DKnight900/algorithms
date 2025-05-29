package ntree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author DKnight900
 */
public class NTreeImpl {
    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        a.add("x");
        a.add("y");
        a.add("z");
        a.add("w");

        for (int i = 0; i < a.size(); i++) {
            NTree ntree = new NTree(a, a.get(i));
        }
    }

    private static class NTree {
        Node root;

        NTree(List<String> a, String rootValue) {
            root = new Node(rootValue);
            addChildren(root, a
                .stream()
                .filter(value -> !value.equals(rootValue))
                .collect(Collectors.toList())
            );
        }

        void addChildren(Node node, List<String> children) {
            for (int i = 0; i < children.size(); i++) {
                node.addChild(new Node(children.get(i)));
                addChildren(node.getChild(i), filteredChildren(node.getChild(i), children));
            }
        }

        List<String> filteredChildren(Node node, List<String> children) {
            return children
                .stream()
                .filter(value -> !value.equals(node.value))
                .collect(Collectors.toList());
        }
    }

    private static class Node {
        String value;
        List<Node> children;

        Node(String value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        void addChild(Node child) {
            children.add(child);
        }

        Node getChild(int index) {
            return children.get(index);
        }
    }
}
