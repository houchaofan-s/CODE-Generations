package com.hhcc.modules.common.utils.core.tool.api;

import java.io.Serializable;

public interface IResultCode extends Serializable {
    String getMessage();

    int getCode();
}
