package work3Library;

import java.util.Objects;

class ArtAlbums extends Book {

    private final String artType;
    private String paperQuality;

    ArtAlbums() {
        this.artType = "Unknown art type";
        this.paperQuality = "Unchecked";
        System.out.print("It seems to be an art album.");
    }


    ArtAlbums(String name, String author, int pagNum, String artType, String paperQuality) {
        super(name, author, pagNum);
        this.artType = artType;
        this.paperQuality = paperQuality;
        System.out.print("It is an art album.");
    }

    public void setPaperQuality(String paperQuality) {
        this.paperQuality = paperQuality;
    }

    public String getPaperQuality() {
        return paperQuality;
    }

    public String getArtType() {
        return artType;
    }

    @Override
    public void checkOutBook() {
        super.checkOutBook();
        System.out.print("Please handle with care!\n");
    }

    @Override
    public String toString() {
        return super.toString() + " is an ArtAlbum{" +
                "artType='" + artType + '\'' + ", paperQuality='" + paperQuality + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtAlbums)) return false;
        if (!super.equals(o)) return false;
        ArtAlbums artAlbums = (ArtAlbums) o;
        return Objects.equals(artType, artAlbums.artType) && Objects.equals(paperQuality, artAlbums.paperQuality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), artType, paperQuality);
    }
}
