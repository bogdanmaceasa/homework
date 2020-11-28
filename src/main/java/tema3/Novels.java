package tema3;

public class Novels extends Books {

    String novelType;


    Novels() {
        super();
        this.novelType = "Unknown novel type";
        System.out.print("It seems to be a novel.");
    }

    Novels(String name, String author, int pagNum, String novelType ) {
        super(name, author,pagNum);
        this.novelType = novelType;
        System.out.print("It is a novel.");
    }


    public void setNovelType(String novelType) {
        this.novelType = novelType;
    }

    public String getNovelType() {
        return novelType;
    }

    @Override
    public String toString() {
        return super.toString() + " is a Novel{" +
                "novelType='" + novelType + '\'' +
                '}';
    }
}
