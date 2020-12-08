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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.eclipse.om2m.commons.constants.DBEntities;
import org.eclipse.om2m.commons.constants.ShortName;

/**
 * Access Control Originator JPA Entity
 *
 */
@Entity(name=DBEntities.ACCESSCONTROLORIGINATOR_ENTITY)
public class AccessControlOriginatorEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name= ShortName.ORIGINATOR)
	protected String originatorID;

	public AccessControlOriginatorEntity() {	
	}
	
	public AccessControlOriginatorEntity(String originatorID){
		this.originatorID = originatorID;
	}
	
	/**
	 * @param originatorID the originatorID to set
	 */
	public void setOriginatorID(String originatorID) {
		this.originatorID = originatorID;
	}

	/**
	 * @return the originatorID
	 */
	public String getOriginatorID() {
		return originatorID;
	}
	
	

}
