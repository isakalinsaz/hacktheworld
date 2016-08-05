package com.sample.concurrent.model;

import java.util.Arrays;
import java.util.List;

public class KPIResourceObject {

	public static final String RESOURCE_ID_DELIMITER = "##";
	private KPIValueObject[] kpiTable = null;
	private String resourceId;
	private List<String> resourceIdList;
	private byte resourceType;

	@Override
	public String toString() {
		return "";
	}

	public KPIResourceObject(int noOfKPIs, String resourceId, byte resourceType) {
		this.kpiTable = new KPIValueObject[noOfKPIs];
		this.resourceId = resourceId;
		this.resourceType = resourceType;
		this.resourceIdList = Arrays.asList(resourceId
				.split(RESOURCE_ID_DELIMITER));
	}

	public KPIValueObject[] getKpiTable() {
		return kpiTable;
	}

	public String getResourceId() {
		return resourceId;
	}

	public byte getResourceType() {
		return resourceType;
	}

	public List<String> getResourceIdList() {
		return resourceIdList;
	}

	public int getDimension() {
		return resourceIdList.size();
	}

}
