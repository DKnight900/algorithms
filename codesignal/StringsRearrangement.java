package codesignal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringsRearrangement {
    public static void main(String[] args) {
        StringsRearrangement sr = new StringsRearrangement();
        List<String> a = new ArrayList<>();

        a.add("abc");
        a.add("bef");
        a.add("bcc");
        a.add("bew");
        a.add("zew");
        a.add("zyw");
        a.add("bec");
        a.add("bbc");
        a.add("bdc");

        String[] myArray = new String[a.size()];
        a.toArray(myArray);
        System.out.println(sr.stringsRearrangement(myArray));
    }

    boolean stringsRearrangement(String[] inputArray) {
        if(inputArray.length == 1) {
            return false;
        }
        if(inputArray.length == 2) {
            if (inputArray[0].equals(inputArray[1])) {
                return false;
            }
        }
        for (String string: inputArray) {
            NTree currentNTree = new NTree(inputArray, string);
            if (currentNTree.itsValidRearrange) {
                return true;
            }
        }

        return false;
    }

    private static class NTree {
        Node root;
        boolean itsValidRearrange;

        NTree(String[] a, String rootValue) {
            root = new Node(rootValue);
            List<String> aList = new ArrayList<>();
            Collections.addAll(aList,a);
            aList.remove(rootValue);

            itsValidRearrange = addChildren(root, aList);
        }

        boolean addChildren(Node node, List<String> children) {
            boolean itsValidChild = false;
            int k = 0;
            if(children.size() == 0) {
                return true;
            }
            for (int i = 0; i < children.size() && !itsValidChild; i++) {
                if (onlyOneDifferentCharacter(node.value, children.get(i))) {
                    node.addChild(new Node(children.get(i)));
                    itsValidChild = addChildren(node.getChild(k), filteredChildren(node.getChild(k), children));
                    k++;
                }
            }
            return itsValidChild;
        }

        List<String> filteredChildren(Node node, List<String> children) {
            List<String> newList = new ArrayList<>();
            newList.addAll(children);
            for (int i = 0; i < newList.size(); i++) {
                if(newList.get(i).equals(node.value)) {
                    newList.remove(i);
                    break;
                }
            }

            return newList;
        }

        boolean onlyOneDifferentCharacter(String string1, String string2) {
            if (string1.length() != string2.length()) {
                return false;
            }
            int differentCharacters = 0;
            for (int i = 0; i < string1.length(); i++) {
                if (string1.charAt(i) != string2.charAt(i)) {
                    differentCharacters++;
                    if (differentCharacters > 1) {
                        return false;
                    }
                }
            }
            return differentCharacters == 1;
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
