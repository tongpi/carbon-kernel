<%--
 Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 WSO2 Inc. licenses this file to you under the Apache License,
 Version 2.0 (the "License"); you may not use this file except
 in compliance with the License.
 You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 --%>

<%@page import="org.wso2.carbon.utils.CarbonUtils"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="org.wso2.carbon.CarbonConstants" %>
<%@ page import="org.wso2.carbon.ui.util.CharacterEncoder"%>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../dialog/display_messages.jsp"/>

<%
    String userForumURL =
            (String) config.getServletContext().getAttribute(CarbonConstants.PRODUCT_XML_WSO2CARBON +
                    CarbonConstants.PRODUCT_XML_USERFORUM);
    String userGuideURL =
            (String) config.getServletContext().getAttribute(CarbonConstants.PRODUCT_XML_WSO2CARBON +
                    CarbonConstants.PRODUCT_XML_USERGUIDE);
    String mailinglistURL =
            (String) config.getServletContext().getAttribute(CarbonConstants.PRODUCT_XML_WSO2CARBON +
                    CarbonConstants.PRODUCT_XML_MAILINGLIST);
    String issuetrackerURL =
            (String) config.getServletContext().getAttribute(CarbonConstants.PRODUCT_XML_WSO2CARBON +
                    CarbonConstants.PRODUCT_XML_ISSUETRACKER);
    if(userForumURL == null){
        userForumURL = "#";
    }
    if(userGuideURL == null){
        userGuideURL = "#";
    }
    if(mailinglistURL == null){
        mailinglistURL = "#";
    }
    if(issuetrackerURL == null){
        issuetrackerURL = "#";
    }

    if (CharacterEncoder.getSafeText(request.getParameter("skipLoginPage"))!=null){
        response.sendRedirect("../admin/login_action.jsp");
        return;
    }

%>

<fmt:bundle basename="org.wso2.carbon.i18n.Resources">

    <script type="text/javascript">

        function doValidation() {
            var reason = "";

            var userNameEmpty = isEmpty("username");
            var passwordEmpty = isEmpty("password");

            if (userNameEmpty || passwordEmpty) {
                CARBON.showWarningDialog('<fmt:message key="empty.credentials"/>');
                document.getElementById('txtUserName').focus();
                return false;
            }

            return true;
        }

    </script>

    <%
        String loginStatus = CharacterEncoder.getSafeText(request.getParameter("loginStatus"));
        String errorCode = CharacterEncoder.getSafeText(request.getParameter("errorCode"));

        if (loginStatus != null && "false".equalsIgnoreCase(loginStatus)) {
            if (errorCode == null) {
                errorCode = "login.fail.message";
            }
    %>

    <script type="text/javascript">
        jQuery(document).ready(function() {
            CARBON.showWarningDialog('<fmt:message key="<%=errorCode%>"/>');
        });
    </script>
    <%
        }

        if (loginStatus != null && "failed".equalsIgnoreCase(loginStatus)) {
            if (errorCode == null) {
                errorCode = "login.fail.message1";
            }
    %>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            CARBON.showWarningDialog('<fmt:message key="<%=errorCode%>"/>');
        });
    </script>
    <%
        }
        String backendURL = CharacterEncoder.getSafeText(CarbonUIUtil.getServerURL(config.getServletContext(), session));
    %>
    <script type="text/javascript">
        function getSafeText(text){
            text = text.replace(/</g,'&lt;');
            return text.replace(/>/g,'&gt');
        }

        function checkInputs(){
            var loginForm = document.getElementById('loginForm');
            var backendUrl = document.getElementById("txtbackendURL");
            var username = document.getElementById("txtUserName");

            backendUrl.value = getSafeText(backendUrl.value);
            username.value = getSafeText(username.value);
            loginForm.submit();
        }
    </script>
    <div id="middle" class="login-form-wrapper" >
    <div class="row">
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 login">
        <div class="data-leftbox"></div>
        <div class="data-container">
            <form action='../admin/login_action.jsp' class= "form-horizontal" method="POST" onsubmit="return doValidation();" target="_self" onsubmit="checkInputs()">
                <div class="login_top">
                    <span class="login_logo" style="float: left"></span>
                    登录到您的帐户
                </div>
                <div class="alert alert-danger" role="alert" id="loginErrorMsg" style="display:none">
                </div>
                <div class="login_bottom">
                    <%if(!CarbonUtils.isRunningOnLocalTransportMode()) { %>
                    <div class="form-group">
                        <div class="input-group input-wrap">
                            <input type="text" class="form-control" id="txtbackendURL" name="backendURL" autofocus="autofocus" placeholder="<fmt:message key='backendURL'/>" value="<%=backendURL%>" autocomplete="off">
                        </div>
                    </div>
                    <% } %>
                    <div class="form-group">
                        <div class="input-group input-wrap">
                            <input type="text" id="txtUserName" name="username"
                                   class="form-control" tabindex="1"  autocomplete="off"
                                   placeholder="<fmt:message key='username'/>" />
                            <input type="hidden" name="rememberMe" value="" tabindex="3"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group input-wrap">
                            <input type="password" id="txtPassword" name="password"
                                   class="form-control" tabindex="2"  autocomplete="off"
                                   placeholder="<fmt:message key='password'/>" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group input-wrap">
                            <input type="hidden" id="tenant" value="null">
                            <button type="submit" class="btn btn-default btn-primary add-margin-right-2x" >登录</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

    </div>
    <script type="text/javascript">
        function init(loginStatus) {
            // intialize the code and call to the back end
            /*wso2.wsf.Util.initURLs();*/
            /*Initialize the XSLT cache*/
            /*wso2.wsf.XSLTHelper.init();*/

            if (loginStatus == 'true') {
            } else if (loginStatus == 'null') {
            } else if (loginStatus == 'false') {
                wso2.wsf.Util.alertWarning("Login failed. Please recheck the user name and password and try again")
            }
        }
        document.getElementById('txtUserName').focus();
    </script>

</fmt:bundle>
