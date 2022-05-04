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
 * �������v���Ǘ��N���X�̃e�X�g�P�[�X�B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:26 $
 * @author first last, Sun Microsystems K.K.
 */
public class FindStatisticsTest extends TestCase {
    /**
     * ���Ԃ̌v�Z�ƕ��ώ��Ԃ̎Z�o�̃e�X�g�B
     * �񐔂����Z�����B
     *
     */
    public void testCalcurate() {
        FindStatistics stat = new FindStatistics();
        stat.calculate(100, 1000);
        assertEquals("���Ԃ�900�̂͂��B", 900, stat.getTime());
        assertEquals("1��ڂ̂͂�", 1, stat.getCount());
        assertEquals("���ώ��Ԃ�900�̂͂�", 900, stat.getAverageTime());
        
        stat.calculate(300, 1200);
        assertEquals("���Ԃ�900�̂͂��B", 900, stat.getTime());
        assertEquals("2��ڂ̂͂�", 2, stat.getCount());
        assertEquals("���ώ��Ԃ�900�̂͂�", 900, stat.getAverageTime());

        stat.calculate(300, 1500);
        assertEquals("���Ԃ�1200�̂͂��B", 1200, stat.getTime());
        assertEquals("3��ڂ̂͂�", 3, stat.getCount());
        assertEquals("���ώ��Ԃ�1000�̂͂�", 1000, stat.getAverageTime());
    }
    
    /**
     * ������0�̏ꍇ�͉񐔂̂ݕω�����B
     *
     */
    public void testCalcurateZero() {
        FindStatistics stat = new FindStatistics();
        stat.calculate(0, 0);
        assertEquals("���Ԃ�0�̂͂��B", 0, stat.getTime());
        assertEquals("1��ڂ̂͂�", 1, stat.getCount());
        assertEquals("���ώ��Ԃ�0�̂͂�", 0, stat.getAverageTime());
        
        stat.calculate(0, 0);
        assertEquals("���Ԃ�0�̂͂��B", 0, stat.getTime());
        assertEquals("2��ڂ̂͂�", 2, stat.getCount());
        assertEquals("���ώ��Ԃ�0�̂͂�", 0, stat.getAverageTime());
    }
    
}
