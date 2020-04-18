package android.example.musicalstructureapp.modals;

public class GenreModal {
    String genreName;
    int genreImage;
    int color;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getGenreImage() {
        return genreImage;
    }

    public void setGenreImage(int genreImage) {
        this.genreImage = genreImage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public GenreModal(String genreName, int genreImage,int color) {
        this.genreName = genreName;
        this.genreImage = genreImage;
        this.color = color;
    }
}