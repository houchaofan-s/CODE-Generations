package com.hhcc.modules.common.utils.core.tool.constant;

public class SystemConstant {
    private boolean devMode = false;
    private boolean remoteMode = false;
    private String domain = "http://localhost:8888";
    private String remotePath = System.getProperty("user.dir") + "/target/blade";
    private String uploadPath = "/upload";
    private String downloadPath = "/download";
    private boolean compress = false;
    private Double compressScale = 2.0;
    private boolean compressFlag = false;
    private String realPath = System.getProperty("user.dir");
    private String contextPath = "/";
    private static final SystemConstant ME = new SystemConstant();

    public static SystemConstant me() {
        return ME;
    }

    public String getUploadRealPath() {
        return (this.remoteMode ? this.remotePath : this.realPath) + this.uploadPath;
    }

    public String getUploadCtxPath() {
        return this.contextPath + this.uploadPath;
    }

    public boolean isDevMode() {
        return this.devMode;
    }

    public boolean isRemoteMode() {
        return this.remoteMode;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getRemotePath() {
        return this.remotePath;
    }

    public String getUploadPath() {
        return this.uploadPath;
    }

    public String getDownloadPath() {
        return this.downloadPath;
    }

    public boolean isCompress() {
        return this.compress;
    }

    public Double getCompressScale() {
        return this.compressScale;
    }

    public boolean isCompressFlag() {
        return this.compressFlag;
    }

    public String getRealPath() {
        return this.realPath;
    }

    public String getContextPath() {
        return this.contextPath;
    }

    public void setDevMode(final boolean devMode) {
        this.devMode = devMode;
    }

    public void setRemoteMode(final boolean remoteMode) {
        this.remoteMode = remoteMode;
    }

    public void setDomain(final String domain) {
        this.domain = domain;
    }

    public void setRemotePath(final String remotePath) {
        this.remotePath = remotePath;
    }

    public void setUploadPath(final String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public void setDownloadPath(final String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public void setCompress(final boolean compress) {
        this.compress = compress;
    }

    public void setCompressScale(final Double compressScale) {
        this.compressScale = compressScale;
    }

    public void setCompressFlag(final boolean compressFlag) {
        this.compressFlag = compressFlag;
    }

    public void setRealPath(final String realPath) {
        this.realPath = realPath;
    }

    public void setContextPath(final String contextPath) {
        this.contextPath = contextPath;
    }
}
