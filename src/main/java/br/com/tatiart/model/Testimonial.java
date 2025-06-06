package br.com.tatiart.model;

public class Testimonial {
    private String author;       // ex: "Maria Santos"
    private String avatarLetter; // ex: "M" (iniciais)
    private String date;         // ex: "Hoje 14:32" ou "Stories"
    private String message;      // texto do depoimento
    private String imageUrl;     // URL da imagem ou vídeo (se houver)
    private String bgColor;      // ex: "green-50", "pink-50", "blue-50", etc
    private String borderColor;  // ex: "green-500", "pink-500", "blue-500", etc
    private Integer rating;      // 1 a 5 (ou null se não for avaliado com estrelas)

    public Testimonial() {}

    public Testimonial(
        String author,
        String avatarLetter,
        String date,
        String message,
        String imageUrl,
        String bgColor,
        String borderColor,
        Integer rating
    ) {
        this.author = author;
        this.avatarLetter = avatarLetter;
        this.date = date;
        this.message = message;
        this.imageUrl = imageUrl;
        this.bgColor = bgColor;
        this.borderColor = borderColor;
        this.rating = rating;
    }

    // getters e setters omitidos para brevidade...
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getAvatarLetter() { return avatarLetter; }
    public void setAvatarLetter(String avatarLetter) { this.avatarLetter = avatarLetter; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getBgColor() { return bgColor; }
    public void setBgColor(String bgColor) { this.bgColor = bgColor; }
    public String getBorderColor() { return borderColor; }
    public void setBorderColor(String borderColor) { this.borderColor = borderColor; }
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
}
