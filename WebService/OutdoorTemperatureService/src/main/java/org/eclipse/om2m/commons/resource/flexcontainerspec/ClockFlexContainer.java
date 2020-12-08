/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

ModuleClass : Clock

This ModuleClass provides capabilities to control and monitor time and date information.

Created: 2018-06-29 17:19:51
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.CustomAttribute;

@XmlRootElement(name = ClockFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = ClockFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class ClockFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "clock";
	public static final String SHORT_NAME = "clock";
		
	public ClockFlexContainer () {
		setContainerDefinition("org.onem2m.home.moduleclass." + ClockFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
		CustomAttribute currentTime = new CustomAttribute();
		currentTime.setLongName("currentTime");
		currentTime.setShortName("curTe");
		currentTime.setType("xs:time");
		getCustomAttributes().add(currentTime);
		CustomAttribute currentTimeZone = new CustomAttribute();
		currentTimeZone.setLongName("currentTimeZone");
		currentTimeZone.setShortName("cuTZe");
		currentTimeZone.setType("xs:string");
		getCustomAttributes().add(currentTimeZone);
		CustomAttribute currentDate = new CustomAttribute();
		currentDate.setLongName("currentDate");
		currentDate.setShortName("curDe");
		currentDate.setType("xs:date");
		getCustomAttributes().add(currentDate);
	}

		
	public void finalizeSerialization() {
	}
	
	public void finalizeDeserialization() {
	}
	
}
