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
package org.wso2.carbon.user.core.ldap;


import org.wso2.carbon.user.api.Property;
import org.wso2.carbon.user.core.UserStoreConfigConstants;

import java.util.ArrayList;

public class ReadWriteLDAPUserStoreConstants {


    //Properties for Read Write LDAP User Store Manager
    public static final ArrayList<Property> RWLDAP_USERSTORE_PROPERTIES = new ArrayList<Property>();
    public static final ArrayList<Property> OPTINAL_RWLDAP_USERSTORE_PROPERTIES = new ArrayList<Property>();

    //For multiple attribute separation
    private static final String MULTI_ATTRIBUTE_SEPARATOR = "MultiAttributeSeparator";
    private static final String MULTI_ATTRIBUTE_SEPARATOR_DESCRIPTION = "指定多个声明值的分隔符";
    private static final String DisplayNameAttributeDescription = "可作为显示名称的属性名称";
    private static final String DisplayNameAttribute = "DisplayNameAttribute";
    private static final String usernameJavaRegExViolationErrorMsg = "UsernameJavaRegExViolationErrorMsg";
    private static final String usernameJavaRegExViolationErrorMsgDescription = "用户名与UsernameJavaRegEx不匹配时的错误信息";

    private static final String passwordJavaRegEx = "PasswordJavaRegEx";
    private static final String passwordJavaRegExViolationErrorMsg = "PasswordJavaRegExViolationErrorMsg";
    private static final String passwordJavaRegExViolationErrorMsgDescription = "密码与passwordJavaRegEx不匹配时的错误信息 " ;

    private static final String passwordJavaRegExDescription = "在后端定义密码格式的策略";
    private static final String roleDNPattern = "RoleDNPattern";
    private static final String roleDNPatternDescription = "角色DN的模式。可以定义它来改进LDAP搜索";



    static {

        setMandatoryProperty(UserStoreConfigConstants.connectionURL, "连接 URL", "ldap://",
                UserStoreConfigConstants.connectionURLDescription, false);
        setMandatoryProperty(UserStoreConfigConstants.connectionName, "连接名称", "uid=," +
                "ou=", UserStoreConfigConstants.connectionNameDescription, false);
        setMandatoryProperty(UserStoreConfigConstants.connectionPassword, "连接密码",
                "", UserStoreConfigConstants.connectionPasswordDescription, true);
        setMandatoryProperty(UserStoreConfigConstants.userSearchBase, "用户搜索库",
                "ou=Users,dc=wso2,dc=org", UserStoreConfigConstants.userSearchBaseDescription, false);
        setMandatoryProperty(UserStoreConfigConstants.userEntryObjectClass,
                "用户实体对象类", "wso2Person", UserStoreConfigConstants
                        .userEntryObjectClassDescription, false);
        setMandatoryProperty(UserStoreConfigConstants.userNameAttribute, "用户名属性",
                "uid", UserStoreConfigConstants.userNameAttributeDescription, false);

        setMandatoryProperty(UserStoreConfigConstants.usernameSearchFilter, "用户搜索过滤条件",
                "(&(objectClass=person)(uid=?))", UserStoreConfigConstants
                        .usernameSearchFilterDescription, false);
        setMandatoryProperty(UserStoreConfigConstants.usernameListFilter, "用户列表过滤条件",
                "(objectClass=person)", UserStoreConfigConstants.usernameListFilterDescription, false);

        setProperty(UserStoreConfigConstants.userDNPattern, "用户 DN 模式", "", UserStoreConfigConstants.userDNPatternDescription);
        setProperty(DisplayNameAttribute, "显示名属性", "", DisplayNameAttributeDescription);
        setProperty(UserStoreConfigConstants.disabled, "禁用", "false", UserStoreConfigConstants.disabledDescription);

        setProperty(UserStoreConfigConstants.readGroups, "允许读取群组", "true", UserStoreConfigConstants
                .readLDAPGroupsDescription);
        setProperty(UserStoreConfigConstants.writeGroups, "允许写群组", "true", UserStoreConfigConstants.writeGroupsDescription);
        setProperty(UserStoreConfigConstants.groupSearchBase, "群组搜索库", "ou=Groups,dc=gds,dc=com",
                UserStoreConfigConstants.groupSearchBaseDescription);
        setProperty(UserStoreConfigConstants.groupEntryObjectClass, "群组实体对象类", "groupOfNames",
                UserStoreConfigConstants.groupEntryObjectClassDescription);
        setProperty(UserStoreConfigConstants.groupNameAttribute, "群组名称属性", "cn",
                UserStoreConfigConstants.groupNameAttributeDescription);
        setProperty(UserStoreConfigConstants.groupNameSearchFilter, "群组搜索过滤条件", "(&(objectClass=groupOfNames)(cn=?))",
                UserStoreConfigConstants.groupNameSearchFilterDescription);
        setProperty(UserStoreConfigConstants.groupNameListFilter, "群组列表过滤条件", "(objectClass=groupOfNames)",
                UserStoreConfigConstants.groupNameListFilterDescription);
        setProperty(roleDNPattern, "角色 DN 模式", "", roleDNPatternDescription);

        setProperty(UserStoreConfigConstants.membershipAttribute, "成员关系属性", "member", UserStoreConfigConstants.membershipAttributeDescription);
        setProperty(UserStoreConfigConstants.memberOfAttribute, "成员属性", "", UserStoreConfigConstants.memberOfAttribute);
        setProperty("BackLinksEnabled", "启用属性引用", "false",
                "是否允许属性由其他对象对对象的引用产生");

        setProperty(UserStoreConfigConstants.usernameJavaRegEx, "用户名正则表达式 (Java)", "[a-zA-Z0-9._-|//]{3,30}$", UserStoreConfigConstants.usernameJavaRegExDescription);
        setProperty(UserStoreConfigConstants.usernameJavaScriptRegEx, "用户名正则表达式 (Javascript)", "^[\\S]{3,30}$", UserStoreConfigConstants.usernameJavaRegExDescription);
        setProperty(usernameJavaRegExViolationErrorMsg, "用户名正则表达式冲突错误消息",
                "用户名正则表达式策略冲突.", usernameJavaRegExViolationErrorMsgDescription);
        setProperty(passwordJavaRegEx, "密码正则表达式 (Java)", "^[\\S]{5,30}$", passwordJavaRegExDescription);
        setProperty(UserStoreConfigConstants.passwordJavaScriptRegEx, "密码正则表达式 (Javascript)", "^[\\S]{5,30}$",
                UserStoreConfigConstants.passwordJavaScriptRegExDescription);
        setProperty(passwordJavaRegExViolationErrorMsg, "密码正则表达式冲突错误消息",
                "密码正则表达式策略冲突.", passwordJavaRegExViolationErrorMsgDescription);
        setProperty(UserStoreConfigConstants.roleNameJavaRegEx, "角色名正则表达式 (Java)", "[a-zA-Z0-9._-|//]{3,30}$", UserStoreConfigConstants.roleNameJavaRegExDescription);
        setProperty(UserStoreConfigConstants.roleNameJavaScriptRegEx, "角色名正则表达式 (Javascript)", "^[\\S]{3,30}$", UserStoreConfigConstants.roleNameJavaScriptRegExDescription);
        setProperty("UniqueID", "", "", "");

    }

    private static void setMandatoryProperty(String name, String displayName, String value,
                                             String description, boolean encrypt) {
        String propertyDescription = displayName + "#" + description;
        if (encrypt) {
            propertyDescription += "#encrypt";
        }
        Property property = new Property(name, value, propertyDescription, null);
        RWLDAP_USERSTORE_PROPERTIES.add(property);

    }

    private static void setProperty(String name, String displayName, String value,
                                    String description) {
        Property property = new Property(name, value, displayName + "#" + description, null);
        OPTINAL_RWLDAP_USERSTORE_PROPERTIES.add(property);

    }

}
