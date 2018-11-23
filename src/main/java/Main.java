
import freemarker.template.Configuration;
import org.slf4j.Logger;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark.route.RouteOverview;
import spark.template.freemarker.FreeMarkerEngine;
import utils.ConfigUtils;
import utils.ExceptionUtils;
import utils.LogUtils;
import utils.ServerUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    private static final Logger log = LogUtils.newLog();

    private static TemplateEngine templateEngine;

    public static void main(String[] args) throws Exception {

        config();
        routes();
    }

    private static void config() throws Exception {
        port(ConfigUtils.getPort());

        externalStaticFileLocation("src/main/resources".replace("/", File.separator));

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_25);
        configuration.setNumberFormat("computer");


        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        configuration.setTemplateUpdateDelayMilliseconds(0);


        templateEngine = new FreeMarkerEngine(configuration);

        after("/api/*", (req, res) -> {
            if (res.type() == null)
                res.type("application/json");
        });

        RouteOverview.enableRouteOverview("/api");
    }

    private static void routes() {
        get("/index", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            req.queryParams().forEach(p -> model.put(p, req.queryParams(p)));
            ConfigUtils.getUsername().ifPresent(u -> model.put("username", u));
            ConfigUtils.getPassword().ifPresent(p -> model.put("password", p));
            return new ModelAndView(model, "index.ftlh");
        }, templateEngine);
    }
}
