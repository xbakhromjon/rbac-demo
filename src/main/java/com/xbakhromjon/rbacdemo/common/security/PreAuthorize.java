package com.xbakhromjon.rbacdemo.common.security;

import com.xbakhromjon.rbacdemo.domain.enumeration.EPrivilege;
import com.xbakhromjon.rbacdemo.domain.enumeration.ETokenType;

public @interface PreAuthorize {
    ETokenType[] type() default {};

    EPrivilege[] privilege() default {};
}
