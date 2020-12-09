/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : PushButtonAnnc

This ModuleClass provides the capability to indicate the operation of a button style switch. A typical application can be an SOS button.

Created: 2018-06-29 17:19:53
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;

@XmlRootElement(name = PushButtonFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = PushButtonFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class PushButtonFlexContainerAnnc extends AbstractFlexContainerAnnc {
	
	public static final String LONG_NAME = "pushButtonAnnc";
	public static final String SHORT_NAME = "pusBnAnnc";
	
	public PushButtonFlexContainerAnnc () {
		setContainerDefinition("org.onem2m.home.moduleclass." + PushButtonFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
		
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
	
}
