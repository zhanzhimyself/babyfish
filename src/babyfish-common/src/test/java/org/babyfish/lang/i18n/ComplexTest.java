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
package org.babyfish.lang.i18n;

import org.junit.Assert;
import org.junit.Test;

public class ComplexTest {

    @Test
    public void test() {
        try {
            new Complex(1, 2).add(null);
            Assert.fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(
                    "The argument \"other\" can not be null", 
                    ex.getMessage()
            );
        }
    }
}
