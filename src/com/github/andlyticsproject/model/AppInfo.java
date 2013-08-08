package com.github.andlyticsproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppInfo {

	private String account;

	private String packageName;

	private Date lastUpdate;

	private String name;

	private String iconUrl;

	private List<AppStats> history = new ArrayList<AppStats>();

	private AppStats latestStats;

	// TODO -- make this an enum? Currently not used
	private int publishState;

	private String versionName;

	private AppDetails details;

	private String developerId;
	private String developerName;
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public String getIconName() {
		String iconName = packageName;
		if (iconUrl != null) {
			int slash = iconUrl.lastIndexOf('/');
			if (slash > -1) {
				iconName = iconUrl.substring(slash + 1, iconUrl.length());
			}
		}

		return iconName;
	}

	public void setHistory(List<AppStats> history) {
		this.history = history;
	}

	public List<AppStats> getHistory() {
		return history;
	}

	public void addToHistory(AppStats stats) {
		history.add(stats);
	}

	public void setLatestStats(AppStats latestStats) {
		this.latestStats = latestStats;
	}

	public AppStats getLatestStats() {
		return latestStats;
	}
	
	public int getPublishState() {
		return publishState;
	}

	public void setPublishState(int publishState) {
		this.publishState = publishState;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getVersionName() {
		return versionName;
	}
	
	public AppDetails getDetails() {
		return details;
	}

	public void setDetails(AppDetails details) {
		this.details = details;
	}

	public String getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(String developerId) {
		this.developerId = developerId;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	// XXX -- do we need to compare everything? 
	// an app should be uniquely identified by the package name alone
	// (this is enforced by the Play Store)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((developerId == null) ? 0 : account.hashCode());
		result = prime * result + ((history == null) ? 0 : history.hashCode());
		result = prime * result + ((iconUrl == null) ? 0 : iconUrl.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((latestStats == null) ? 0 : latestStats.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((packageName == null) ? 0 : packageName.hashCode());
		return result;
	}

	// XXX -- do we need to compare everything? 
	// an app should be uniquely identified by the package name alone
	// (this is enforced by the Play Store)
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppInfo other = (AppInfo) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (developerId == null) {
			if (other.developerId != null)
				return false;
		} else if (!developerId.equals(other.developerId))
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		if (iconUrl == null) {
			if (other.iconUrl != null)
				return false;
		} else if (!iconUrl.equals(other.iconUrl))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (latestStats == null) {
			if (other.latestStats != null)
				return false;
		} else if (!latestStats.equals(other.latestStats))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (packageName == null) {
			if (other.packageName != null)
				return false;
		} else if (!packageName.equals(other.packageName))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return String.format("AppInfo [account=%s, developerId=%s, packageName=%s]", account,
				developerId, packageName);
	}

	public boolean isIncomplete() {
		return name == null || versionName == null || iconUrl == null;
	}

}
