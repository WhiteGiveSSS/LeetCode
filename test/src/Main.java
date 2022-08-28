import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        if (left.left.val == right.right.val && left.right.val == right.left.val) {
            return check(left.left, right.right) && check(left.right, right.left);
        }
        return false;
    }
}
