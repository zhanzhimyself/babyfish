/*
 * BabyFish, Object Model Framework for Java and JPA.
 * https://github.com/babyfish-ct/babyfish
 *
 * Copyright (c) 2008-2016, Tao Chen
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * Please visit "http://opensource.org/licenses/LGPL-3.0" to know more.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 */
package org.babyfish.hibernate.context.internal;

import org.babyfish.hibernate.XSession;
import org.babyfish.hibernate.context.spi.CurrentXSessionContext;
import org.babyfish.hibernate.internal.XSessionFactoryImplementor;
import org.hibernate.context.internal.ManagedSessionContext;

/**
 * @author Tao Chen
 */
public class ManagedXSessionContext extends ManagedSessionContext implements CurrentXSessionContext {

    private static final long serialVersionUID = 1315676025450712332L;

    public ManagedXSessionContext(XSessionFactoryImplementor factory) {
        super(factory);
    }

    @Override
    public XSession currentSession() {
        return (XSession)super.currentSession();
    }
}
