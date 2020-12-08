/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

Device : DeviceClothesDryer

A clothes dryer is a home appliance for drying clothes. This clothesDryer information model provides capabilities to control and monitor clothes dryer specific functions and resources.

Created: 2018-06-29 17:19:54
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;

@XmlRootElement(name = DeviceClothesDryerFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = DeviceClothesDryerFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class DeviceClothesDryerFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "deviceClothesDryer";
	public static final String SHORT_NAME = "deCDr";
	
	public DeviceClothesDryerFlexContainer () {
		setContainerDefinition("org.onem2m.home.device." + DeviceClothesDryerFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
    public void finalizeSerialization() {
		getBinarySwitch();
		getRunState();
		getClothesDryerJobMode();
		getClothesDryerOperationMode();
	}
	
	public void finalizeDeserialization() {
		if (this.binarySwitch != null) {
			setBinarySwitch(this.binarySwitch);
		}
		if (this.runState != null) {
			setRunState(this.runState);
		}
		if (this.clothesDryerJobMode != null) {
			setClothesDryerJobMode(this.clothesDryerJobMode);
		}
		if (this.clothesDryerOperationMode != null) {
			setClothesDryerOperationMode(this.clothesDryerOperationMode);
		}
	}

	@XmlElement(name=BinarySwitchFlexContainer.SHORT_NAME, required=true, type=BinarySwitchFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private BinarySwitchFlexContainer binarySwitch;
		
	public void setBinarySwitch(BinarySwitchFlexContainer binarySwitch) {
		this.binarySwitch = binarySwitch;
		getFlexContainerOrContainerOrSubscription().add(binarySwitch);
	}
	
	public BinarySwitchFlexContainer getBinarySwitch() {
		this.binarySwitch = (BinarySwitchFlexContainer) getResourceByName(BinarySwitchFlexContainer.SHORT_NAME);
		return binarySwitch;
	}
	
	@XmlElement(name=RunStateFlexContainer.SHORT_NAME, required=true, type=RunStateFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private RunStateFlexContainer runState;
		
	public void setRunState(RunStateFlexContainer runState) {
		this.runState = runState;
		getFlexContainerOrContainerOrSubscription().add(runState);
	}
	
	public RunStateFlexContainer getRunState() {
		this.runState = (RunStateFlexContainer) getResourceByName(RunStateFlexContainer.SHORT_NAME);
		return runState;
	}
	
	@XmlElement(name=ClothesDryerJobModeFlexContainer.SHORT_NAME, required=true, type=ClothesDryerJobModeFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private ClothesDryerJobModeFlexContainer clothesDryerJobMode;
		
	public void setClothesDryerJobMode(ClothesDryerJobModeFlexContainer clothesDryerJobMode) {
		this.clothesDryerJobMode = clothesDryerJobMode;
		getFlexContainerOrContainerOrSubscription().add(clothesDryerJobMode);
	}
	
	public ClothesDryerJobModeFlexContainer getClothesDryerJobMode() {
		this.clothesDryerJobMode = (ClothesDryerJobModeFlexContainer) getResourceByName(ClothesDryerJobModeFlexContainer.SHORT_NAME);
		return clothesDryerJobMode;
	}
	
	@XmlElement(name=OperationModeFlexContainer.SHORT_NAME, required=true, type=OperationModeFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private OperationModeFlexContainer clothesDryerOperationMode;
		
	public void setClothesDryerOperationMode(OperationModeFlexContainer clothesDryerOperationMode) {
		this.clothesDryerOperationMode = clothesDryerOperationMode;
		getFlexContainerOrContainerOrSubscription().add(clothesDryerOperationMode);
	}
	
	public OperationModeFlexContainer getClothesDryerOperationMode() {
		this.clothesDryerOperationMode = (OperationModeFlexContainer) getResourceByName(OperationModeFlexContainer.SHORT_NAME);
		return clothesDryerOperationMode;
	}
	
}
