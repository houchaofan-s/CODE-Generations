package com.hhcc.modules.common.utils.core.tool.constant;

public interface BladeConstant {
    String UTF_8 = "UTF-8";
    String CONTENT_TYPE_NAME = "Content-type";
    String CONTENT_TYPE = "application/json;charset=utf-8";
    String CONTEXT_KEY = "bladeContext";
    String MDC_REQUEST_ID_KEY = "requestId";
    String MDC_ACCOUNT_ID_KEY = "accountId";
    String MDC_TENANT_ID_KEY = "tenantId";
    String SECURITY_ROLE_PREFIX = "ROLE_";
    String DB_PRIMARY_KEY = "id";
    String DB_PRIMARY_KEY_METHOD = "getId";
    String DB_TENANT_KEY = "tenantId";
    String DB_TENANT_KEY_GET_METHOD = "getTenantId";
    String DB_TENANT_KEY_SET_METHOD = "setTenantId";
    int DB_STATUS_NORMAL = 1;
    int DB_NOT_DELETED = 0;
    int DB_IS_DELETED = 1;
    int DB_ADMIN_NON_LOCKED = 0;
    int DB_ADMIN_LOCKED = 1;
    Long TOP_PARENT_ID = 0L;
    String TOP_PARENT_NAME = "顶级";
    String ADMIN_TENANT_ID = "000000";
    String LOG_NORMAL_TYPE = "1";
    String DEFAULT_NULL_MESSAGE = "暂无承载数据";
    String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    String DEFAULT_FAILURE_MESSAGE = "操作失败";
    String DEFAULT_UNAUTHORIZED_MESSAGE = "签名认证失败";
}
