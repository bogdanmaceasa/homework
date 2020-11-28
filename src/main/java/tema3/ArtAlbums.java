package tema3;

public class ArtAlbums extends Books {

    private String artType;

    ArtAlbums() {
        this.artType = "Unknown art type";
        System.out.print("It seems to be an art album.");
    }


    ArtAlbums(String name, String author, int pagNum, String artType) {
        super(name, author, pagNum);
        this.artType = artType;
        System.out.print("It is an art album.");
    }

    public void setArtType(String artType) {
        this.artType = artType;
    }

    public String getArtType() {
        return artType;
    }

    @Override
    public String toString() {
        return super.toString() + " is an ArtAlbum{" +
                "artType='" + artType + '\'' +
                '}';
    }
}
