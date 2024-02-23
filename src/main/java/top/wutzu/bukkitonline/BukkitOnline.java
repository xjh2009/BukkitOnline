package top.wutzu.bukkitonline;

import com.sun.net.httpserver.HttpServer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.logging.Logger;

public final class BukkitOnline extends JavaPlugin {
    public static FileConfiguration config;
    public static HttpServer httpServer;
    public static Logger logger;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("BukkitOnline插件加载中");
        config = getConfig();
        logger = getLogger();
        getLogger().info("加载配置中");
        if (!new File("./plugins/BukkitOnline/config.yml").exists()){
            getLogger().info("未检测到配置文件，将加载默认配置");
            this.saveDefaultConfig();
        }
        getLogger().info("加载配置完成");
        new Thread(new BukkitRunnable(){
            @Override
            public void run(){
                try {
                    httpServer = HttpServer.create(new InetSocketAddress(BukkitOnline.config.getString("HttpPort")),100);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                httpServer.createContext("/",new Index());
                httpServer.createContext("/main.css",new MainCSS());
                httpServer.start();
            }
        }).start();
        getLogger().info("开启http服务成功，端口"+BukkitOnline.config.getString("HttpPort"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("卸载BukkitOnline中");
        httpServer.stop(3);
        getLogger().info("http服务已关闭");
    }
}
