public class TextConverter {
    private String textArea;
    private int quantity;

    public TextConverter(Text text) {
        textArea = text.getText();
    }
    // method to calculate quantity of words in text area
    public int words() {
        String[] arrayOfStrings;
        if (textArea == null || textArea.isEmpty()) {
            quantity = 0;
        }else {
            arrayOfStrings = textArea.split("\\s+");
            quantity = arrayOfStrings.length;
        }
        return quantity;
    }

    // method to calculate quantity of all characters in text area
    public int allCharacters() {
        if (textArea == null || textArea.isEmpty()) {
            quantity = 0;
        }else {
            quantity = textArea.length();
        }
        return quantity;
    }

    // method to calculate quantity of all characters without space in text area
    public int allCharactersWithoutSpaces() {
        char[] arrayOfCharacters;
        if (textArea == null || textArea.isEmpty()) {
            quantity = 0;
        } else {
            quantity = 0;
            arrayOfCharacters = textArea.toCharArray();
            for (int i = 0; i < textArea.length(); i++) {
                if (arrayOfCharacters[i] != ' ')
                    quantity++;
            }
        }
        return quantity;
    }

    // method to check if text is palindrome
    public boolean isTextPalindrome() {
        if (textArea == null || textArea.isEmpty()){
         return false;
        }
        return textArea.equals(new StringBuilder(textArea).reverse().toString());
    }
}
