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
    public static final String writeGroupsDescription = "Indicate whether write groups enabled";
    public static final String userEntryObjectClass = "UserEntryObjectClass";
    public static final String userEntryObjectClassDescription = "Object Class used to construct user entries";
    public static final String passwordJavaScriptRegEx = "PasswordJavaScriptRegEx";
    public static final String passwordJavaScriptRegExDescription = "Policy that defines the password format";
    public static final String usernameJavaScriptRegEx = "UserNameJavaScriptRegEx";
    public static final String usernameJavaScriptRegExDescription = "The regular expression used by the front-end components for username validation";
    public static final String usernameJavaRegEx = "UserNameJavaRegEx";
    public static final String usernameJavaRegExDescription = "A regular expression to validate user names";
    public static final String roleNameJavaScriptRegEx = "RoleNameJavaScriptRegEx";
    public static final String roleNameJavaScriptRegExDescription = "The regular expression used by the front-end components for role name validation";
    public static final String roleNameJavaRegEx = "RoleNameJavaRegEx";
    public static final String roleNameJavaRegExDescription = "A regular expression to validate role names";
    public static final String groupEntryObjectClass = "GroupEntryObjectClass";
    public static final String groupEntryObjectClassDescription = "Object Class used to construct group entries";
    public static final String emptyRolesAllowed = "EmptyRolesAllowed";
    public static final String emptyRolesAllowedDescription = "Specifies whether the underlying user store allows empty roles to be added";

    //LDAP Specific Properties
    public static final String passwordHashMethod = "PasswordHashMethod";
    public static final String passwordHashMethodDescription = "Password Hash method to use when storing user entries";
    public static final String usernameListFilter = "UserNameListFilter";
    public static final String usernameListFilterDescription = "Filtering criteria for listing all the user entries in LDAP";
    public static final String usernameSearchFilter = "UserNameSearchFilter";
    public static final String usernameSearchFilterDescription = "Filtering criteria for searching a particular user entry";
    public static final String userNameAttribute = "UserNameAttribute";
    public static final String userNameAttributeDescription = "Attribute used for uniquely identifying a user entry. Users can be authenticated using their email address, uid and etc";
    public static final String readGroups = "ReadGroups";
    public static final String readLDAPGroupsDescription = "Specifies whether groups should be read from LDAP";
    public static final String groupSearchBase = "GroupSearchBase";
    public static final String groupSearchBaseDescription = "DN of the context under which user entries are stored in LDAP";
    public static final String groupNameListFilter = "GroupNameListFilter";
    public static final String groupNameListFilterDescription = "Filtering criteria for listing all the group entries in LDAP";
    public static final String groupNameAttribute = "GroupNameAttribute";
    public static final String groupNameAttributeDescription = "Attribute used for uniquely identifying a user entry";
    public static final String groupNameSearchFilter = "GroupNameSearchFilter";
    public static final String groupNameSearchFilterDescription = "Filtering criteria for searching a particular group entry";
    public static final String membershipAttribute = "MembershipAttribute";
    public static final String membershipAttributeDescription = "Attribute used to define members of LDAP groups";
    public static final String memberOfAttribute = LDAPConstants.MEMBEROF_ATTRIBUTE;
    public static final String memberOfAttributeDescription = "Attribute used to define groups of a LDAP User";
    public static final String userDNPattern = "UserDNPattern";
    public static final String userDNPatternDescription = "The patten for user's DN. It can be defined to improve the LDAP search";
    public static final String connectionPoolingEnabled = "ConnectionPoolingEnabled";
    public static final String connectionPoolingEnabledDescription = "Set this property to enable LDAP connection " +
            "pooling.";
}
