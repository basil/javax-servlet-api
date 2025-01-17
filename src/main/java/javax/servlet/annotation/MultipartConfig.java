/*
 * Copyright (c) 2017, 2018 Oracle and/or its affiliates and others.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package javax.servlet.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation that may be specified on a {@link javax.servlet.Servlet} class, indicating that instances of the
 * <code>Servlet</code> expect requests that conform to the <code>multipart/form-data</code> MIME type.
 *
 * <p>
 * Servlets annotated with <code>MultipartConfig</code> may retrieve the {@link javax.servlet.http.Part} components of a
 * given <code>multipart/form-data</code> request by calling {@link javax.servlet.http.HttpServletRequest#getPart getPart}
 * or {@link javax.servlet.http.HttpServletRequest#getParts getParts}.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MultipartConfig {

    /**
     * The directory location where files will be stored
     *
     * @return the directory location where files will be stored
     */
    String location() default "";

    /**
     * The maximum size allowed for uploaded files.
     * 
     * <p>
     * The default is <code>-1L</code>, which means unlimited.
     *
     * @return the maximum size allowed for uploaded files
     */
    long maxFileSize() default -1L;

    /**
     * The maximum size allowed for <code>multipart/form-data</code> requests
     * 
     * <p>
     * The default is <code>-1L</code>, which means unlimited.
     *
     * @return the maximum size allowed for <code>multipart/form-data</code> requests
     */
    long maxRequestSize() default -1L;

    /**
     * The size threshold after which the file will be written to disk
     *
     * @return the size threshold after which the file will be written to disk
     */
    int fileSizeThreshold() default 0;
}
