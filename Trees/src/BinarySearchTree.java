
public class BinarySearchTree extends BinaryTree {
    Node root;

    public Node search(Node node, int n) {
        if(node==null) {
            return null;
        }
        if(node.val==n) {
            return node;
        }
        if(node.val<n) {
            return search(node.right, n);
        } else {
            return search(node.left, n);
        }
    }

    public Node insertIter(int n) throws Exception {
        Node node = new Node(n);
        if(root==null) {
            root = node;
        } else {
            Node curr = root;
            while (true) {
                if(n>curr.val) {
                    if(curr.right==null) {
                        curr.right = node;
                        return node;
                    } else curr= curr.right;
                } else if(n<curr.val){
                    if(curr.left==null) {
                        curr.left = node;
                        return node;
                    } else curr = curr.left;
                } else {
                    throw new Exception("All elements must be unique in a Binary Tree");
                }
            }
        }
        return null;
    }

    public Node insert(Node root, int n) throws Exception {
        if(root==null) {
            Node node = new Node(n);
            return node;
        } else {
            if(root.val>n) {
                root.left = insert(root.left,n);
            } else if(root.val<n) {
                root.right = insert(root.right,n);
            } else {
                throw new Exception("All elements must be unique in a Binary Tree");
            }
        }
        return root;
    }

    public void insert(int n) throws Exception {
        insert(root, n);
    }

    public void delete(int n) {
        if(root.val==n) {
            root = null;
            return;
        }
        Node curr = root;
        Node prev = null;
        while(curr!=null && curr.val!=n) {
            prev = curr;
            if(curr.val>n) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if(curr.left==null&& curr.right==null) {
            replaceNext(prev, curr, null);
        } else if(curr.left==null && curr.right!=null) {
            replaceNext(prev, curr, curr.right);
        } else if(curr.right==null && curr.left!=null) {
            replaceNext(prev, curr, curr.left);
        } else {
            if(curr.left.right==null && curr.left.left==null) {
                curr.left.right = curr.right;
                curr.left.left = curr.left;
                replaceNext(prev, curr, curr.left);
            } else if(curr.right.right==null && curr.right.left==null) {
                curr.right.right = curr.right;
                curr.right.left = curr.left;
                replaceNext(prev, curr, curr.right);
            } else {

            }
        }

    }

    public void replaceNext(Node prev, Node curr, Node newNode) {
        if(prev.right==curr) {
            prev.right = newNode;
        } else {
            prev.left = newNode;
        }
    }
 }
