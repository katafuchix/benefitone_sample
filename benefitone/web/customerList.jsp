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
        <h:outputText style="font-size: 24px" value="�ڋq����"/>
      </center>
      <h:form>
        <table>
          <tr>
            <td align="right">
              <h:outputText value="����"/>
            </td>
            <td align="left">
              <h:inputText value="#{criteria.customerName}"/>
            </td>
          </tr>
          <tr>
            <td align="right">
              <h:outputText value="������"/>
            </td>
            <td align="left">
              <h:inputText value="#{criteria.departmentName}"/>
            </td>
          </tr>
          <tr>
            <td algin="right">
              <h:outputText value="��Ж�"/>
            </td>
            <td align="left">
              <h:inputText value="#{criteria.companyName}"/>
            </td>
          </tr>
        </table>
        <table width="80%">
          <tr>
            <td align="left">
              <h:commandButton value="����"
                               action="#{customerListBean.find}"/>
              <h:commandButton value="���Z�b�g"
                               actionListener="#{customerListBean.clear}"/>
            </td>
            <td align="right">
              <h:commandButton value="�V�K�ڋq" immediate="true"
                               action="#{customerListBean.create}"/>
            </td>
           </tr>
        </table>
        <h:dataTable border="1" 
                     value="#{customerListBean.customerModel}" 
                     var="c">
          <h:column>
            <h:commandButton value="�ڍ�" immediate="true"
                             action="#{customerListBean.select}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="�ڋq"/>
            </f:facet>
            <h:outputText value="#{c.name.firstName} #{c.name.lastName}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="�d�b�ԍ�"/>
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
              <h:outputText value="����"/>
            </f:facet>
            <h:outputText value="#{c.department.name}"/>
          </h:column>
          <h:column>
            <f:facet name="header">
              <h:outputText value="���"/>
            </f:facet>
            <h:outputText value="#{c.company.name}"/>
          </h:column>
          <h:column>
            <h:commandButton value="�폜" immediate="true"
                             action="#{customerListBean.delete}"/>
          </h:column>
        </h:dataTable>
        <h:outputText value="�������ԁF #{findStatistics.time} ms, "/>
        <h:outputText value="���ρF #{findStatistics.averageTime} ms, "/>
        <h:outputText value="�񐔁F #{findStatistics.count} ��"/>
      </h:form>
    </body>
  </f:view>
</html>
