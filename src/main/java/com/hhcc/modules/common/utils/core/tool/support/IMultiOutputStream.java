package com.hhcc.modules.common.utils.core.tool.support;

import java.io.OutputStream;

public interface IMultiOutputStream {
    OutputStream buildOutputStream(Integer... params);
}
