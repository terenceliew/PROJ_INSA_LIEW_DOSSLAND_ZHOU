/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

Action : ResetNumberValueAnnc

Reset the "numberValue" to its "defaultValue".

Created: 2018-06-29 17:19:53
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;

@XmlRootElement(name = ResetNumberValueFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = ResetNumberValueFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class ResetNumberValueFlexContainerAnnc extends AbstractFlexContainerAnnc {
	
	public static final String LONG_NAME = "resetNumberValueAnnc";
	public static final String SHORT_NAME = "reNVeAnnc";
	
	public ResetNumberValueFlexContainerAnnc () {
		setContainerDefinition("org.onem2m.home.moduleclass.numbervalue." + ResetNumberValueFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
		
}
