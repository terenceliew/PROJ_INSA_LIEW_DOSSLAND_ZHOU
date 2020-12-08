/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

Device : DeviceSmokeDetector



Created: 2018-06-29 17:19:55
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;

@XmlRootElement(name = DeviceSmokeDetectorFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = DeviceSmokeDetectorFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class DeviceSmokeDetectorFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "deviceSmokeDetector";
	public static final String SHORT_NAME = "deSDr";
	
	public DeviceSmokeDetectorFlexContainer () {
		setContainerDefinition("org.onem2m.home.device." + DeviceSmokeDetectorFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
    public void finalizeSerialization() {
		getSmokeSensor();
	}
	
	public void finalizeDeserialization() {
		if (this.smokeSensor != null) {
			setSmokeSensor(this.smokeSensor);
		}
	}

	@XmlElement(name=SmokeSensorFlexContainer.SHORT_NAME, required=true, type=SmokeSensorFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private SmokeSensorFlexContainer smokeSensor;
		
	public void setSmokeSensor(SmokeSensorFlexContainer smokeSensor) {
		this.smokeSensor = smokeSensor;
		getFlexContainerOrContainerOrSubscription().add(smokeSensor);
	}
	
	public SmokeSensorFlexContainer getSmokeSensor() {
		this.smokeSensor = (SmokeSensorFlexContainer) getResourceByName(SmokeSensorFlexContainer.SHORT_NAME);
		return smokeSensor;
	}
	
}
