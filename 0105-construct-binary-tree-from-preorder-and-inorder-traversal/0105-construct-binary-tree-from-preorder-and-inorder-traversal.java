class Solution {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder, inorder, 0, inorder.length - 1);
    }
    public TreeNode createTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int value = preorder[index++];
        TreeNode root = new TreeNode(value);
        int position = start;
        while (inorder[position] != value) {
            position++;
        }
        root.left = createTree(preorder, inorder, start, position - 1);
        root.right = createTree(preorder, inorder, position + 1, end);
        return root;
    }
}