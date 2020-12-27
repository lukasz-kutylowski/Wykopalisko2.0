package pl.lukaszkutylowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszkutylowski.AdminCredentionals;
import pl.lukaszkutylowski.controller.service.AdminPanelControllerService;
import pl.lukaszkutylowski.frontend.view.AdminPanelHtmlView;
import pl.lukaszkutylowski.session.Session;

@RestController
public class AdminPanelController {

    private AdminPanelControllerService adminPanelControllerService;
    private AdminPanelHtmlView adminPanelHtmlView;
    private Session session;

    @Autowired
    public AdminPanelController(
            AdminPanelControllerService adminPanelControllerService,
            AdminPanelHtmlView adminPanelHtmlView,
            Session session) {
        this.adminPanelControllerService = adminPanelControllerService;
        this.adminPanelHtmlView = adminPanelHtmlView;
        this.session = session;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam long discovery_id) {
        if (session.getSessionUser().getUsername().equals(AdminCredentionals.ADMIN_USERNAME)) {
            if (session.getSessionUser().getPassword().equals(AdminCredentionals.ADMIN_PASSWORD)) {
                adminPanelControllerService.deleteDiscovery(discovery_id);
            }
        }
        return adminPanelHtmlView.render();
    }
}
