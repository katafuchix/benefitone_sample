<?xml version="1.0" encoding="Windows-31J"?>
<html xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:c="http://java.sun.com/jstl/core"
      xmlns:jsp="http://java.sun.com/JSP/Page">
  <jsp:directive.page contentType="text/html;charset=Windows-31J" 
                      pageEncoding="Windows-31J"/>
  <f:view>
    <head>
      <title>Error</title>
    </head>
    <body>
      <div>
        <jsp:directive.include file="header.jspf"/>
      </div>
      <h:form>
        <center>
        <h:outputText value="エラーが発生しました。"/>
        <br/><br/>
        <h:commandButton type="button" value="戻る"
                         onclick="javascript:history.back()"/>
        </center>
      </h:form>
    </body>
  </f:view>
</html>
