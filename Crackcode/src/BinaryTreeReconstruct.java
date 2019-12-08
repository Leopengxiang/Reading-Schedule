public class BinaryTreeReconstruct {
    private static class BinaryTreeNode {
        private int value;
        private BinaryTreeNode leftTree;
        private BinaryTreeNode rightTree;
        public BinaryTreeNode(int v) {
            this.value = v;
        }
    }

    public static BinaryTreeNode reconstruct(int[] preOrder, int[] inOrder) throws Exception {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length) {
            return null;
        }
        return reconstruct(preOrder, 0, inOrder, 0, preOrder.length);
    }

    private static BinaryTreeNode
        reconstruct(int[] preOrder, int preStart,  int[]inOrder, int inStart, int length) throws Exception {
        if (length == 0) {
            return null;
        }
        // 当前序遍历数组和中序遍历数组的长度为0时，返回null.
        int rootValue = preOrder[preStart];    // 根节点的值为前序遍历的第一个值
        BinaryTreeNode tree = new BinaryTreeNode(rootValue);  //以rootValue为值，新建一棵树
        int rootIndex = -1;  //
        for (int i = inStart; i < inStart + length; i++) {
            if (inOrder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex < 0) {
            throw new RuntimeException("输入参数存在问题");
        }   // 若在中序遍历数组中未找到rootValue，则说明输入的前序遍历数组和中序遍历数组并不一一对应，输入存在问题。
        int leftLength = rootIndex - inStart;  // 左数组长度， 根据rootValue在中序数组中位置确定
        int rightLength = length - leftLength - 1;  // 右数组长度 = length - leftLength -1;
        tree.leftTree = reconstruct(preOrder, preStart + 1, inOrder, inStart, leftLength);
        tree.rightTree = reconstruct(preOrder, preStart + leftLength + 1, inOrder, rootIndex + 1, rightLength);
        return tree;
    }

    public static void main(String[] args) throws Exception {
        int[] preOrder = {4, 2, 1};
        int[] inOrder = {1, 3, 4};
        BinaryTreeNode result = reconstruct(preOrder, inOrder);
        printPostOrderly(result);
    }

    public static void printPostOrderly(BinaryTreeNode root) {

        if (root == null) {
            return;
        }
        printPostOrderly(root.leftTree);
        printPostOrderly(root.rightTree);
        System.out.println(root.value);
    }


}
