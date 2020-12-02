package tema3;

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


}
