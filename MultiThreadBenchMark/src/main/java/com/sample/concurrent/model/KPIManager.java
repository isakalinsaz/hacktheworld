package com.sample.concurrent.model;

import java.util.HashMap;

public class KPIManager {

	private HashMap<Byte, HashMap<String, KPIResourceObject>> kpiResourceTables;

	public KPIManager() {
		kpiResourceTables = new HashMap<Byte, HashMap<String, KPIResourceObject>>();
	}

	public HashMap<Byte, HashMap<String, KPIResourceObject>> getKpiResourceTables() {
		return kpiResourceTables;
	}

	public void setKpiResourceTables(
			HashMap<Byte, HashMap<String, KPIResourceObject>> kpiResourceTables) {
		this.kpiResourceTables = kpiResourceTables;
	}
}
