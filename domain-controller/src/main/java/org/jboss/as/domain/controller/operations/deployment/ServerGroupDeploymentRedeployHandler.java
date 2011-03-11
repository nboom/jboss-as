/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.jboss.as.domain.controller.operations.deployment;

import static org.jboss.as.controller.descriptions.ModelDescriptionConstants.OP_ADDR;

import java.util.Locale;

import org.jboss.as.controller.BasicOperationResult;
import org.jboss.as.controller.ModelQueryOperationHandler;
import org.jboss.as.controller.OperationContext;
import org.jboss.as.controller.OperationFailedException;
import org.jboss.as.controller.OperationResult;
import org.jboss.as.controller.ResultHandler;
import org.jboss.as.controller.descriptions.DescriptionProvider;
import org.jboss.as.controller.operations.common.Util;
import org.jboss.as.server.controller.descriptions.DeploymentDescription;
import org.jboss.dmr.ModelNode;

/**
 * Handles redeployment in the runtime.
 *
 * @author Brian Stansberry (c) 2011 Red Hat Inc.
 */
public class ServerGroupDeploymentRedeployHandler implements ModelQueryOperationHandler, DescriptionProvider {

    public static final String OPERATION_NAME = "redeploy";

    public static final ServerGroupDeploymentRedeployHandler INSTANCE = new ServerGroupDeploymentRedeployHandler();

    private ServerGroupDeploymentRedeployHandler() {
    }

    @Override
    public ModelNode getModelDescription(Locale locale) {
        return DeploymentDescription.getRedeployDeploymentOperation(locale);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperationResult execute(OperationContext context, ModelNode operation, ResultHandler resultHandler) throws OperationFailedException {

        ModelNode compensatingOp = Util.getEmptyOperation(OPERATION_NAME, operation.get(OP_ADDR));
        resultHandler.handleResultComplete();

        return new BasicOperationResult(compensatingOp);
    }
}