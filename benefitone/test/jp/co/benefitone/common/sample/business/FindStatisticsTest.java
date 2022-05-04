/* ======================================================================
 *  $Id: FindStatisticsTest.java,v 1.1.1.1 2006/01/29 13:03:26 gon Exp $
 *    tkakeda
 *      2005/04/07
 * Originator: Takeshi.Kakeda@Sun.COM
 * OriginDate: 2005/04/07
 * ======================================================================
 */
package jp.co.benefitone.common.sample.business;

import junit.framework.TestCase;

/**
 * 検索統計情報管理クラスのテストケース。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:26 $
 * @author first last, Sun Microsystems K.K.
 */
public class FindStatisticsTest extends TestCase {
    /**
     * 時間の計算と平均時間の算出のテスト。
     * 回数も加算される。
     *
     */
    public void testCalcurate() {
        FindStatistics stat = new FindStatistics();
        stat.calculate(100, 1000);
        assertEquals("時間は900のはず。", 900, stat.getTime());
        assertEquals("1回目のはず", 1, stat.getCount());
        assertEquals("平均時間は900のはず", 900, stat.getAverageTime());
        
        stat.calculate(300, 1200);
        assertEquals("時間は900のはず。", 900, stat.getTime());
        assertEquals("2回目のはず", 2, stat.getCount());
        assertEquals("平均時間は900のはず", 900, stat.getAverageTime());

        stat.calculate(300, 1500);
        assertEquals("時間は1200のはず。", 1200, stat.getTime());
        assertEquals("3回目のはず", 3, stat.getCount());
        assertEquals("平均時間は1000のはず", 1000, stat.getAverageTime());
    }
    
    /**
     * 引数が0の場合は回数のみ変化する。
     *
     */
    public void testCalcurateZero() {
        FindStatistics stat = new FindStatistics();
        stat.calculate(0, 0);
        assertEquals("時間は0のはず。", 0, stat.getTime());
        assertEquals("1回目のはず", 1, stat.getCount());
        assertEquals("平均時間は0のはず", 0, stat.getAverageTime());
        
        stat.calculate(0, 0);
        assertEquals("時間は0のはず。", 0, stat.getTime());
        assertEquals("2回目のはず", 2, stat.getCount());
        assertEquals("平均時間は0のはず", 0, stat.getAverageTime());
    }
    
}
