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
 * �������v���N���X�B
 * ���Ԃ͂��ׂă~���b(int)�Ŋi�[���܂��B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class FindStatistics implements Serializable {
    /** ������ */
    private int count;
    /** ���O�������� */
    private int time;
    /** ���ό������� */
    private int averageTime;

    /**
     * �f�t�H���g�R���X�g���N�^�B
     */
    public FindStatistics() {
    }

    /**
     * �����񐔂�Ԃ��܂��B
     * @return ��
     */
    public int getCount() {
        return count;
    }

    /**
     * �񐔂�ݒ肵�܂��B
     * @param count ��
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * �������Ԃ�Ԃ��܂��B
     * @return ��������
     */
    public int getTime() {
        return time;
    }

    /**
     * �������Ԃ�ݒ肵�܂��B
     * @param time ��������
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * �����̕��ώ��Ԃ�Ԃ��܂��B
     * �񐔕��̌����̕��ώ��Ԃ�Ԃ��܂��B
     * @return ���ώ���
     */
    public int getAverageTime() {
        return averageTime;
    }

    /**
     * �������ώ��Ԃ�ݒ肵�܂��B
     * @param averageTime �������ώ���
     */
    public void setAverageTime(int averageTime) {
        this.averageTime = averageTime;
    }

    /**
     * �����̎��ԁA�y�ѕ��ώ��Ԃ��v�Z���܂��B
     * @param start �J�n����
     * @param end �I������
     */
    public void calculate(long start, long end) {
        time = (int) (end - start);
        averageTime = (averageTime * count + time) / ++count;
    }
}
