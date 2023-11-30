package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.ContextConfig;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        String contextPath = "/myapp";
        String appBase = ".";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.setHostname("localhost");
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp(contextPath, appBase);

        Context ctx = tomcat.addContext("", new File(".").getAbsolutePath());
        ctx.addLifecycleListener(new ContextConfig());
        final WebResourceRoot root = new StandardRoot(ctx);
        final URL url = findClassLocation(Main.class);
        root.createWebResourceSet(WebResourceRoot.ResourceSetType.PRE, "/WEB-INF/classes", url, "/");
        ctx.setResources(root);

        tomcat.getConnector();
        tomcat.start();
        tomcat.getServer().await();
    }

    private static URL findClassLocation(Class<?> clazz) {
        return clazz.getProtectionDomain().getCodeSource().getLocation();
    }
}