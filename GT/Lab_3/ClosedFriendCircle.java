
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosedFriendCircle {

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0, 0}, {1, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        List<Integer> list = new ArrayList<>();
        int circle = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1 && !list.contains(arr[i][j])) {
                    dfs(arr[i][j], list, arr);
                    circle++;
                }
            }
        }
        System.out.println(circle);
    }

    static void dfs(int i, List<Integer> l, int[][] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(i);
        l.add(i);
        while (!st.isEmpty()) {
            int top = st.pop();
            l.add(top);
            for (int j : arr[top]) {
                if (!l.contains(j) && j == 1) {
                    st.push(j);
                }
            }
        }
    }
}
