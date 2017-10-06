package com.actionmedia.autotest.annotations;

import com.actionmedia.autotest.utils.SystemPubs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: n.tyukavkin
 * Date: 17.08.2014
 * Time: 16:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SystemType {

    SystemPubs systemPubs();
}
