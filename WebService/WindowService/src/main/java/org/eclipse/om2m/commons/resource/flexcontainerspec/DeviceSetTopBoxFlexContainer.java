/*
********************************************************************************
 * Copyright (c) 2014, 2018 Orange.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 ********************************************************************************

Device : DeviceSetTopBox

A set top box is a device that in general contains a TV tuner input and displays output to a TV.

Created: 2018-06-29 17:19:55
*/

package org.eclipse.om2m.commons.resource.flexcontainerspec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.om2m.commons.resource.AbstractFlexContainer;

@XmlRootElement(name = DeviceSetTopBoxFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = DeviceSetTopBoxFlexContainer.SHORT_NAME, namespace = "http://www.onem2m.org/xml/protocols/homedomain")
public class DeviceSetTopBoxFlexContainer extends AbstractFlexContainer {
	
	public static final String LONG_NAME = "deviceSetTopBox";
	public static final String SHORT_NAME = "dSTBx";
	
	public DeviceSetTopBoxFlexContainer () {
		setContainerDefinition("org.onem2m.home.device." + DeviceSetTopBoxFlexContainer.LONG_NAME);
		setLongName(LONG_NAME);
		setShortName(SHORT_NAME);
	}
	
    public void finalizeSerialization() {
		getBinarySwitch();
		getAudioVolume();
		getChannel();
		getMediaInput();
		getMediaOutput();
	}
	
	public void finalizeDeserialization() {
		if (this.binarySwitch != null) {
			setBinarySwitch(this.binarySwitch);
		}
		if (this.audioVolume != null) {
			setAudioVolume(this.audioVolume);
		}
		if (this.channel != null) {
			setChannel(this.channel);
		}
		if (this.mediaInput != null) {
			setMediaInput(this.mediaInput);
		}
		if (this.mediaOutput != null) {
			setMediaOutput(this.mediaOutput);
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
	
	@XmlElement(name=AudioVolumeFlexContainer.SHORT_NAME, required=true, type=AudioVolumeFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private AudioVolumeFlexContainer audioVolume;
		
	public void setAudioVolume(AudioVolumeFlexContainer audioVolume) {
		this.audioVolume = audioVolume;
		getFlexContainerOrContainerOrSubscription().add(audioVolume);
	}
	
	public AudioVolumeFlexContainer getAudioVolume() {
		this.audioVolume = (AudioVolumeFlexContainer) getResourceByName(AudioVolumeFlexContainer.SHORT_NAME);
		return audioVolume;
	}
	
	@XmlElement(name=TelevisionChannelFlexContainer.SHORT_NAME, required=true, type=TelevisionChannelFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private TelevisionChannelFlexContainer channel;
		
	public void setChannel(TelevisionChannelFlexContainer channel) {
		this.channel = channel;
		getFlexContainerOrContainerOrSubscription().add(channel);
	}
	
	public TelevisionChannelFlexContainer getChannel() {
		this.channel = (TelevisionChannelFlexContainer) getResourceByName(TelevisionChannelFlexContainer.SHORT_NAME);
		return channel;
	}
	
	@XmlElement(name=MediaSelectFlexContainer.SHORT_NAME, required=true, type=MediaSelectFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private MediaSelectFlexContainer mediaInput;
		
	public void setMediaInput(MediaSelectFlexContainer mediaInput) {
		this.mediaInput = mediaInput;
		getFlexContainerOrContainerOrSubscription().add(mediaInput);
	}
	
	public MediaSelectFlexContainer getMediaInput() {
		this.mediaInput = (MediaSelectFlexContainer) getResourceByName(MediaSelectFlexContainer.SHORT_NAME);
		return mediaInput;
	}
	
	@XmlElement(name=MediaSelectFlexContainer.SHORT_NAME, required=true, type=MediaSelectFlexContainer.class, namespace="http://www.onem2m.org/xml/protocols/homedomain")
	private MediaSelectFlexContainer mediaOutput;
		
	public void setMediaOutput(MediaSelectFlexContainer mediaOutput) {
		this.mediaOutput = mediaOutput;
		getFlexContainerOrContainerOrSubscription().add(mediaOutput);
	}
	
	public MediaSelectFlexContainer getMediaOutput() {
		this.mediaOutput = (MediaSelectFlexContainer) getResourceByName(MediaSelectFlexContainer.SHORT_NAME);
		return mediaOutput;
	}
	
}
