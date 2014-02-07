package mod.desafio;

public class Substitui {

    public static String replaceAll(String source, String pattern, String replacement) {
        if (source == null)
            return "";

        StringBuffer sb = new StringBuffer();

        int idx = 0;

        String palavra = source;

        while ((idx = palavra.indexOf(pattern, idx)) != -1) {

            sb.append(palavra.substring(0, idx));
            sb.append(replacement);
            sb.append(palavra.substring(idx + pattern.length()));

            palavra = sb.toString();
            sb.delete(0, sb.length());

            idx += replacement.length();
        }

        return palavra;
    }
}
