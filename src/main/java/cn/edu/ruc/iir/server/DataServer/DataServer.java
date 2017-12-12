package cn.edu.ruc.iir.server.DataServer;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class DataServer {

    private Server server;
    private static int port = 8080;

    public void setPort(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        server = new Server(port);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setWar("E:\\ruc_projects\\github_t\\JaxRsExample\\target\\jaxrsexample.war");
        webAppContext.setParentLoaderPriority(true);
        webAppContext.setServer(server);
        webAppContext.setClassLoader(ClassLoader.getSystemClassLoader());
        webAppContext.getSessionHandler().getSessionManager()
                .setMaxInactiveInterval(10);
        server.setHandler(webAppContext);
        server.start();
    }

    public static void main(String[] args) throws Exception {
        DataServer dataServer = new DataServer();
        dataServer.start();
    }

}
