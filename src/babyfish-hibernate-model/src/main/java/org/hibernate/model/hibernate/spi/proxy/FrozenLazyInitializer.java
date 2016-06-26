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
package org.hibernate.model.hibernate.spi.proxy;

import org.babyfish.collection.FrozenContext;
import org.babyfish.model.event.ScalarModificationAware;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyObject;

public interface FrozenLazyInitializer extends LazyInitializer, ScalarModificationAware {

    void freezeIdentifier(FrozenContext<?> ctx);
    
    void unfreezeIdentifier(FrozenContext<?> ctx);
    
    static FrozenLazyInitializer get(HibernateProxy hibernateProxy) {
        ProxyObject proxyObject = (ProxyObject)hibernateProxy;
        MethodHandler handler = proxyObject.getHandler();
        if (handler instanceof FrozenLazyInitializer) {
            return (FrozenLazyInitializer)handler;
        }
        return new FrozenLazyInitializerImpl(hibernateProxy);
    }
}
