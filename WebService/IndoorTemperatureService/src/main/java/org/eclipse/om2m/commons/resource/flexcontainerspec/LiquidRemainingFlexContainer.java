/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : LiquidRemaining

This ModuleClass provides the status of water level (or other liquid) for an appliance, for example the level of remaining milk in a coffee machine.

Created: 2018-06-29 17:19:52
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.CustomAttribute;

@XmlRootElement(name = LiquidRemainingFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = LiquidRemainingFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class LiquidRemainingFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "liquidRemaining";
	public static final String SHORT_NAME = "liqRg";
		
	public LiquidRemainingFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + LiquidRemainingFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
		CustomAttribute liquidRemaining = new CustomAttribute();
		liquidRemaining.setLongName("liquidRemaining");
		liquidRemaining.setShortName("liqRg");
		liquidRemaining.setType("hd:enumLiquidLevel");
		getCustomAttributes().add(liquidRemaining);
	}

		
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}
