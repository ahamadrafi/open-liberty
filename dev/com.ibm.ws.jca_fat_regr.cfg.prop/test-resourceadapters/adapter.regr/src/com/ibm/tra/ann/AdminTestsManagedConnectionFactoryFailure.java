/*******************************************************************************
 * Copyright (c) 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.tra.ann;

import java.io.PrintWriter;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionDefinition;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.security.auth.Subject;

import com.ibm.ejs.ras.Tr;
import com.ibm.ejs.ras.TraceComponent;
import com.ibm.tra.SimpleRAImpl;
import com.ibm.tra.outbound.base.ConnectionFactoryBase;
import com.ibm.tra.outbound.base.ConnectionRequestInfoBase;
import com.ibm.tra.trace.DebugTracer;

@ConnectionDefinition(
                      connectionFactory = com.ibm.tra.outbound.base.ConnectionFactoryBase.class,
                      connectionFactoryImpl = com.ibm.tra.outbound.impl.J2CConnectionFactory.class,
                      connection = com.ibm.tra.outbound.base.ConnectionBase.class,
                      connectionImpl = com.ibm.tra.outbound.impl.J2CConnection.class)
public class AdminTestsManagedConnectionFactoryFailure implements javax.resource.spi.ManagedConnectionFactory {

    private static final String className = "AdminTestsManagedConnectionFactoryFailure";

    private static final TraceComponent tc = Tr.register(AdminTestsManagedConnectionFactoryFailure.class, SimpleRAImpl.RAS_GROUP, null);

    public AdminTestsManagedConnectionFactoryFailure() {
        super();
        DebugTracer.printClassLoaderInfo(className, this);
        DebugTracer.printStackDump(className, new Exception());
    }

    public Object createConnectionFactory() throws ResourceException {
        final String methodName = "createConnectionFactory";
        Tr.entry(tc, methodName);

        ConnectionFactoryBase cf = null; //new J2CConnectionFactory( this, new ConnectionManagerBase() );

        Tr.exit(tc, methodName, cf);
        return cf;
    }

    public ManagedConnection createManagedConnection(Subject subj, ConnectionRequestInfo reqInfo) throws ResourceException {
        final String methodName = "createManagedConnection";
        Tr.entry(tc, methodName, new Object[] { subj, reqInfo });

        @SuppressWarnings("unused")
        ConnectionRequestInfoBase myReqInfo = null;
        if (reqInfo != null && reqInfo instanceof ConnectionRequestInfoBase)
            myReqInfo = (ConnectionRequestInfoBase) reqInfo;
        else
            throw new ResourceException("Invalid ConnectionRequestInfo.");

        ManagedConnection mc = null; //new J2CManagedConnection( this, myReqInfo );

        Tr.exit(tc, methodName, mc);
        return mc;
    }

/*
 * (non-Javadoc)
 * 
 * @see javax.resource.spi.ManagedConnectionFactory#createConnectionFactory(javax.resource.spi.ConnectionManager)
 */
    @Override
    public Object createConnectionFactory(ConnectionManager arg0) throws ResourceException {
        return null;
    }

/*
 * (non-Javadoc)
 * 
 * @see javax.resource.spi.ManagedConnectionFactory#getLogWriter()
 */
    @Override
    public PrintWriter getLogWriter() throws ResourceException {
        return null;
    }

/*
 * (non-Javadoc)
 * 
 * @see javax.resource.spi.ManagedConnectionFactory#matchManagedConnections(java.util.Set, javax.security.auth.Subject, javax.resource.spi.ConnectionRequestInfo)
 */
    @Override
    public ManagedConnection matchManagedConnections(Set arg0, Subject arg1, ConnectionRequestInfo arg2) throws ResourceException {
        return null;
    }

/*
 * (non-Javadoc)
 * 
 * @see javax.resource.spi.ManagedConnectionFactory#setLogWriter(java.io.PrintWriter)
 */
    @Override
    public void setLogWriter(PrintWriter arg0) throws ResourceException {
    }
}
