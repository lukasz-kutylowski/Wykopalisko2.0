package pl.lukaszkutylowski.frontend.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lukaszkutylowski.model.Discovery;
import pl.lukaszkutylowski.service.DiscoveryService;
import pl.lukaszkutylowski.session.Session;

import java.util.List;

@Component
public class AdminPanelHtmlView {

    private Session session;
    private DiscoveryService discoveryService;

    @Autowired
    public AdminPanelHtmlView(Session session, DiscoveryService discoveryService) {
        this.session = session;
        this.discoveryService = discoveryService;
    }

    public String render() {
        StringBuilder s = new StringBuilder();
        List<Discovery> discoveries = discoveryService.getAllDiscoveries();

        s.append("<!DOCTYPE html>");
        s.append("<html>");
        s.append("<head>");
        s.append("    <meta charset='UTF-8'>");
        s.append("    <title>Wykopalisko</title>");

        s.append(StyleCss.getStyleCss());

        s.append("</head>");
        s.append("<body>");
        s.append("<div class='container'>");
        s.append("    <div class='navbar-brand'>");
        s.append("        <div class='brand'>Wykopalisko</div>");
        s.append("    </div>");
        s.append("    <div class='menu'>");
        s.append("        <div class='navbar-button'>");
        s.append("            <a href='/'>Główna</a>");
        s.append("        </div>");
        s.append("        <div class='navbar-button'>");

        if (session.getSessionUser() != null) {
            s.append("                    <a href='/'>Usuń</a>");
        } else {
            s.append("                    <a href='login'>Zaloguj, by dodać</a>");
        }

        s.append("        </div>");
        s.append("        <div class='navbar-button'>");

        if (session.getSessionUser() != null) {
            s.append("                    <a href='logout'>Wyloguj się</a>");
        } else {
            s.append("                    <a href='login'>Zaloguj się</a>");
        }

        s.append("        </div>");
        s.append("        <div class='end'></div>");
        s.append("    </div>");

        if (session.getSessionUser() != null) {
            s.append("    <div class='login-info'>Zalogowany jako: " + session.getSessionUser().getUsername() + "</div>");
        } else {
            s.append("    <div class='login-info'>Niezalogowany użytkownik</div>");
        }

        for (Discovery d: discoveries) {
            s.append("<div class='title'>" + d.getName() + "</div>" +
                    "<div class='description'>" + d.getDescription() + " [" + d.getUser().getUsername() + "]" + "</div>" +
                    "<div class='link'>" +
                    "<a href='http://" + d.getUrl() + "' target='_blank' style='font-size: 15px; color: #0099ff !important;'/>http://" + d.getUrl() + "</a></div>"
            );

            if (session.getSessionUser() != null) {
                s.append("  <form action='/delete' method='post'>");
                s.append("      <input type='hidden' name='discovery_id' value='" + d.getDiscovery_id() + "'/>");
                s.append("      <button type='submit' class='delete' style='border: none;'>Delete discovery id=" + d.getDiscovery_id() + "</button>");
                s.append("  </form>");

            } else {
                s.append("  <div>");
                s.append("      <a href='/login'><button type='submit' class='delete' style='border: none;'>Delete discovery id=" + d.getDiscovery_id() + "</button></a>");
                s.append("  </div>");
            }
        }

        s.append("            <div class='wykopalisko'>");
        s.append("                <div class='space'></div>");
        s.append("                <div class='end'></div>");

        s.append("    <div class='footer'>");
        s.append("        <p class='navbar-text'>Wykopalisko - developed by Łukasz Kutyłowski | 2020</p>");
        s.append("    </div>");
        s.append("</div>");

        s.append("</body>");
        s.append("</html>");


        return s.toString();
    }
}
