package com.hhcc.modules.common.core.api;

import java.io.Serializable;

public interface IResultCode extends Serializable {
    String getMessage();

    int getCode();
}
