/*******************************************************************************
 * Copyright (c) 2013-2020 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Initial Contributors:
 *     Thierry Monteil : Project manager, technical co-manager
 *     Mahdi Ben Alaya : Technical co-manager
 *     Samir Medjiah : Technical co-manager
 *     Khalil Drira : Strategy expert
 *     Guillaume Garzone : Developer
 *     François Aïssaoui : Developer
 *
 * New contributors :
 *******************************************************************************/
package org.eclipse.om2m.commons.entities;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.eclipse.om2m.commons.constants.DBEntities;
import org.eclipse.om2m.commons.constants.MgmtDefinitionTypes;
import org.eclipse.om2m.commons.constants.ShortName;
import org.eclipse.om2m.commons.resource.AnnouncedMgmtResource;
import org.eclipse.om2m.commons.resource.AreaNwkDeviceInfoAnnc;

/**
 * Area Nwk Device Info entity - Specialization of MgmtObj
 *
 */
@Entity(name = ShortName.AREA_NWK_DEVICE_INFO_ANNC)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AreaNwkDeviceInfoAnncEntity extends MgmtObjAnncEntity {

	@Column(name = ShortName.DEV_ID)
	protected String devID;
	@Column(name = ShortName.DEV_TYPE)
	protected String devType;
	@Column(name = ShortName.AREA_NWK_ID)
	protected String areaNwkId;
	@Column(name = ShortName.SLEEP_INTERVAL)
	protected BigInteger sleepInterval;
	@Column(name = ShortName.SLEEP_DURATION)
	protected BigInteger sleepDuration;
	@Column(name = ShortName.STATUS)
	protected String status;
	@Column(name = ShortName.LIST_OF_NEIGHBORS)	
	protected List<String> listOfNeighbors;
	
	/** AccessControlPolicies linked to the MgmtObj */
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = DBEntities.ANDIA_ACP_JOIN,
			joinColumns = { @JoinColumn(name = DBEntities.ANDIA_JOIN_ID, referencedColumnName = ShortName.RESOURCE_ID) }, 
			inverseJoinColumns = { @JoinColumn(name = DBEntities.ACP_JOIN_ID, referencedColumnName = ShortName.RESOURCE_ID) }
			)
	protected List<AccessControlPolicyEntity> accessControlPolicies;
	
	/** List of DynamicAuthorizationConsultations*/
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="linkedAreaNwkDeviceInfoEntities")
	@JoinTable(
			name = DBEntities.ANDIA_DAC_JOIN,
			joinColumns = { @JoinColumn(name = DBEntities.ANDIA_JOIN_ID, referencedColumnName = ShortName.RESOURCE_ID) }, 
			inverseJoinColumns = { @JoinColumn(name = DBEntities.DAC_JOINID, referencedColumnName = ShortName.RESOURCE_ID) }
			)
	protected List<DynamicAuthorizationConsultationEntity> dynamicAuthorizationConsultations;
	
	
	// Database link to Subscriptions
	@OneToMany(fetch = FetchType.LAZY, targetEntity = SubscriptionEntity.class, mappedBy="parentAndi")
	@JoinTable(
			name = DBEntities.ANDIA_SUB_JOIN,
			joinColumns = { @JoinColumn(name = DBEntities.ANDIA_JOIN_ID, referencedColumnName = ShortName.RESOURCE_ID) }, 
			inverseJoinColumns = { @JoinColumn(name = DBEntities.SUB_JOIN_ID, referencedColumnName = ShortName.RESOURCE_ID) }
			)
	protected List<SubscriptionEntity> subscriptions;	
	
	// Database link to Node
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = NodeEntity.class)
	@JoinTable(
			name = DBEntities.ANDIA_NOD_JOIN,
			joinColumns = { @JoinColumn(name = DBEntities.ANDIA_JOIN_ID, referencedColumnName = ShortName.RESOURCE_ID) }, 
			inverseJoinColumns = { @JoinColumn(name = DBEntities.NOD_JOIN_ID, referencedColumnName = ShortName.RESOURCE_ID) }
			)
	protected NodeAnncEntity parentNode;

	public AreaNwkDeviceInfoAnncEntity() {
		this.mgmtDefinition = MgmtDefinitionTypes.AREA_NWK_DEVICE_INFO;
	}
	
	/**
	 * @return the devID
	 */
	public String getDevID() {
		return devID;
	}

	/**
	 * @param devID the devID to set
	 */
	public void setDevID(String devID) {
		this.devID = devID;
	}

	/**
	 * @return the devType
	 */
	public String getDevType() {
		return devType;
	}

	/**
	 * @param devType the devType to set
	 */
	public void setDevType(String devType) {
		this.devType = devType;
	}

	/**
	 * @return the areaNwkId
	 */
	public String getAreaNwkId() {
		return areaNwkId;
	}

	/**
	 * @param areaNwkId the areaNwkId to set
	 */
	public void setAreaNwkId(String areaNwkId) {
		this.areaNwkId = areaNwkId;
	}

	/**
	 * @return the sleepInterval
	 */
	public BigInteger getSleepInterval() {
		return sleepInterval;
	}

	/**
	 * @param sleepInterval the sleepInterval to set
	 */
	public void setSleepInterval(BigInteger sleepInterval) {
		this.sleepInterval = sleepInterval;
	}

	/**
	 * @return the sleepDuration
	 */
	public BigInteger getSleepDuration() {
		return sleepDuration;
	}

	/**
	 * @param sleepDuration the sleepDuration to set
	 */
	public void setSleepDuration(BigInteger sleepDuration) {
		this.sleepDuration = sleepDuration;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the listOfNeighbors
	 */
	public List<String> getListOfNeighbors() {
		if (this.listOfNeighbors == null) {
			this.listOfNeighbors = new ArrayList<>();
		}
		return listOfNeighbors;
	}

	/**
	 * @param listOfNeighbors the listOfNeighbors to set
	 */
	public void setListOfNeighbors(List<String> listOfNeighbors) {
		this.listOfNeighbors = listOfNeighbors;
	}

	/**
	 * @return the subscriptions
	 */
	public List<SubscriptionEntity> getSubscriptions() {
		if (this.subscriptions == null) {
			this.subscriptions = new ArrayList<>();
		}
		return subscriptions;
	}

	/**
	 * @param subscriptions the subscriptions to set
	 */
	public void setSubscriptions(List<SubscriptionEntity> subscriptions) {
		this.subscriptions = subscriptions;
	}

	/**
	 * @return the parentNode
	 */
	public NodeAnncEntity getParentNode() {
		return parentNode;
	}

	/**
	 * @param parentNode the parentNode to set
	 */
	public void setParentNode(NodeAnncEntity parentNode) {
		this.parentNode = parentNode;
	}
	
	/**
	 * @return the acps
	 */
	public List<AccessControlPolicyEntity> getAccessControlPolicies() {
		if (this.accessControlPolicies == null) {
			this.accessControlPolicies = new ArrayList<>();
		}
		return accessControlPolicies;
	}

	/**
	 * @param acps the acps to set
	 */
	public void setAccessControlPolicies(List<AccessControlPolicyEntity> acps) {
		this.accessControlPolicies = acps;
	}	
	
	
	@Override
	public List<DynamicAuthorizationConsultationEntity> getDynamicAuthorizationConsultations() {
		if (this.dynamicAuthorizationConsultations == null) {
			this.dynamicAuthorizationConsultations = new ArrayList<>();
		}
		return dynamicAuthorizationConsultations;
	}
	
	@Override
	public void setDynamicAuthorizationConsultations(List<DynamicAuthorizationConsultationEntity> list) {
		this.dynamicAuthorizationConsultations = list;
	}

	@Override
	public void fillFrom(AnnouncedMgmtResource mgmtObj) {
		super.fillFrom(mgmtObj);
		AreaNwkDeviceInfoAnnc andi = (AreaNwkDeviceInfoAnnc) mgmtObj;
		this.devID = andi.getDevID();
		this.devType = andi.getDevType();
		this.areaNwkId = andi.getAreaNwkId();
		this.sleepDuration = andi.getSleepDuration();
		this.sleepInterval = andi.getSleepInterval();
		this.status = andi.getStatus();
		this.listOfNeighbors = andi.getListOfNeighbors();
	}
	
}
