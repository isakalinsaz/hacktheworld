package com.sample.concurrent.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KPIValueObject {
	
	private static final Logger logger = LoggerFactory
			.getLogger(KPIValueObject.class);

	/** enum for repeat values, represents periods of Last variables */
	public static final int PERIOD_FIVE_MIN = 5;
	public static final int PERIOD_SIXTY_MIN = 60;

	/** 5 minute intervals are maintained */
	public static final int interval = 5;

	/** Average value for the current hour */
	private long currentHourAverage;

	/** Value of current 5 minutes */
	private long value5;

	/** Value of current hour */
	private long value60;

	/** Value of last 5 minutes */
	private long valueLast5;

	/** Value of last hour */
	private long valueLast60;

	/** ID of the KPI */
	private int id;

	/** which service this KPI belongs to */
	private int serviceId;

	/** Resource of the KPI */
	private String resource;

	/** Type of KPIs [INCREMENTAL, MIN, MAX] */
	private KpiMinMaxTypes kpiMinMaxType;

	/** Average value for the next hour */
	private long nextHourAverage;

	public long getNextHourAverage() {
		return nextHourAverage;
	}

	public void setNextHourAverage(long nextHourAverage) {
		this.nextHourAverage = nextHourAverage;
	}

	public long getCurrentHourAverage() {
		return currentHourAverage;
	}

	public void setCurrentHourAverage(long currentHourAverage) {
		this.currentHourAverage = currentHourAverage;
	}

	public long getValue5() {
		return value5;
	}

	public void setValue5(long value5) {
		this.value5 = value5;
	}

	public long getValue60() {
		return value60;
	}

	public void setValue60(long value60) {
		this.value60 = value60;
	}

	public long getValueLast5() {
		return valueLast5;
	}

	public void setValueLast5(long valueLast5) {
		this.valueLast5 = valueLast5;
	}

	public long getValueLast60() {
		return valueLast60;
	}

	public void setValueLast60(long valueLast60) {
		this.valueLast60 = valueLast60;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public KpiMinMaxTypes getKpiMinMaxType() {
		return kpiMinMaxType;
	}

	public void setKpiMinMaxType(KpiMinMaxTypes kpiMinMaxType) {
		this.kpiMinMaxType = kpiMinMaxType;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "KPI Id:"+id+" - Kpi Value:"+valueLast5+" - MinMax Type:"+kpiMinMaxType+" - Resource:"+resource;
	}
}
