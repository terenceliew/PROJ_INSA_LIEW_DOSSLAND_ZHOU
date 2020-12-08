/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

Device : DeviceLight

A light is a device that is used to control the state of an illumination appliance.

Created: 2018-06-29 17:19:55
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;

@XmlRootElement(name = DeviceLightFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = DeviceLightFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class DeviceLightFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "deviceLight";
	public static final String SHORT_NAME = "devLt";
	
	public DeviceLightFlexContainer () {
		setContainerDefinition("org.onem2m.home.device." + DeviceLightFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
    public void finalizeSerialization() {
		getFaultDetection();
		getBinarySwitch();
		getRunState();
		getColour();
		getColourSaturation();
		getBrightness();
	}
	
	public void finalizeDeserialization() {
		if (this.faultDetection != null) {
			setFaultDetection(this.faultDetection);
		}
		if (this.binarySwitch != null) {
			setBinarySwitch(this.binarySwitch);
		}
		if (this.runState != null) {
			setRunState(this.runState);
		}
		if (this.colour != null) {
			setColour(this.colour);
		}
		if (this.colourSaturation != null) {
			setColourSaturation(this.colourSaturation);
		}
		if (this.brightness != null) {
			setBrightness(this.brightness);
		}
	}

	@XmlElement(name=FaultDetectionFlexContainer.SHORT_NAME, required=true, type=FaultDetectionFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private FaultDetectionFlexContainer faultDetection;
		
	public void setFaultDetection(FaultDetectionFlexContainer faultDetection) {
		this.faultDetection = faultDetection;
		getFlexContainerOrContainerOrSubscription().add(faultDetection);
	}
	
	public FaultDetectionFlexContainer getFaultDetection() {
		this.faultDetection = (FaultDetectionFlexContainer) getResourceByName(FaultDetectionFlexContainer.SHORT_NAME);
		return faultDetection;
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
	
	@XmlElement(name=ColourFlexContainer.SHORT_NAME, required=true, type=ColourFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private ColourFlexContainer colour;
		
	public void setColour(ColourFlexContainer colour) {
		this.colour = colour;
		getFlexContainerOrContainerOrSubscription().add(colour);
	}
	
	public ColourFlexContainer getColour() {
		this.colour = (ColourFlexContainer) getResourceByName(ColourFlexContainer.SHORT_NAME);
		return colour;
	}
	
	@XmlElement(name=ColourSaturationFlexContainer.SHORT_NAME, required=true, type=ColourSaturationFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private ColourSaturationFlexContainer colourSaturation;
		
	public void setColourSaturation(ColourSaturationFlexContainer colourSaturation) {
		this.colourSaturation = colourSaturation;
		getFlexContainerOrContainerOrSubscription().add(colourSaturation);
	}
	
	public ColourSaturationFlexContainer getColourSaturation() {
		this.colourSaturation = (ColourSaturationFlexContainer) getResourceByName(ColourSaturationFlexContainer.SHORT_NAME);
		return colourSaturation;
	}
	
	@XmlElement(name=BrightnessFlexContainer.SHORT_NAME, required=true, type=BrightnessFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private BrightnessFlexContainer brightness;
		
	public void setBrightness(BrightnessFlexContainer brightness) {
		this.brightness = brightness;
		getFlexContainerOrContainerOrSubscription().add(brightness);
	}
	
	public BrightnessFlexContainer getBrightness() {
		this.brightness = (BrightnessFlexContainer) getResourceByName(BrightnessFlexContainer.SHORT_NAME);
		return brightness;
	}
	
}
