import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommentFilter implements BlackListFilter {
    @Override
    public List<String> filterComments(List<String> comments, Set<String> blackList) {
        List<String> filteredComments = new ArrayList<>();

        for (String comment : comments) {
            if (!containsBlacklistedWords(comment, blackList)) {
                filteredComments.add(comment);
            }
        }

        return filteredComments;
    }

    private boolean containsBlacklistedWords(String comment, Set<String> blackList) {
        String[] words = comment.split("\\s+"); // Разбиваем комментарий на слова

        for (String word : words) {
            // Удаляем пунктуацию и приводим к нижнему регистру для регистронезависимого сравнения
            String cleanedWord = word.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();

            if (blackList.contains(cleanedWord)) {
                return true; // Комментарий содержит запрещенное слово
            }
        }

        return false; // Комментарий не содержит запрещенных слов
    }
}
