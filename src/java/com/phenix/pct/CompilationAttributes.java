package com.phenix.pct;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.ResourceCollection;

public class CompilationAttributes implements ICompilationAttributes {
    private List<ResourceCollection> resources = new ArrayList<ResourceCollection>();
    private File destDir = null;
    private File xRefDir = null;
    private File preprocessDir = null;
    private File debugListingDir = null;
    private boolean minSize = false;
    private boolean md5 = true;
    private boolean forceCompile = false;
    private boolean xcode = false;
    private boolean runList = false;
    private boolean listing = false;
    private String listingSource = null;
    private boolean preprocess = false;
    private boolean debugListing = false;
    private boolean keepXref = false;
    private boolean noParse = false;
    private boolean multiCompile = false;
    private boolean streamIO = false;
    private boolean v6Frame = false;
    private boolean stringXref = false;
    private boolean appendStringXref = false;
    private boolean saveR = true;
    private boolean stopOnError = false;
    private boolean xmlXref = false;
    private boolean requireFullKeywords = false;
    private boolean requireFieldQualifiers = false;
    private boolean requireFullNames = false;
    private String xcodeKey = null;
    private String languages = null;
    private int growthFactor = -1;
    private int progPerc = 0;
    private boolean flattenDbg = true;
    private String ignoredIncludes = null;

    // Internal use
    private Project project;

    public CompilationAttributes(Project project) {
        this.project = project;
    }

    @Override
    public void setMinSize(boolean minSize) {
        this.minSize = minSize;
    }

    @Override
    public void setStringXref(boolean stringXref) {
        this.stringXref = stringXref;
    }

    @Override
    public void setAppendStringXref(boolean appendStringXref) {
        this.appendStringXref = appendStringXref;
    }

    @Override
    public void setSaveR(boolean saveR) {
        this.saveR = saveR;
    }

    @Override
    public void setForceCompile(boolean forceCompile) {
        this.forceCompile = forceCompile;
    }

    @Override
    public void setListing(boolean listing) {
        this.listing = listing;
    }

    @Override
    public void setListingSource(String source) {
        if ((source == null) || (source.trim().length() == 0) || ("preprocessor".equalsIgnoreCase(source.trim())))
            this.listingSource = source;
        else
            throw new BuildException("Invalid listingSource attribute : " + source);
    }

    @Override
    public void setIgnoredIncludes(String pattern) {
        this.ignoredIncludes = pattern;
    }

    @Override
    public void setPreprocess(boolean preprocess) {
        this.preprocess = preprocess;
    }

    @Override
    public void setPreprocessDir(File dir) {
        this.preprocess = true;
        this.preprocessDir = dir;
    }

    @Override
    public void setDebugListing(boolean debugListing) {
        this.debugListing = debugListing;
    }

    @Override
    public void setDebugListingDir(File debugListingDir) {
        this.debugListing = true;
        this.debugListingDir = debugListingDir;
    }

    @Override
    public void setFlattenDebugListing(boolean flatten) {
        this.flattenDbg = flatten;
    }

    @Override
    public void setNoXref(boolean noXref) {
        this.forceCompile = noXref;
    }

    @Override
    public void setNoParse(boolean noParse) {
        this.noParse = noParse;
    }

    @Override
    public void setMultiCompile(boolean multiCompile) {
        this.multiCompile = multiCompile;
    }

    @Override
    public void setStreamIO(boolean streamIO) {
        this.streamIO = streamIO;
    }

    @Override
    public void setv6Frame(boolean v6Frame) {
        this.v6Frame = v6Frame;
    }

    @Override
    public void setKeepXref(boolean keepXref) {
        this.keepXref = keepXref;
    }

    @Override
    public void setXmlXref(boolean xmlXref) {
        this.xmlXref = xmlXref;
    }

    @Override
    public void setXRefDir(File xrefDir) {
        this.xRefDir = xrefDir;
    }

    @Override
    public void setMD5(boolean md5) {
        this.md5 = md5;
    }

    @Override
    public void setRunList(boolean runList) {
        this.runList = runList;
    }

    @Override
    public void setDestDir(File destDir) {
        this.destDir = destDir;
    }

    @Override
    public void setXCode(boolean xcode) {
        this.xcode = xcode;
    }

    @Override
    public void setXCodeKey(String xcodeKey) {
        this.xcodeKey = xcodeKey;
    }

    @Override
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @Override
    public void setTextGrowth(int growthFactor) {
        this.growthFactor = growthFactor;
    }

    @Override
    public void setProgPerc(int progPerc) {
        this.progPerc = progPerc;
    }

    @Override
    public void setRequireFullKeywords(boolean requireFullKeywords) {
        this.requireFullKeywords = requireFullKeywords;
    }

    @Override
    public void setRequireFieldQualifiers(boolean requireFieldQualifiers) {
        this.requireFieldQualifiers = requireFieldQualifiers;
    }

    @Override
    public void setRequireFullNames(boolean requireFullNames) {
        this.requireFullNames = requireFullNames;
    }

    @Override
    public void setStopOnError(boolean stopOnError) {
        this.stopOnError = stopOnError;
    }

    @Override
    public void add(ResourceCollection rc) {
        resources.add(rc);
    }

    @Override
    public void addConfiguredOEFileset(OpenEdgeFileSet oefs) {
        resources.add(oefs.getCompilationFileSet(project));
    }

    public List<ResourceCollection> getResources() {
        return resources;
    }

    public boolean isMinSize() {
        return minSize;
    }

    public boolean isMd5() {
        return md5;
    }

    public boolean isForceCompile() {
        return forceCompile;
    }

    public boolean isXcode() {
        return xcode;
    }

    public boolean isRunList() {
        return runList;
    }

    public boolean isListing() {
        return listing;
    }

    public String getListingSource() {
        return listingSource;
    }

    public boolean isPreprocess() {
        return preprocess;
    }

    public boolean isDebugListing() {
        return debugListing;
    }

    public boolean isKeepXref() {
        return keepXref;
    }

    public boolean isNoParse() {
        return noParse;
    }

    public boolean isMultiCompile() {
        return multiCompile;
    }

    public boolean isStreamIO() {
        return streamIO;
    }

    public boolean isV6Frame() {
        return v6Frame;
    }

    public boolean isStringXref() {
        return stringXref;
    }

    public boolean isAppendStringXref() {
        return appendStringXref;
    }

    public boolean isSaveR() {
        return saveR;
    }

    public boolean isStopOnError() {
        return stopOnError;
    }

    public boolean isXmlXref() {
        return xmlXref;
    }

    public boolean isRequireFullKeywords() {
        return requireFullKeywords;
    }

    public boolean isRequireFieldQualifiers() {
        return requireFieldQualifiers;
    }

    public boolean isRequireFullNames() {
        return requireFullNames;
    }

    public String getXcodeKey() {
        return xcodeKey;
    }

    public String getLanguages() {
        return languages;
    }

    public int getGrowthFactor() {
        return growthFactor;
    }

    public File getDestDir() {
        return destDir;
    }

    public File getxRefDir() {
        return xRefDir;
    }

    public int getProgPerc() {
        return progPerc;
    }

    public File getPreprocessDir() {
        return preprocessDir;
    }

    public File getDebugListingDir() {
        return debugListingDir;
    }

    public boolean isFlattenDbg() {
        return flattenDbg;
    }

    public String getIgnoredIncludes() {
        return ignoredIncludes;
    }

}
