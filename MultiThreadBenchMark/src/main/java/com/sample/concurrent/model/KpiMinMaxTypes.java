package com.sample.concurrent.model;

public enum KpiMinMaxTypes {

	INCREMENTAL(0), MIN(1), MAX(2);

	private int value;

	private KpiMinMaxTypes(int value) {
		this.value = value;
	}

	@Override
	public String toString() {

		if (this.equals(INCREMENTAL)) {
			return "Incremental Kpi";
		} else if (this.equals(MIN)) {
			return "Min Kpi";
		} else if (this.equals(MAX)) {
			return "Max Kpi";
		}
		return "ERROR KPI Sub TYPE";
	}

	public static KpiMinMaxTypes getKpiMinMaxType(int id) {
		for (KpiMinMaxTypes type : values()) {
			if (type.getValue() == id) {
				return type;
			}
		}
		throw new IllegalArgumentException("Invalid Kpi Type id: " + id);
	}

	public int getValue() {
		return value;
	}

}
