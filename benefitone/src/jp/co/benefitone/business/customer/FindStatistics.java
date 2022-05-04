/* ======================================================================
 *  $Id: FindStatistics.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/05
 * Originator: first.last@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.business.customer;

import java.io.Serializable;

/**
 * 検索統計情報クラス。
 * 時間はすべてミリ秒(int)で格納します。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class FindStatistics implements Serializable {
    /** 検索回数 */
    private int count;
    /** 直前検索時間 */
    private int time;
    /** 平均検索時間 */
    private int averageTime;

    /**
     * デフォルトコンストラクタ。
     */
    public FindStatistics() {
    }

    /**
     * 検索回数を返します。
     * @return 回数
     */
    public int getCount() {
        return count;
    }

    /**
     * 回数を設定します。
     * @param count 回数
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 検索時間を返します。
     * @return 検索時間
     */
    public int getTime() {
        return time;
    }

    /**
     * 検索時間を設定します。
     * @param time 検索時間
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * 検索の平均時間を返します。
     * 回数分の検索の平均時間を返します。
     * @return 平均時間
     */
    public int getAverageTime() {
        return averageTime;
    }

    /**
     * 検索平均時間を設定します。
     * @param averageTime 検索平均時間
     */
    public void setAverageTime(int averageTime) {
        this.averageTime = averageTime;
    }

    /**
     * 検索の時間、及び平均時間を計算します。
     * @param start 開始時間
     * @param end 終了時間
     */
    public void calculate(long start, long end) {
        time = (int) (end - start);
        averageTime = (averageTime * count + time) / ++count;
    }
}
