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
package org.babyfish.collection.event;

import java.util.EventListener;

import org.babyfish.lang.Delegate;
import org.babyfish.lang.DelegateExceptionHandlingType;

/**
 * @author Tao Chen
 */
@Delegate(DelegateExceptionHandlingType.CONTINUE)
public interface ListElementListener<E> extends EventListener {

    default void modifying(ListElementEvent<E> e) throws Throwable {}
    
    default void modified(ListElementEvent<E> e) throws Throwable {}
    
    static <E> ListElementListener<E> combine(
            ListElementListener<E> a, 
            ListElementListener<E> b) {
        throw new UnsupportedOperationException("Instrument required");
    }
    
    static <E> ListElementListener<E> remove(
            ListElementListener<E> a, 
            ListElementListener<E> b) {
        throw new UnsupportedOperationException("Instrument required");
    }
}
