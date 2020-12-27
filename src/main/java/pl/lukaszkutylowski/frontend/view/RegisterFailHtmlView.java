package pl.lukaszkutylowski.frontend.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lukaszkutylowski.session.Session;

@Component
public class RegisterFailHtmlView {

    private Session session;

    @Autowired
    public RegisterFailHtmlView(Session session) {
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
        s.append("</div>");
        s.append("<div class='navbar-button'>");
        s.append("    <a href='/'>Główna</a>");
        s.append("</div>");
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
        s.append("<div class='end'></div>");

        s.append("    <div class='login-info'>Zalogowany jako: " + session.getSessionUser().getUsername() + "</div>");

        s.append("<div class='login-info'>Użytkownik od podanej nazwie istnieje. Użyj innej nazwy.</div>");
        s.append("<div class='login-register-bar'>");
        s.append("    <h2>Zarejestruj się</h2>");
        s.append("    <form action='/register-form' method='post'>");
        s.append("        <input name='username' type='text' class='form-control'");
        s.append("               placeholder='Nazwa użytkownika...' required='required'>");
        s.append("        <input name='password' type='password' class='form-control'");
        s.append("               placeholder='Hasło...' required='required'>");
        s.append("        <button class='apply-button' type='submit'>Zarejestruj</button>");
        s.append("        <a href='login' style='color: red;'>Zaloguj</a>");
        s.append("    </form>");
        s.append("</div>");
        s.append("<div class='footer'>");
        s.append("    <p class='navbar-text'>Wykopalisko - developed by Łukasz Kutyłowski | 2020</p>");
        s.append("</div>");
        s.append("</div>");
        s.append("</body>");
        s.append("</html>");


        return s.toString();
    }
}
