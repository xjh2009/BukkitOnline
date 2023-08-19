package top.wutzu.bukkitonline;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainCSS implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) {
        try {
            String content = "body {\n" +
                    "    margin: 0;\n" +
                    "    background: #2e2e2c;\n" +
                    "}\n" +
                    "* {\n" +
                    "    -webkit-tap-highlight-color: transparent;\n" +
                    "}\n" +
                    "::selection {\n" +
                    "    color: #e0e0e0;\n" +
                    "    background: rgba(255,64,129,.35);\n" +
                    "}\n" +
                    "#rin-bg {\n" +
                    "    top: 0;\n" +
                    "    left: 0;\n" +
                    "    right: 0;\n" +
                    "    bottom: 0;\n" +
                    "    z-index: -2;\n" +
                    "    position: fixed;\n" +
                    "    background-size: cover;\n" +
                    "    background-repeat: no-repeat;\n" +
                    "    background-attachment: fixed;\n" +
                    "    background-position: 50% 50%;\n" +
                    "    background-color: #818181;\n" +
                    "    background-image: url('" + BukkitOnline.config.getString("background") + "');\n" +
                    "}\n" +
                    "#rin-bg:after {\n" +
                    "    top: 0;\n" +
                    "    left: 0;\n" +
                    "    right: 0;\n" +
                    "    bottom: 0;\n" +
                    "    content: '';\n" +
                    "    z-index: -1;\n" +
                    "    position: fixed;\n" +
                    "    background-color: rgba(66,66,66,.6);\n" +
                    "}\n" +
                    "\n" +
                    "#rin-footer {\n" +
                    "    bottom: 0;\n" +
                    "    margin: auto;\n" +
                    "    width: 100vw;\n" +
                    "    position: absolute;\n" +
                    "    padding: 10px 0 10px 0;\n" +
                    "}\n" +
                    "#rin-footer div {\n" +
                    "    font-size: 14px;\n" +
                    "    text-align: center;\n" +
                    "    color: rgba(255,255,255,.79);\n" +
                    "}\n" +
                    "#rin-footer div a {\n" +
                    "    color: #2196f3;\n" +
                    "    font-weight: 700;\n" +
                    "    transition: all .3s;\n" +
                    "    text-decoration: none;\n" +
                    "}\n" +
                    ".rin-tr {\n" +
                    "    width: 80%;\n" +
                    "    height: 2px;\n" +
                    "    margin: auto;\n" +
                    "    background: rgba(255,255,255,.3);\n" +
                    "}\n";
            httpExchange.sendResponseHeaders(200, content.getBytes(StandardCharsets.UTF_8).length);
            httpExchange.getResponseHeaders().set("Content-Type", "text/css; charset=utf8");
            OutputStream os = httpExchange.getResponseBody();
            os.write(content.getBytes(StandardCharsets.UTF_8));
            os.close();
        } catch (Exception e) {
            BukkitOnline.logger.warning(e.getStackTrace().toString());
        }
    }
}
