/*
 * ====================================================================== $Id: AssertUtil.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 * tkakeda 2005/04/05 Originator: first.last@Sun.COM OriginDate: 2005/04/05
 * ======================================================================
 */
package jp.co.benefitone.common.sample;

import java.util.List;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

/**
 * カスタムアサーションクラス。
 * 
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class AssertUtil {
    /**
     * List同士の比較をするAssertionメソッド。
     * 
     * @param target 対象リスト
     * @param expected 期待値のリスト
     */
    public static void assertListEquals(List expected, List target) {
        Assert.assertEquals("リストのサイズが異なる", expected.size(), target.size());
        
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(target.get(i))) {
                String msg = "Expected <" + expected.get(i) + "> but <"
                             + target.get(i) + ">" + " at " + String.valueOf(i);
                throw new AssertionFailedError(msg);
            }
        }
    }

}
