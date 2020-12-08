/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

Device : DeviceSmartElectricMeterAnnc

A smart electric meter is a metering device that is used to measure consumption data for electrictricity.

Created: 2018-06-29 17:19:55
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;
import org.eclipse.om2m.commons.resource.AbstractFlexContainerAnnc;

@XmlRootElement(name = DeviceSmartElectricMeterFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = DeviceSmartElectricMeterFlexContainerAnnc.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class DeviceSmartElectricMeterFlexContainerAnnc extends AbstractFlexContainerAnnc {
	
	public static final String LONG_NAME = "deviceSmartElectricMeterAnnc";
	public static final String SHORT_NAME = "dSEMrAnnc";
	
	public DeviceSmartElectricMeterFlexContainerAnnc () {
		setContainerDefinition("org.onem2m.home.device." + DeviceSmartElectricMeterFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
    }
	
	public void finalizeSerialization() {
		getFaultDetection();
		getFaultDetectionAnnc();
		getBinarySwitch();
		getBinarySwitchAnnc();
		getRunState();
		getRunStateAnnc();
		getClock();
		getClockAnnc();
		getEnergyConsumption();
		getEnergyConsumptionAnnc();
		getEnergyGeneration();
		getEnergyGenerationAnnc();
    }
	
	public void finalizeDeserialization() {
		if (this.faultDetection != null) {
			setFaultDetection(this.faultDetection);
		}
		if (this.faultDetectionAnnc != null) {
			setFaultDetectionAnnc(this.faultDetectionAnnc);
		}
		if (this.binarySwitch != null) {
			setBinarySwitch(this.binarySwitch);
		}
		if (this.binarySwitchAnnc != null) {
			setBinarySwitchAnnc(this.binarySwitchAnnc);
		}
		if (this.runState != null) {
			setRunState(this.runState);
		}
		if (this.runStateAnnc != null) {
			setRunStateAnnc(this.runStateAnnc);
		}
		if (this.clock != null) {
			setClock(this.clock);
		}
		if (this.clockAnnc != null) {
			setClockAnnc(this.clockAnnc);
		}
		if (this.energyConsumption != null) {
			setEnergyConsumption(this.energyConsumption);
		}
		if (this.energyConsumptionAnnc != null) {
			setEnergyConsumptionAnnc(this.energyConsumptionAnnc);
		}
		if (this.energyGeneration != null) {
			setEnergyGeneration(this.energyGeneration);
		}
		if (this.energyGenerationAnnc != null) {
			setEnergyGenerationAnnc(this.energyGenerationAnnc);
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
	
	@XmlElement(name=FaultDetectionFlexContainerAnnc.SHORT_NAME, required=true, type=FaultDetectionFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private FaultDetectionFlexContainerAnnc faultDetectionAnnc;
		
	public void setFaultDetectionAnnc(FaultDetectionFlexContainerAnnc faultDetectionAnnc) {
		this.faultDetectionAnnc = faultDetectionAnnc;
		getFlexContainerOrContainerOrSubscription().add(faultDetectionAnnc);
	}
	
	public FaultDetectionFlexContainerAnnc getFaultDetectionAnnc() {
		this.faultDetectionAnnc = (FaultDetectionFlexContainerAnnc) getResourceByName(FaultDetectionFlexContainerAnnc.SHORT_NAME);
		return faultDetectionAnnc;
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
	
	@XmlElement(name=BinarySwitchFlexContainerAnnc.SHORT_NAME, required=true, type=BinarySwitchFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private BinarySwitchFlexContainerAnnc binarySwitchAnnc;
		
	public void setBinarySwitchAnnc(BinarySwitchFlexContainerAnnc binarySwitchAnnc) {
		this.binarySwitchAnnc = binarySwitchAnnc;
		getFlexContainerOrContainerOrSubscription().add(binarySwitchAnnc);
	}
	
	public BinarySwitchFlexContainerAnnc getBinarySwitchAnnc() {
		this.binarySwitchAnnc = (BinarySwitchFlexContainerAnnc) getResourceByName(BinarySwitchFlexContainerAnnc.SHORT_NAME);
		return binarySwitchAnnc;
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
	
	@XmlElement(name=RunStateFlexContainerAnnc.SHORT_NAME, required=true, type=RunStateFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private RunStateFlexContainerAnnc runStateAnnc;
		
	public void setRunStateAnnc(RunStateFlexContainerAnnc runStateAnnc) {
		this.runStateAnnc = runStateAnnc;
		getFlexContainerOrContainerOrSubscription().add(runStateAnnc);
	}
	
	public RunStateFlexContainerAnnc getRunStateAnnc() {
		this.runStateAnnc = (RunStateFlexContainerAnnc) getResourceByName(RunStateFlexContainerAnnc.SHORT_NAME);
		return runStateAnnc;
	}
	
	@XmlElement(name=ClockFlexContainer.SHORT_NAME, required=true, type=ClockFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private ClockFlexContainer clock;
		
	public void setClock(ClockFlexContainer clock) {
		this.clock = clock;
		getFlexContainerOrContainerOrSubscription().add(clock);
	}
	
	public ClockFlexContainer getClock() {
		this.clock = (ClockFlexContainer) getResourceByName(ClockFlexContainer.SHORT_NAME);
		return clock;
	}
	
	@XmlElement(name=ClockFlexContainerAnnc.SHORT_NAME, required=true, type=ClockFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private ClockFlexContainerAnnc clockAnnc;
		
	public void setClockAnnc(ClockFlexContainerAnnc clockAnnc) {
		this.clockAnnc = clockAnnc;
		getFlexContainerOrContainerOrSubscription().add(clockAnnc);
	}
	
	public ClockFlexContainerAnnc getClockAnnc() {
		this.clockAnnc = (ClockFlexContainerAnnc) getResourceByName(ClockFlexContainerAnnc.SHORT_NAME);
		return clockAnnc;
	}
	
	@XmlElement(name=EnergyConsumptionFlexContainer.SHORT_NAME, required=true, type=EnergyConsumptionFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private EnergyConsumptionFlexContainer energyConsumption;
		
	public void setEnergyConsumption(EnergyConsumptionFlexContainer energyConsumption) {
		this.energyConsumption = energyConsumption;
		getFlexContainerOrContainerOrSubscription().add(energyConsumption);
	}
	
	public EnergyConsumptionFlexContainer getEnergyConsumption() {
		this.energyConsumption = (EnergyConsumptionFlexContainer) getResourceByName(EnergyConsumptionFlexContainer.SHORT_NAME);
		return energyConsumption;
	}
	
	@XmlElement(name=EnergyConsumptionFlexContainerAnnc.SHORT_NAME, required=true, type=EnergyConsumptionFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private EnergyConsumptionFlexContainerAnnc energyConsumptionAnnc;
		
	public void setEnergyConsumptionAnnc(EnergyConsumptionFlexContainerAnnc energyConsumptionAnnc) {
		this.energyConsumptionAnnc = energyConsumptionAnnc;
		getFlexContainerOrContainerOrSubscription().add(energyConsumptionAnnc);
	}
	
	public EnergyConsumptionFlexContainerAnnc getEnergyConsumptionAnnc() {
		this.energyConsumptionAnnc = (EnergyConsumptionFlexContainerAnnc) getResourceByName(EnergyConsumptionFlexContainerAnnc.SHORT_NAME);
		return energyConsumptionAnnc;
	}
	
	@XmlElement(name=EnergyGenerationFlexContainer.SHORT_NAME, required=true, type=EnergyGenerationFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private EnergyGenerationFlexContainer energyGeneration;
		
	public void setEnergyGeneration(EnergyGenerationFlexContainer energyGeneration) {
		this.energyGeneration = energyGeneration;
		getFlexContainerOrContainerOrSubscription().add(energyGeneration);
	}
	
	public EnergyGenerationFlexContainer getEnergyGeneration() {
		this.energyGeneration = (EnergyGenerationFlexContainer) getResourceByName(EnergyGenerationFlexContainer.SHORT_NAME);
		return energyGeneration;
	}
	
	@XmlElement(name=EnergyGenerationFlexContainerAnnc.SHORT_NAME, required=true, type=EnergyGenerationFlexContainerAnnc.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private EnergyGenerationFlexContainerAnnc energyGenerationAnnc;
		
	public void setEnergyGenerationAnnc(EnergyGenerationFlexContainerAnnc energyGenerationAnnc) {
		this.energyGenerationAnnc = energyGenerationAnnc;
		getFlexContainerOrContainerOrSubscription().add(energyGenerationAnnc);
	}
	
	public EnergyGenerationFlexContainerAnnc getEnergyGenerationAnnc() {
		this.energyGenerationAnnc = (EnergyGenerationFlexContainerAnnc) getResourceByName(EnergyGenerationFlexContainerAnnc.SHORT_NAME);
		return energyGenerationAnnc;
	}
	
}
