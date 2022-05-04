<?xml version="1.0" encoding="Windows-31J"?>
<html xmlns:f="http://java.sun.com/jsf/core" 
      xmlns:h="http://java.sun.com/jsf/html" 
      xmlns:jsp="http://java.sun.com/JSP/Page">
  <jsp:directive.page contentType="text/html;charset=Windows-31J" 
                      pageEncoding="Windows-31J"/>
  <f:view>
    <head>
      <title>Customer Details</title>
    </head>
    <body>
      <div>
        <jsp:directive.include file="header.jspf"/>
      </div>
      <center>
        <h:outputText style="font-size: 24px" value="顧客情報詳細"/>
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
              <h:outputText value="#{selectedCustomer.company.id}"/>
            </td>
          </tr>
          <tr bgcolor="#eeaacc">
            <td align="right">
              <h:outputText value="会社名"/>
            </td>
            <td>
              <h:outputText value="#{selectedCustomer.company.name}"/>
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
              <h:outputText value="#{selectedCustomer.department.id}"/>
            </td>
          </tr>
          <tr bgcolor="#cceeaa">
             <td align="right">
               <h:outputText value="部署名"/>
             </td>
             <td align="left">
               <h:outputText value="#{selectedCustomer.department.name}"/>
             </td>
           </tr>
           <tr bgcolor="#cceeaa">
             <td align="right">
               <h:outputText value="住所"/>
             </td>
             <td align="left">
               <h:outputText value="#{selectedCustomer.department.address}"/>
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
               <h:outputText value="#{selectedCustomer.id}"/>
             </td>
           </tr>
           <tr bgcolor="#aaeecc">
             <td align="right">
               <h:outputText value="氏名"/>
             </td>
             <td align="left">
               <h:outputText value="#{selectedCustomer.name.firstName}"/>
               <h:outputText value="#{selectedCustomer.name.lastName}"/>
             </td>
           </tr>
           <tr bgcolor="#aaeecc">
             <td align="left">
               <h:outputText value="メールアドレス"/>
             </td>
             <td align="left">
               <h:outputText value="#{selectedCustomer.email}"/>
             </td>
           </tr>
           <tr bgcolor="#aaeecc">
             <td align="right">
               <h:outputText value="電話番号"/>
             </td>
             <td>
               <h:outputText value="#{selectedCustomer.phone}"/>
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
              <h:commandButton action="#{customerDetailsBean.modify}" 
                               value="編集"
                               disabled="#{!customerDetailsBean.manager}"/>
            </td>
          </tr>
        </table>
      </h:form>
    </body>
  </f:view>
</html>
