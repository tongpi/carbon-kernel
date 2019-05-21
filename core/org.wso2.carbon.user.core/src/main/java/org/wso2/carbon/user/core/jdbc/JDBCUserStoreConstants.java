/*
 * Copyright 2005-2007 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.carbon.user.core.jdbc;


import org.wso2.carbon.user.api.Property;
import org.wso2.carbon.user.core.UserStoreConfigConstants;
import org.wso2.carbon.user.core.jdbc.caseinsensitive.JDBCCaseInsensitiveConstants;

import java.util.ArrayList;

public class JDBCUserStoreConstants {


    //Properties for Read Active Directory User Store Manager
    public static final ArrayList<Property> JDBC_UM_MANDATORY_PROPERTIES = new ArrayList<Property>();
    public static final ArrayList<Property> JDBC_UM_OPTIONAL_PROPERTIES = new ArrayList<Property>();
    public static final ArrayList<Property> JDBC_UM_ADVANCED_PROPERTIES = new ArrayList<Property>();
    private static final String usernameJavaRegExViolationErrorMsg = "UsernameJavaRegExViolationErrorMsg";
    private static final String usernameJavaRegExViolationErrorMsgDescription = "用户名与用户名正则表达式不匹配时的错误消息";

    private static final String passwordJavaRegExViolationErrorMsg = "PasswordJavaRegExViolationErrorMsg";
    private static final String passwordJavaRegExViolationErrorMsgDescription = "密码与密码正则表达式不匹配时的错误消息";

    private static final String MULTI_ATTRIBUTE_SEPARATOR = "MultiAttributeSeparator";
    private static final String MULTI_ATTRIBUTE_SEPARATOR_DESCRIPTION = "多个声明的分隔符";
    private static final String VALIDATION_INTERVAL = "validationInterval";

    static {

        //setMandatoryProperty
        setMandatoryProperty(JDBCRealmConstants.URL, "连接 URL", "",
                "用户存储数据库的连接URL", false);
        setMandatoryProperty(JDBCRealmConstants.USER_NAME, "连接名称", "",
                "数据库用户名", false);
        setMandatoryProperty(JDBCRealmConstants.PASSWORD, "连接密码", "",
                "数据库用户的密码", true);
        setMandatoryProperty(JDBCRealmConstants.DRIVER_NAME, "驱动名称", "",
                "驱动类全名", false);

        //set optional properties
        setProperty(UserStoreConfigConstants.disabled, "禁用", "false", UserStoreConfigConstants.disabledDescription);
        setProperty("ReadOnly", "只读", "false", "指示此领域的用户存储是否以用户只读模式运行");
        setProperty(UserStoreConfigConstants.readGroups, "读取群组", "true", UserStoreConfigConstants.readLDAPGroupsDescription);
        setProperty(UserStoreConfigConstants.writeGroups, "写入群组", "true", UserStoreConfigConstants.writeGroupsDescription);
        setProperty("UsernameJavaRegEx", "用户名正则表达式 (Java)", "^[\\S]{5,30}$", "用于验证用户名的正则表达式");
        setProperty("UsernameJavaScriptRegEx", "用户名正则表达式 (Javascript)", "^[\\S]{5,30}$", "前端组件用于用户名验证的正则表达式");

        setProperty(usernameJavaRegExViolationErrorMsg, "用户名正则表达式冲突错误消息",
                "用户名正则表达式冲突错误消息.", usernameJavaRegExViolationErrorMsgDescription);

        setProperty("PasswordJavaRegEx", "密码正则表达式 (Java)", "^[\\S]{5,30}$", "用于验证密码的正则表达式");
        setProperty("PasswordJavaScriptRegEx", "密码正则表达式 (Javascript)", "^[\\S]{5,30}$", "前端组件用于密码验证的正则表达式");

        setProperty(passwordJavaRegExViolationErrorMsg, "密码正则表达式冲突错误消息",
                "Password pattern policy violated.", passwordJavaRegExViolationErrorMsgDescription);
        setProperty("RolenameJavaRegEx", "角色名正则表达式 (Java)", "^[\\S]{5,30}$", "用于验证角色名称的正则表达式");
        setProperty("RolenameJavaScriptRegEx", "角色名正则表达式 (Javascript)", "^[\\S]{5,30}$", "前端组件用于角色名称验证的正则表达式");
        setProperty(JDBCCaseInsensitiveConstants.CASE_SENSITIVE_USERNAME, "用户名不区分大小写", "true",
                JDBCCaseInsensitiveConstants.CASE_SENSITIVE_USERNAME_DESCRIPTION);

        //set Advanced properties
        setAdvancedProperty(UserStoreConfigConstants.SCIMEnabled, "启用 SCIM", "false", UserStoreConfigConstants.SCIMEnabledDescription);
        setAdvancedProperty("IsBulkImportSupported", "支持批导入", "false", "支持用户批导入 " );
        setAdvancedProperty(JDBCRealmConstants.DIGEST_FUNCTION, "密码哈希算法", "SHA-256", UserStoreConfigConstants
                .passwordHashMethodDescription);
        setAdvancedProperty(MULTI_ATTRIBUTE_SEPARATOR, "多值分隔符", ",", MULTI_ATTRIBUTE_SEPARATOR_DESCRIPTION);

        setAdvancedProperty(JDBCRealmConstants.STORE_SALTED_PASSWORDS, "启用盐化密码", "true", "指示是否启用对密码加盐");

        setAdvancedProperty(UserStoreConfigConstants.maxUserNameListLength, "用户列表最大长度", "100", UserStoreConfigConstants
                .maxUserNameListLengthDescription);
        setAdvancedProperty(UserStoreConfigConstants.maxRoleNameListLength, "角色列表最大长度", "100", UserStoreConfigConstants
                .maxRoleNameListLengthDescription);

        setAdvancedProperty(UserStoreConfigConstants.userRolesCacheEnabled, "启用用户角色缓存", "true", UserStoreConfigConstants
                .userRolesCacheEnabledDescription);

        setAdvancedProperty("UserNameUniqueAcrossTenants", "确保用户名跨租户唯一", "false", "用于多租户的属性");


        setAdvancedProperty(JDBCRealmConstants.VALIDATION_QUERY, "数据库校验查询", "",
                "validationQuery是用于验证连接的SQL查询. 该查询必须是一个 " +
                        "返回至少一行的SQL SELECT语句");
        setAdvancedProperty(VALIDATION_INTERVAL, "验证间隔(毫秒)", "", "用于避免过度验证，最多只能在此频率运行验证");

        setAdvancedProperty("CountRetrieverClass", "计数实现",
                "org.wso2.carbon.identity.user.store.count.jdbc.JDBCUserStoreCountRetriever",
                "实现计数功能的类的名称");

        //Advanced Properties (No descriptions added for each property)
        setAdvancedProperty(JDBCRealmConstants.SELECT_USER, "查询用户的 SQL", JDBCRealmConstants.SELECT_USER_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.SELECT_USER_CASE_INSENSITIVE, "不区分大小写用户名的查询用户 SQL ", JDBCCaseInsensitiveConstants.SELECT_USER_SQL_CASE_INSENSITIVE, "");

        setAdvancedProperty("GetRoleListSQL", "查询角色列表的 SQL", "SELECT UM_ROLE_NAME, UM_TENANT_ID, UM_SHARED_ROLE FROM UM_ROLE WHERE " +
                "UM_ROLE_NAME LIKE ? AND UM_TENANT_ID=? AND UM_SHARED_ROLE ='0' ORDER BY UM_ROLE_NAME", "");
        setAdvancedProperty(JDBCRealmConstants.GET_SHARED_ROLE_LIST, "查询共享角色列表的 SQL", JDBCRealmConstants.GET_SHARED_ROLE_LIST_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.GET_USER_FILTER, "用户筛选SQL", JDBCRealmConstants.GET_USER_FILTER_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.GET_USER_FILTER_CASE_INSENSITIVE, "不区分大小写用户名的用户筛选SQL ", JDBCCaseInsensitiveConstants.GET_USER_FILTER_SQL_CASE_INSENSITIVE,
                "");
        setAdvancedProperty(JDBCRealmConstants.GET_USER_ROLE, "查询用户角色的 SQL", JDBCRealmConstants.GET_USER_ROLE_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.GET_USER_ROLE_CASE_INSENSITIVE, "不区分大小写用户名的用户角色查询 SQL", JDBCCaseInsensitiveConstants.GET_USER_ROLE_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCRealmConstants.GET_SHARED_ROLES_FOR_USER, "查询共享角色的 SQL", JDBCRealmConstants.GET_SHARED_ROLES_FOR_USER_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.GET_SHARED_ROLES_FOR_USER_CASE_INSENSITIVE, "不区分大小写用户名的" +
                "查询共享角色的 SQL", JDBCCaseInsensitiveConstants
                .GET_SHARED_ROLES_FOR_USER_SQL_CASE_INSENSITIVE, "");


        setAdvancedProperty(JDBCRealmConstants.GET_IS_ROLE_EXISTING, "判断角色存在的 SQL", JDBCRealmConstants.GET_IS_ROLE_EXISTING_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.GET_USERS_IN_ROLE, "查询角色的用户列表的 SQL", JDBCRealmConstants.GET_USERS_IN_ROLE_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.GET_USERS_IN_SHARED_ROLE, "查询共享角色的用户列表的 SQL", JDBCRealmConstants.GET_USERS_IN_SHARED_ROLE_SQL, "");

        setAdvancedProperty(JDBCRealmConstants.GET_IS_USER_EXISTING, "判断用户存在的 SQL", JDBCRealmConstants.GET_IS_USER_EXISTING_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.GET_IS_USER_EXISTING_CASE_INSENSITIVE, "不区分大小写用户名的判断用户存在的 SQL", JDBCCaseInsensitiveConstants
                .GET_IS_USER_EXISTING_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCRealmConstants.GET_PROPS_FOR_PROFILE, "获取个人资料用户属性的 SQL", JDBCRealmConstants.GET_PROPS_FOR_PROFILE_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.GET_PROPS_FOR_PROFILE_CASE_INSENSITIVE, "不区分大小写用户名的" +
                "获取个人资料用户属性的 SQL", JDBCCaseInsensitiveConstants
                .GET_PROPS_FOR_PROFILE_SQL_CASE_INSENSITIVE, "");
        // setAdvancedProperty(JDBCRealmConstants.GET_PROP_FOR_PROFILE, "获取个人资料用户属性的 SQL", JDBCRealmConstants.GET_PROP_FOR_PROFILE_SQL, "");
        // setAdvancedProperty(JDBCCaseInsensitiveConstants.GET_PROP_FOR_PROFILE_CASE_INSENSITIVE, "Get User " +
        //         "Property for Profile SQL With Case Insensitive Username", JDBCCaseInsensitiveConstants
        //         .GET_PROP_FOR_PROFILE_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCRealmConstants.GET_USERS_FOR_PROP, "获取用户列表属性的 SQL", JDBCRealmConstants.GET_USERS_FOR_PROP_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.GET_PROFILE_NAMES, "得到个人资料名称的 SQL", JDBCRealmConstants.GET_PROFILE_NAMES_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.GET_PROFILE_NAMES_FOR_USER, "得到用户个人资料名称的 SQL", JDBCRealmConstants.GET_PROFILE_NAMES_FOR_USER_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.GET_PROFILE_NAMES_FOR_USER_CASE_INSENSITIVE, "不区分大小写用户名的得到用户个人资料名称的 SQL", JDBCCaseInsensitiveConstants
                .GET_PROFILE_NAMES_FOR_USER_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCRealmConstants.GET_USERID_FROM_USERNAME, "根据用户名称得到用户ID的 SQL", JDBCRealmConstants.GET_USERID_FROM_USERNAME_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.GET_USERID_FROM_USERNAME_CASE_INSENSITIVE, "不区分大小写用户名的根据用户名称得到用户ID的 SQL", JDBCCaseInsensitiveConstants
                .GET_USERID_FROM_USERNAME_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCRealmConstants.GET_USERNAME_FROM_TENANT_ID, "根据租户ID得到用户名的 SQL", JDBCRealmConstants.GET_USERNAME_FROM_TENANT_ID_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.GET_TENANT_ID_FROM_USERNAME, "根据用户名得到租户ID的 SQL", JDBCRealmConstants.GET_TENANT_ID_FROM_USERNAME_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.GET_TENANT_ID_FROM_USERNAME_CASE_INSENSITIVE, "不区分大小写用户名的根据用户名得到租户ID的 SQL", JDBCCaseInsensitiveConstants
                .GET_TENANT_ID_FROM_USERNAME_SQL_CASE_INSENSITIVE, "");

        setAdvancedProperty(JDBCRealmConstants.ADD_USER, "添加用户的 SQL", JDBCRealmConstants.ADD_USER_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.ADD_USER_TO_ROLE, "添加用户到角色的 SQL", JDBCRealmConstants.ADD_USER_TO_ROLE_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.ADD_USER_TO_ROLE_CASE_INSENSITIVE, "不区分大小写用户名的添加用户到角色的 SQL", JDBCCaseInsensitiveConstants
                .ADD_USER_TO_ROLE_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCRealmConstants.ADD_ROLE, "添加角色的 SQL", JDBCRealmConstants.ADD_ROLE_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.ADD_SHARED_ROLE, "添加共享角色的 SQL", JDBCRealmConstants.ADD_SHARED_ROLE_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.ADD_ROLE_TO_USER, "添加角色到用户的 SQL", JDBCRealmConstants.ADD_ROLE_TO_USER_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.ADD_SHARED_ROLE_TO_USER, "添加共享角色到用户的 SQL",
                JDBCRealmConstants.ADD_SHARED_ROLE_TO_USER_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.ADD_SHARED_ROLE_TO_USER_CASE_INSENSITIVE, "不区分大小写用户名的添加共享角色到用户的 SQL", JDBCCaseInsensitiveConstants
                .ADD_SHARED_ROLE_TO_USER_SQL_CASE_INSENSITIVE, "");

        setAdvancedProperty(JDBCRealmConstants.REMOVE_USER_FROM_SHARED_ROLE, "移除共享角色的用户的 SQL", JDBCRealmConstants.REMOVE_USER_FROM_SHARED_ROLE_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.REMOVE_USER_FROM_ROLE_CASE_INSENSITIVE, "不区分大小写用户名的" +
                "从角色移除用户的 SQL", JDBCCaseInsensitiveConstants
                .REMOVE_USER_FROM_ROLE_SQL_CASE_INSENSITIVE, "");

        setAdvancedProperty(JDBCRealmConstants.REMOVE_USER_FROM_ROLE, "从角色移除用户的 SQL", JDBCRealmConstants.REMOVE_USER_FROM_ROLE_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.REMOVE_USER_FROM_ROLE_CASE_INSENSITIVE, "不区分大小写用户名的" +
                "从角色移除用户的 SQL", JDBCCaseInsensitiveConstants
                .REMOVE_USER_FROM_ROLE_SQL_CASE_INSENSITIVE, "");

        setAdvancedProperty(JDBCRealmConstants.REMOVE_ROLE_FROM_USER, "移除用户的角色的 SQL", JDBCRealmConstants.REMOVE_ROLE_FROM_USER_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.REMOVE_ROLE_FROM_USER_CASE_INSENSITIVE, "不区分大小写用户名的" +
                "移除用户的角色的 SQL", JDBCCaseInsensitiveConstants
                .REMOVE_ROLE_FROM_USER_SQL_CASE_INSENSITIVE, "");

        setAdvancedProperty(JDBCRealmConstants.DELETE_ROLE, "删除角色的 SQL", JDBCRealmConstants.DELETE_ROLE_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.ON_DELETE_ROLE_REMOVE_USER_ROLE, "删除角色并删除用户角色映射的 SQL", JDBCRealmConstants.ON_DELETE_ROLE_REMOVE_USER_ROLE_SQL, "");
        setAdvancedProperty("DeleteUserSQL", "删除用户的 SQL", "DELETE FROM UM_USER WHERE UM_USER_NAME = ? AND UM_TENANT_ID=?", "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.DELETE_USER_CASE_INSENSITIVE, "不区分大小写用户名的" +
                "删除用户的 SQL", JDBCCaseInsensitiveConstants.DELETE_USER_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCRealmConstants.ON_DELETE_USER_REMOVE_USER_ROLE, "删除用户并删除用户角色映射的 SQL", JDBCRealmConstants.ON_DELETE_USER_REMOVE_USER_ROLE_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.ON_DELETE_USER_REMOVE_ATTRIBUTE, "删除用户并删除用户属性的 SQL", JDBCRealmConstants.ON_DELETE_USER_REMOVE_ATTRIBUTE_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.ON_DELETE_USER_REMOVE_ATTRIBUTE_CASE_INSENSITIVE, "不区分大小写用户名的" +
                        "删除用户并删除用户属性的 SQL",
                JDBCCaseInsensitiveConstants.ON_DELETE_USER_REMOVE_ATTRIBUTE_SQL_CASE_INSENSITIVE, "");

        setAdvancedProperty(JDBCRealmConstants.UPDATE_USER_PASSWORD, "修改用户密码的 SQL", JDBCRealmConstants.UPDATE_USER_PASSWORD_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.UPDATE_USER_PASSWORD_CASE_INSENSITIVE, "不区分大小写用户名的" +
                "修改用户密码的 SQL", JDBCCaseInsensitiveConstants
                .UPDATE_USER_PASSWORD_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCRealmConstants.UPDATE_ROLE_NAME, "修改角色名称的 SQL", JDBCRealmConstants.UPDATE_ROLE_NAME_SQL, "");

        setAdvancedProperty(JDBCRealmConstants.ADD_USER_PROPERTY, "添加用户属性的 SQL", JDBCRealmConstants.ADD_USER_PROPERTY_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.UPDATE_USER_PROPERTY, "修改用户属性的 SQL", JDBCRealmConstants.UPDATE_USER_PROPERTY_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.UPDATE_USER_PROPERTY_CASE_INSENSITIVE, "不区分大小写用户名的" +
                "修改用户属性的 SQL", JDBCCaseInsensitiveConstants
                .UPDATE_USER_PROPERTY_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCRealmConstants.DELETE_USER_PROPERTY, "删除用户属性的 SQL", JDBCRealmConstants.UPDATE_USER_PROPERTY_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.DELETE_USER_PROPERTY_CASE_INSENSITIVE, "不区分大小写用户名的" +
                "删除用户属性的 SQL", JDBCCaseInsensitiveConstants
                .DELETE_USER_PROPERTY_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCRealmConstants.USER_NAME_UNIQUE, "用户名跨租户唯一的 SQL", JDBCRealmConstants.USER_NAME_UNIQUE_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.USER_NAME_UNIQUE_CASE_INSENSITIVE, "不区分大小写用户名的" +
                "用户名跨租户唯一的 SQL", JDBCCaseInsensitiveConstants
                .USER_NAME_UNIQUE_SQL_CASE_INSENSITIVE, "");

        setAdvancedProperty(JDBCRealmConstants.IS_DOMAIN_EXISTING, "判断Domain存在的 SQL", JDBCRealmConstants.IS_DOMAIN_EXISTING_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.ADD_DOMAIN, "添加 Domain SQL", JDBCRealmConstants.ADD_DOMAIN_SQL, "");

        // mssql
        setAdvancedProperty(JDBCRealmConstants.ADD_USER_TO_ROLE_MSSQL, "添加用户到角色的 SQL (MSSQL)", JDBCRealmConstants.ADD_USER_TO_ROLE_MSSQL_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.ADD_ROLE_TO_USER_MSSQL, "添加角色到用户的 SQL (MSSQL)", JDBCRealmConstants.ADD_ROLE_TO_USER_MSSQL_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.ADD_USER_PROPERTY_MSSQL, "添加用户属性的 SQL (MSSQL)", JDBCRealmConstants.ADD_USER_PROPERTY_MSSQL_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.ADD_USER_TO_ROLE_CASE_INSENSITIVE_MSSQL, "不区分大小写用户名的" +
                "添加用户到角色的 SQL (MSSQL)", JDBCCaseInsensitiveConstants
                .ADD_USER_TO_ROLE_MSSQL_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.ADD_ROLE_TO_USER_CASE_INSENSITIVE_MSSQL, "不区分大小写用户名的" +
                "添加角色到用户的 (MSSQL)", JDBCCaseInsensitiveConstants
                .ADD_ROLE_TO_USER_MSSQL_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.ADD_USER_PROPERTY_CASE_INSENSITIVE_MSSQL, "不区分大小写用户名的" +
                "添加用户属性的 SQL (MSSQL)", JDBCCaseInsensitiveConstants
                .ADD_USER_PROPERTY_MSSQL_SQL_CASE_INSENSITIVE, "");

        //openedge
        setAdvancedProperty(JDBCRealmConstants.ADD_USER_TO_ROLE_OPENEDGE, "添加用户到角色的 SQL (OpenEdge)", JDBCRealmConstants.ADD_USER_TO_ROLE_OPENEDGE_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.ADD_ROLE_TO_USER_OPENEDGE, "添加角色到用户的 SQL (OpenEdge)", JDBCRealmConstants.ADD_ROLE_TO_USER_OPENEDGE_SQL, "");
        setAdvancedProperty(JDBCRealmConstants.ADD_USER_PROPERTY_OPENEDGE, "添加用户属性的 (OpenEdge)", JDBCRealmConstants.ADD_USER_PROPERTY_OPENEDGE_SQL, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.ADD_USER_TO_ROLE_CASE_INSENSITIVE_OPENEDGE, "不区分大小写用户名的" +
                "添加用户到角色的 SQL (OpenEdge)", JDBCCaseInsensitiveConstants
                .ADD_USER_TO_ROLE_OPENEDGE_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.ADD_ROLE_TO_USER_CASE_INSENSITIVE_OPENEDGE, "不区分大小写用户名的" +
                "添加角色到用户的 SQL (OpenEdge)", JDBCCaseInsensitiveConstants
                .ADD_ROLE_TO_USER_OPENEDGE_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(JDBCCaseInsensitiveConstants.ADD_USER_PROPERTY_CASE_INSENSITIVE_OPENEDGE, "不区分大小写用户名的" +
                "添加用户属性的 (OpenEdge)", JDBCCaseInsensitiveConstants
                .ADD_USER_PROPERTY_OPENEDGE_SQL_CASE_INSENSITIVE, "");
        setAdvancedProperty(UserStoreConfigConstants.claimOperationsSupported, UserStoreConfigConstants.getClaimOperationsSupportedDisplayName, "true",
                UserStoreConfigConstants.claimOperationsSupportedDescription);
        setProperty("UniqueID", "", "", "");
    }


    private static void setProperty(String name, String displayName, String value,
                                    String description) {
        Property property = new Property(name, value, displayName + "#" + description, null);
        JDBC_UM_OPTIONAL_PROPERTIES.add(property);

    }

    private static void setMandatoryProperty(String name, String displayName, String value,
                                             String description, boolean encrypt) {
        String propertyDescription = displayName + "#" + description;
        if (encrypt) {
            propertyDescription += "#encrypt";
        }
        Property property = new Property(name, value, propertyDescription, null);
        JDBC_UM_MANDATORY_PROPERTIES.add(property);

    }

    private static void setAdvancedProperty(String name, String displayName, String value,
                                            String description) {
        Property property = new Property(name, value, displayName + "#" + description, null);
        JDBC_UM_ADVANCED_PROPERTIES.add(property);

    }


}
