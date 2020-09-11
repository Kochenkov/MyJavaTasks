package another;

import org.junit.Assert;
import org.junit.Test;

public class FindShortestWayForChessKingTests {

    @Test
    public void findShortestWayTest() {
        Assert.assertEquals(3, FindShortestWayForChessKing.findShortestWay(1, 2, 3, 5));
        Assert.assertEquals(7, FindShortestWayForChessKing.findShortestWay(8, 8, 1, 1));
        Assert.assertEquals(1, FindShortestWayForChessKing.findShortestWay(2, 1, 2, 2));
    }
}