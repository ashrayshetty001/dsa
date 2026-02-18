package binary_tree;

import java.util.*;

public class basic {

    // Node Class
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Binary Tree Methods Class
    public static class binary_trees {
        static int index = -1;

        public static Node bt(int nodes[]) {
            index++;
            if (index >= nodes.length || nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = bt(nodes);
            newNode.right = bt(nodes);
            return newNode;
        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null); // Level delimiter

            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();
                if (currentNode == null) {
                    System.out.println(); // End of current level
                    if (!queue.isEmpty()) {
                        queue.add(null); // Add level delimiter for next level
                    }
                } else {
                    System.out.print(currentNode.data + " ");
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
            }
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public static int countNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            return leftCount + rightCount + 1;
        }

        public static int sumNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftSum = sumNodes(root.left);
            int rightSum = sumNodes(root.right);
            return leftSum + rightSum + root.data;
        }

        public static int diameter(Node root) {
            if (root == null) {
                return 0;
            }
            int leftDiameter = diameter(root.left);
            int rightDiameter = diameter(root.right);
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            int currentDiameter = leftHeight + rightHeight + 1;
            return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
        }

        public static boolean issubTree(Node mainTree, Node subTree) {
            if (subTree == null) {
                return true;
            }
            if (mainTree == null) {
                return false;
            }
            if (areIdentical(mainTree, subTree)) {
                return true;
            }
            return issubTree(mainTree.left, subTree) || issubTree(mainTree.right, subTree);
        }

        public static boolean areIdentical(Node tree1, Node tree2) {
            if (tree1 == null && tree2 == null) {
                return true;
            }
            if (tree1 == null || tree2 == null) {
                return false;
            }
            return (tree1.data == tree2.data) &&
                    areIdentical(tree1.left, tree2.left) &&
                    areIdentical(tree1.right, tree2.right);
        }
    }
    public List<List<Integer>> zigzagLevelOrderList(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                if (leftToRight) {
                    currentLevel.add(currentNode.data);
                } else {
                    currentLevel.add(0, currentNode.data); // Add to the front for right to left
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
            leftToRight = !leftToRight; // Toggle direction
        }
        return result;
    }

    // Horizontal Distance helper class
    static class Info {
        Node node;
        int hd;

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }

        public static void topview(Node root) {
            if (root == null) return;
            
            Queue<Info> queue = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0;
            int max = 0;

            queue.add(new Info(root, 0));
            queue.add(null);

            while (!queue.isEmpty()) {
                Info curr = queue.poll();
                if (curr == null) {
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        queue.add(null);
                    }
                } else {
                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }
                    if (curr.node.left != null) {
                        queue.add(new Info(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
                    if (curr.node.right != null) {
                        queue.add(new Info(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }
            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        binary_trees tree = new binary_trees();
        Node root = tree.bt(nodes);

        System.out.println("Preorder traversal of the binary tree:");
        binary_trees.preorder(root);
        System.out.println();
    }
}