package boot.backend.mongo.pojo;

import java.util.List;

import boot.backend.mongo.health.CheckServerStatusService;
import boot.backend.mongo.logic.Utils;

public class ServerStatus {

	private final String serverDate;
	private final String serverName;
	private final String serverProvider;
	private final String appVersion;
	private final String appName;
	private final String appOwner;
	private final String appOwnerEmail;
	private final String appGoal;
	private final String message;
	private final Health health;

	public ServerStatus() {
		this.serverDate = Utils.getTimeZoneOfServer();
		this.serverName = "HerokuBootMongoJSR100";
		this.serverProvider = "Heroku";
		this.appVersion = "v1";
		this.appName = "JSR 100 Boot-Mongo";
		this.appOwner = "skbh";
		this.appOwnerEmail = "xorasysgen@yahoo.com";
		this.appGoal = "F&O equity analysis platform - The Trading & Investing Engine that simplify trades";
		this.message = "JSR100 Boot-Mongo Micro Service is Running Ok.200";
		List<Long> jvmMemoryList=CheckServerStatusService.getSimpleJVMMemoryDetail();
		Health health=new Health();
			health.setUsedHeapSizeMemory(jvmMemoryList.get(0));
			health.setFreeHeapSizeMemory(jvmMemoryList.get(1));
			health.setTotalHeapHeapSizeMemory(jvmMemoryList.get(2));
			health.setMaximumHeapHeapSizeMemory(jvmMemoryList.get(3));
			this.health=health;
	}

	public String getServerDate() {
		return serverDate;
	}

	public String getServerName() {
		return serverName;
	}

	public String getServerProvider() {
		return serverProvider;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public String getAppName() {
		return appName;
	}

	public String getAppOwner() {
		return appOwner;
	}

	public String getAppOwnerEmail() {
		return appOwnerEmail;
	}

	public String getAppGoal() {
		return appGoal;
	}

	public String getMessage() {
		return message;
	}

	public Health getHealth() {
		return health;
	}
	
	

}
