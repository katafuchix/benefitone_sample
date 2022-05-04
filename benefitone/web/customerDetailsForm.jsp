<?xml version="1.0" encoding="Windows-31J"?>
<html xmlns:f="http://java.sun.com/jsf/core" 
      xmlns:h="http://java.sun.com/jsf/html" 
      xmlns:jsp="http://java.sun.com/JSP/Page">
  <jsp:directive.page contentType="text/html;charset=Windows-31J" 
                      pageEncoding="Windows-31J"/>
  <f:view>
    <head>
      <title>Customer Edit</title>
      <link href="/resources/stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
      <div>
        <jsp:directive.include file="header.jspf"/>
      </div>
      <center>
        <h:outputText style="font-size: 24px" value="顧客情報編集"/>
      </center>
      <h:form>
        <table>
          <tr bgcolor="#eeaacc">
            <td align="left" rowspan="2" valign="top">
              <h:outputText value="会社"/>
            </td>
            <td align="right">
              <h:outputText value="コード"/>
            </td>
            <td align="left">
              <h:outputText value="#{tmpCustomer.company.id}"/>
            </td>
          </tr>
          <tr bgcolor="#eeaacc">
            <td align="right">
              <h:outputText value="会社名(入力必須)"/>
            </td>
            <td>
              <h:inputText value="#{tmpCustomer.company.name}"
                           required="true"/>
            </td>
          </tr>
          <tr bgcolor="#cceeaa">
            <td align="left" rowspan="3" valign="top">
              <h:outputText value="部署"/>
            </td>
            <td align="right">
              <h:outputText value="コード"/>
            </td>
            <td align="left">
              <h:outputText value="#{tmpCustomer.department.id}"/>
            </td>
          </tr>
          <tr bgcolor="#cceeaa">
             <td align="right">
               <h:outputText value="部署名(入力必須)"/>
             </td>
             <td align="left">
               <h:inputText value="#{tmpCustomer.department.name}"
                            required="true"/>
             </td>
           </tr>
           <tr bgcolor="#cceeaa">
             <td align="right">
               <h:outputText value="住所"/>
             </td>
             <td align="left">
               <h:inputTextarea value="#{tmpCustomer.department.address}"/>
             </td>
           </tr>
           <tr bgcolor="#aaeecc">
             <td align="left" rowspan="4" valign="top">
               <h:outputText value="顧客"/>
             </td>
             <td align="right">
               <h:outputText value="コード"/>
             </td>
            <td align="left">
              <h:outputText value="#{tmpCustomer.id}"/>
            </td>
           </tr>
           <tr bgcolor="#aaeecc">
            <td align="right">
              <h:outputText value="氏名(入力必須)"/>
            </td>
            <td align="left">
              <h:inputText value="#{tmpCustomer.name.firstName}"
                           required="true"/>
              <h:inputText value="#{tmpCustomer.name.lastName}"
                           required="true"/>
            </td>
           </tr>
           <tr bgcolor="#aaeecc">
             <td align="left">
               <h:outputText value="メールアドレス"/>
             </td>
             <td align="left">
               <h:inputText value="#{tmpCustomer.email}"/>
             </td>
           </tr>
           <tr bgcolor="#aaeecc">
             <td align="right">
               <h:outputText value="電話番号"/>
             </td>
             <td>
               <h:inputText value="#{tmpCustomer.phone}"/>
             </td>
           </tr>
         </table>
         <table cellspacing="4">
           <tr>
             <td align="left">
               <h:commandButton action="back" immediate="true"
                                value="戻る"/>
             </td>
             <td align="right">
               <h:commandButton action="#{detailsForm.confirm}" value="次へ"/>
             </td>
          </tr>
       </table>
       <h:messages/>
      </h:form>
    </body>
  </f:view>
</html>
