<?xml version="1.0" encoding="Windows-31J"?>
<html xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:c="http://java.sun.com/jstl/core"
      xmlns:jsp="http://java.sun.com/JSP/Page">
  <jsp:directive.page contentType="text/html;charset=Windows-31J" 
                      pageEncoding="Windows-31J"/>
  <f:view>
    <head>
      <title>Customer List</title>
    </head>
    <body>
      <div style="position: relative">
        <jsp:directive.include file="header.jspf"/>
      </div>
      <center>
        <h:outputText style="font-size: 24px" value="顧客検索"/>
      </center>
      <h:form>
        <table>
          <tr>
            <td align="right">
              <h:outputText value="氏名"/>
            </td>
            <td align="left">
              <h:inputText value="#{criteria.customerName}"/>
            </td>
          </tr>
          <tr>
            <td align="right">
              <h:outputText value="部署名"/>
            </td>
            <td align="left">
              <h:inputText value="#{criteria.departmentName}"/>
            </td>
          </tr>
          <tr>
            <td algin="right">
              <h:outputText value="会社名"/>
            </td>
            <td align="left">
              <h:inputText value="#{criteria.companyName}"/>
            </td>
          </tr>
        </table>
        <table width="80%">
          <tr>
            <td align="left">
              <h:commandButton value="検索"
                               action="#{customerListBean.find}"/>
              <h:commandButton value="リセット"
                               actionListener="#{customerListBean.clear}"/>
            </td>
            <td align="right">
              <h:commandButton value="新規顧客" immediate="true"
                               action="#{customerListBean.create}"/>
            </td>
           </tr>
        </table>
        <h:dataTable border="1" 
                     value="#{customerListBean.customerModel}" 
                     var="c">
          <h:column>
            <h:commandButton value="詳細" immediate="true"
                             action="#{customerListBean.select}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="顧客"/>
            </f:facet>
            <h:outputText value="#{c.name.firstName} #{c.name.lastName}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="電話番号"/>
            </f:facet>
            <h:outputText value="#{c.phone}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="E-Mail"/>
            </f:facet>
            <h:outputText value="#{c.email}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="部署"/>
            </f:facet>
            <h:outputText value="#{c.department.name}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="会社"/>
            </f:facet>
            <h:outputText value="#{c.company.name}"/>
          </h:column>
          <h:column>
            <h:commandButton value="削除" immediate="true"
                             action="#{customerListBean.delete}"/>
          </h:column>
        </h:dataTable>
        <h:outputText value="検索時間： #{findStatistics.time} ms, "/>
        <h:outputText value="平均： #{findStatistics.averageTime} ms, "/>
        <h:outputText value="回数： #{findStatistics.count} 回"/>
      </h:form>
    </body>
  </f:view>
</html>
