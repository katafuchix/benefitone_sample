<?xml version="1.0" encoding="Windows-31J"?>
<html xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:c="http://java.sun.com/jstl/core"
      xmlns:jsp="http://java.sun.com/JSP/Page">
  <jsp:directive.page contentType="text/html;charset=Windows-31J" 
                      pageEncoding="Windows-31J"/>
    <f:view>
      <head>
        <title>Login</title>
      </head>
      <body>
        <center>
        <h:outputText style="font-size: 24px" value="ログイン"/>
        <br/>
        <form action="j_security_check" method="POST">
          <table>
            <tr>
              <td align="right">
                <h:outputText value="ユーザID："/>
              </td>
              <td align="left">
                <h:inputText id="j_username" maxlength="32" required="true"/>
              </td>
            </tr>
            <tr>
              <td align="right">
                <h:outputLabel>
                  <h:outputText value="パスワード："/>
                </h:outputLabel>
              </td>
              <td align="left">
                <h:inputSecret id="j_password" maxlength="32" required="true"/>
              </td>
            </tr>
            <tr>
              <td align="center" colspan="2">
                <input type="submit" value="ログイン"/>
                <input type="reset"  value="クリア"/>
              </td>
            </tr>
          </table>
        </form>
      </center>
    </body>
  </f:view>
</html>
