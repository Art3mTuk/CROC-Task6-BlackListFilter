import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task6 {
    /**
     * Если в файле comments.txt есть запрещенные слова, которые указаны в программе,
     * то она удаляет всю строку и оставляет в файле filtered_comments.txt только хорошие комментарии.
     * Только нужно в comments.txt и в filtered_comments.txt указать полный путь к файлам.
     *
     * @author Artem Tukalenko
     */
    public static void main(String[] args) {
        try {
            // Чтение комментариев из файла
            List<String> comments = readCommentsFromFile("C:/Users/БратскийПК/IdeaProjects/Java/src/comments.txt");

            // Запрещенные слова
            Set<String> blackList = new HashSet<>();
            blackList.add("админ");
            blackList.add("подпишись");
            blackList.add("лайк");
            blackList.add("пиар");
            blackList.add("плохой");

            // Создание экземпляра CommentFilter и фильтрация комментариев
            BlackListFilter commentFilter = new CommentFilter();
            List<String> filteredComments = commentFilter.filterComments(comments, blackList);

            // Вывод отфильтрованных комментариев в файл
            writeCommentsToFile(filteredComments, "C:/Users/БратскийПК/IdeaProjects/Java/src/filtered_comments.txt");
            System.out.println("Комментарии отфильтрованы в файле filtered_comments.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readCommentsFromFile(String fileName) throws IOException {
        List<String> comments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                comments.add(line);
            }
        }
        return comments;
    }

    private static void writeCommentsToFile(List<String> comments, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String comment : comments) {
                writer.write(comment);
                writer.newLine();
            }
        }
    }
}



