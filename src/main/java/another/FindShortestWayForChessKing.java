package another;

public class FindShortestWayForChessKing {

    static int findShortestWay(int x1, int y1, int x2, int y2) {

        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);

        if (x >= y) {
            return x;
        } else {
            return y;
        }
    }
}
