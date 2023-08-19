package top.wutzu.bukkitonline;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
public class Index implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String playerListString = "";
        BukkitOnline.logger.info(httpExchange.getRemoteAddress().getHostName() + httpExchange.getRequestHeaders().getFirst("User-Agent"));
        if(Bukkit.getServer().getOnlinePlayers().size()!=0){
            for (Player player: Bukkit.getServer().getOnlinePlayers()){
                playerListString = playerListString + player.getDisplayName() + "<br>";
            }
        }
        double playerPer = (double) Bukkit.getOnlinePlayers().size() / Bukkit.getMaxPlayers();
        String page = "\n" +
                "<!-- saved from url=(0016)https://seir.in/ -->\n" +
                "<html lang=\"zh-CN\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "    \n" +
                "    <title>{ServerName}</title>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/gh/AyagawaSeirin/homepage@latest/mdui/css/mdui.min.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"./main.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://seir.in/assets/css/index.css\">\n" +
                "    <!-- <link rel=\"stylesheet\" href=\"/assets/css/detaile.css\"> -->\n" +
                "    <link rel=\"stylesheet\" href=\"https://at.alicdn.com/t/font_1625701_q2422cy34wn.css\">\n" +
                "    <link rel=\"icon\" href=\"https://seir.in/assets/img/logo-circul-100.png\">\n" +
                "    <!-- Global site tag (gtag.js) - Google Analytics -->\n" +
                "    <script type=\"text/javascript\" async=\"\" src=\"https://www.google-analytics.com/analytics.js\"></script>\n" +
                "    <script type=\"text/javascript\" async=\"\" src=\"https://www.googletagmanager.com/gtag/js?id=G-363RTB0YDC&amp;l=dataLayer&amp;cx=c\"></script>\n" +
                "    <script async=\"\" src=\"https://www.googletagmanager.com/gtag/js?id=UA-162013750-5\"></script>\n" +
                "\n" +
                "</head>\n" +
                "<body class=\"mdui-theme-primary-pink mdui-theme-accent-pink mdui-loaded\">\n" +
                "<div id=\"rin-bg\"></div>\n" +
                "<main id=\"rin-main\">\n" +
                "    <div class=\"mdui-row\">\n" +
                "        \n" +
                "        <div class=\"mdui-col-xs-12 mdui-col-md-10\">\n" +
                "            <div class=\"mdui-card rin-card\">\n" +
                "<!--                <div class=\"rin-card-title\">关于我</div>-->\n" +
                "                <div class=\"rin-card-part\" id=\"introduce\" style=\"margin-top: 0;\">\n" +
                "                    <div class=\"rin-card-content mdui-typo\">\n" +
                "                        {ServerDescription}\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <!--        <div class=\"rin-tr\"></div>-->\n" +
                "                <div class=\"rin-card-part\" id=\"fighting\">\n" +
                "                    <div class=\"rin-card-title2 mdui-typo\"><a href=\"https://seir.in/#fighting\">#</a>在线玩家</div>\n" +
                "                    <div class=\"mdui-container\">\n" +
                "                        <div class=\"mdui-row\">\n" +
                "                            <div class=\"mdui-col-xs-12 mdui-col-sm-6 mdui-col-md-4\" mdui-tooltip=\"{content: &#39;在线玩家数&#39;}\">\n" +
                "\n" +
                "                                <div class=\"rin-progress-title\">"+ Bukkit.getOnlinePlayers().size()+"/"+Bukkit.getMaxPlayers()+"</div>\n" +
                "\n" +
                "                                <div class=\"mdui-progress\">\n" +
                "                                    <div class=\"mdui-progress-determinate\" style=\"width: "+playerPer * 100+"%;\"></div>\n" +
                "                                </div>\n" +
                "\n" +
                "                            </div>\n" +
                "\n" +
                "                            \n" +
                "\n" +
                "                            \n" +
                "\n" +
                "                        </div>\n" +
                "\n" +
                "                        \n" +
                "\n" +
                "                        \n" +
                "\n" +
                "\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"rin-card-part\" id=\"contact\">\n" +
                "                    <div class=\"rin-card-content mdui-typo\">"+playerListString+"</div>\n" +
                "\n" +
                "                    \n" +
                "\n" +
                "                    \n" +
                "\n" +
                "                    \n" +
                "\n" +
                "                    \n" +
                "\n" +
                "                </div>\n" +
                "\n" +
                "                \n" +
                "\n" +
                "\n" +
                "                <div class=\"rin-card-part\" id=\"works\">\n" +
                "                    <div class=\"rin-card-title2 mdui-typo\"><a href=\"https://seir.in/#works\">#</a>TPS</div><div class=\"rin-card-title2 mdui-typo\">"+ Arrays.toString(Bukkit.getServer().getTPS()) +"</div>\n" +
                "\n" +
                "                    <a target=\"_blank\" href=\"https://github.com/AyagawaSeirin/UploadGithubForTypecho\">\n" +
                "                        \n" +
                "                    </a>\n" +
                "                    \n" +
                "                    \n" +
                "                    \n" +
                "\n" +
                "                </div>\n" +
                "\n" +
                "\n" +
                "                <div class=\"rin-tr\"></div>\n" +
                "\n" +
                "                <div class=\"rin-card-part\" id=\"last\">\n" +
                "                    <div class=\"rin-card-title2\">{ServerName}</div>\n" +
                "                    <div class=\"rin-card-content\">{Sentence}</div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"rin-card-part\" id=\"footer\">\n" +
                "                    <div class=\"rin-card-content\">©2023 WutzuBert | Made with love by Seirin</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</main>\n" +
                "<script src=\"https://cdn.jsdelivr.net/gh/AyagawaSeirin/homepage@latest/mdui/js/mdui.min.js\"></script>\n" +
                "<!--<script src=\"/assets/js/main.js\"></script>-->\n" +
                "\n" +
                "\n" +
                "</body></html>";
        String serverName = BukkitOnline.config.getString("ServerName");
        String serverDescription = BukkitOnline.config.getString("ServerDescription");
        String sentence = BukkitOnline.config.getString("Sentence");
        page = page.replace("{ServerName}",serverName);
        page = page.replace("{ServerDescription}",serverDescription);
        page = page.replace("{Sentence}",sentence);
        httpExchange.sendResponseHeaders(200,page.getBytes(StandardCharsets.UTF_8).length);
        httpExchange.getResponseHeaders().set("Content-Type","text/html; charset=utf8");
        OutputStream os = httpExchange.getResponseBody();
        os.write(page.getBytes(StandardCharsets.UTF_8));
        os.close();
    }
}
