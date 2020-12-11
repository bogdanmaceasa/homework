package tema3;

import java.util.Objects;

class Novel extends Book {

    String novelType;


    Novel() {
        super();
        this.novelType = "Unknown novel type";
        System.out.print("It seems to be a novel.");
    }

    Novel(String name, String author, int pagNum, String novelType ) {
        super(name,author,pagNum);
        this.novelType = novelType;
        System.out.print("It is a novel.");
    }

    Novel(String name, String author, String novelType ) {
        super(name,author);
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
    public void readBook(){
        System.out.println("Someone is reading some amazing novel, please be quiet while in the library!");
    }

    @Override
    public String toString() {
        return super.toString() + " is a Novel{" +
                "novelType='" + novelType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Novel)) return false;
        if (!super.equals(o)) return false;
        Novel novel = (Novel) o;
        return Objects.equals(novelType, novel.novelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), novelType);
    }
}
