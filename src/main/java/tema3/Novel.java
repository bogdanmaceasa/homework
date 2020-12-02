package tema3;

class Novel extends Book {

    String novelType;


    Novel() {
        super();
        this.novelType = "Unknown novel type";
        System.out.print("It seems to be a novel.\n");
    }

    Novel(String name, String author, int pagNum, String novelType ) {
        super(name,author,pagNum);
        this.novelType = novelType;
        System.out.print("It is a novel.\n");
    }

    Novel(String name, String author, String novelType ) {
        super(name,author);
        this.novelType = novelType;
        System.out.print("It is a novel.\n");
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
}
