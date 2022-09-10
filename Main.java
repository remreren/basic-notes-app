import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static ArrayList<Note> notesMemory = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("BasicNotes uygulamasına hoş geldiniz");

        boolean devamEt = true;

        Scanner scanner = new Scanner(System.in);

        while (devamEt) {
            System.out.println("Devam etmek için seçim yapın.");
            System.out.println("1. Not ekle");
            System.out.println("2. Not düzenle");
            System.out.println("3. Not sil");
            System.out.println("4. Not listele");
            System.out.println("q. Çıkış");

            String secim = scanner.nextLine().trim().toLowerCase();
            String title;
            String content;
            int noteId;

            switch (secim) {
                case "1":
                    System.out.print("Not başlığını girin:");
                    title = scanner.nextLine();
                    System.out.print("Not içeriğini girin:");
                    content = scanner.nextLine();
                    Note note = new Note(title, content);
                    notesMemory.add(note);
                    System.out.println("Not kaydedildi.");
                    break;

                case "2":
                    System.out.print("Not numarasını girin:");
                    noteId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Yeni not başlığını girin:");
                    title = scanner.nextLine();
                    System.out.print("Yeni not içeriğini girin:");
                    content = scanner.nextLine();
                    Note note1 = notesMemory.get(noteId);
                    note1.title = title;
                    note1.content = content;
                    note1.updatedAt = new Date();
                    notesMemory.set(noteId, note1);
                    System.out.println("Not güncellendi.");
                    break;

                case "3":
                    System.out.print("Not numarasını girin:");
                    noteId = scanner.nextInt();
                    notesMemory.remove(noteId);
                    break;

                case "4":
                    for (int i = 0; i < notesMemory.size(); i++) {
                        Note note2 = notesMemory.get(i);
                        System.out.println((i + 1) + ".\t" + note2.title);
                        System.out.println("\t" + note2.content);
                        System.out.println();
                    }
                    break;

                case "q":
                    devamEt = false;
                    break;

            }
        }
    }
}

class Note {

    public String title;
    public String content;
    public Date createdAt;
    public Date updatedAt;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
        this.updatedAt = createdAt;
    }
}