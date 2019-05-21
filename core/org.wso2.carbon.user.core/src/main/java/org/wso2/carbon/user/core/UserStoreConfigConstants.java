/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.carbon.user.core;

import org.wso2.carbon.user.core.ldap.LDAPConstants;

public class UserStoreConfigConstants {
    public static final String PRIMARY = "PRIMARY";
    public static final String DOMAIN_NAME = "DomainName";
    public static final String USER_STORES = "userstores";
    public static final String TENANTS = "tenants";
    //Define datasource property for JDBC
    public static final String dataSource = "dataSource";
    public static final String dataSourceDescription = "用户存储连接名称";
    //Common Properties
    public static final String maxRoleNameListLength = "MaxRoleNameListLength";
    public static final String maxRoleNameListLengthDescription = "一次检索的最大角色数";
    public static final String maxUserNameListLength = "MaxUserNameListLength";
    public static final String maxUserNameListLengthDescription = "一次检索的最大用户数";
    public static final String userRolesCacheEnabled = "UserRolesCacheEnabled";
    public static final String userRolesCacheEnabledDescription = "这是为了指示是否缓存用户的角色列表";
    public static final String SCIMEnabled = "SCIMEnabled";
    public static final String SCIMEnabledDescription = "是否为用户存储启用SCIM";
    public static final String claimOperationsSupported = "ClaimOperationsSupported";
    public static final String claimOperationsSupportedDescription = "用户存储区是否支持声明读写";
    public static final String getClaimOperationsSupportedDisplayName = "声明操作支持";

    //Mandatory to LDAP user stores
    public static final String connectionURL = "ConnectionURL";
    public static final String connectionURLDescription = "用户存储的连接URL";
    public static final String connectionName = "ConnectionName";
    public static final String connectionNameDescription = "这应该是具有足够权限对LDAP中的用户和角色执行操作的用户的DN（区分名称）";


    public static final String connectionPassword = "ConnectionPassword";
    public static final String connectionPasswordDescription = "管理员用户的密码";
    public static final String userSearchBase = "UserSearchBase";
    public static final String userSearchBaseDescription = "在LDAP中存储用户条目的上下文的DN";
    public static final String disabled = "Disabled";
    public static final String disabledDescription = "用户存储是否被禁用";


    //Write Group Privilege Properties
    public static final String writeGroups = "WriteGroups";
    public static final String writeGroupsDescription = "指示是否启用写入组";
    public static final String userEntryObjectClass = "UserEntryObjectClass";
    public static final String userEntryObjectClassDescription = "用来构造用户实体的对象类";
    public static final String passwordJavaScriptRegEx = "PasswordJavaScriptRegEx";
    public static final String passwordJavaScriptRegExDescription = "定义密码格式的策略";
    public static final String usernameJavaScriptRegEx = "UserNameJavaScriptRegEx";
    public static final String usernameJavaScriptRegExDescription = "前端组件用于用户名验证的正则表达式";
    public static final String usernameJavaRegEx = "UserNameJavaRegEx";
    public static final String usernameJavaRegExDescription = "用于验证用户名的正则表达式";
    public static final String roleNameJavaScriptRegEx = "RoleNameJavaScriptRegEx";
    public static final String roleNameJavaScriptRegExDescription = "前端组件用于角色名称验证的正则表达式";
    public static final String roleNameJavaRegEx = "RoleNameJavaRegEx";
    public static final String roleNameJavaRegExDescription = "用于验证角色名称的正则表达式";
    public static final String groupEntryObjectClass = "GroupEntryObjectClass";
    public static final String groupEntryObjectClassDescription = "用于构造群组的对象类";
    public static final String emptyRolesAllowed = "EmptyRolesAllowed";
    public static final String emptyRolesAllowedDescription = "指定基础用户存储区是否允许添加空角色";

    //LDAP Specific Properties
    public static final String passwordHashMethod = "PasswordHashMethod";
    public static final String passwordHashMethodDescription = "存储用户条目时使用的密码哈希方法";
    public static final String usernameListFilter = "UserNameListFilter";
    public static final String usernameListFilterDescription = "用于列出LDAP中所有用户条目的筛选条件";
    public static final String usernameSearchFilter = "UserNameSearchFilter";
    public static final String usernameSearchFilterDescription = "搜索特定用户条目的筛选条件";
    public static final String userNameAttribute = "UserNameAttribute";
    public static final String userNameAttributeDescription = "用于唯一标识用户条目的属性。用户可以使用其电子邮件地址、uid等进行身份验证。";
    public static final String readGroups = "ReadGroups";
    public static final String readLDAPGroupsDescription = "指定是否应从LDAP读取组";
    public static final String groupSearchBase = "GroupSearchBase";
    public static final String groupSearchBaseDescription = "在LDAP中存储用户条目的上下文的DN";
    public static final String groupNameListFilter = "GroupNameListFilter";
    public static final String groupNameListFilterDescription = "在LDAP中列出所有组条目的筛选条件";
    public static final String groupNameAttribute = "GroupNameAttribute";
    public static final String groupNameAttributeDescription = "用于唯一标识用户条目的属性";
    public static final String groupNameSearchFilter = "GroupNameSearchFilter";
    public static final String groupNameSearchFilterDescription = "用于搜索特定组条目的筛选条件";
    public static final String membershipAttribute = "MembershipAttribute";
    public static final String membershipAttributeDescription = "用于定义LDAP组成员的属性";
    public static final String memberOfAttribute = LDAPConstants.MEMBEROF_ATTRIBUTE;
    public static final String memberOfAttributeDescription = "用于定义LDAP用户组的属性";
    public static final String userDNPattern = "UserDNPattern";
    public static final String userDNPatternDescription = "用户DN的模式。可以定义它来改进LDAP搜索";
    public static final String connectionPoolingEnabled = "ConnectionPoolingEnabled";
    public static final String connectionPoolingEnabledDescription = "设置此属性以启用LDAP连接池.";
}
