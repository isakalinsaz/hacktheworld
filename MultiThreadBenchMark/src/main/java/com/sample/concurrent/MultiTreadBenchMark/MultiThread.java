package com.sample.concurrent.MultiTreadBenchMark;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.concurrent.model.KPIManager;
import com.sample.concurrent.model.KPIResourceObject;
import com.sample.concurrent.model.KPIValueObject;
import com.sample.concurrent.model.KpiMinMaxTypes;

public class MultiThread extends Thread {

	private static Logger logger = LoggerFactory.getLogger(MultiThread.class);

	public MultiThread(String threadName) {
		super(threadName);
		logger.info("Threads are created : " + this);
	}

	@Override
	public void run() {
		logger.debug("INITIALIZITION STARTED!!!"
				+ new Date(System.currentTimeMillis()));
		initializeServiceKpiList();
	}

	private KPIValueObject[] initializeValueObject() {

		KPIValueObject[] kpiValueObject = new KPIValueObject[80];

		for (int i = 0; i < 80; i++) {

			KPIValueObject value = new KPIValueObject();

			Random randKpiValue = new Random();
			value.setId(i);
			value.setServiceId(31);

			int kpiType = randKpiValue.nextInt(3) + 0;
			value.setKpiMinMaxType(KpiMinMaxTypes.getKpiMinMaxType(kpiType));

			String resource = UUID.randomUUID().toString().substring(0, 16);
			value.setResource(resource);

			value.setValue5(0);
			value.setValue60(0);
			long valueLast5 = randKpiValue.nextInt(100000) + 0;
			long valueLast60 = randKpiValue.nextInt(100000) + 0;
			value.setValueLast5(valueLast5);
			value.setValue60(valueLast60);

			//logger.info(value.toString());

			kpiValueObject[i] = value;
		}

		return kpiValueObject;
	}

	private HashMap<String, KPIResourceObject> initializeResourceObject() {

		HashMap<String, KPIResourceObject> kpiResourceObjectMap = new HashMap<String, KPIResourceObject>();

		for (int k = 0; k < 100; k++) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < 5; i++) {
				String resource = UUID.randomUUID().toString().substring(0, 16);
				builder.append(resource
						+ KPIResourceObject.RESOURCE_ID_DELIMITER);
			}
			KPIResourceObject resource = new KPIResourceObject(80,
					builder.toString(), builder.toString().getBytes()[0]);

			KPIValueObject[] kpiValueObjects = initializeValueObject();

			for (int i = 0; i < kpiValueObjects.length; i++) {
				resource.getKpiTable()[i] = kpiValueObjects[i];
			}

			logger.debug("Resources :" + builder.toString());

			kpiResourceObjectMap.put(builder.toString(), resource);
		}

		return kpiResourceObjectMap;
	}

	private KPIManager initializeKpiTableForResourceType() {
		HashMap<Byte, HashMap<String, KPIResourceObject>> kpiTableForResourceType = new HashMap<Byte, HashMap<String, KPIResourceObject>>();

		for (byte i = 49; i <= 54; i++) {
			HashMap<String, KPIResourceObject> kpiResourceObjectMap = initializeResourceObject();
			kpiTableForResourceType.put(i, kpiResourceObjectMap);
		}

		KPIManager manager = new KPIManager();
		manager.setKpiResourceTables(kpiTableForResourceType);

		return manager;
	}

	void initializeServiceKpiList() {
		HashMap<Integer, KPIManager> kpiManagerServiceIdMap = new HashMap<Integer, KPIManager>();
		for (int i = 31; i <= 40; i++) {
			KPIManager kpiManager = initializeKpiTableForResourceType();
			kpiManagerServiceIdMap.put(i, kpiManager);
		}
		logger.debug("INITIALIZITION DONE!!!"
				+ new Date(System.currentTimeMillis()));
	}
}
