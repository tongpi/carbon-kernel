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

public class ActiveDirectoryUserStoreConstants {


    //Properties for Read Active Directory User Store Manager
    public static final ArrayList<Property> ACTIVE_DIRECTORY_UM_PROPERTIES = new ArrayList<Property>();
    public static final ArrayList<Property> OPTIONAL_ACTIVE_DIRECTORY_UM_PROPERTIES = new ArrayList<Property>();

    //For multiple attribute separation
    private static final String DisplayNameAttributeDescription = "要作为显示名称的属性名称";
    private static final String DisplayNameAttribute = "DisplayNameAttribute";
    private static final String usernameJavaRegExViolationErrorMsg = "UsernameJavaRegExViolationErrorMsg";
    private static final String usernameJavaRegExViolationErrorMsgDescription = "用户名与用户名正则表达式不匹配时的错误消息";
    private static final String passwordJavaRegEx = "PasswordJavaRegEx";
    private static final String passwordJavaRegExViolationErrorMsg = "PasswordJavaRegExViolationErrorMsg";
    private static final String passwordJavaRegExViolationErrorMsgDescription = "密码与密码正则表达式不匹配时的错误消息";
    private static final String passwordJavaRegExDescription = "在后端定义密码格式的策略";
    private static final String roleDNPattern = "RoleDNPattern";
    private static final String roleDNPatternDescription = "角色DN的模式。可以定义它来改进LDAP搜索";

    public static final String TRANSFORM_OBJECTGUID_TO_UUID = "transformObjectGUIDToUUID";
    public static final String TRANSFORM_OBJECTGUID_TO_UUID_DESC = "以UUID规范格式返回objectGUID";

    static {
        //Set mandatory properties
        setMandatoryProperty(UserStoreConfigConstants.connectionURL, "连接 URL",
                "ldaps://", UserStoreConfigConstants.connectionURLDescription, false);

        setMandatoryProperty(UserStoreConfigConstants.connectionName, "连接名称", "CN=," +
                "DC=", UserStoreConfigConstants.connectionNameDescription, false);

        setMandatoryProperty(UserStoreConfigConstants.connectionPassword, "连接密码",
                "", UserStoreConfigConstants.connectionPasswordDescription, true);

        setMandatoryProperty(UserStoreConfigConstants.userSearchBase, "用户搜索库",
                "CN=Users,DC=WSO2,DC=Com", UserStoreConfigConstants.userSearchBaseDescription, false);

        setMandatoryProperty(UserStoreConfigConstants.userEntryObjectClass, "用户实体对象类", "user",
                UserStoreConfigConstants.userEntryObjectClassDescription, false);

        setMandatoryProperty(UserStoreConfigConstants.userNameAttribute, "用户名属性",
                "cn", UserStoreConfigConstants.userNameAttributeDescription, false);

        setMandatoryProperty(UserStoreConfigConstants.usernameSearchFilter, "用户搜索过滤条件",
                "(&(objectClass=user)(cn=?))", UserStoreConfigConstants
                        .usernameSearchFilterDescription, false);

        setMandatoryProperty(UserStoreConfigConstants.usernameListFilter, "用户列表过滤条件",
                "(objectClass=person)", UserStoreConfigConstants.usernameListFilterDescription, false);


        //Set optional properties

        setProperty(UserStoreConfigConstants.userDNPattern, "用户 DN 模式", "",
                UserStoreConfigConstants.userDNPatternDescription);
        setProperty(DisplayNameAttribute, "显示名属性", "", DisplayNameAttributeDescription);

        setProperty(UserStoreConfigConstants.disabled, "禁用", "false", UserStoreConfigConstants.disabledDescription);

        Property readLDAPGroups = new Property(UserStoreConfigConstants.readGroups, "true", "读取群组#" + UserStoreConfigConstants.readLDAPGroupsDescription, null);
        //Mandatory only if readGroups is enabled
        Property groupSearchBase = new Property(UserStoreConfigConstants.groupSearchBase, "CN=Users,DC=gds,DC=Com",
                "群组搜索库#" + UserStoreConfigConstants.groupSearchBaseDescription, null);
        Property groupNameListFilter = new Property(UserStoreConfigConstants.groupNameListFilter, "(objectcategory=group)",
                "群组刷选器#" + UserStoreConfigConstants.groupNameListFilterDescription, null);
        Property groupNameAttribute = new Property(UserStoreConfigConstants.groupNameAttribute, "cn", "群组名称属性#"
                + UserStoreConfigConstants.groupNameAttributeDescription, null);
        Property membershipAttribute = new Property(UserStoreConfigConstants.membershipAttribute, "member",
                "成员属性#" + UserStoreConfigConstants.membershipAttributeDescription, null);
        Property groupNameSearchFilter = new Property(UserStoreConfigConstants.groupNameSearchFilter,
                "(&(objectClass=group)(cn=?))", "群组搜索刷选器#" + UserStoreConfigConstants
                .groupNameSearchFilterDescription, null);
        readLDAPGroups.setChildProperties(new Property[]{groupSearchBase, groupNameAttribute, groupNameListFilter,
                membershipAttribute, groupNameSearchFilter});
        OPTIONAL_ACTIVE_DIRECTORY_UM_PROPERTIES.add(readLDAPGroups);

        setProperty(UserStoreConfigConstants.writeGroups, "写群组", "true", UserStoreConfigConstants.writeGroupsDescription);
        setProperty(UserStoreConfigConstants.groupSearchBase, "群组搜索库", "CN=Users,DC=WSO2,DC=Com",
                UserStoreConfigConstants.groupSearchBaseDescription);

        setProperty(UserStoreConfigConstants.groupEntryObjectClass, "群组实体对象类", "group",
                UserStoreConfigConstants.groupEntryObjectClassDescription);
        setProperty(UserStoreConfigConstants.groupNameAttribute, "群组名属性", "cn",
                UserStoreConfigConstants.groupNameAttributeDescription);
        setProperty(UserStoreConfigConstants.groupNameSearchFilter, "群组搜索过滤条件", "(&(objectClass=group)(cn=?))",
                UserStoreConfigConstants.groupNameSearchFilterDescription);
        setProperty(UserStoreConfigConstants.groupNameListFilter, "群组列表过滤条件", "(objectcategory=group)",
                UserStoreConfigConstants.groupNameListFilterDescription);

        setProperty(roleDNPattern, "角色DN模式", "", roleDNPatternDescription);

        setProperty(UserStoreConfigConstants.membershipAttribute, "成员关系属性", "member",
                UserStoreConfigConstants.membershipAttributeDescription);
        setProperty(UserStoreConfigConstants.memberOfAttribute, "成员属性", "memberOf",
                UserStoreConfigConstants.memberOfAttribute);
        setProperty("BackLinksEnabled", "启用属性引用", "true", " 是否允许属性由其他对象对象的引用产生");
        setProperty("Referral", "转介", "follow", "将请求引导到正确域中的域控制器");

        setProperty(UserStoreConfigConstants.usernameJavaRegEx, "用户名正则表达式 (Java)", "[a-zA-Z0-9._-|//]{3,30}$",
                UserStoreConfigConstants.usernameJavaRegExDescription);
        setProperty(UserStoreConfigConstants.usernameJavaScriptRegEx, "用户名正则表达式  (Javascript)", "^[\\S]{3,30}$",
                UserStoreConfigConstants.usernameJavaScriptRegExDescription);

        setProperty(usernameJavaRegExViolationErrorMsg, "用户名正则表达式冲突错误消息",
                "用户名正则表达式冲突错误消息.", usernameJavaRegExViolationErrorMsgDescription);

        setProperty(passwordJavaRegEx, "密码正则表达式 (Java)", "^[\\S]{5,30}$", passwordJavaRegExDescription);
        setProperty(UserStoreConfigConstants.passwordJavaScriptRegEx, "密码正则表达式 (Javascript)", "^[\\S]{5,30}$",
                UserStoreConfigConstants.passwordJavaScriptRegExDescription);

        setProperty(passwordJavaRegExViolationErrorMsg, "密码正则表达式冲突错误消息",
                "密码正则表达式冲突错误消息.", passwordJavaRegExViolationErrorMsgDescription);

        setProperty(UserStoreConfigConstants.roleNameJavaRegEx, "角色名正则表达式 (Java)", "[a-zA-Z0-9._-|//]{3,30}$",
                UserStoreConfigConstants.roleNameJavaRegExDescription);

        setProperty(UserStoreConfigConstants.roleNameJavaScriptRegEx, "角色名称正则表达式 (Javascript)", "^[\\S]{3,30}$",
                UserStoreConfigConstants.roleNameJavaScriptRegExDescription);
        setProperty("UniqueID", "", "", "");


    }

    private static void setMandatoryProperty(String name, String displayName, String value,
                                             String description, boolean encrypt) {
        String propertyDescription = displayName + "#" + description;
        if (encrypt) {
            propertyDescription += "#encrypt";
        }
        Property property = new Property(name, value, propertyDescription, null);
        ACTIVE_DIRECTORY_UM_PROPERTIES.add(property);

    }

    private static void setProperty(String name, String displayName, String value,
                                    String description) {
        Property property = new Property(name, value, displayName + "#" + description, null);
        OPTIONAL_ACTIVE_DIRECTORY_UM_PROPERTIES.add(property);

    }


}
