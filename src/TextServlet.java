import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TextServlet")
public class TextServlet extends HttpServlet {
    private int quantityOfWords;
    private int quantityOfAllCharacters;
    private int quantityOfAllCharactersWithoutSpaces;
    private boolean isTextPalindrome;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Text text = createTextFromRequest(request);
        textConverter(text);
        sendResults(text, response);
    }

    private Text createTextFromRequest(HttpServletRequest request) {
        String textArea = request.getParameter("textArea");
        Text text = new Text();
        text.setText(textArea);
        return text;
    }

    private void textConverter(Text text) {
        TextConverter textConverter = new TextConverter(text);
        quantityOfWords = textConverter.words();
        quantityOfAllCharacters = textConverter.allCharacters();
        quantityOfAllCharactersWithoutSpaces = textConverter.allCharactersWithoutSpaces();
        isTextPalindrome = textConverter.isTextPalindrome();
    }

    private void sendResults(Text text, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.print("<p>" + text.getText().toString() + "</p><br>");
        writer.println("<h2>Ilosc slow: " + quantityOfWords + "</h2><br>");
        writer.println("<h2>Ilosc znakow: " + quantityOfAllCharacters + "</h2><br>");
        writer.println("<h2>Ilosc znakow (bez spacji): " + quantityOfAllCharactersWithoutSpaces + "</h2><br>");
        writer.println("<h2>Palindrom: " + isTextPalindrome + "</h2><br>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
