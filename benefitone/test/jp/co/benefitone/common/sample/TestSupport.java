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
 * テストサポートクラス。
 *
 * @version $Revision: 1.1.1.1 $, $Date: 2006/01/29 13:03:25 $
 * @author Takeshi Kakeda, Sun Microsystems K.K.
 */
public class TestSupport {
    /** ロガーオブジェクト */
    private static Logger logger
        = Logger.getLogger("jp.co.benefitone.common.sample.TestSupport"); 

    /**
     * SQLファイルを実行します。
     * ファイル名とDatabaseConnectionオブジェクトを受けとり、ファイル内のSQLを実行
     * します。主にテストデータの登録に使用します。末尾の「;」は実行時にエラーとなるので
     * 取り除いてから実行します。
     * @param fileName SQLファイル名
     * @param con コネクションオブジェクト
     * @throws SQLException データベース例外時
     * @throws IOException ファイルIO例外時
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
