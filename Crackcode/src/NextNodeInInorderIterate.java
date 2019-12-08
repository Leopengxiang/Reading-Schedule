
public class NextNodeInInorderIterate {
    private static class TreeLinkNode {
        int  val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        TreeLinkNode result = null;
        if (pNode.right != null) {
            TreeLinkNode nNode = pNode.right;
            while (nNode.left != null) {
                nNode = nNode.left;
            }
            result = nNode;
        } else {
            TreeLinkNode parentTree = pNode.next;
            TreeLinkNode currentTree = pNode;
            while (parentTree != null && currentTree != parentTree.left) {
                parentTree = parentTree.next;
                currentTree = currentTree.next;
            }
            result = parentTree;
        }
        return result;
    }

    // 第一种情况： 该节点有右子树，则中序访问的下一个节点是该右子树中的最左边的节点。
    // 第二种情况： 该节点无右子树，且它是其父节点的左节点，则返回父节点值即可。
    // 第三种情况： 该节点无右子树，且它是其父节点的右节点，则沿树往上遍历，直到一个节点是其父节点的左节点或其母树的节点为空，则中序遍历的
    // 下一个节点是该父节点。
    // 第二三种情况可以一同表示

}

