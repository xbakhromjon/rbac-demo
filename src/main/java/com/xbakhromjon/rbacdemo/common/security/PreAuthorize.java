package com.xbakhromjon.rbacdemo.common.security;

import com.xbakhromjon.rbacdemo.domain.EPrivilege;
import com.xbakhromjon.rbacdemo.domain.ETokenType;

public @interface PreAuthorize {
    ETokenType[] type() default {};

    EPrivilege[] privilege() default {};
}
