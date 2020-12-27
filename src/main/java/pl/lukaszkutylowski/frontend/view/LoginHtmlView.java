package pl.lukaszkutylowski.frontend.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lukaszkutylowski.model.Discovery;
import pl.lukaszkutylowski.service.DiscoveryService;
import pl.lukaszkutylowski.session.Session;

import java.util.List;

@Component
public class LoginHtmlView {

    private Session session;

    @Autowired
    public LoginHtmlView(Session session) {
        this.session = session;
    }

    public String render() {
        StringBuilder s = new StringBuilder();

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
            s.append("                    <a href='add'>Dodaj</a>");
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

        s.append("    <div class='login-register-bar'>");
        s.append("        <h2>Zaloguj się</h2>");
        s.append("        <form action='login-form' method='post'>");
        s.append("            <input name='username' type='text' class='form-control'");
        s.append("                   placeholder='Nazwa użytkownika...' required='required'>");
        s.append("            <input name='password' type='password' class='form-control'");
        s.append("                   placeholder='Hasło...' required='required'>");
        s.append("            <input class='apply-button' type='submit' value='Zaloguj'>");
        s.append("            <br><h2>lub</h2>");
        s.append("            <div class='link-register'>");
        s.append("                <a href='register' style='color: red'>Zarejestruj się!</a>");
        s.append("            </div>");
        s.append("        </form>");
        s.append("    </div>");

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
