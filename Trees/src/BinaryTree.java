import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

class Node {
    int val;
    Node right, left;
    public Node(int val) {
        this.val = val;
    }
}

public class BinaryTree {
    Node root;
    int postOrderIndex;
    int preOrderIndex;
    int[][] matrix;
    int size;
    int index;
    public void preOrder() {
        preOrder(root);
    }
    public void inOrder() {
        inOrder(root);
    }
    public void postOrder() {
        postOrder(root);
    }
    public void bfs() {
        Queue<Node> queue = new ArrayBlockingQueue<Node>(10);
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if(current!=null) {
                System.out.print(current.val + ",");
            }
            if(current.left!=null) {
                queue.add(current.left);
            }
            if(current.right!=null) {
                queue.add(current.right);
            }
        }
    }

    public void nThLevel(int n) {
        if(root!=null) {
            nThLevel(root, n);
        }
    }

    private void nThLevel(Node node, int n) {
        if(node!=null) {
            if(n==1) {
                System.out.print(node.val + ",");
            }
            if(node.left!=null) nThLevel(node.left, n-1);
            if(node.right!=null) nThLevel(node.right, n-1);
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if(node==null) {
            return 0;
        } else {
            return 1+ Math.max(height(node.right), height(node.left));
        }
    }

    public void levelOrderTraverseRecur() {
        int height = height();
        for (int i=1;i<=height;i++) {
            nThLevel(i);
        }
    }

    public void levelOrderTraverse() {
        Queue<Node> queue = new ArrayBlockingQueue<Node>(10);
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if(current!=null) {
                System.out.print(current.val + ",");
            }
            if(current.left!=null) {
                queue.add(current.left);
            }
            if(current.right!=null) {
                queue.add(current.right);
            }
        }
    }

    public void reverseLevelOrderTraverseRecur() {
        int height = height();
        for (int i=height;i>=0;i--) {
            nThLevel(i);
        }
    }

    public void reverseLevelOrderTraverse() {
        Queue<Node> queue = new ArrayBlockingQueue<Node>(10);
        Stack<Node> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if(current!=null) {
               stack.push(current);
            }
            if(current.right!=null) {
                queue.add(current.right);
            }
            if(current.left!=null) {
                queue.add(current.left);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop().val + ",");
        }
    }


    public void preOrderIter() {
        if(root!=null) {
            Stack<Node> stack = new Stack<Node>();
            Node curr = root;
            stack.push(curr);
            while(!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.val + ",");
                if(node.right!=null) stack.push(node.right);
                if(node.left!=null) stack.push(node.left);
            }
        }
    }

    public void inOrderIter() {
        if(root!=null) {
            Stack<Node> stack = new Stack<Node>();
            Node curr = root;
            stack.push(curr);
            while(!stack.isEmpty() || curr!=null) {
                while(curr!=null) {
                    curr = curr.left;
                    if(curr!=null) stack.push(curr);
                }
                if(curr==null) {
                    Node node = stack.pop();
                    if(node!=null) System.out.print(node.val + ",");
                    if(node.right!=null) {
                        stack.push(node.right);
                        curr = node.right;
                    }
                }
            }
        }
    }

    //NOT WORKING
    public void postOrderIter() {
        if(root!=null) {
            Stack<Node> stack = new Stack<>();
            Node curr = root;
            stack.push(curr);
            while (!stack.isEmpty() || curr!=null) {
                while (curr!=null) {
                    if(curr.right!=null) stack.push(curr.right);
                    if(curr.left!=null) stack.push(curr.left);
                    curr = curr.left;
                }
                if(curr==null) {
                    Node node = stack.pop();
                    Node prev = null;
                    if(!stack.isEmpty()) prev = stack.pop();
                    System.out.print(node.val + ",");
                    if(prev!=null && (prev.right==node || prev.right==null)) {
                        System.out.print(prev.val + ",");
                    } else {
                        if(prev!=null) stack.push(prev);
                        curr=prev;
                    }
                }
            }
        }
    }

    public void postOrderIterTwoStacks() {
        if(root!=null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            Node curr = root;
            stack1.push(curr);
            while (!stack1.isEmpty()) {
                Node node = stack1.pop();
                stack2.push(node);
                if(node.left!=null) stack1.push(node.left);
                if(node.right!=null) stack1.push(node.right);
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().val + ",");
            }
        }
    }

    public void preOrderIterInverse() {
        if(root!=null) {
            Stack<Node> stack = new Stack<Node>();
            Node curr = root;
            stack.push(curr);
            while(!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.print(node.val + ",");
                if(node.left!=null) stack.push(node.left);
                if(node.right!=null) stack.push(node.right);
            }
        }
    }

    public void inOrderIterInverse() {
        if(root!=null) {
            Stack<Node> stack = new Stack<Node>();
            Node curr = root;
            stack.push(curr);
            while(!stack.isEmpty() || curr!=null) {
                while(curr!=null) {
                    curr = curr.right;
                    if(curr!=null) stack.push(curr);
                }
                if(curr==null) {
                    Node node = stack.pop();
                    if(node!=null) System.out.print(node.val + ",");
                    if(node.left!=null) {
                        stack.push(node.left);
                        curr = node.left;
                    }
                }
            }
        }
    }

    private void preOrder(Node node) {
        if(node!=null) {
            System.out.print(node.val + ",");
        } else {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(Node node) {
        if(node==null) {
            return;
        } else {
            inOrder(node.left);
            System.out.print(node.val + ",");
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if(node==null) {
            return;
        } else {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + ",");
        }
    }

    public void buildTreeFromInAndPostOrder(int[] inOrder, int[] postOrder) {
        postOrderIndex=postOrder.length-1;
        root =  buildTreeFromInAndPostOrder(inOrder, 0, inOrder.length-1, postOrder);
    }

    public Node buildTreeFromInAndPostOrder(int[] inOrder, int start, int end, int[] postOrder){
        int l = inOrder.length;
        if(start>=l || start<0 || end<0 || end>=l || start>end) {
            return null;
        }
        int num = postOrder[postOrderIndex--];
        int i = searchIndex(inOrder, start, end, num);
        Node root = new Node(num);
        root.right = buildTreeFromInAndPostOrder(inOrder, i+1, end, postOrder);
        root.left = buildTreeFromInAndPostOrder(inOrder, start, i-1, postOrder);
        return root;
    }

    public void buildTreeFromInAndPreOrder(int[] inOrder, int[] preOrder) {
        preOrderIndex = 0;
        root = buildTreeFromInAndPreOrder(inOrder, 0, inOrder.length-1, preOrder);
    }

    public Node buildTreeFromInAndPreOrder(int[] inOrder, int start, int end, int[] preOrder) {
        int l = inOrder.length;
        if(start>=l || start<0 || end<0 || end>=l || start>end) {
            return null;
        }
        int num = preOrder[preOrderIndex++];
        int i = searchIndex(inOrder, start, end, num);
        Node root = new Node(num);
        root.left = buildTreeFromInAndPreOrder(inOrder, start, i-1, preOrder);
        root.right = buildTreeFromInAndPreOrder(inOrder, i+1, end, preOrder);
        return root;
    }

    public void generatePostOrderFromInAndPreOrder(int[] inOrder, int[] preOrder) {
        preOrderIndex=0;
        generatePostOrderFromInAndPreOrder(inOrder, 0, inOrder.length-1, preOrder);
    }

    public void generatePostOrderFromInAndPreOrder(int[] inOrder, int start, int end, int[] preOrder) {
        int l = inOrder.length-1;
        if(start>=l || end>=l || start<0 || end<0 || start>end) {
            return;
        }
        int num = preOrder[preOrderIndex++];
        int i = searchIndex(inOrder, start, end, num);
        generatePostOrderFromInAndPreOrder(inOrder, start, i-1, preOrder);
        generatePostOrderFromInAndPreOrder(inOrder, i+1, end, preOrder);
        System.out.print(num + ",");
    }

    public int searchIndex(int[] searchIn, int start, int end, int num) {
        for(int i=start; i<=end; i++) {
            if(searchIn[i]== num) {
                return i;
            }
        }
        return -1;
    }

    public void generateAncestorMatrix(int n) {
        matrix = new int[n][n];
        populateAncestorMatrix(root.left, root.val);
        populateAncestorMatrix(root.right, root.val);
    }

    public void populateAncestorMatrix(Node node, int parentV) {
        if(node==null) {
            return;
        }
        int curr = node.val;
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][parentV]==1) {
                matrix[i][curr]=1;
            } else {
                matrix[i][curr]=0;
            }
        }
        matrix[parentV][curr]=1;
        populateAncestorMatrix(node.left, curr);
        populateAncestorMatrix(node.right, curr);
    }

    public void buildTreeFromPreOrder(int[] preOrder, char[] preOrderLN) throws Exception {
        preOrderIndex=0;
        root = buildTreeFromPreOrder(preOrder, 'N', preOrderLN);
    }

    public Node buildTreeFromPreOrder(int[] preOrder, char parentChar, char[] preOrderLN) throws Exception {
        if(parentChar=='L') {
            return null;
        } else if(parentChar=='N'){
            int val = preOrder[preOrderIndex];
            char i = preOrderLN[preOrderIndex++];
            Node root = new Node(val);
            root.left = buildTreeFromPreOrder(preOrder, i, preOrderLN);
            root.right = buildTreeFromPreOrder(preOrder, i, preOrderLN);
            return root;
        } else {
            throw new Exception("Incorrect preOrderLN array info");
        }
    }

    //Builds tree where parent is larger than children
    public void buildTreeFromInOrder(int[] inOrder) {
        root = buildTreeFromInOrderInRange(inOrder, 0, inOrder.length-1);
    }

    public Node buildTreeFromInOrderInRange(int[] inOrder, int start, int end) {
        if(start<0 || end <0 || start>=inOrder.length || end>=inOrder.length || start>end) {
            return null;
        }
        int index = getMaxFromArrayInRange(inOrder, start, end);
        int val = inOrder[index];
        Node root = new Node(val);
        root.left = buildTreeFromInOrderInRange(inOrder, start, index-1);
        root.right = buildTreeFromInOrderInRange(inOrder, index+1, end);
        return root;
    }

    public int getMaxFromArrayInRange(int[] array, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i=start; i<=end; i++) {
            if(array[i]>max) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    public void buildTreeFromParentArray(int[] parentArray) {
        int rootIndex=-1;
        for(int i=0; i< parentArray.length-1; i++) {
            if(parentArray[i]==-1) {
                rootIndex=i;
            }
        }
        root = buildTreeFromParentArray(parentArray, rootIndex);
    }

    public Node buildTreeFromParentArray(int[] parentArray, int parent) {
        int leftIndex = -1, rightIndex = -1;
        Node root = null;
        if(parent!=-1) {
            root = new Node(parent);
            for(int i=0; i<parentArray.length; i++) {
                if(parentArray[i]==parent) {
                    if(leftIndex==-1) {
                        leftIndex=i;
                    } else {
                        rightIndex=i;
                    }
                }
            }
            root.left = buildTreeFromParentArray(parentArray, leftIndex);
            root.right = buildTreeFromParentArray(parentArray, rightIndex);
        }
        return root;
    }

    public DoublyLinkedListWithTreeNode convertTreeToDoublyLinkedList() {
        DoublyLinkedListWithTreeNode dll = new DoublyLinkedListWithTreeNode();
        convertTreeToDLL(root, dll);
        return dll;
    }

    public void convertTreeToDLL(Node node, DoublyLinkedListWithTreeNode dll) {
        if(node.left!=null) {
            convertTreeToDLL(node.left, dll);
        }
        dll.insertNodeAtRear(node);
        if(node.right!=null) {
            convertTreeToDLL(node.right, dll);
        }
    }

    public void convertChildrenSum() {
        childrenSum(root);
    }

    public int childrenSum(Node node) {
        int sum = node.left==null && node.right==null ? node.val : 0;
        if(node.left!=null) {
            sum+=childrenSum(node.left);
        }
        if(node.right!=null) {
            sum+=childrenSum(node.right);
        }
        node.val = sum;
        return sum;
    }

    public int findLowestCommonAncestor(int n1, int n2) {
        size=0;
        findSize(root);
        int[] n1Path = new int[size];
        int[] n2Path = new int[size];
        index=0;
        findPath(n1, n1Path, root);
        index=0;
        findPath(n2, n2Path, root);
        int i1=0, i2=0;
        while(n1Path[i1]!=root.val) {
            i1++;
        }
        while(n2Path[i2]!=root.val) {
            i2++;
        }
        while(i1>=0 && i2>=0 && n1Path[i1]==n2Path[i2]) {
            i1--;
            i2--;
        }
        return n1Path[i1+1];
    }

    public boolean findPath(int num, int[] n1Path, Node node) {
        if(node==null) {
            return false;
        }
        if(node.val == num || findPath(num, n1Path, node.left) || findPath(num, n1Path, node.right)) {
            n1Path[index++] = node.val;
            return true;
        }
        return false;
    }


    public void findSize(Node root) {
        if(root.left!=null) {
            findSize(root.left);
        }
        if(root.right!=null) {
            findSize(root.right);
        }
        size++;
    }

    public int maxDepth(Node node) {
        if(node==null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
        }
    }

    public int size(Node node) {
        if(node==null) {
            return 0;
        } else {
            return 1 + size(node.left) +  size(node.right);
        }
    }

    public int diameter(Node node) {
        if(node==null) {
            return 0;
        } else {
            int leftDiameter = diameter(node.left);
            int rightDiameter = diameter(node.right);
            int diameter = maxDepth(node.left) + maxDepth(node.right) + 1;
            return Math.max(Math.max(leftDiameter, rightDiameter), diameter);
        }
    }

    public int leafDistanceFromK(Node root, int k) {
        Node kNode = findNode(root, k);
        int descendantMinDistance = minHeight(kNode)-1;
        int nonDescendantMinDistance = minLeafDistanceFromK(root, k);
        return Math.min(descendantMinDistance, nonDescendantMinDistance);
    }

    public int minHeight(Node root) {
        if(root==null) {
            return 0;
        } else {
            int left = minHeight(root.left);
            int right = minHeight(root.right);
            return 1 + (left==0 || right==0 ? Math.max(left, right) : Math.min(left, right));
        }
    }

    public int minLeafDistanceFromK(Node root, int k) {
        if(root==null) {
            return 0;
        } else if(root.val==k) {
            return 1;
        } else {
            return 1 + Math.min(minLeafDistanceFromK(root.left, k), minLeafDistanceFromK(root.right, k));
        }
    }

    public Node findNode(Node root, int val) {
        if(root==null) {
            return null;
        } else if(root.val==val) {
            return root;
        } else {
            Node node = findNode(root.left, val);
            if (node != null) {
                return node;
            } else {
                node = findNode(root.right, val);
                if (node != null) {
                    return node;
                }
            }
        }
        return null;
    }

    public int findMaxPathSum() {
        List<Integer> maxAtEachNode = new ArrayList<>();
        findMaxPathSum(root, maxAtEachNode);
        int max = Integer.MIN_VALUE;
        for(int num : maxAtEachNode) {
            if(num > max) {
                max = num;
            }
        }
        return max;
    }

    public int findMaxPathSum(Node root, List<Integer> maxAtEachNode) {
        if(root==null) {
            return 0;
        } else {
            int left = findMaxPathSum(root.left, maxAtEachNode);
            int right = findMaxPathSum(root.right, maxAtEachNode);
            maxAtEachNode.add(Math.max(Math.max(Math.max(left, right),left+right)+root.val, root.val));
            return Math.max(Math.max(left, right)+root.val, root.val);
        }
    }

    public static void main(String[] args) throws Exception {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(8);
        tree.root.right.right = new Node(5);
        tree.root.right.left = new Node(9);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.right = new Node(10);
        tree.root.right.right.right = new Node(7);
        tree.root.right.right.left = new Node(11);
        tree.preOrder();
        System.out.println();
        tree.preOrderIter();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.inOrderIter();
        System.out.println();
        tree.postOrder();
        System.out.println();
        //NOT WORKING
        tree.postOrderIter();
        System.out.println();
        tree.postOrderIterTwoStacks();
        System.out.println();
        tree.bfs();
        System.out.println();
        tree.levelOrderTraverse();
        System.out.println();
        tree.levelOrderTraverseRecur();
        System.out.println();
        tree.reverseLevelOrderTraverse();
        System.out.println();
        tree.reverseLevelOrderTraverseRecur();
        System.out.println();
        tree.nThLevel(3);
        System.out.println();
        System.out.println(tree.height());

        int[] inOrder = new int[]{6,4,10,2,8,1,9,3,11,5,7};
        int[] postOrder = new int[]{6,10,4,8,2,9,11,7,5,3,1};
        BinaryTree constructedTree = new BinaryTree();
        constructedTree.buildTreeFromInAndPostOrder(inOrder,postOrder);
        System.out.println();
        constructedTree.preOrder();
        System.out.println();
        constructedTree.inOrder();
        System.out.println();
        constructedTree.postOrder();

        int[] preOrder = new int[]{1,2,4,6,10,8,3,9,5,11,7};
        BinaryTree constructedTree2 = new BinaryTree();
        constructedTree2.buildTreeFromInAndPreOrder(inOrder, preOrder);
        System.out.println();
        constructedTree2.preOrder();
        System.out.println();
        constructedTree2.inOrder();
        System.out.println();
        constructedTree2.postOrder();
        System.out.println();
        constructedTree2.generatePostOrderFromInAndPreOrder(inOrder, preOrder);
        System.out.println();

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(5);
        tree2.root.left = new Node(1);
        tree2.root.right = new Node(2);
        tree2.root.left.left = new Node(0);
        tree2.root.left.right = new Node(4);
        tree2.root.right.left = new Node(3);
        tree2.root.right.right = new Node(6);
        System.out.println();
        tree2.preOrder();
        System.out.println();
        tree2.inOrder();
        System.out.println();
        tree2.postOrder();
        System.out.println();
        System.out.println();
        System.out.println("AncestorMatrix");
        tree2.generateAncestorMatrix(7);
        for (int i=0;i<7; i++) {
            for(int j=0; j<7; j++) {
                System.out.print(tree2.matrix[i][j] + " ");
            }
            System.out.println();
        }

        BinaryTree tree3 = new BinaryTree();
        int[] preOrder1 = new int[]{1,2,4,6,10,8,3,9,5,11,7};
        char[] preOrderLN = new char[]{'N','N','N','L','L','L', 'N', 'L', 'N', 'L', 'L'};
        tree3.buildTreeFromPreOrder(preOrder1, preOrderLN);
        System.out.println();
        tree3.preOrder();
        System.out.println();
        tree3.inOrder();
        System.out.println();
        tree3.postOrder();
        System.out.println();

        BinaryTree tree4 = new BinaryTree();
        int[] inOrder2 = {1, 5, 10, 40, 30, 15, 28, 20};
        tree4.buildTreeFromInOrder(inOrder2);
        System.out.println();
        tree4.preOrder();
        System.out.println();
        tree4.inOrder();
        System.out.println();
        tree4.postOrder();
        System.out.println();

        BinaryTree tree5 = new BinaryTree();
        int[] parent = {-1, 0, 0, 1, 1, 3, 5};
        tree5.buildTreeFromParentArray(parent);
        System.out.println();
        tree5.preOrder();
        System.out.println();
        tree5.inOrder();
        System.out.println();
        tree5.postOrder();
        System.out.println();


        BinaryTree tree6 = new BinaryTree();
        tree6.root = new Node(10);
        tree6.root.right = new Node(15);
        tree6.root.left = new Node(12);
        tree6.root.right.left = new Node(36);
        tree6.root.left.left = new Node(25);
        tree6.root.left.right = new Node(30);
        DoublyLinkedListWithTreeNode dll = tree5.convertTreeToDoublyLinkedList();
        dll.print();
        System.out.println();
        DoublyLinkedListWithTreeNode dll2 = tree6.convertTreeToDoublyLinkedList();
        dll2.print();
        System.out.println();

        BinaryTree tree7 = new BinaryTree();
        tree7.root = new Node(50);
        tree7.root.left = new Node(7);
        tree7.root.right = new Node(2);
        tree7.root.left.left = new Node(3);
        tree7.root.left.right = new Node(5);
        tree7.root.right.left = new Node(1);
        tree7.root.right.right = new Node(30);
        System.out.println();
        tree7.preOrder();
        System.out.println();
        tree7.inOrder();
        System.out.println();
        tree7.postOrder();
        System.out.println();

        tree7.convertChildrenSum();
        System.out.println();
        tree7.preOrder();
        System.out.println();
        tree7.inOrder();
        System.out.println();
        tree7.postOrder();
        System.out.println();

        BinaryTree tree8 = new BinaryTree();
        tree8.root = new Node(4);
        tree8.root.left = new Node(7);
        tree8.root.right = new Node(2);
        tree8.root.left.left = new Node(3);
        tree8.root.left.left.left = new Node(6);
        tree8.root.left.left.left.left = new Node(9);
        tree8.root.left.right = new Node(5);
        tree8.root.left.right.right = new Node(8);
        tree8.root.left.right.right.right = new Node(10);
        System.out.println(tree8.findLowestCommonAncestor(4,5));
        System.out.println(tree8.maxDepth(tree8.root));
        System.out.println(tree8.size(tree8.root));
        System.out.println(tree8.diameter(tree8.root));
        System.out.println(tree8.leafDistanceFromK(tree8.root, 7));
        System.out.println(tree8.findMaxPathSum());
    }
}
