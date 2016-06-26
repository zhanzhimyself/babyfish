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
package org.babyfish.model.spi.association;

import java.util.Map;

import org.babyfish.validator.Validator;

/**
 * @author Tao Chen
 */
final class AssociatedCollectionValidator<E> implements Validator<E> {
    
    private AssociatedEndpoint endpoint;
    
    protected  AssociatedCollectionValidator(AssociatedEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void validate(E e) {
        if (e != null) {
            AssociatedEndpoint oppositeEndpoint = 
                this.endpoint.getOppositeEndpoint(e);
            if (!oppositeEndpoint.isSuspended() && (oppositeEndpoint instanceof Map<?, ?>)) {
                throw new UnsupportedOperationException(
                        CommonMessages.canNotAttachElementToSpecialAssociation(
                                this.endpoint.getAssociationProperty(),
                                this.endpoint.getAssociationProperty().getTargetType(),
                                oppositeEndpoint.getAssociationProperty(),
                                oppositeEndpoint.getAssociationProperty().getTargetType()
                        )
                );
            }
        }
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this.endpoint);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AssociatedCollectionValidator<?>;
    }
    
}
