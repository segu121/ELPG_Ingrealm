package vaaks.ingrealm.indexservlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexWebSiteController {

    @GetMapping(value = "/")
    public void startIndexPage() {

    }
}
