/* ======================================================================
 *  $Id: TestSupport.java,v 1.1.1.1 2006/01/29 13:03:25 gon Exp $
 *    tkakeda
 *      2005/04/08
 * Originator: first.last@Sun.COM
 * OriginDate: 2005/MM/dd
 * ======================================================================
 */
package jp.co.benefitone.common.sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * �e�X�g�T�|�[�g�N���X�B
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class TestSupport {
    /** ���K�[�I�u�W�F�N�g */
    private static Logger logger
        = Logger.getLogger("jp.co.benefitone.common.sample.TestSupport"); 

    /**
     * SQL�t�@�C�������s���܂��B
     * �t�@�C������DatabaseConnection�I�u�W�F�N�g���󂯂Ƃ�A�t�@�C������SQL�����s
     * ���܂��B��Ƀe�X�g�f�[�^�̓o�^�Ɏg�p���܂��B�����́u;�v�͎��s���ɃG���[�ƂȂ�̂�
     * ��菜���Ă�����s���܂��B
     * @param fileName SQL�t�@�C����
     * @param con �R�l�N�V�����I�u�W�F�N�g
     * @throws SQLException �f�[�^�x�[�X��O��
     * @throws IOException �t�@�C��IO��O��
     */
    public static void executeSQLFromFile(String fileName, Connection con) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        Statement st = con.createStatement();
        while ((line = reader.readLine()) != null) {
            if (line.length() > 0 && line.charAt(0) != '-') {
                logger.finer(line);
                st.execute(line.replaceAll(";$",""));
            }
        }
    }

}
