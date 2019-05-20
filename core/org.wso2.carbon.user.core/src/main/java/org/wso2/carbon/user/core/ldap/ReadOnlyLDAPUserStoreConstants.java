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

public class ReadOnlyLDAPUserStoreConstants {


    //Properties for Read Write LDAP User Store Manager
    public static final ArrayList<Property> ROLDAP_USERSTORE_PROPERTIES = new ArrayList<Property>();
    public static final ArrayList<Property> OPTIONAL_ROLDAP_USERSTORE_PROPERTIES = new ArrayList<Property>();

    //For multiple attribute separation
    private static final String MULTI_ATTRIBUTE_SEPARATOR = "MultiAttributeSeparator";
    private static final String MULTI_ATTRIBUTE_SEPARATOR_DESCRIPTION = "指定多个声明值的分隔符";
    private static final String DisplayNameAttributeDescription = "可作为显示名称的属性名称";
    private static final String DisplayNameAttribute = "DisplayNameAttribute";
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
                "ou=system", UserStoreConfigConstants.userSearchBaseDescription, false);
        setMandatoryProperty(UserStoreConfigConstants.userNameAttribute, "用户名属性",
                "", UserStoreConfigConstants.userNameAttributeDescription, false);

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
        setProperty(UserStoreConfigConstants.groupSearchBase, "群组搜索库", "ou=Groups,dc=wso2,dc=org",
                UserStoreConfigConstants.groupSearchBaseDescription);
        setProperty(UserStoreConfigConstants.groupNameAttribute, "群组名称属性", "cn", UserStoreConfigConstants.groupNameAttributeDescription);
        setProperty(UserStoreConfigConstants.groupNameSearchFilter, "群组搜索过滤条件",
                "(&(objectClass=groupOfNames)(cn=?))", UserStoreConfigConstants.groupNameSearchFilterDescription);
        setProperty(UserStoreConfigConstants.groupNameListFilter, "群组列表过滤条件", "(objectClass=groupOfNames)",
                UserStoreConfigConstants.groupNameListFilterDescription);

        setProperty(roleDNPattern, "角色 DN 模式", "", roleDNPatternDescription);

        setProperty(UserStoreConfigConstants.membershipAttribute, "成员关系属性", "member", UserStoreConfigConstants.membershipAttributeDescription);
        setProperty(UserStoreConfigConstants.memberOfAttribute, "成员属性", "", UserStoreConfigConstants.memberOfAttribute);
        setProperty("BackLinksEnabled", "启用属性引用", "false", " W是否允许属性由其他对象对对象的引用产生");
        

        setProperty("Referral", "转介", "follow", "将请求引导到正确域中的域控制器");
        setProperty("ReplaceEscapeCharactersAtUserLogin", "在用户登录时启用转义字符", "true", "用户登录时是否替换转义符");
        setProperty("UniqueID", "", "", "");

    }

    private static void setMandatoryProperty(String name, String displayName, String value,
                                             String description, boolean encrypt) {
        String propertyDescription = displayName + "#" + description;
        if (encrypt) {
            propertyDescription += "#encrypt";
        }
        Property property = new Property(name, value, propertyDescription, null);
        ROLDAP_USERSTORE_PROPERTIES.add(property);

    }

    private static void setProperty(String name, String displayName, String value,
                                    String description) {
        Property property = new Property(name, value, displayName + "#" + description, null);
        OPTIONAL_ROLDAP_USERSTORE_PROPERTIES.add(property);

    }


}
