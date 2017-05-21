
package aiss.model.google.drive.about;

import java.util.List;

public class About {

    private String kind;
    private String etag;
    private String selfLink;
    private String name;
    private User user;
    private String quotaBytesTotal;
    private String quotaBytesUsed;
    private String quotaBytesUsedAggregate;
    private String quotaBytesUsedInTrash;
    private String quotaType;
    private List<QuotaBytesByService> quotaBytesByService = null;
    private String largestChangeId;
    private String rootFolderId;
    private String domainSharingPolicy;
    private String permissionId;
    private List<ImportFormat> importFormats = null;
    private List<ExportFormat> exportFormats = null;
    private List<AdditionalRoleInfo> additionalRoleInfo = null;
    private List<Feature> features = null;
    private List<MaxUploadSize> maxUploadSizes = null;
    private Boolean isCurrentAppInstalled;
    private String languageCode;
    private List<String> folderColorPalette = null;
    private List<TeamDriveTheme> teamDriveThemes = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getQuotaBytesTotal() {
        return quotaBytesTotal;
    }

    public void setQuotaBytesTotal(String quotaBytesTotal) {
        this.quotaBytesTotal = quotaBytesTotal;
    }

    public String getQuotaBytesUsed() {
        return quotaBytesUsed;
    }

    public void setQuotaBytesUsed(String quotaBytesUsed) {
        this.quotaBytesUsed = quotaBytesUsed;
    }

    public String getQuotaBytesUsedAggregate() {
        return quotaBytesUsedAggregate;
    }

    public void setQuotaBytesUsedAggregate(String quotaBytesUsedAggregate) {
        this.quotaBytesUsedAggregate = quotaBytesUsedAggregate;
    }

    public String getQuotaBytesUsedInTrash() {
        return quotaBytesUsedInTrash;
    }

    public void setQuotaBytesUsedInTrash(String quotaBytesUsedInTrash) {
        this.quotaBytesUsedInTrash = quotaBytesUsedInTrash;
    }

    public String getQuotaType() {
        return quotaType;
    }

    public void setQuotaType(String quotaType) {
        this.quotaType = quotaType;
    }

    public List<QuotaBytesByService> getQuotaBytesByService() {
        return quotaBytesByService;
    }

    public void setQuotaBytesByService(List<QuotaBytesByService> quotaBytesByService) {
        this.quotaBytesByService = quotaBytesByService;
    }

    public String getLargestChangeId() {
        return largestChangeId;
    }

    public void setLargestChangeId(String largestChangeId) {
        this.largestChangeId = largestChangeId;
    }

    public String getRootFolderId() {
        return rootFolderId;
    }

    public void setRootFolderId(String rootFolderId) {
        this.rootFolderId = rootFolderId;
    }

    public String getDomainSharingPolicy() {
        return domainSharingPolicy;
    }

    public void setDomainSharingPolicy(String domainSharingPolicy) {
        this.domainSharingPolicy = domainSharingPolicy;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public List<ImportFormat> getImportFormats() {
        return importFormats;
    }

    public void setImportFormats(List<ImportFormat> importFormats) {
        this.importFormats = importFormats;
    }

    public List<ExportFormat> getExportFormats() {
        return exportFormats;
    }

    public void setExportFormats(List<ExportFormat> exportFormats) {
        this.exportFormats = exportFormats;
    }

    public List<AdditionalRoleInfo> getAdditionalRoleInfo() {
        return additionalRoleInfo;
    }

    public void setAdditionalRoleInfo(List<AdditionalRoleInfo> additionalRoleInfo) {
        this.additionalRoleInfo = additionalRoleInfo;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<MaxUploadSize> getMaxUploadSizes() {
        return maxUploadSizes;
    }

    public void setMaxUploadSizes(List<MaxUploadSize> maxUploadSizes) {
        this.maxUploadSizes = maxUploadSizes;
    }

    public Boolean getIsCurrentAppInstalled() {
        return isCurrentAppInstalled;
    }

    public void setIsCurrentAppInstalled(Boolean isCurrentAppInstalled) {
        this.isCurrentAppInstalled = isCurrentAppInstalled;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public List<String> getFolderColorPalette() {
        return folderColorPalette;
    }

    public void setFolderColorPalette(List<String> folderColorPalette) {
        this.folderColorPalette = folderColorPalette;
    }

    public List<TeamDriveTheme> getTeamDriveThemes() {
        return teamDriveThemes;
    }

    public void setTeamDriveThemes(List<TeamDriveTheme> teamDriveThemes) {
        this.teamDriveThemes = teamDriveThemes;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "About [kind=" + kind + ", etag=" + etag + ", selfLink=" + selfLink + ", name=" + name + ", user=" + user
				+ ", quotaBytesTotal=" + quotaBytesTotal + ", quotaBytesUsed=" + quotaBytesUsed
				+ ", quotaBytesUsedAggregate=" + quotaBytesUsedAggregate + ", quotaBytesUsedInTrash="
				+ quotaBytesUsedInTrash + ", quotaType=" + quotaType + ", quotaBytesByService=" + quotaBytesByService
				+ ", largestChangeId=" + largestChangeId + ", rootFolderId=" + rootFolderId + ", domainSharingPolicy="
				+ domainSharingPolicy + ", permissionId=" + permissionId + ", importFormats=" + importFormats
				+ ", exportFormats=" + exportFormats + ", additionalRoleInfo=" + additionalRoleInfo + ", features="
				+ features + ", maxUploadSizes=" + maxUploadSizes + ", isCurrentAppInstalled=" + isCurrentAppInstalled
				+ ", languageCode=" + languageCode + ", folderColorPalette=" + folderColorPalette + ", teamDriveThemes="
				+ teamDriveThemes + "]";
	}

}
